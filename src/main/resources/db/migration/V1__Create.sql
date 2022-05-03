create sequence emp_seq start 1 increment 1;
create table employee (id int8 not null, 
					   seq_name varchar(255), 
					   email varchar(255), 
					   first_name varchar(255), 
					   last_name varchar(255), 
					   primary key (id));