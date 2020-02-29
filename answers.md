# Apica Engineering Internship - Technical Exercise         
**by Shixian Cui**
<br />
<br />
<br />
<br />

# - Part 1 API Investigation
    
   https to **www.ticketmaster.com** from Chrome browser.<br />
   ![api_call_1](https://github.com/shixianc/hiring-intern/blob/master/screenshots/api_call_1.png)<br />
   ![api_call_2](https://github.com/shixianc/hiring-intern/blob/master/screenshots/api_call_2.png)<br />
   ![api_call_3](https://github.com/shixianc/hiring-intern/blob/master/screenshots/api_call_3.png)<br /> <br />
   
   This call bascially send a HTTPS POST method to **api2.branch.io/v1/open**<br />
   This API is a **3rd** party call that provides Deep-Linking for mobile device. In our case, TicketMaster uses branch.io API to first detect if user has TicketMaster App on their device. if has, the page would be redirected to a specific location inside the TicketMaster APP, or if not, the page would continue on the browswer.<br /><br />
   ```{"session_id":"762205744628531442",```
    ``` "identity_id":"762205744627494358",```
    ``` "link":"https://ticketmaster-us.app.link?%24identity_id=762205744627494358",```
   ```  "data":"{\"+clicked_branch_link\":false,\"+is_first_session\":true}",```
  ```   "browser_fingerprint_id":"760604525505416595",```
   ```  "has_app":false}``` <br /> <br />
   Above is the response JSON file. We can see the last key/value pair : ```"has_app":false``` implies that I do not have a APP on my device, which makes sense because I am using Chrome on my laptop.<br /><br />
    I do not see any calls being blocked on www.TicketMaster.com<br />
    However, I change to www.groupon.com and find Chrome blocked the following link:<br />
    https://ads.stickyadstv.com/user-registering?dataProviderId=1025&userId=XlREW9HM4cYAABHQfs0AAABA%26453 <br />
    From the URL we could easily identify that it is an advertisement and I find it contains many re-directs when I click on it.<br /><br /><br />
# - Part 2 Chaining API Requests

### TicketMaster API
   ![ticketmaster](https://github.com/shixianc/hiring-intern/blob/master/screenshots/Screen%20Shot%202020-02-29%20at%201.10.05%20AM.png)<br />
    I signed up at **TicketMaster Developer** and I retrieved the customer key from TicketMaster Discovery API. It is an free API that provides basic Events searching function based on my Geo Location/ distance, etc. <br />
    I created a simple Java Web Application, and I created a class "SearchItem" that implemented the HttpServlet:<br /> <br />
    ```{```<br />
    ```package rpc;```<br />
    ```@WebServlet("/search")```<br />
    ```public class SearchItem extends HttpServlet {```<br />
    ```protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {```<br />
    ```double lat = Double.parseDouble(request.getParameter("lat")); ```<br />
    ```double lon = Double.parseDouble(request.getParameter("lon"));```<br />
    ```TicketMasterClient client = new TicketMasterClient();```<br />
    ```response.setContentType("application/json");```<br />
	```response.getWriter().print(obj);```<br />
    ```}```<br /> <br />
    Then I created another method to create a http connection with TickerMaster Server. <br />
    ![client](https://github.com/shixianc/hiring-intern/blob/master/screenshots/client.png)<br />
    I set it up at my localhost:8080 port.<br />
    I used PostMan to test it with Geo-location set to Apica Systems Office @ Santa Monica: **1250 6th St, Santa Monica, CA.**
    I googled its Latitude is **34.82** and Longitude **-118.42** <br />
    by using PostMan GET: http://localhost:8080/Jupiter/search?lat=34.82&lon=-118.42:
    ![post_apica](https://github.com/shixianc/hiring-intern/blob/master/screenshots/post_apica.png)<br />
    And I get a JSON file that contains an array of JSON objects, and each with multiple elements such as address, name, url,etc.<br />
    ![tour](https://github.com/shixianc/hiring-intern/blob/master/screenshots/tour.png)<br /><br /><br />
### Requests Chaining with PostMan Collections
   I created a PostMan collection called: **Ticketmaster** <br />
   ![request1](https://github.com/shixianc/hiring-intern/blob/master/screenshots/request1.png);<br />
   ![request1](https://github.com/shixianc/hiring-intern/blob/master/screenshots/request2.png);<br />
   From the first response, I extract **"categories"** from one JSON Object inside JSON Array, and then set an environmentVariable called **"keyword"** with this "categories" element. <br />
   Then I use this "keyword" as my second request's URL "term" value. <br />
   *The basic idea is that: I first search all the events that is related to Apica System's geo location, and from the first event that comes up, I extract its categories, and say I want to search more similar events within the same category, so that I start my second reqeust.* <br />
   ![request1](https://github.com/shixianc/hiring-intern/blob/master/screenshots/postman_result.png);<br />
   All test cases passed with **Status 200**. <br />
   ![request1](https://github.com/shixianc/hiring-intern/blob/master/screenshots/request2_reponse_body.png);<br />
   We can examine the response body which shows that the categories from second reqeust is all "Arts & Theatre". (The whole response body can be found in src/ folder)<br /><br /> <br />
   
   
### follow ups:
   #### - Why is the global/environment variable necessary? 
   	
global / Environment Variable is necessary because we need it to **pass data to other reqeusts. / or passing data from pre-tests to requests or tests** <br />
Best practice is that we need to limit the usage of variables and set their scope as small as possible. Global vars may be useful for quick prototyping so that we would not worry much at the beginning. One last thing that I find online, when I only has one enviroment variable, it's better to set it to collection variable to avoid overheads. <br /> <br />
   
   #### - What would happen to the second request if the pre-request script is missing or failed to run successfully?
   If my first test failed, it would fail to set the "keyword" environment variable with correct value. Because I have set up the enviroment, the default value for "keyword" is null. Therefore, the API would take keyword as "null" input. There are corner case checking from their API, so TicketMaster API would set the keyword to default which is "all categoreis".<br /><br /><br /> <br /> <br />
    
# - Part 3 Chaining API Requests with Apica
   I added my Postman Collections manually to Zebra IDE.<br />
   ![script](https://github.com/shixianc/hiring-intern/blob/master/screenshots/general_script.png)<br />
   ### explanation:
   My Zebra Script consists of 2 Page Break and each contains 1 URL.<br />
   I extracted a variable *keyword* from *Content* and set the JSON path to retreive the first *"category"* found. (same as PostMan Collection above).<br />
   However, the String var that I extracted is **"Art & Theatre"** which **contains spaces**, that leads to HTTP 505 Error. I debugged in different ways and found out the spaces is the issue. Previously PostMan did not catch this problem so I assume Postman has some internal function to format my variable input automatically. <br />
   Due to this issue, I created an **Inline Code** between two URLs requests.  <br /> 
   @Input: String Variable **"keyword"** extracted from first HTTP request.<br /> 
   @Output: a Global Varibale **"keywordTrimed"** to replace with the parameter "term" in the second HTTP request.<br /> 
   ![script](https://github.com/shixianc/hiring-intern/blob/master/screenshots/inlinecode.png)<br />
    <br />
   And it works as expected.<br />
    <br />
   ![script](https://github.com/shixianc/hiring-intern/blob/master/screenshots/log_trim.png)<br />
    <br />
   ![script](https://github.com/shixianc/hiring-intern/blob/master/screenshots/check200.png)<br />
   I also set the **Response Verification** to confirm Status 200. <br /><br />
   ![request1](https://github.com/shixianc/hiring-intern/blob/master/screenshots/result.png) <br /> <br /> <br />
   
   
   ### Followup: Describe how can users more easily manage multiple variables accross multiple API scripts comparitively with Zebra IDE? 
   
  Users can easily extract variables from any API response content, or simply created any variables.<br />
  All these variables are stored and listed in the upper-right corner **"Variables"** section. <br />
  User can also easily add to any **Inline Code** or even **Java Plugin!** as input/output(I found this VERY helpful!) <br />
  Compared to Postman, Zebra IDE has a excellent UI experience and visualization, and it provides much more efficiency and flexibility to do complicated jobs. <br /> <br /> <br /> <br />
  
# - Part 4 Java Exercise

  ![Substring Applet Screenshot](https://github.com/shixianc/hiring-intern/blob/master/screenshots/Screen%20Shot%202020-02-28%20at%205.14.27%20PM.png)
                     (*Screenshot for my getSubString() function running as a Java Applet*)
### Algorithm: 
Traversing the whole input string character by character. When finding a match on the first letter, program would call another private method *check()* to check if the match found. With multiple constraints, it would output the correct substring in between [fromString, toString]. Source code can be found in this repository!<br />
**Time Complexity: O(m\*n)**    *(m is "inputString" length, n is "fromString" and "toString" length.)*<br />
**Space Complexity: O(1)**<br />
Optimization to O(n) time by using Rolling Hash method. (detailed implementation in the comment of the source file.)

### Import as Java Plugin:
I also convert it into a **Zebra IDE Plugin** and test and run on my localhost.<br />
I build my Plugin by implementing **LoadTestPluginInterface** from library **dfischer.utils**<br />
The main mechanism involves the three states: **Construct(), Execute() and Deconstruct().**<br />

First I import it from **Custom Java Plugin Tab** 
![import plugin](https://github.com/shixianc/hiring-intern/blob/master/screenshots/add_plugin.png)<br />
Then I add 3 Zebra variables and use them as the parameters of my Java Plugin.<br />
I Created a simple Zebra IDE scripts with a GET http request to google.<br />
And I placed my Plugin to run at the beginning.<br />
![import plugin](https://github.com/shixianc/hiring-intern/blob/master/screenshots/variables.png)<br />
It runs successfully
![import plugin](https://github.com/shixianc/hiring-intern/blob/master/screenshots/run.png)<br />
From the **Log Files** we could find the output is correct.<br />
![import plugin](https://github.com/shixianc/hiring-intern/blob/master/screenshots/log_file.png)

