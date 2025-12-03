# ACM 321 Project Report: Inventory Management System 

# Team Information 

Section:2 

Team Name: Keyboard Boys 

Team Members: 

Selim Eskimumcu - Java Swing/Class

Mirzat Ceylan - Java Swing/Database 

Muhammet Talha Çatal - Database/Report

Atilla Utku Demirci - Design/Architecture 

# Project Overview 

# Objective 

Computer Store Inventory Management System. 

#Store Type 

Computer store, the reason for this is to ensure that inventory (stock) is stored effectively in a store selling computers and technology products. 

# Design and Architecture 

# System Architecture 

# 1. Introduction 

This report explains the System Architecture for the Computer Store Management System. The system is designed to manage computer store operations, including product management, order tracking, customer and supplier information, and payment processing. The system consists of five key components: Product, Customer, Supplier, Order, and Order Details. Each of these components plays a crucial role in the overall functioning of the system. 

# 2. System Architecture 

2.1 Product 

Purpose: The Product component manages all computer hardware and software available in the store. It stores details such as the product's price, stock level, and description. 

Database Structure: 

product_id (primary key) 

name (Product name) 

price (Product price) 

stock_quantity (Stock quantity) 

Relationships: 

It is related to the Order Details table. When an order is placed, the products ordered are stored in the Order Details table. 

2.2 Customer 

Purpose: The Customer component represents the individuals who purchase products. It stores customer details such as personal information, contact details, and delivery addresses. 

Database Structure: 

customer_id (primary key) 

