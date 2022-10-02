# uttermost-rat-9889

Created by -Sukhendu Paul
Application is made with JAVA and MYSQl.

We can start this application by opening src>usecase>main.java

Tables are created with their structural detail :-

// admin table 

    create table admin(
       id int primary key,
       name varchar(20),
       email varchar(20),
       pass varchar(20)); 


  // customer table

   create table customer(
           
       ac_no int primary key auto_increment,
        name varchar(20),
        email varchar(20) unique,
        pass varchar(20),
        amount int,
        loan amt default 0);


//loanApply Table

  create table loanApply(

    ac_no int,
    amount int,
    date  datetime default now() 
);

//loanApproved Table

  create table loanApproved(

    ac_no int,
    amount int,
    date  datetime default now() 

);

//Deposit Table

  create table deposit(

    ac_no int,
    amount int,
    date  datetime default now() 
);

//Payment Table
  create table payment(

    ac_no int,
    amount int,
    date  datetime default now() 
);


feature

1- customer:-
* Register as a new Customer.
* log-in if already a customer of the bank(with email and password)
* Check Balance.
* Deposit money.
* Money-Transfer
* Apply for loan

2-Admin:-
* Log in (with the data already created in the admin table of the database)
* See customer detail
* See deposits made by various customers day-wise.
* see payment made by various customers day-wise.
* Approve the loan which the customer has applied for.

