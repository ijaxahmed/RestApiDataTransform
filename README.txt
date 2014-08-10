Application: RestApiDataTransform
----------------------------------------

This a Sample Application to access REST API and convert Json response to CSV format
Prerequisite: Java 7
Version: 1.0

Software Development Process: Test Driven Development
Test: src/test


Compile:
----------------------------------------
- Compile Application using following Maven command
              clean compile package assembly:single
-Out Jar will be created in Target folder (target/SampleRestApis-exe.jar)

RUN:
----------------------------------------
Prerequisite: Java 7

- java  -jar  SampleRestApis-exe.jar  “String” 
- Application will ask for output CSV file path , Please Enter the path

Please enter path to save CSV file path (e.g. d:\temp\abc.csv)