email (Customer's email address) 

phone_number (Customer's phone number) 

Relationships 

It is related to the Order table. A customer can place one or more orders. 

2.3 Supplier 

Purpose: The Supplier component represents the suppliers who provide products to the store. It stores details like supplier contact information and the products they supply. 

Database Structure: 

supplier_id (primary key) 

name (Supplier name) 

contact_info (Supplier contact information) 

Relationships: 

It is related to the Product table. Each product can be supplied by one or more suppliers. 

2.4 Order 

Purpose: The Order component manages the orders placed by customers. It stores details such as the order date, payment status, and total amount. 

Database Structure: 

order_id (primary key) 

customer_id (foreign key) 

order_date (Order date) 

total_amount (Total amount) 

subtotal (Subtotal) 

Relationships: 

It is related to the Customer table. Each order is placed by a customer. 

It is also related to the Order Details table. An order can contain multiple products. 

2.5 Order Details 

Purpose: The Order Details component stores the details of each product in an order, such as the quantity and unit price. 

Database Structure: 

order_detail_id (primary key) 

order_id (foreign key) 

product_id (foreign key) 

quantity (Quantity) 

unit_price (Unit price) 

Relationships: 

It is related to the Order table. It stores the details of the products within a particular order. 

It is also related to the Product table. It contains information about the products ordered. 

# 3. General System Flow 

Customer Registration and Order Placement: 

A customer browses through the store using a web interface or mobile app and selects products. 

When the customer decides to buy a product, it is added to the shopping cart, and the order is placed. 

Order Recording: 

After the customer completes the order, the details are recorded in the Order table, with a reference to the customer who placed the order. 

Order Details: 

The Order Details table stores the products included in the order, their quantities, and unit prices. 

The total amount of the order is calculated based on the products and their quantities. 

Product and Supplier Information: 

Each product is associated with one or more Suppliers. Information about the suppliers who provide the products is stored. 

Payment and Order Completion: 

After the customer makes the payment, the order status is updated, and payment details are recorded. 

# 4. Conclusion 

The Computer Store Management System architecture ensures that each component interacts smoothly with others to facilitate store operations. The components of Product, Customer, Supplier, Order, and Order Details are interconnected in a structured manner to maintain efficient data flow and provide seamless management of products, orders, customers, and suppliers.This architecture provides a clear and organized structure for managing all aspects of a computer store, from product inventory to order processing and payment management. 

# Features and Functionality 

Key Features 

Save or update products, delete products. 

Save or update customers, delete customers. 

Save or update Suppliers, delete suppliers. 

Save or update Order, delete order. 

Save or update Order Details, delete order details. 

Cleaning Information Screen 

 

# Customization 

1. Adding, Updating, and Deleting Inventory Items 

Feature Description: 

This feature allows users (administrators or store managers) to manage the inventory of products. It enables the addition of new products, updating existing product information (such as price, description, or stock quantity), and deleting products that are no longer available for sale. 

 

Use Case:  

A store manager can add a new laptop model to the inventory, update the stock quantity of a particular item, or remove an outdated product. 

 

Benefits: 

Helps maintain accurate and up-to-date inventory records. 

Ensures that customers can only view and purchase available products. 

 

# 2. Managing Supplier and Sales Information 

Feature Description: 

The system includes a feature for managing supplier information. It allows the store to store and update details about each supplier, such as contact information, delivery terms, and the products they supply. 

Additionally, it tracks sales information for reporting purposes, providing insights into sales trends, most popular products, and overall revenue. 

 

Use Case:  

The store manager can update a supplier’s contact details, view a list of products from a specific supplier, or generate sales reports to analyze performance. 

 

Benefits: 

Helps in maintaining strong relationships with suppliers. 

Provides valuable insights into sales patterns, which can help in inventory planning and marketing strategies. 

 

# 4. Customer Management 

Feature Description: 

 

This feature allows the store to track customer information such as names, contact details, purchase history, and shipping addresses. It helps to maintain a database of registered customers. 

 

Use Case: 

 A customer support representative can quickly retrieve a customer’s past orders, address details, and contact information to assist with returns or other inquiries. 

 

Benefits: 

Enables personalized customer service and targeted marketing. 

Facilitates order tracking and faster customer support. 

 

# 5. Order Management (Placing, Tracking, and Completing Orders) 

 

Feature Description: 

The system allows customers to place orders and track their status (e.g., processing, shipped, completed). The store administrator can manage orders, update statuses, and generate invoices. 

 

Use Case: 

 A customer places an order for a computer; the store staff updates the order status once the product is shipped, and the customer is notified when it’s delivered. 

 

Benefits: 

Streamlines order processing and helps maintain order accuracy. 

Provides clear visibility into the order lifecycle for both customers and store employees. 

 
# Sample Workflow 

The GUI part of our project consists of two swing codes.To start the application, the swing code named "Baslangic.java" is executed in the first place and the input frame of the application is opened. By clicking on the "HOMEPAGE" button in this frame, we can open the frame, which is the homepage of our application. 

The name of the swing code, which is the main page of our application, is "ComputerStoreGUI.java"  

If we want to add a new product in the opened frame, we need to enter the values of this field and click on the "SAVE or UPDATE" button. 

In which field (Product, customer,supplier...) to see the saved values if we have saved a value, we should select that field in the "CHOOSE A TYPE" section. 

After selecting the field, we need to enter the id of the selected field in the "ENTER ID : " section. 

And then by pressing the "PRINT" button, we can see the saved data in the "textArea" section. 

The "CLEAR" button clears the use textArea section. 

To delete the saved data, the "DELETE" button is used. 

First of all, the field we want to delete data from the "CHOOSE TYPE TO DELETE" section is selected. 

Then, in the "ENTER ID : " section, the "ID" number in the selected field is entered. 

And when we press the "DELETE" button, the saved data is deleted. 

We can also use the "SAVE or UPDATE" button to update the data.Because that button does both recording and updating. 

Finally, we can do all these operations for other classes as well. 

The way our application works is generally like this. 

 

 

# Object-Oriented Principles 

# Use of Classes and Objects 

In our project, we designed the product, order, order details, supplier, and customer classes using object-oriented programming (OOP) principles. Each class contains objects that perform specific functions and are interrelated. Here are the descriptions of each class: 

Product Class: This class holds all the properties and functionalities of the products. It includes information such as the product name, price, and stock quantity. The Product class also performs functions like updating stock levels and calculating prices. 

Order Class: This class stores information about the orders placed by customers. It contains data such as the order number, date, customer information, and total amount. The Order class also handles actions such as adding, updating, or canceling orders. 

Order Details Class: The Order Details class defines the contents of each order. It includes information about which products were ordered, their quantity, and unit price. This class is used to calculate the total amount of the order. 

Supplier Class: The Supplier class defines the companies or individuals who supply the products. It contains information such as the supplier's name, contact details, and a list of products provided. The Supplier class also includes functions for communicating with the supplier and placing orders. 

Customer Class: The Customer class stores information about the customers. It includes data such as the customer’s name, address, contact details, and order history. The Customer class enables interactions with the customer and viewing the order history. 

By establishing relationships between these classes, we enhanced the functionality of each object and ensured that the data was managed consistently. Through object-oriented programming, we minimized code repetition and created a more modular and maintainable structure for the project. 

 

# Inheritance and Polymorphism 

In a computer store project, inheritance can be used to define a base class like Product, which contains general attributes such as the product name, price, and stock status. Subclasses such as Laptop, Desktop Computer, and Accessory inherit these attributes and methods from the Product class while adding their specific features. For example, the Laptop class might include a battery life attribute, while the Desktop Computer class might have details about the case type or cooling system. 

 

Polymorphism can be implemented through a method like DisplayInfo() in the Product class. This method can be overridden by each subclass to display unique details for different types of products. For instance, the Laptop class can provide information about its battery life, while the Desktop Computer class may show details about its case type or graphics card. This approach allows the program to handle all products uniformly while enabling each subclass to present its specific details, making the code cleaner and more modular.. 

 

# Interfaces and Abstract Classes 

We didn't use any Interfaces or Abstract Class in our Project. 

 

# Database Integration 

# Database Operations 

# 1.Create: 

Users can add new products, customers, suppliers, orders and Order details. 

In this operation, the data entered by the user in the GUI is taken and a new record is inserted into the SQLite database. 

For example, when adding a product, information such as the product name, category, price, and stock quantity is entered and saved in the database. 

# 2.Read 

Users can view existing data. 

In this operation, products, customers, suppliers, or orders are queried from the database and displayed to the user. 

The data retrieved from the database is listed on the GUI or presented to the user through search results. 

# 3.Update: 

Users can update the details of an existing product, customer, supplier, or order. 

When the user wants to modify a record, the related record’s details are first displayed in the form. After the user makes changes, the updated data is saved back into the database. 

For example, if the price or stock quantity of a product changes, the new value is updated in the database and displayed on the information screen. 

# 4.Delete: 

Users can delete an existing product, customer, supplier, or order. 

For the delete operation, the user selects the record to delete, and the selected record is permanently removed from the database. 

For example, when a product is deleted, it is permanently removed from the database. 

These operations facilitate data management according to the user's needs and provide the core functionality of the application. 

 

# Sample Queries 

 

-Listing all products: Retrieves information about all products in the store. 

-Listing products by category: Displays all products in a specific category, such as "Laptop". 

-Adding a new product: Adds a new product to the store, for example, a new laptop. 

-Updating stock after a sale: Decreases the stock quantity of a product after it is sold. 

-Retrieving customer information: Retrieves customer information such as name and email. 

-Listing orders made by a customer: Shows all orders placed by a specific customer. 

-Listing order details: Shows the products and quantities in a specific order. 

-Calculating total sales for a product: Calculates the total sales and revenue for a specific product. 

-Listing suppliers for a product: Shows which suppliers provide a specific product. 

-Deleting a product: Removes a specific product from the store. 

 

 

# File I/O 

# Import/Export Functionality 

In the Java GUI application above, an inventory management system for a computer store has been designed. The application allows users to perform operations on products, customers, suppliers, orders, and order details. This application connects to an SQLite database and performs CRUD (Create, Read, Update, Delete) operations. Here are the key features of the application: 

Database Connection and Table Check: 

It connects to the SQLite database (Project_inventory.db). 

It checks if the PRODUCT table exists, and if not, it creates the table. 

# Product Management: 

Functions for adding and updating information such as product ID, name, category, price, and stock quantity are provided. 

Product data is saved to the database, or an existing product is updated. 

Customer, Supplier, Order, and Order Details: 

Similarly, customer, supplier, and order data is processed with information such as ID, name, contact details, and other necessary information. 

Customer and supplier data is saved or updated in the database. 

# GUI Components: 

Necessary form fields (JTextField) for each operation and buttons (JButton) for saving or updating the form are provided. 

Users can enter data and save or update it in the database. 

# Buttons and Workflow: 

The "SAVE or UPDATE" buttons work based on each data entry. If there is no data, a new record is added; if data exists, the existing record is updated. 

 

# Error Handling 

Database Connection Errors: Errors that occur when connecting to the SQLite database, such as a failed connection, can be captured and displayed to the user through appropriate error messages. These types of errors can be caught using try-catch blocks, and the user is informed that the database connection could not be established. 

 

Database Table Errors: If there is an error while creating or updating a table, an error message is displayed to the user. For example, if an error occurs when trying to create a table, the user is notified that the operation could not be performed. 

 

User Input Errors: If users enter incomplete or incorrect data in the form, the validity of the form data can be checked. If there are missing or incorrect inputs, a warning message is shown to the user (e.g., when fields are empty or when data is entered in the wrong format). 

 

CRUD Operation Errors: If an error occurs during the product addition or update process, error-handling mechanisms are activated. If a product cannot be added, the user is shown a message like "Product could not be added." Similarly, error messages are displayed for updates. 

 

Data Reading and Writing Errors: Errors that occur during reading or writing data to the database can also be controlled and appropriate error messages can be shown. For instance, if no data is found during a database read, the user may be shown a message like "Data not found." 

 

# Challenges and Solutions 

We could not integrate sql and java also we had difficulty writing sql codes in java. 

 
# Future Improvements 

Error handling and user feedback can be added. 

The database connection should not be reopened with each operation; a more efficient connection management can be implemented. 

Aesthetic adjustments can be made for the GUI elements. 

 

# Conclusion 

We have come to the end of this project, which we had a hard time with. Our harmony with the teammates was good and energetic. Thanks to this project, we had the opportunity to develop a Java project with a database. 

 

 



#User Manual 

The store owner enters the ID, name, fee and stock amount of the products from the product section and records them in the system. For customer information, he records the ID, name, email and phone number from the customer section. In the suppliers section, he enters the ID, name and information that he can connect to and records them. In the order section, he enters the ID, customer ID, order day and amount and records them. In the order details section, he enters the ID, customer ID, product ID, quantity and total fee and records them. In the field below, he can access the data he wants with the function he chooses and get information. In addition, he can delete a data he wants to delete with the ''delete'' button. 

 

# References 

Microsoft How to Run SQL Server in Eclipse, 

DB Browser SQLite 

Eclipse 2024,  

Medium.com
