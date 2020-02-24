# Apica Engineering Internship - Technical Exercise

Applying to be an Intern at [Apica](https://apicasystems.com)? You are in the right place. 

<img src="https://files.apicasystem.com/HiringEngineersUS/Apica+Rooftop+Meetup.jpeg" width="625px" height="415" alt="ApicaRooftopBeers" title="Apica Team on our Santa Monica rooftop">



## Getting Started

Please read through the exercises before starting.


To submit your answers:

1. Fork this repo.
2. Add your notes and answers to **answers.md**
3. Commit as much as needed to support your answers.
4. Submit a pull request.

*Important*: Set the repository as Private (under Repo Settings > Danger Zone > Make Private) and add user ApicaSolutionsEngineering as a collaborator for the Apica repo.  Commit your completed scripts under the newly created repo.

Use screenshots, gifs, videos! Any sort of creativity or interesting formats are totally welcome in presenting your solutions.  However, please keep your content organized and professionally formatted.


**Downloads**

* Postman - https://www.getpostman.com/

* Apica Zebra IDE
	- [Windows](http://zebrascriptingtools.apicasystems.com/download/zst-0.5.5.msi)
	- [Mac](http://zebrascriptingtools.apicasystems.com/download/zst-0.5.5.dmg)
	- [Linux](http://zebrascriptingtools.apicasystems.com/download/zst-0.5.5.deb)


## The Exercise - Part 1 API Investigation

- Using your Browser's Development Tools, bring up the Network tab.  Ensure the record light is on and load any web page. Find an API call made by the browser.
- Copy the request and response into your **answers.md** 

**Questions:**
1. Describe the call's function. Is it a 1st or 3rd party call?
2. Are you using an ad blocker?  Were there any calls blocked from posting information about your session?

## The Exercise - Part 2 Chaining API Requests

Please provide screenshots and copy+paste your code snippets for all steps.

- Sign up for developer access to a familiar REST API, use another REST API that you are familiar with, or use a public sandbox.  Bonus points for virtualizing your own API sandbox or knowledge/use of your own web microservice endpoints.
- Understand the HTTPS schemes available and select 2+ related requests to create a meaningful transaction
- Add your chosen requests into a simple Postman collection
- Use the postman documentation [here](https://blog.getpostman.com) & [here](https://learning.getpostman.com/) to chain the requests by extracting data from the first API response into the request of the second.

**Questions:**
1. Why is the global/environment variable necessary?
2. What would happen to the second request if the pre-request script is missing or failed to run successfully?

## The Exercise - Part 3 Chaining API Requests with Apica

Please provide screenshots and copy+paste your code snippets for all steps.

- With Apica Zebra IDE import or manually add URLs from the Postman collection you created in Exercise 1.
- In your answers.md comment on the insight and benefit recieved from running this chained transaction as a continuous synthetic monitor or via performance testing.
- Refer to [Apica Zebra documentation](https://academy.apicasystems.com/astdocs/doku.php) for guidance using the toolset

**Questions:**
1. Describe how can users more easily manage multiple variables accross multiple API scripts comparitively with Zebra IDE?



## The Exercise - Part 4 Java Exercise

Since ZebraTester and Zebra IDE are Java based, we are sometimes required to extend functionality through the use of plugins  written in Java. Use the IDE of your choice to create this java class (e.g. Eclipse, IntelliJ, ...). You may use Javascript or other programming language for this exercise if instructed to do so.

1. Create a function that accepts 3 parameters to return a sub-string value between two different strings from an input string.
- public String getSubString(input_string, from_string, to_string)
- sample input and output (minus quotes)
	- input_string = “the quick brown fox jumped over the last dog”
	- from_string = “quick”
	- to_string = “the”
	- return value = “ brown fox jumped over ” (including leading and trailing space)
- Bonus for adding as a plugin to Zebra IDE to execute as a component of a script


# How do I submit my results?

1. Get in touch!
2. Fork this repo.
3. Commit your work within **answers.md**
4. Submit a pull request against this upstream repository.

Please reach out to ask questions if you have any!  

# Questions?
File an issue in this repository.
