# CustomerManager  
---  

Design Document  

Rania Ibrahim,  

## Introduction  

CustomerManager allows managers to see customers and their information. They can edit customers information or delete customers. They can add a new customer to the system. As well as searching for a specific customer.

Managers can interact with CustomerManager using either a set of RESTful service endpoints, or a simple UI, or both.

## Storyboard  
[CustomerManager Storyboard](https://1drv.ms/p/s!Anzr06X31ysqi3jYjLcyFBEfi_WZ?e=W1Ker9)  

## Requirments  

1.  As a manager I want to be able to edit customers information, so that I have the updated information on my customer stored in my database.  

#### Example  

**Given**: A customers information is available.

**When**: The manager selects edit next to the customers infomation.  

**Then**: Then manager can edit the information of the customer and it will be updated in the database.      


2.  As a manager I want to be able to delete a customer, so that the customers information is deleted in my database.  

#### Example  

**Given**: A customers information is available.

**When**: The manager selects delete next to the customers infomation.  

**Then**: Then manager can delete that customer and it will be delete from the database.      

3.  As a manager I want to be able to add a new customer, so that I can store the customers information in my database.  

#### Example  

**Given**: A new customer tab is available.

**When**: The manager selects the tab and a form show up for the customers infomation.  

**Then**: Then manager can add the information of the customer and it will be stored in the database.      

4.  As a manager I want to be able to specifically search for a customer, so that I can preview that customers informatio that is in my database.  

#### Example  

**Given**: A search bar is available.

**When**: The manager enters the customers infomation.  

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

-	Integration Developer:  Darrion Hoard

## Milestones

 [Milestone 1](https://github.com/RIA03B/CustomerManager/milestone/1)  
 
### github.com project link:  
  
https://github.com/RIA03B/CustomerManager.git  

### Weekly Meeting  

Meeting at 6:00 pm  on Microsoft Teams.
