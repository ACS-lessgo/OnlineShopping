# OnlineShopping
---
### Project Abstract and Problem Statement: 

- Application to be developed is an E-Commerce Web Application. The product will provide platform for several individuals and companies to sell their products. The application is intended to be small and resource efficient. Application will implement all the CRUD operations on database with strict constriction to DRY principle. The goal of our application is to provide a quick and easy to use interface for all users. The system should be available to be used with the least number of variable factors that can affect it. 
Online shopping application has 3 users: 
1. 	Admin 
2.	Retailer 
3.	User 

- UI will be efficient and user-friendly with simple transitions and minimal fields in forms. User will be provided with a search bar to further ease the process of getting an eye on his need from the application. Also, breadcrumbs will be enabled on all navigations on an attempt to eliminate memory constraints and implementing forgiveness. Several features that’ll help the user to customize his/her window or view (example sort, filter) will be implemented. Screenreader will be implemented for visually impaired users. The application will be totally responsive thereby making it mobile. 
Application will be enhanced to ease the cumbersome process of shopping from one website and comparing on the other. Equipping compare will help the user to better decide on their choice. User can compare up to four products of a single category. The system will be available to all users but compare and checkout component will require user to signup/login. Signup and login will contain minimal fields and data fed in the form will be secure. The cart page, along with other pages will also be dynamic. The user will have the option to update quantity on the cart page i.e. before he proceeds to checkout. Admin panel will also be integrated, so that the admin can decide/update on products, their quantity, revised prices and all other provisions that’ll be needed by the companies that are using the platform to sell their products. The product will be perennially exposed to enhancement. The goal of our system is not just to sell the product to the buyer, but also to make him aware of what he is buying. UI will be userfriendly, working will be efficient and data will be secure. The system will allow user to shop around with ease and open doors to many small retailers that would never be in business if they had to incur the high cost of owning a brick and mortar store. 
---
### Mandatory Modules: 

1. Login: The user can login using email and password. If the user fails to enter correct email and password, the Forgot Password option can be clicked which will allow the user to reset the password with OTP. The user can purchase a product, compare or add to wish list only when he/she logins. 
 
2.	Signup: Users should enter their personal details like name, email id, address, mobile number. The user must choose a password for himself which will be used for future logins. The password will be encrypted before being fed in the DB. After successful registration, the user can login to the application. 
 
3.	User: The user will be provided with features like sort, filter, on the home page, to ease the search of the product. Sorting can be done either alphabetically based on product name or according to the product price (Low to High and High to Low). Filtering can be done with respect to price or brand of the product.  
The user can search for a product by entering a keyword from either of its name or description. While going through the products if the user reaches the end of the scroll bar, the page will be refreshed to display more products. The user can see the magnified image of the product if mouse pointer is hovered on the product image.  
If the user likes a product but does not wish to buy it now, he/she can add it to the wish list. If a user is in a dilemma as to which product to choose, there is an add to compare option for each product wherein the user can select different products for comparison (maximum 4) from search result page, home page, product page or compare page itself. The user can also remove a product added to compare. A product can be added to cart if the user decides to purchase it. The user can update the quantity of the product using plus minus signs which will auto-update the price. The user can proceed to checkout when he decides to purchase product(s).  The User Profile will display wish list and details of the user. 
 
4.	Retailer:  A retailer can update(add/modify/delete) stock as and when he wishes. The retailer can view product information and total revenue generated. The retailer has privileges to decide about the pricing of the products. 
 
5.	Admin: Admin can view all products and retailers, add or remove a retailer, verify legitimacy of updates done by a retailer. All the updates done by retailers have to be approved by the admin. 


### Agile Methodology: 

Abstract: 
Agile development is a group of software development methodology based on iterative and incremental development, in which requirements and solutions evolve through collaboration between self-organizing, cross-functional teams. 
 
Steps to follow in Agile methodology: 

---
# Approach

- To integrate your HTML/CSS files with a database (HSQLDB) and build an eCommerce webpage, you can use Java Server Pages (JSP) along with Java as the backend language. Here's a step-by-step guide on how to approach the integration:

Set up your Java Development Environment:

- Install Java Development Kit (JDK) on your computer.
Set up a code editor or Integrated Development Environment (IDE) for Java development. Eclipse, IntelliJ IDEA, or Visual Studio Code with appropriate extensions are popular choices.
Create a Java Web Project:

- Set up a new Java web project in your IDE.
Ensure that your project is configured to use a Java server, such as Apache Tomcat.
Design the Database Schema:

- Plan and design the database schema for your eCommerce application using HSQLDB. Define tables for products, users, orders, etc.
Create the necessary SQL scripts to create tables, insert initial data, and set up the database.
Establish the Database Connection:

- Use JDBC (Java Database Connectivity) to connect your Java application to the HSQLDB database.
Implement a database utility class to manage database connections and query execution.
Convert HTML/CSS to JSP Pages:

- Convert your HTML/CSS files into JSP pages. JSP allows you to embed Java code within HTML to dynamically generate content.
Use JSP tags (such as <jsp:include> or custom tags) to modularize and reuse parts of your web page layout.
Implement Java Servlets or Controllers:

- Create Java servlets or controllers to handle incoming HTTP requests from the JSP pages.
Use Java to process data from the database and pass the necessary information to the JSP pages.
Implement eCommerce Features:

- Implement shopping cart functionality, user registration, login, product listing, and checkout features using Java and JSP.
Use Java classes to handle the business logic, such as adding items to the cart, calculating totals, and processing orders.
Use JSTL (JavaServer Pages Standard Tag Library):

- JSTL provides a set of custom tags for common web development tasks, such as iteration, conditionals, and formatting.
Utilize JSTL tags in your JSP pages to keep the Java code clean and separated from the presentation layer.
Test and Debug:

- Thoroughly test your eCommerce application, including functionality, user experience, and database interactions.
Debug and fix any issues that you encounter during testing.
Deploy and Run:

- Deploy your Java web application on the Java server (e.g., Apache Tomcat).
Access your eCommerce application through a web browser and verify that it works as expected.
Remember to follow best practices for security, such as preventing SQL injection and protecting sensitive data like user passwords.

 -Integrating HTML/CSS, Java, and HSQLDB using JSP allows you to build dynamic and interactive eCommerce web pages that can interact with the database and provide a seamless shopping experience for users.
•	You need to identify various user stories and its modules/tasks which needs to be implemented in the project as a part of Sprint planning.  
•	Divide all the user stories in two Sprints. Duration of each Sprint will be 3 days.  
•	Any backlogs of Sprint 1 should be included in Sprint 2 along with stories of Sprint 2. 
•	You need to prepare Scrum boards for each sprint. You can include both sprints in one scrum board if there is enough space for the same. 
