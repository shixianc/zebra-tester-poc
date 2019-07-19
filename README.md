# Technical Account Manager - Technical Exercise

Applying to be a TAM at [Apica](https://apicasystems.com)? You are in the right place. 

<img src="https://files.apicasystem.com/HiringEngineersUS/Apica+Rooftop+Meetup.jpeg" width="625px" height="415" alt="ApicaRooftopBeers" title="Apica Team on our Santa Monica rooftop">



## Getting Started

Please read through the exercises before starting.



**Setup**
Create an AWS Account - https://aws.amazon.com/account/
Create an EC2 instance using a CentOS 7 Community AMI - https://aws.amazon.com/marketplace/pp/B00O7WM7QW?ref=cns_srchrow

Before starting please contact support@apicasystems.com with the subject line "Candidate Exercise - Agent Install Credentials".  In your message specify that you are asking for 1) Trial Account creatino to ASM 2) credentials to authenticate your own private browser agent.

**Downloads**
* Get the Selenium IDE Extension - https://www.seleniumhq.org/selenium-ide/
* Apica agent package (found in steps below)
* Apica Zebra IDE
	- Windows: https://apica-packages.s3.eu-central-1.amazonaws.com/current/ast/0.4.6/windows/2012r2/ast-0.4.6-332-x64.msi
	- Mac: https://apica-packages.s3.eu-central-1.amazonaws.com/current/ast/0.4.6/mac_os_x/10.10/ast-0.4.6-216.dmg
	- Linux: https://apica-packages.s3.eu-central-1.amazonaws.com/current/ast/0.4.6/ubuntu/14.04/ast_0.4.6-56_amd64.deb


To submit your answers:

1. Fork this repo.
2. Add your notes and answers to **answers.md**
3. Commit as much as needed to support your answers.
4. Submit a pull request.

Use screenshots, gifs, videos! Any sort of creativity or interesting formats are totally welcome in presenting your solutions.  However, please keep your content organized and professionally formatted.

## The Exercise - Part 1 Apica Account Setup

- Select a web site / application / web service to be the target of a group of monitors you will create
- Within the Apica Synthetic portal create 3-4 checks (or however many you feel appropriate to evaluate that site and its components)
- Create at least 1 browser-based monitor
- Add select check data from your monitors to an Apica Panel (Note: you will need to ensure the panel_user is added to your check group)

**Questions:**
1. Describe the chosen monitoring checks and the insights they provide to either availability, performance, or other unique insights.
2. Do third-party resources cause any false-positives in the results of your browser check(s)?  What is the signficance of these (or potential) third-party errors detected?


## The Exercise - Part 2 Private Agent Installation

Please provide screenshots and copy+paste your code snippets for all steps.

- Download the agent package found [here](https://apica-packages.s3.eu-central-1.amazonaws.com/current/asm-browser-agent/1.2.2/el/7/asm-browser-agent-1.2.2-1.el7.x86_64.rpm)
- Install instructions found [here](https://files.apicasystem.com/se/ASM+Agent+Installation+Manual+-+CentOS7.pdf)
- Once the agent is installed, started, and becomes registered (it may take up to 30 minutes), create a check from your new private location.
- Remember to terminate any running instances!



## The Exercise - Part 3 API Investigation

- Using your Browser's Development Tools, bring up the Network tab.  Ensure the record light is on and load any web page. Find a microservice call.
- Copy the request and response into your **answers.md** 

**Questions:**
1. Describe the call's function. Is it a 1st or 3rd party call?
2. Are you using an ad blocker?  Were there any calls blocked from posting information about your session?




# How do I submit my results?

1. Get in touch!
2. Fork this repo.
3. Commit your work within **answers.md**
4. Submit a pull request against this upstream repository.

Please reach out to ask questions if you have any!  

# Questions?
File an issue in this repository.
