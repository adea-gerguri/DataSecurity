# Password AES Application

## Introduction

This is a password managment application built using JavaFX, following the Model-View-Controller (MVC) architecture. It provides functionalities for registration, login, password generation of three different categories (weak, medium and strong). The application uses SceneBuilder for creating FXML files and is developed using IntelliJ IDEA.

## Features

- User Registration: Users can sign up by providing their details.
- User Login: Registred users can log in to the application.
- Password Generation: Users can generate weak, medium and strong passwords.
- Password Encryption: Passwords are salted and hashed using AES encryption.

## Application Structure

The project is organized in several packages:

- app: Contains the Main application class and Navigator class for scene navigation.
- controller: Contains controllers for handling user interactions
- model: Contains data transfer objects DTOs and the User model.
- repository: Contains the UserRepository class for database operations
- service: Contains utility classes for connection with database, password hashing, and user services.

## Setup

### Tools needed
- Java Development Kit (JDK) 
- JavaFX SDK
- MySQL Database
- IntelliJ IDEA ( or any other Java IDE)
- SceneBuilder - used for creating FXML files
- Dalle3 - used for AI image generator

### Database Setup
1. Install MySQL and create a database named 'datasecurity'
2. Create  users table with the following schema:

```
create table users (
	id integer primary key auto_increment,
    firstName nvarchar(30),
    lastName nvarchar(50),
    email nvarchar(300),
    salt nvarchar(100),
    passwordHash nvarchar(500)
);
```

## Configuration

1. Clone the repository
2. Open the project in your selected Java IDE.
3. Ensure the JavaFX SDK is added to the project libraries.
4. Configure the database connection in `DBConnector.java`:

```
private static String URL = "jdbc:mysql://localhost:3306/datasecurity";
private static String USER = "root";
private static String PASSWORD = "your_password";
```
### Running the Application
1. Open the Main class in app package.
2. Run the Main class.

# Usage

## User Registration

![image](https://github.com/adea-gerguri/DataSecurity/assets/153314075/aa7f680b-5acd-4547-8901-1637b312f672)


## User Login

![image](https://github.com/adea-gerguri/DataSecurity/assets/153314075/14c88ca4-7213-4c9c-84f1-af35955df89a)


## Password Generation

![image](https://github.com/adea-gerguri/DataSecurity/assets/153314075/16467dca-8070-4f3d-8c71-d1eaec50a035)

## Dependencies

- JavaFX SDK
- MySQL JDBC Driver

## Authors

[Adea Tabaku](https://github.com/adeatabaku1)

[Adea Gerguri](https://github.com/adea-gerguri)

[Adea Lluhani](https://github.com/adealluhani)


## License

This project is licensed under the MIT license.
