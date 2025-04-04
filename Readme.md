**Overview**

The Real-Time Ticket Management System is a Java-based application designed to facilitate the efficient management of tickets in a shared pool. The system supports interactions between multiple vendors and customers, ensuring seamless ticket allocation and addition in real-time. It features both a Graphical User Interface (GUI) and Command-Line Interface (CLI), providing flexibility for users.

--------------------------------------------------------------------

**Features**


Shared Ticket Pool: Centralized management of tickets.

Vendor Module: Vendors can add tickets to the pool at a specified rate.

Customer Module: Customers can retrieve tickets from the pool or wait if it's empty.

Multi-threading Support: Vendors and customers operate as threads for real-time interaction.

Logging: Logs all vendor and customer actions for traceability.

--------------------------------------------------------------------

**Technologies Used**


Java: Core programming language.

Spring Boot: Backend framework for configuration management.

Angular: Frontend framework for the GUI.

Maven: Dependency management.

--------------------------------------------------------------------

**Installation**


**Prerequisites**

Java JDK 17 or later

Node.js 18 or later

Maven

An IDE such as IntelliJ IDEA or Visual Studio Code

--------------------------------------------------------------------

**Setup**


Extract the project files to a desired location on your machine.

Backend Setup (Spring Boot):

Navigate to the backend directory:

cd backend

Build and run the Spring Boot application:

mvn clean install
mvn spring-boot:run

--------------------------------------------------------------------

**Frontend Setup (Angular):**

Open a new terminal and navigate to the frontend directory:

cd ../frontend

Install dependencies and run the Angular application:

npm install
ng serve

--------------------------------------------------------------------

**Usage**

Starting the Application

Start the backend by running the Spring Boot application as described above.

Launch the frontend to interact with the application.

Command-Line Interface (CLI)

Launch the backend application.

Use the CLI to interact with the ticket pool by executing predefined commands (examples to be added).

Graphical User Interface (GUI)

Access the application in your web browser at http://localhost:4200.

Use the GUI to perform vendor and customer operations intuitively.

