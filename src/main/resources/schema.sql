--create an aircraft table
create table aircraft(
    aircraft_id int auto_increment not null,
    reg_code varchar(8) not null,
    enabled BOOL not null,
    notes varchar(666) not null,
    unique (reg_code),
    primary key(aircraft_id)
);
----create flight table
create table flight(
flight_id int not null auto_increment,
flight_reg_code varchar(8) not null,
takeoff varchar(30),
landing varchar(30),
aircraft_id int not null,
primary key(flight_id),
constraint fk_flight
foreign key(aircraft_id) references aircraft(aircraft_id)
);

----create component table
create table component(
componet_id int not null auto_increment,
part_number varchar(10) not null,
last_fitment_time varchar(30),
notes varchar(30),
aircraft_id int not null,
primary key(componet_id),
constraint fk_component
foreign key(aircraft_id) references aircraft(aircraft_id)
constraint check_enabled CHECK(enabled = true) references aircraft(aircraft_id)  
ON UPDATE CASCADE
);
