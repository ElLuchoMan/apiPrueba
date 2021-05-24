
CREATE TABLE employees(
employee_id number primary key,
first_name varchar2(20),
last_name varchar2(20),
email varchar2(20),
phone_number varchar2(20),
job_id varchar2(20),
salary number,
commission_pct number,
manager_id number,
department_id number
);