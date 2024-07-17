# Task Manager Test Suite

This is a test suite for a basic CRUD (Create, Read, Update, Delete) application for managing tasks. The tests are written in Java using Selenium and TestNG.

## Features

- Automated tests for creating a new task
- Automated tests for viewing all tasks
- Automated tests for editing a task
- Automated tests for deleting a task

## Requirements

- Java JDK 8 or higher
- Maven
- ChromeDriver
- TestNG

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/FernandoSanta08/TaskTestSelenium task-manager-tests
    cd task-manager-tests
    ```

2. Install the dependencies:
    ```bash
    mvn install
    ```

3. Download the appropriate WebDriver for your browser (e.g., ChromeDriver for Google Chrome) and make sure it is available in your system PATH.

## Running the Tests

1. Run the tests:
    - Right-click on the `testng.xml` file in the Project Explorer.
    - Select `Run As -> TestNG Suite`.

2. Generating the report:
    - After the tests have run, an HTML report will be generated in the `test-output` directory.