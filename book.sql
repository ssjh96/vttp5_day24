drop database if exists d24;

create database d24;
use d24;

create table Book (
    id int not null auto_increment,
    title varchar(255) not null,
    quantity int default 1,
    is_active boolean default true,

    constraint pk_book_id primary key (id)
);

create table Reservation (
    id int not null auto_increment,
    full_name varchar(255) not null,
    reserve_date date,

    constraint pk_reservation_id primary key (id)
);

create table ReservationDetails (
    id int not null auto_increment,
    book_id int,
    reservation_id int,

    constraint pk_reservationdetails_id primary key (id),
    constraint fk_reservationdetails_book_id foreign key (book_id) references book(id),
    constraint fk_reservationdetails_reservation_id foreign key (reservation_id) references reservation(id)
);

-- insert into pk_book_id (fullName, isActive, balance) 
--     values ('Test Account', true, 300.0);

