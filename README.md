# Java Databse Manipulation Server

The JAVA4_LABS project is a Java-based application built on the Spring Boot framework. It is designed to facilitate database access through HTTP requests, providing a flexible and efficient way to interact with the underlying database.

## Features

- Spring Boot: Utilizes the Spring Boot framework for building robust and scalable Java applications.
- Database Access: Allows seamless interaction with a database using HTTP requests.
- Easy Configuration: Simple configuration files to adapt the application to various database setups.

## Project Structure

The project is structured as follows:

- **home.masterserver.config.DatabaseConfig:** Contains loading information logic about database service location, username and password.
- **home.masterserver.controller.AccountsController:** Contains mapping for HTTP requests.
- **home.masterserver.service.DatabaseServer:** Contains main logic for retrieving information from database.
- **home.masterserver.other.Database:** Contains database initialization.
- **home.masterserver.other.Database.Query:** Contains object for quering database.
- **home.masterserver.other.Log:** Contains operation for showing messages in console.

## Dependencies

- **Spring Boot:** For building the application.
- **PostgreSQL JDBC:** For using database operations.
- **Spring Web:** For building RESTful APIs.
- **JSON.org:** For serializing/desirializing JSON objects.

## How to Run the Project

1. Clone the repository: `git clone https://github.com/Aizyka/JAVA4_LABS.git`
2. Navigate to the project directory: `cd JAVA4_LABS`
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`

The application will start, and you can access the API at `http://localhost:8080/{request}`.
