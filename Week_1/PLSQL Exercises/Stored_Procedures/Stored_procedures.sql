-->create savings account table
CREATE TABLE savings_acc (
    accId NUMBER PRIMARY KEY,
    customerID NUMBER,
    balance NUMBER
);
-->Insert data into the savings account table
INSERT INTO savings_acc VALUES (1, 101, 15000);
INSERT INTO savings_acc VALUES (2, 102, 19999);
INSERT INTO savings_acc VALUES (3, 103, 389256.29);
INSERT INTO savings_acc VALUES (4, 104, 76000);

COMMIT;
--drop table savings_acc;

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN

   FOR acc IN (
      SELECT accId, balance
      FROM savings_acc
   )
   LOOP

      UPDATE savings_acc
      SET balance = acc.balance + (acc.balance * 0.01)
      WHERE accId = acc.accId;

   END LOOP;

   COMMIT;

   DBMS_OUTPUT.PUT_LINE(
      'Monthly Interest Applied Successfully'
   );

END;
/

BEGIN
   ProcessMonthlyInterest;
END;
/

SELECT * FROM savings_acc;
--> Scenario-2
CREATE TABLE employees (
    empID NUMBER PRIMARY KEY,
    empName VARCHAR2(50),
    department VARCHAR2(30),
    salary NUMBER
);

INSERT INTO employees VALUES (1,'Shahi','HR',75000);
INSERT INTO employees VALUES (2,'Devika','IT',65000);
INSERT INTO employees VALUES (3,'Alekhya','Sales',70000);
INSERT INTO employees VALUES (4,'Satya','Finance',80000);
--truncate table savings_acc;

COMMIT;

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    deptName IN VARCHAR2,
    bonusPercent IN NUMBER
)
AS
BEGIN

   UPDATE employees
   SET salary =
       salary + (salary * bonusPercent / 100)
   WHERE department = deptName;

   COMMIT;

   DBMS_OUTPUT.PUT_LINE(
      'Bonus Updated Successfully'
   );

END;
/

BEGIN
   UpdateEmployeeBonus('IT',10);
END;
/

SELECT * FROM employees;

-->Scenario-3
SELECT * FROM savings_acc;

CREATE OR REPLACE PROCEDURE TransferFunds(
    fromAccId IN NUMBER,
    toAccId IN NUMBER,
    amount IN NUMBER
)
AS

    sourceBalance NUMBER;

BEGIN

    SELECT balance
    INTO sourceBalance
    FROM savings_acc
    WHERE accId = fromAccId;

    IF sourceBalance < amount THEN

        DBMS_OUTPUT.PUT_LINE(
            'Transfer Failed: Insufficient Balance'
        );

    ELSE

        UPDATE savings_acc
        SET balance = balance - amount
        WHERE accId = fromAccId;

        UPDATE savings_acc
        SET balance = balance + amount
        WHERE accId = toAccId;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE(
            'Transfer Successful'
        );

    END IF;

END;
/

BEGIN
   TransferFunds(2,4,5000);
END;
/

SELECT * FROM savings_acc;