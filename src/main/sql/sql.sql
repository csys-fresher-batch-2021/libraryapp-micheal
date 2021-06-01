create table lib_book_details_db (bookname varchar(255),quantity int);
create table lib_user_details_db(id int,password varchar(255),phone_no bigint,name varchar(255));
create table debtuser_db(taken_book varchar(255),taken_quantity int,taken_date date,user_id int);