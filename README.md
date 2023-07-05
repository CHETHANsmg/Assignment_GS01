# Green Stitch
This project is a backend implementation of a login and signup REST API with security and JWT tokens.
It is built using Java, Spring Boot, and utilizes MySql database for data storage. 
The API endpoints provided below demonstrate the functionality of the application.

## Installation
- Java Development Kit (JDK) 8 or later
- Maven
- MySQL Workbench
- Postman (for testing the API)

1. Clone the repository: `https://github.com/CHETHANsmg/Assignment_GS01.git`
2. Dependencies: `Web, Security, JPA, Dev tools,Devtools, lambok, Jsonweb token`

## Usage

Instructions on how to use the project:

1. Run the application: `For GitBash`
2. Open your browser and navigate to `http://localhost:8081`

## API EndPoints
* User Signup
* Method: POST
* Path: http://localhost:8081/app/signup
* Description: Register a new user.
* Request Body: User data in the JSON format (e.g., name, email, password).
* {
  "id":1,
  "fullName": "Admin",
  "password": "Admin@123",
  "email": "Admingmail.com";
}
* Response:
* {
    "id": 1,
    "fullName": "Admin",
    "password": "$2a520$KVzpSGKFpX2eph58ARXLgqumnZKFy3bT8wdJMW3tYH2yqASAucpZPGSG",
    "email": "admin@gmail.com",
    "role": "ROLE_USER"
}

## Validation Rules
The following validation rules are applied to the user entity:

* Full Name:
* Minimum length: 3 characters
* Maximum length: 20 characters
* Password:
* At least 8 characters
* Contains at least one digit
* Contains at least one lowercase letter
* Contains at least one uppercase letter
* Contains at least one special character
* Email:
* Valid email format

## Mysql Database Configuration

spring.datasource.url= jdbc:mysql://localhost:3306/greens\
spring.datasource.username=root\
spring.datasource.password=root\
spring.jpa.hibernate.ddl-auto=update\
spring.jpa.properties.hibernate.format_sql=true\
spring.jpa.show-sql=true\
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect\
spring.mvc.pathmatch.matching-strategy=ant-path-matcher
