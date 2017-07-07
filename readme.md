# mysampleauto

This project is for creating and running automation scripts using the [QAF](https://github.com/qmetry/qaf) framework within few simple steps, and enable you to start writing your tests.

**********************
# Setup

Begin with installing the dependencies below, and continue with the Getting Started procedure below.

### Dependencies

There are several prerequisite dependencies you should install on your machine prior to starting to work with the project:

* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

* An IDE to write your tests on - [Eclipse](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/marsr) or [IntelliJ](https://www.jetbrains.com/idea/download/#)

* [Maven](https://maven.apache.org/)

Eclipse users should also install:

1. [Maven Plugin](http://marketplace.eclipse.org/content/m2e-connector-maven-dependency-plugin)

2. [TestNG Plugin](http://testng.org/doc/download.html)

3. [QAF Cucumber Plugin](https://marketplace.eclipse.org/content/qaf-bdd-editors). Or go to  install new software option in eclipse, and download from https://qmetry.github.io/qaf/editor/bdd/eclipse/

IntelliJ IDEA users should also install:

1. [Maven Plugin for IDEA](https://plugins.jetbrains.com/plugin/1166)

2. [Cucumber Plugin (Community version only)](https://plugins.jetbrains.com/plugin/7212)

TestNG Plugin is built-in in the IntelliJ IDEA, from version 7 onwards.
 
### Other Installations

* For source control management, you can install [git](https://git-scm.com/downloads).

### Project Setup

After setting up all dependencies mentioned above, clone or checkout this project repository to local machine using git. Import the project as existing Maven project in Eclipse/Intellj IDEA.

**********************
# Getting Started

This procedure leads you through the various QAF framework's aspects:

* [Running one of the samples](#running-sample-as-is) in the project as is.
* [Creating your first test](#creating-your-first-test) using the QAF
* [Executing your first test](#executing-your-first-test)
* [Parallel execution](#parallel-execution) of all Test cases/scripts.
* [Viewing test execution results](#viewing-test-execution-results)
* [Advanced features](#advanced-features)

## Running sample as is

Run a sample test suite provided in this project.

The sample scenarios are located under the _scenarios_ folder.

1. Configure yout cloud and credentials in the _appication.properties_ file (under the top _resources/_ folder).
2. Run your test via the right-click menu while hovering on the _testrun_config.xml_ file in _config/_ under the project pane (on the left).

###The sample dose _TODO_.

## Creating your first test

1. Open the project from its _pom.xml_ file, to open it as a Maven project with all the required dependencies.
2. Define your CQ Lab name, username, and password in the _application.properties_ file.
3. Add a  _.bdd_/_.feature_ file under the _scenarios/_ folder, and proceed to create your test using the [test writing guidelines](#test-writing-guidelines).
5. Add a _.loc_ file under the _resources/mobileweb/_ folder, and proceed to create the Object Repository using the [Object Repository creation guidelines](#object-repository-creation-guidelines).
6. Clean your test from the object definitions until all lines become syntax highlighted.
7. [Configure the testng file](#testng-guidelines), and run your test from it.


## Test writing guidelines

### .feature file:

* Begin with @featuretagname, Feature: name of feature, @scenariotagname (can be the same as the feature's tag).
* Write your scenario using [Given/When/Then/And](https://github.com/cucumber/cucumber/wiki/Given-When-Then) BDD statements. Use the commands in the pull-down list for accurate steps syntax, and easy step insertion.
* Write your first scenario for the app's initial starting point, and later create scenarios for other cases; name them differently to enable easy identification in execution report, and name their tags differently if you want to run them separately.


### .bdd file:

* Begin with SCENARIO: name of the test case/scenario
* Add test case related matadata information like description, group information etc...
* Write your scenario using [Given/When/Then/And](https://qmetry.github.io/qaf/latest/scenario.html) BDD statements. Use the commands in the pull-down list for accurate steps syntax, and easy step insertion.

### step library creation:

* Add backend java step library in terms of Java classes to _src/main/java/steps_. Organize and create multiple Java files based on modules in AUT.
* Create functional test steps based on [Test Step Creation Guidelines](https://qmetry.github.io/qaf/latest/Describe_Test_Step.html). Use java approach over bdl.

## Object Repository creation guidelines

1. _.loc_ file is a container for application objects/locators.
2. Name your app's objects as _functionality.purpose_, for example _button.route_, _edit.start_, etc.
3. From each object related line, create a line formatted as <br>`objectname = locatortype=objectlocator`<br>For example <br>`edit.start = xpath=//*[@label="Start location"]`

* If you are using [Qmetry Automation Studio](http://www.qmetry.com/automated-testing-tools-qmetry-automated-studio/). Use Object Spy feature to add, validate and manage objects/locators by connecting with Appium, Perfecto or Web applications UI. 

## Executing your first test

Test scripts can be executed by

1. Setting some [important properites](https://qmetry.github.io/qaf/latest/properties_list.html) in _application.properties_ file
2. [Defining execution suite](#testng-guidelines) in _testrun_config.xml_ file

### TestNG guidelines

1. Under the _config/_ folder, open the _testrun_config.xml_.
2. Identify target test suite to be executed, and verify it's the only one with a **true** _enabled_ property, to prevent the other test suites from running.
3. Add a parameter specifying the type of device, or naming a specific one, to be used for your test execution, for example, <br>`<parameter name="driver.capabilities.model" value="iPhone.*"></parameter>`
4. For platform specific resources to load in case of multi-platform project, use, <br>`<parameter name="env.resources" value="resources/android" />` 
5. While having multiple bdd scenario files and want to run specific, one can use, <br>`<parameter name="scenario.file.loc" value="scenarios/samplesuite.bdd" />` 

## Parallel execution
To run all samples in parallel, you need to configure the _testrun_config.xml_ file, which is located under the _config/_ folder.

1. For each of the test (enclosed within <test>...</test>), set the _enabled_ property value to **_true_**.
2. For the test suite (enclosed within <suite>...</suite>), set the _parallel_ property value to **_tests/methods_**. One can sel number of parallel instancecs by setting _thread-count_ property to respective number.
3. Run your test as before.

[Testng guidelines for parallel execution](http://testng.org/doc/documentation-main.html#parallel-suites)

## Viewing test execution results

### QAF Dashboard

* QAF reporting is a powerful and customizable reporting engine ensures that you have access to all relevant test data like test results,check points,test case time, test step time and environment information.Use powerful filters to slice and dice the data to drill down to exact result you seek.
* Comprehensive drill-down reporting, with each step result, step command log and screenshots.
* Live reporting enables you to view reports of executed tests without waiting for entire suite to finish.
* Get Detailed Reporting including Trending,root cause analysis and Automated screen capture.

To view the test execution report, open _dashboard.htm_ file in browser. Firefox is the recommended browser.

## Advanced features

* Refer to [QMetry Automation Framework](https://qmetry.github.io/qaf/latest/docs.html) for QAF basic and advanced features.


