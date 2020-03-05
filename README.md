# QA Assignment for your company

## About
This is my attempt at the QA assignment for your company

## Requirements
- git
- Java 1.8

## Instructions for OsX 
- Clone the repo \
`git clone https://github.com/sandeepthukral/qa-assignment-mq.git`
- Once done, move into the repo folder\
`cd qa-assignment-mq`
- Run the following command to execute the tests \
`./gradlew clean test`
- The report will be available in the folder `build/test-report/cucumber`. Open it using the command \
`open build/test-reports/cucumber/cucumber-html-reports/overview-features.html`

## Instructions for Windows (this project has not been tested on Windows)
- Clone the repo \
`git clone https://github.com/sandeepthukral/qa-assignment-mq.git`
- Once done, move into the repo folder\
`cmd qa-assignment-mq`
- Run the following command to execute the tests \
`gradlew.bat clean test`
- The report will be available in the folder `build\\test-report\\cucumber`. Open it by navigating to and double-clicking the file \
`build\\test-reports\\cucumber\\cucumber-html-reports\\overview-features.html`

### Options
- The tests execute by default on Chrome. In order to run the tests on Firefox,\
`./gradlew -DBROWSER=firefox clean test`\
The options are `chrome`, `firefox`, `ie`, `edge`, `opera`
(The project has been tested on OsX with Chrome and Firefox)

## Package information

### Components of the framework
- The framework uses Java, jUnit, Selenide, Cucumber JVM, REST Assured
- Selenide manages getting the relevant driver and also starts the webdriver. \
But it mainly is a wrapper on selenium webdriver, providing useful, fluent access to elements and commands on the same.
- REST Assured has been use to make REST calls to endpoints exposed by the application for test data setup and cleaning.
- The framework is ready for being executed on a remote hub. 
This will be useful when running on Jenkins using docker solutions like selenoid or zalenium.

### Structure
- `sandeep.qa.features` - Contains the feature files
- `sandeep.qa.pages` - Page Object implementation
- `sandeep.qa.runner` - Contains the TestRunner 
- `sandeep.qa.steps` - Contains the Step Definition Files
- `sandeep.qa.utils` - Utilities and Hooks code 

### Classes
- *TestBase* - Does one-time reading of configuration and test data.
- *Context* - Helps share data across steps
- *TestRunner* - The runner for Cucumber 
- *Utils/Cleanups* - Runnable methods to be executed later
- *Utils/Hooks* - Before and After hooks and checks for JS Errors
- *Utils/EndpointsApi* - Api to call endpoints that the browser calls. Faster data setup and teardown
- *Utils/LaterExecution* - Setting and executing data cleanup Runnable methods.

### Notes on adding tests
- You need to add new scenarios in existing feature files, or create new feature files for new features in the features package.
- Then the glue code for the new steps will have to be written in the steps package.
- To support these new steps, you might need to extend the Page Object files in the pages package.

## Additional tests
Additional tests that could be added based on the limited understanding of the application under test 
have been mentioned as commented scenarios in the feature files.

## My thought process

### Getting started
- I first started with the instructions I received in the email explaining the asignment.
- I then began my exploration of the application. I clicked on all buttons and observed what they did.
- I also took a look 'under-the-hood' by monitoring the Network and Application section of DevTools.
I was looking for the network calls made, their payloads and headers and the cookies being set.
- Based on this exploration, I wrote down the test scenarios I would like to execute.

### Choice of frameworks and components

#### Cucumber
- I chose Java and Cucumber because BDD makes it easier to read the scenarios. 
This can lead to more involvement of other stakeholders in the testing process.
If this is not a requirement in the project, we can fall back to more traditional test automation in JUnit or TestNG.

#### Selenide
- I chose selenide as it is a very convenient wrapper over the standard WebDriver. 
It allows me to and not worry about managing WebDriver and individual browser drivers.

#### REST Assured
I chose REST Assured to make REST calls to endpoints exposed by the application for test data setup and cleaning.

### Data use
- I have added code that will clean test data as much as possible. 
Any test data created for editing or deleting a customer is deleted in the After call.
This ensures a cleaner list of test employees in the application.

### Checks for JS Errors
Frontend components, especially VueJS and React, throw JavaScript errors in the console if something goes wrong with them.
These errors usually result in frontend issues and should be caught and reported.

The framework has the capability to fail tests if SEVERE JS errors are observed. But it has been turned off for now, 
because an error is reported when creating a user with invalid email address.  

## Further (proposed) improvements for the framework
### Run the tests on CI platform
- Run tests on selenoid docker instances (using REMOTE_DRIVER option)
- Dockerize the text execution environment itself
- Wrap it in docker-compose
- Write a shell script to execute the tests. This can be extended to get inputs from Jenkins parameters.

### Parallel execution of tests. 
That *might* require replacing a few components of the framework, like jUnit with TestNG.
This is not yet required for this solution but would be for a bigger project.

### Using API calls in place of UI flow
If we have access to (internal) APIs and some more time then we can automate user login or further improve user creation.
via API calls instead of via the UI. This can help speed up the process, ensure test data is always present 
when required and finally clean it up (if required).