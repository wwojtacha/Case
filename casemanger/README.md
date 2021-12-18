# Case Manager

Before starting the application, mysql database named 'case_manager' is required running on port 3306.
Additionally, mysql user named 'casemanager' identified by password: 'password' is also required.

In a nutshell, after logging to mysql client:

    create database case_manager;
    create user 'casemanager'@'localhost' identified by 'password';
    grant all privileges on case_manager.* to 'casemanager'@'localhost';
    flush privileges;

To run the application, go to directory with pom.xml file and type:

    'mvn spring-boot:run'

The application runs on port: 8500. To make requests, using for instance Postman, use url:

    http://localhost:8500

In order to build the application with tests triggered, go to directory with pom.xml file and type:

    'mvn clean install'

