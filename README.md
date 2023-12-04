# Test Automation Framework Details

## Overview
Welcome to our Test Automation Framework! This Test Automation Framework is designed for web and API testing using Selenium, Java, Maven, TestNG, Rest Assured, Extent Reports, TestNG Listeners, and WebDriver Manager. It follows a hybrid framework approach, integrating test case descriptions and data from external Excel file for easy management and scalability.
## Highlights
This framework is designed to leverage the power of Java 8, especially its functional programming features, to enhance the testing capabilities. Primary focus is on writing clean, reusable code that adheres to the principles of single responsibility and the Singleton pattern to control the use of resources.
## Code Quality and Standards
### SonarLint Integration
To maintain high standards of code quality and ensure adherence to best practices, Sonar Lint integrated [SonarLint](https://www.sonarlint.org/) into the development process. SonarLint is a static code analysis tool that helps detect bugs, vulnerabilities, and code smells in the codebase.

## Technology Stack
- **Selenium**: For automating web applications.
- **Java**: Programming language.
- **Maven**: Dependency management and build automation.
- **TestNG**: Testing framework providing powerful testing strategies.
- **Rest Assured**: For automating API test case execution.
- **Extent Reports**: For generating interactive and detailed reports of test executions.
- **TestNG Listeners**: For additional logging and custom actions during the test lifecycle.
- **WebDriver Manager**: For managing WebDriver binaries automatically.
- **Excel Integration**: For test data and test case management.

## Prerequisites
- Java JDK 11 or above.
- Maven installed and configured.
- Excel installation for handling test data files.
- Chrome Browser.

## Setup
1. **Clone the Repository**
2. **Project directory**: Navigate to the Project directory.
3. **Resolve Dependencies**: Maven will automatically handle all the dependencies specified in the `pom.xml` file.

## Configuration
-For Web UI Testing - Locate and update the `config.properties` file with the required browser, application URL, required report generation details, retrying failed test cases in the src/test/resources/config.properties.
-For API Testing - Locate and update the `api-config.properties` file with the base URL and necessary endpoints in the src/test/resources/api-config.properties.
- Update the ‘testmanager’ excel in the src/test/resources/testmanager.xlsx with the test data and test case details. Please make sure to have the test method name mentioned in both TestCaseManager and TestData sheets.

## Writing Tests
- Write your Selenium and Rest Assured tests using Java in the `src/test/java` directory.
- Define your test cases and associate them with the data in Excel files.

## Running Tests
- Open Bash and navigate to the downloaded project directory. To trigger the tests, run the command ‘bash run_tests.sh’. The Bash script ‘run_tests.sh’ is available in the project root directory. The script checks for the Java and Maven installation in order to run the tests.
- Alternatively, use the following Maven command to execute the tests from cmd window navigating to project root folder:
mvn clean test
- Choose the tests in the ‘TestManager’ excel and TestNG will automatically pick up tests based on the `testng.xml` configuration.

## Test Reports
- After execution, Extent Reports will generate detailed test reports in the `extent-test-output` directory in the name of index.html. Set the value of ‘overridereports’ to yes, if you want to override the test report after each execution.
- TestNG reports can be found in `target/surefire-reports`.

## Customizing Test Execution
- Modify the `testng.xml` file to include or exclude specific tests or groups.
- Choose the necessary test methods for execution available in the ‘TestManager’ excel.

## Package Information

src/main/java/com/pan

 - api: Classes for required POJOs and Request Specifications.
 - config: Interfaces, and Classes for reading config property files.
 - constants: Constants related to the test project.
 - driver: Classes and interfaces for encapsulated driver invocation.
 - enums: Enums to set and control the browser, log, and configuration.
 - exceptions: Framework and Selenium Exception Handler Classes.
 - factory: Factory classes to get WebDriver, config file values, and explicit waits.
 - listeners: Classes for handling Extent report, retrying failed tests, passing data to test methods.
 - pages: Classes implementing functions related to pages of the Web application under test.
 - reports: Classes for logging, Extent report, and Thread safety.
 - utils: Classes for framework-level utilities.

src/test/java/com/pan/tests

 - api: Classes for API test execution, base methods, and assertions.
 - web: Classes for Web UI test execution, set up, and tear down actions.

src/test/java/resources

 - resources: Property files for Web, API testing, and TestCaseManager Excel for passing test cases and test data.
 - apitestdata: Contains input and output JSON files for API testing.

## Web UI Test Scenarios Covered

Web Application under test: [Naveen Automation Labs Open Cart App]( Your Store (naveenautomationlabs.com))
1. Login and landing on the home page.
2. Navigate to Desktop -> Mac page from the home page.
3. Search for iMac in the home page search bar.

## API Test Scenarios Covered

REST API under test: [ReqRes]( Reqres - A hosted REST-API ready to respond to your AJAX requests)
1. Search for a specific user via get users API call by passing ID.
2. Create a new user via post API call.
3. Login via post API call using email and password.