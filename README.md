## Overview
LuxAuto is a Java EE web application that manages **automotive parts orders**.  
It allows supervisors and managers to securely log in, record customer orders, and monitor order statuses.  
The application solves the problem of **tracking delayed orders, filtering recent activity, and managing customer data** in a structured and efficient way.

## Features

### Supervisor Features
- Login to the system
- Add new orders
- View orders under specific conditions (e.g., under 25 years old, past 90 days)  
- Check critically delayed orders flagged by the system  
- Logout securely  

### Manager Features
- Role-based access with restricted views  
- Monitor system-wide order statistics  
- Track overdue orders and ensure timely resolution  
- View all customer orders in tabular format with detailed information  

## Technologies Used
- Java  
- JSP  
- Servlets  
- EJB  
- JPA  
- Apache Derby  
- GlassFish / Payara  
- HTML

##SCREENSHOTS
 ![Login to the system](https://github.com/user-attachments/assets/e8cff5d7-f445-42d2-8100-537886194bd3)  
 ![Add new orders](https://github.com/user-attachments/assets/6f4c769d-baa9-4a46-aa53-ed043e8a52ce)
 ![View orders](https://github.com/user-attachments/assets/eba5dd2e-21ec-4e45-ab77-2b17c7945ab1)  
 ![View critically Delayed Orders](https://github.com/user-attachments/assets/0255decf-ff00-44e9-9ff6-79b508fc964b)
 ![Security reservation](https://github.com/user-attachments/assets/5341beb0-1bff-4aa8-bdac-8bcb5676acfb)
![Logout page](https://github.com/user-attachments/assets/fd4f19e9-740f-4959-9aac-32831e433dc1)
![Raw database](https://github.com/user-attachments/assets/37ba88be-c4ad-44a7-adfb-16c3d6502aaa)

## Installation

### Prerequisites
- NetBeans IDE  
- GlassFish or Payara Server  
- Apache Derby  

### Setup
1. Start Apache Derby.  
2. Open the project in NetBeans.  
3. Clean and Build the project.  
4. Deploy to GlassFish/Payara.  
5. Run the application.  

## Security Roles
- Supervisor 
- Manager  

## Author
Rethabile
