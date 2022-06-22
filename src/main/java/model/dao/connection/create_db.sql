DROP database if exists R_a;
CREATE database R_a;

USE R_a;

create table Users (
                       id INT primary key not null auto_increment,
                       email varchar(40) not null,
                       passwd varchar(40) not null,
                       name varchar(40) not null,
                       access_level INT not null unique ,
                       money float(9,2) not null
);

create table Orders (
                        id INT not null auto_increment primary key,
                        cost float(9,2) not null,
                        description varchar(100) not null,
                        work_status varchar(40) not null,
                        payment_status varchar(40) not null,
                        review varchar(40),
                        worker_mark INT,
                        user_id INT,
                        foreign key (user_id) references Users(id),
                        title  varchar(40) not null,
                        role_id INT not null,
                        foreign key (role_id) references Users(access_level)
);

insert into Users (email, passwd, name, money, access_level)
values ('manager@gmail.com', 'manager', 'Julia', 13500, 4);

insert into Users (email, passwd, name, money, access_level)
values ('master1@gmail.com', 'master1', 'Vladislav', 1500, 3);
