# Server Management Application

The Server Management Application is a Java-based web application built using the Spring Boot framework. It provides a convenient and efficient way to manage the IP addresses of servers in a network.

## Overview

In modern networks, managing IP addresses is a critical task for system administrators. The Server Management Application simplifies this process by offering a user-friendly interface to track, allocate, and monitor IP addresses within a network infrastructure.

## Features
### Using Postman

### 1. List All Server 
-- http://localhost:{port}/server/list

The application allows users to track and record the allocation of IP addresses. It maintains a database of all IP addresses within the network, including their associated servers, status (e.g., available, allocated, reserved), and relevant details (e.g., server name, location).

### 2. Ping A Server
Using the application, administrators can ping IP addresses to specific servers. If the server respone to the ping withing a amount of time it will show that server is running and vice versa, reducing the risk of conflicts or errors. 

-- http://localhost:{port}/server/ping/192.168.1.1
This will return a status OK because 192.168.1.1 is a valid IP Address
--http://localhost:{port}/server/ping/192.168.1.2
This will return a status 500 after 10s because this is not a valid address

### 3. Create A Server
Sending a valid request to backend will create a new running server. If that server came across any erros it will show that server is down
-- http://localhost:{port}/server/save
Sending this with method POST will return a status code 201 and a message "Server Created"
```
{
    "ipAddress": "192.168.1.12",
    "name": "Window Linux",
    "memory": "128 GB",
    "type": "Server PC",
    "imgUrl": "http://localhost:8080/server/image/server1.png",
    "status": "SERVER_UP"
}
```


### 4. Get A Specific IP Address

--http://localhost:{port}/server/ping/192.168.1.1

Sending a request with this will return a status 200 if server is pingable and status code 200 with the message ping failed after 10s

### 5. Delete A Server
--http://localhost:{port}/server/delete/1

To delete a server by sending the server index will return a status 200 if server is found and deleted

## Technology Stack

The Server Management Application is built using the following technologies:

- Java: The application is developed in Java, a widely-used programming language known for its robustness and cross-platform compatibility.
- Spring Boot: The application leverages the Spring Boot framework, which provides a comprehensive set of tools and libraries for building enterprise-grade applications in Java.
- Spring Data JPA: For data persistence, the application employs Spring Data JPA, which simplifies database operations and offers powerful query capabilities.
- MySQL: The application stores IP address information in a MySQL database, ensuring data integrity and reliability.

## Conclusion

The Server Management Application built with Java and Spring Boot offers a comprehensive solution for efficiently managing IP addresses within a network. With it simplifies the administration of IP addresses, reducing manual effort and minimizing the risk of errors. This application is a valuable tool for network administrators seeking to streamline IP address management and ensure the smooth operation of their network infrastructure.
