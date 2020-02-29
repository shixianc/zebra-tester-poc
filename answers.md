# Apica Engineering Internship - Technical Exerciseds

# - Part 1 API Investigation
 
# - Part 2 Chaining API Requests
 
# - Part 3 Chaining API Requests with Apica
  
# - Part 4 Java Exercise

  ![Substring Applet Screenshot](https://github.com/shixianc/hiring-intern/blob/master/screenshots/Screen%20Shot%202020-02-28%20at%205.14.27%20PM.png)
                     (*Screenshot for my getSubString() function running as a Java Applet*)
### Algorithm: 
Traversing the whole input string character by character. When finding a match on the first letter, program would call another private method *check()* to check if the match found. With multiple constraints, it would output the correct substring in between [fromString, toString]. Source code can be found in this repository!<br />
**Time Complexity: O(m\*n) Space O(1)**    *(m is "inputString" length, n is "fromString" and "toString" length.)*<br />
**Space Complexity: O(1)**<br />
Optimization to O(n) time by using Rolling Hash method. (detailed implementation in the comment of the source file.)

### Import as Java Plugin:
I also convert it into a **Zebra IDE Plugin** and test and run on my localhost.<br />
I build my Plugin by implementing **LoadTestPluginInterface** from library **dfischer.utils**<br />
The main mechanism involves the three states: **Construct(), Execute() and Deconstruct().**<br />

First I import it from **Custom Java Plugin Tab** 
![import plugin](https://github.com/shixianc/hiring-intern/blob/master/screenshots/add_plugin.png)<br />
Then I add 3 Zebra variables and use them as the parameters of my Java Plugin.
![import plugin](https://github.com/shixianc/hiring-intern/blob/master/screenshots/variables.png)<br />
It runs successfully
![import plugin](https://github.com/shixianc/hiring-intern/blob/master/screenshots/run.png)<br />
From the **Log Files** we could find the output is correct.<br />
![import plugin](https://github.com/shixianc/hiring-intern/blob/master/screenshots/log_file.png)


It teaches me a lot.  construct execute  deconstruct... 
