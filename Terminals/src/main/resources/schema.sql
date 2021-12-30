create table ftr_terminals(
terminal_id varchar(20) primary key,
terminal_name varchar(100),
country varchar(30),
item_type varchar(100),
terminal_description varchar(200),
capacity BigInt,
available_capacity BigInt,
status_code varchar(200), 
harbor_location varchar(30)
);