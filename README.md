# CustomerManager  
---  

Design Document  

Rania Ibrahim, Christian Turner, Elijah Klopfstein.  

## Introduction  

Managers can see customers and their information with CustomerManager. The system essentially serves as a central repository for companies to store customer and prospect information. This will aid in the tracking of customer interactions. It enables businesses to manage customer relationships, allowing them to grow. They have the ability to edit or delete customer information. They have the ability to add a new customer to the system. In addition to looking for a specific customer.

Managers can interact with CustomerManager using either a set of RESTful service endpoints, or a simple UI, or both.

## Storyboard  
[CustomerManager Storyboard](https://1drv.ms/p/s!Anzr06X31ysqi3jYjLcyFBEfi_WZ?e=W1Ker9)  

## Requirments  

1.  As a manager I want to be able to edit customers information, so that I have the updated information on my customer stored in my database.  

#### Example  

**Given**: A customers information is available.

**When**: The manager selects edit next to the customers infomation. Example (First Name: 'James', Last Name: 'Hill', Email: 'James.Hill@gmail.com', Address: '444 Mont St, Cincinnati, Ohio 45454'). 

**Then**: Then manager can edit the information of the customer and it will be updated in the database. Example (First Name: 'James', Last Name: 'Hill', Email: 'James.Hill@gmail.com', Address: '789 Bill Rd, Cincinnati, Ohio 45434').      


2.  As a manager I want to be able to delete a customer, so that the customers information is deleted in my database.  

#### Example  

**Given**: A customers information is available.

**When**: The manager selects delete next to the customers infomation. Example: delete customer thats first name is 'James'.

**Then**: Then manager can delete that customer and it will be delete from the database.      

3.  As a manager I want to be able to add a new customer, so that I can store the customers information in my database.  

#### Example  

**Given**: A new customer tab is available.

**When**: The manager selects the tab and a form show up for the customers infomation.  

**Then**: Then manager can add the information of the customer, which includes First Name: 'James', Last Name: 'Hill', Email: 'James.Hill@gmail.com', Address: '444 Mont St, Cincinnati, Ohio 45454'. This information will be stored in the database.      

4.  As a manager I want to be able to specifically search for a customer, so that I can preview that customers informatio that is in my database.  

#### Example  

**Given**: A search bar is available.

**When**: The manager enters any of the customers infomation, which include any thing from name, email, and address (First Name: 'James', Last Name: 'Hill', Email: 'James.Hill@gmail.com', Address: '444 Mont St, Cincinnati, Ohio 45454'). 

**Then**: Then manager can then preview the information of the customer that is in the database.      


  

### Class Diagram  

![Class Diagram FinalGroupProjectFall2021](https://user-images.githubusercontent.com/56984616/130507729-afd2e2b6-9df0-4451-970d-b70a570d07cd.JPG)  

### Class Diagram Description  

**Customer:**  The customers table in the database.  

**Data Access Layer:**  (CustomerRepository) This extends Repository.  

**CustomerService:**  This makes use of the customer repository and in the controller layer.  

**Customer Controller Layer:**  This class handles all requests from the clients.  

**The Three Configurations classes:** To enable Spring Data JPA, we need to create two beans: EntityManagerFactory and JpaTransactionManager.  

- @EnableJpaRepositories: this tells Spring Data JPA to look for repository classes in the specified package (net.codejava) in order to inject relevant code at runtime.

- @EnableTransactionManagement: this tells Spring Data JPA to generate code for transaction management at runtime.
### JSON Schema  

> {
>   "type": "object",
>   "properties" : {
>      "name" : {
>          "type" : "string" 
>       },
>       "email" : {
>          "type" : "string" 
>       },
>       "address" : {
>          "type" : "string" 
>       }
>    }
>   }

### Team Memebers and Roles  

- DevOps/Product Owner/Scrum Master: Rania Ibrahim  

-	Frontend Developer: Elijah Klopfstein

-	Integration Developer:  Christian Turner

## Milestones

 [Milestone 1](https://github.com/RIA03B/CustomerManager/milestone/1)  
 
 [Milestone 2](https://github.com/RIA03B/CustomerManager/milestone/2)    
 
 [Milestone 3](https://github.com/RIA03B/CustomerManager/milestone/3)  
 
### github.com project link:  
  
https://github.com/RIA03B/CustomerManager.git  

### Weekly Meeting  

Meeting at 6:00 pm on Sunday night on Microsoft Teams.
