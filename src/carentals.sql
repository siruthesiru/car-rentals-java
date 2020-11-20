
DROP DATABASE IF EXISTS carentals;
-- 
CREATE DATABASE carentals;

USE carentals;

CREATE TABLE IF NOT EXISTS customers (
    id          INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    lname       varchar(80) NOT NULL,
    fname       varchar(80) NOT NULL,
    phone       varchar(15) NOT NULL,
    address     varchar(255) NOT NULL,
    lic_no      varchar(15) NOT NULL
);

-- Add a few customers
INSERT INTO customers (lname, fname, phone, address, lic_no) 
    VALUES 
        ("McGyver","Selena","334-908-221","#64 Wellington Ave., Santa Fe, Burns","TGG-900876"),
        ("Perez","Roberto","998-222-736","Avesian Hills, Samespot city","YL90483-GT"),
        ("Trekk","Trevor Sim","898-839-332","Inferdent Ave., Wallock city","BG-909087-A");

CREATE TABLE IF NOT EXISTS cars (
    id          integer unsigned primary key auto_increment,
    make        varchar(60) not null,
    model       varchar(60) not null,
    plate       varchar(10) not null,
    color       varchar(30) not null,
    `year`        integer(4) not null
);
-- Add a few Cars
INSERT INTO cars (make, model, plate, color, `year`)
    VALUES
        ("Honda","City","RTC-786590","White",2019),
        ("Toyota","Prius","CG-93837","Red",2018),
        ("Nissan","Sentra","KL-98484","White",2016),
        ("Ford","Mustang","UT-90303","Green",1997);

CREATE TABLE IF NOT EXISTS rentals (
    id          integer unsigned primary key auto_increment,
    customer_id integer unsigned not null,
    car_id      integer unsigned not null,
    date_taken  date not null,
    date_returned  date not null,
    deposit     decimal(10,2),
    foreign key (customer_id) references customers(id),
    foreign key (car_id) references cars(id)
);

