# SpringMachineTest

How to Run the Project
1-Clone the Project
    git clone https://github.com/Venkatesh8048/SpringMachineTest.git
    Open in IntelliJ / Eclipse IDE

2 - Create MySQL Database
    Open MySQL and run:
    CREATE DATABASE springmt;

3 - Configure application.properties
    spring.datasource.url=jdbc:mysql://localhost:3306/springmt
    spring.datasource.username=root
    spring.datasource.password=your_password
    
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

4 - Run the Application
    Open main class
    Click ▶ Run
    
    Application will start on: http://localhost:8080

Admin → Owner Flow
     Step 1: Admin Login
    Admin is created manually (database or hardcoded)
    Admin logs into system

Step 2: Admin Creates Owner

Admin can:
    Enter Owner name
    Enter Owner email
    Enter Owner password
    Enable/Disable Owner account
    
    When Owner is created:
    Credentials are sent via email
    Password is encrypted using BCrypt

Step 3: Owner Login

    Owner can:
    Login using username + password

    Access Owner Dashboard
    Add Product
    Edit Product
    Delete Product
    View Product Details

5 - Gmail Configuration (application.properties)

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=yourgmail@gmail.com
spring.mail.password=your_app_password

spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

Enable 2-Step Verification in Gmail
Generate App Password
Use App Password (NOT your Gmail password)

Security Notes
Passwords are encrypted using BCryptPasswordEncoder
Role-based authorization using Spring Security
Only Admin can create Owners
Only Owner can manage products
