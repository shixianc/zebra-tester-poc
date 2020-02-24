# Apica Engineering Internship - Technical Exercise

Applying to be an Intern at [Apica](https://apicasystems.com)? You are in the right place. 

<img src="https://files.apicasystem.com/HiringEngineersUS/Apica+Rooftop+Meetup.jpeg" width="625px" height="415" alt="ApicaRooftopBeers" title="Apica Team on our Santa Monica rooftop">



## Getting Started

Please read through the exercises before starting.



**Setup**

Before starting please contact support@apicasystems.com with the subject line "Candidate Exercise - Agent Install Credentials".  In your message specify that you are asking for:
1) Trial Account creation to ASM 
2) Credentials to authenticate your private Apica agent.

For the agent installation (Bonus):
- Create an AWS Account - https://aws.amazon.com/account/
- Create an EC2 instance using a [CentOS 7 Community AMI](https://aws.amazon.com/marketplace/pp/B00O7WM7QW?ref=cns_srchrow)

**Downloads**

* Get the Selenium IDE Extension - https://www.seleniumhq.org/selenium-ide/
* Apica agent package (found in steps below)
* Apica Zebra IDE
	- [Windows](http://zebrascriptingtools.apicasystems.com/download/zst-0.5.5.msi)
	- [Mac](http://zebrascriptingtools.apicasystems.com/download/zst-0.5.5.dmg)
	- [Linux](http://zebrascriptingtools.apicasystems.com/download/zst-0.5.5.deb)


To submit your answers:

1. Fork this repo.
2. Add your notes and answers to **answers.md**
3. Commit as much as needed to support your answers.
4. Submit a pull request.

Use screenshots, gifs, videos! Any sort of creativity or interesting formats are totally welcome in presenting your solutions.  However, please keep your content organized and professionally formatted.


## The Exercise - Part 1 API Investigation

- Using your Browser's Development Tools, bring up the Network tab.  Ensure the record light is on and load any web page. Find a microservice call.
- Copy the request and response into your **answers.md** 

**Questions:**
1. Describe the call's function. Is it a 1st or 3rd party call?
2. Are you using an ad blocker?  Were there any calls blocked from posting information about your session?

## The Exercise - Part 2 Chaining API Requests

Please provide screenshots and copy+paste your code snippets for all steps.

- Sign up for developer access to a familiar REST API, use another REST API that you are familiar with, or use a public sandbox.  Bonus points for virtualizing your own API sandbox or knowledge/use of your own web microservice endpoints.
- Understand the HTTPS schemes available and select 2+ related requests to create a meaningful transaction

| Example   |
| ------ |
|  "Find a **User**, then find their **Order History**." |
| 1.  The first request might use a request to the endpoint `GET /user` |
| 2.  Then selecting a User from the previous response, a subsequent request would collect the Orders of that user using a query with the request: `GET/orders?` or part of the request body content `POST/orders`  ..depending on how your chosen  works.) |
| Bonus points for using this to automate a manual task repeated often.|

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



## The Exercise - (Bonus) Part 4 Account Setup and Private Agent Installation

Please provide screenshots and copy+paste your code snippets for all steps.
1. Setup Account
- Select a web site / application / web service to be the target of a group of monitors
- Within the Apica Synthetic portal create 3-4 monitoring checks against your chosen site (or however many you feel appropriate to evaluate that site and its components)
2. Install Agent
- Download the agent package found [here](https://apica-packages.s3.eu-central-1.amazonaws.com/current/asm-browser-agent/1.2.2/el/7/asm-browser-agent-1.2.2-1.el7.x86_64.rpm)
- Install instructions found [here](https://files.apicasystem.com/se/ASM+Agent+Installation+Manual+-+CentOS7.pdf)
- Once the agent is installed, started, and becomes registered (it may take up to 30 minutes), create a check from your new private location.
- Remember to terminate any running instances!



# How do I submit my results?

1. Get in touch!
2. Fork this repo.
3. Commit your work within **answers.md**
4. Submit a pull request against this upstream repository.

Please reach out to ask questions if you have any!  

# Questions?
File an issue in this repository.
