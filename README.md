# jdbc
JDBC project for student and employee CRUD Operation

# JDBC Projects – Student & Employee Management

This repository contains two Java projects using **JDBC (Java Database Connectivity)** with **MySQL** for learning and practicing CRUD (Create, Read, Update, Delete) operations.

---

## 📘 Project 1: MyJDBCTutorial (Student Management)

### 📄 Description
A simple Java application for managing student records using JDBC. It demonstrates how to connect to a database, create tables, and perform CRUD operations using `PreparedStatement`.

### ✅ Features
- Connects to MySQL database
- Creates `student` table
- Inserts new student data
- Reads and displays all student records
- Updates existing student entries
- Deletes student records

### 📁 Folder Structure
MyJDBCTutorial/
├── Main.java # Entry point to run operations
└── Student.java # Contains all JDBC logic


---
## 🧑‍💼 Project 2: JDBCEmployeeProject (Employee Management)

### 📄 Description
This project handles employee data operations using JDBC in a structured and object-oriented way. It includes database setup and interaction with `employee` table.

### ✅ Features
- Connects to MySQL using JDBC
- Creates `employee` table
- Inserts employee records
- Reads employee data
- Updates employee salary or name
- Deletes employee entries

### 📁 Folder Structure
JDBCEmployeeProject/
├── Main.java # Application driver
└── Employee.java # Employee-related DB methods


---

## 🛠️ Technologies Used

- Java 8+
- JDBC
- MySQL
- Eclipse IDE
- Git & GitHub

---

## ⚙️ Setup Instructions

### 1. 📦 Clone the Repository

```bash
git clone https://github.com/Shivamupa48/jdbc.git

2. 🛠️ Set Up MySQL
Ensure your MySQL server is running

Create the database manually, or use this SQL:

CREATE DATABASE IF NOT EXISTS codingwallahdb;
USE codingwallahdb;

CREATE TABLE IF NOT EXISTS student (
  sid INT(3),
  sname VARCHAR(200),
  semail VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS employee (
  eid INT PRIMARY KEY,
  ename VARCHAR(100),
  email VARCHAR(150),
  salary DOUBLE
);


3. 🧩 Import the Project in Eclipse
Open Eclipse → File → Import → Existing Java Projects → Select the jdbc folder.

Make sure your mysql-connector-java.jar is added to your build path.

4. 🔐 Update Credentials in Java Code
In both Student.java and Employee.java, update:
String url = "jdbc:mysql://localhost:3306/codingwallahdb";
String user = "root";
String password = "root";

5. ▶️ Run the Projects
Right-click on Main.java in either project → Run As → Java Application

📦 Project Tree Overview

jdbc/
├── JDBCEmployeeProject/
│   ├── Main.java
│   └── Employee.java
│
├── MyJDBCTutorial/
│   ├── Main.java
│   └── Student.java
│
├── database.sql           # (optional) DB schema and sample data
└── README.md              # This file
