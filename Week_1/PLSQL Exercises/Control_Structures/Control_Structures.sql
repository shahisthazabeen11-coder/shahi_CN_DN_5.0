--creating the required tables for Customer & Loans
create table customers (
   customerid number primary key,
   name       varchar2(50),
   age        number,
   balance    number,
   isvip      varchar2(5)
);
create table loans (
   loanid       number primary key,
   customerid   number,
   interestrate number,
   duedate      date
);
--Now we should insert the values into the table
insert into customers values ( 1,'Shahi',62,18000,'FALSE' ),
 ( 2,'Alex', 75,8000,'FALSE'),
( 3,'Jaya',55,32000,'FALSE');

insert into loans values ( 101,1, 10,sysdate + 20),
( 102, 2,12,sysdate + 40 ),
( 103,3,9,sysdate + 15 );

commit;

-->display tables 
select * from customers;
select *from loans;

-->Scenario-1  The bank wants to apply a discount to loan interest rates for customers above 60 years old.
   SET SERVEROUTPUT ON;

begin
   for cus in (
      select customerid
       from customers
       where age > 60
   ) loop
      update loans
         set
         interestrate = interestrate - 1
       where customerid = cus.customerid;

   end loop;

   dbms_output.put_line('Discount Applied Successfully');
end;
/
select * from loans;

-->Scenario-2 A customer can be promoted to VIP status based on their balance.
begin
   for cust in (
      select customerid
        from customers
       where balance > 10000
   ) loop
      update customers
         set
         isvip = 'TRUE'
       where customerid = cust.customerid;

   end loop;

   dbms_output.put_line('VIP Status Updated');
end;
/

select * from customers;


-->Scenario-3 The bank wants to send reminders to customers whose loans are due within the next 30 days.

begin
   for loan_record in (
      select c.name,
             l.duedate
        from customers c
        join loans l
      on c.customerid = l.customerid
       where l.duedate between sysdate and sysdate + 30
   ) loop
      dbms_output.put_line('Reminder: '
                           || loan_record.name
                           || ' Loan Due on ' || loan_record.duedate);
   end loop;
end;
/