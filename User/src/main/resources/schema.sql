drop table if exists ftr_user;
create table ftr_user(
user_id BigInt primary key,
first_name varchar(30),
last_name varchar(30),
email_id varchar(30),
mobile_number BigInt,
password varchar(30),
nationality varchar(30),
passport_number varchar(30),
permanent_address varchar(200),
office_address varchar(200),
personal_identification_number BigInt
);
