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
   ![api_call_3](https://github.com/shixianc/hiring-intern/blob/master/screenshots/api_call_3.png)<br />
   
   This call bascially send a HTTPS POST method to **api2.branch.io/v1/open**<br />
   This API is a **3rd** party call that provides Deep-Linking for mobile device. In our case, TicketMaster uses branch.io API to first detect if user has TicketMaster App on their device. if has, the page would be redirected to a specific location inside the TicketMaster APP, or if not, the page would continue on the browswer.<br /><br />
   ```{"session_id":"762205744628531442",```
    ``` "identity_id":"762205744627494358",```
    ``` "link":"https://ticketmaster-us.app.link?%24identity_id=762205744627494358",```
   ```  "data":"{\"+clicked_branch_link\":false,\"+is_first_session\":true}",```
  ```   "browser_fingerprint_id":"760604525505416595",```
   ```  "has_app":false}``` <br />
   Above is the response JSON file. We can see the last key/value pair : ```"has_app":false``` implies that I do not have a APP on my device, which makes sense because I am using Chrome on my laptop.<br /><br />
    I do not see any calls being blocked on www.TicketMaster.com<br />
    However, I change to www.groupon.com and find Chrome blocked the following link:<br />
    https://ads.stickyadstv.com/user-registering?dataProviderId=1025&userId=XlREW9HM4cYAABHQfs0AAABA%26453 <br />
    From the URL we could easily identify that it is an advertisement and I find it contains many re-directs when I click on it.<br />
# - Part 2 Chaining API Requests

### TicketMaster API
   ![ticketmaster](https://github.com/shixianc/hiring-intern/blob/master/screenshots/Screen%20Shot%202020-02-29%20at%201.10.05%20AM.png)<br />
    I signed up at **TicketMaster Developer** and I retrieved the customer key from TicketMaster Discovery API. It is an free API that provides basic Events searching function based on my Geo Location/ distance, etc. <br />
    I created a simple Java Web Application, and I created a class "SearchItem" that implemented the HttpServlet:<br />
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
    ```}```<br />
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
   ![request1](https://github.com/shixianc/hiring-intern/blob/master/screenshots/request2_response_body.png);<br />
   We can examine the response body which shows that the categories from second reqeust is all "Arts & Theatre". (The whole response body can be found in src/ folder)<br />
    
# - Part 3 Chaining API Requests with Apica
  
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


# Conclusion 
