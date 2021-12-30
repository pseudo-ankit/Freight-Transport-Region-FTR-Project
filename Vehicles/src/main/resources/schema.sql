drop table if exists ftr_vehicles;
create table ftr_vehicles(
    vehicle_number varchar(20) primary key,
    vehicle_name varchar(50),
    max_lifting_capacity BigInt,
    retire_date Date,
    vehicle_status varchar(30),
    harbor_location varchar(30),
    country varchar(30)
);