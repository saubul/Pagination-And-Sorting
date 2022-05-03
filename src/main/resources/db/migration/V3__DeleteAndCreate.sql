delete from employee where first_name='Ruslan';
insert into employee(id, first_name, last_name, email) values (nextval('emp_seq'), 'Ruslan', 'Nigmatzianov', 'mail@mail.ru'),
															  (nextval('emp_seq'), 'Karina', 'Nigmatzianov', 'mail@mail.ru'),
															  (nextval('emp_seq'), 'Diana', 'Nigmatzianov', 'mail@mail.ru'),
															  (nextval('emp_seq'), 'Barry', 'Nigmatzianov', 'mail@mail.ru'),
															  (nextval('emp_seq'), 'Dan', 'Nigmatzianov', 'mail@mail.ru'),
														  	  (nextval('emp_seq'), 'Borya', 'Nigmatzianov', 'mail@mail.ru'),
															  (nextval('emp_seq'), 'Slava', 'Nigmatzianov', 'mail@mail.ru'),
															  (nextval('emp_seq'), 'Alex', 'Nigmatzianov', 'mail@mail.ru');