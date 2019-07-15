# Solutions Engineering Technical Exercise

Applying to be a Solutions Engineer at [Apica](https://apicasystems.com)? You are in the right place. 

<img src="https://files.apicasystem.com/HiringEngineersUS/Apica+Rooftop+Meetup.jpeg" width="625px" height="415" alt="ApicaRooftopBeers" title="Apica Team on our Santa Monica rooftop">



## Getting Started

Please read through the exercises before starting.

* Download Postman here - http://getpostman.com/
* Get the Selenium IDE Extension - https://www.seleniumhq.org/selenium-ide/
* Download Zebra IDE - https://www.apicasystems.com/scripting-tools/

To submit your answers:

1. Fork this repo.
2. Add your notes and answers to **answers.md**
3. Commit as much code as you need to support your answers.
4. Submit a pull request.

Use screenshots, gifs, videos! Any sort of creativity or interesting formats are totally welcome in presenting your solutions.  However, please keep your content organized and professionally formatted.

## The Exercise - Part 1 Chaining API Requests

Please provide screenshots and copy+paste your code snippets for all steps.

- Sign up for developer access to a familiar REST API, use another REST API that you are familiar with, or use a public sandbox.  Bonus points for virtualizing your own API sandbox or knowledge/use of your own web microservice endpoints.
- Understand the HTTPS schemes available and select 2+ related requests to create a meaningful transaction
- Add your chosen requests into a simple Postman collection
- Use the postman documentation [here](https://blog.getpostman.com) & [here](https://learning.getpostman.com/) to chain the requests by extracting data from the first API response into the request of the second.

**Questions:**
1. Why is the global/environment variable necessary?
2. What would happen to the second request if the pre-request script is missing or failed to run successfully?


## The Exercise - Part 2 Chaining API Requests with Apica

Please provide screenshots and copy+paste your code snippets for all steps.

- With Apica Zebra IDE import or manually add URLs from the Postman collection you created in Exercise 1.
- Upload the script to Apica Synthetic Monitoring [ASM](https://wpm.apicasystem.com/) or Apica LoadTest [ALT](https://loadtest.apicasystem.com/).
- Create and execute a monitor or a load test.
- In your **answers.md** comment on the insight and benefit recieved from running this chained transaction as a continuous synthetic monitor or via performance testing.
- Refer to [Apica Zebra documentation](https://academy.apicasystems.com/astdocs/doku.php) for guidance using the toolset

**Questions:**
1. Describe how can users more easily manage multiple variables accross multiple API scripts comparitively with Zebra IDE?


## The Exercise - Part 3 EUM insights with Selenium

Please provide screenshots and copy+paste your code snippets for all steps.

- Using Selenium IDE, create a test case against amazon.com.  Use the recorder to record the transaction:
1. Open `https://www.amazon.com`
2. Search for _"phone cases"_
3. Pick one and add it to your cart
(You do not need to login on your browser (if you are, please remember to remove it from your cart)
- Replay your recording and inspect the recorded actions.   Was the test case able to replay without breaking?
- Next, remove any 'mouse' commands and re-execute the script.  Was the test case able to complete without breaking now?  If not, can you modify any target elements to improve playback?
- Upload to [ASM](https://wpm.apicasystem.com/) and create as a monitoring check

**Questions:**
1. What components of the page HTML change or do you anticipate to change in your scenario over the next few days or weeks?
2. How does (or might) asynchronous javascript modify the rendered contont on the page?  How does this break script execution?


# How do I submit my results?

1. Get in touch!
2. Fork this repo.
3. Commit your work within **answers.md**
4. Submit a pull request against this upstream repository.

Please reach out to ask questions if you have any!  

# Questions?
File an issue in this repository.
