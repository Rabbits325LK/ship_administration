--USER_INFO(TABLE)--
drop table user_info;
create table user_info (
user_id int(11) not null primary key auto_increment,
role_id int(11) not null,
user_name varchar(32) not null,
user_pwd varchar(64) not null,
nick_name varchar(32),
gender int not null,
user_idcard varchar(32),
address varchar(128),
email varchar(64),
tel varchar(13),
phone varchar(11),
qq varchar(32),
user_images varchar(128));
--USER_INFO(INSERT INTO)--
insert into user_info(role_id,user_name,user_pwd,nick_name,gender,address,email,tel,phone,qq) values(
1,'rabbits325','lk5115702','梁慷',1,'天心区','rabbits325@live.cn','07315115702','18676660220','464020173');
select * from user_info;
--USER_INFO END--
drop table role_info;
--ROLE_INFO(TABLE)--
create table role_info (
role_id int(11) not null primary key auto_increment,
role_name varchar(32));
--ROLE_INFO_INSERT INTO---
insert into role_info(role_name) values('root');
insert into role_info(role_name) values('admin');
insert into role_info(role_name) values('user');
--ROLE_INFO END--
--SHIP_INFO(TABLE)--
drop table ship_info;
create table ship_info(
ship_id int(11) not null primary key auto_increment,
ship_name varchar(64) not null,
ship_type_code int(11) not null,
ship_size varchar(32),
ship_capacity varchar(32),
ship_images varchar(128));
--SHIP_INFO INSERT INTO--
insert into ship_info(ship_name,ship_type_code,ship_size,ship_capacity) values(
'荣超地产',1,'60','14');
insert into ship_info(ship_name,ship_type_code,ship_size,ship_capacity) values(
'大梅沙1号',2,'42','10');
insert into ship_info(ship_name,ship_type_code,ship_size,ship_capacity) values(
'大梅沙2号',2,'37','8');
insert into ship_info(ship_name,ship_type_code,ship_size,ship_capacity) values(
'大梅沙3号',2,'14','4');
insert into ship_info(ship_name,ship_type_code,ship_size,ship_capacity) values(
'大梅沙4号',2,'14','4');
insert into ship_info(ship_name,ship_type_code,ship_size,ship_capacity) values(
'广田',1,'68','16');
insert into ship_info(ship_name,ship_type_code,ship_size,ship_capacity) values(
'55号',2,'55','12');
insert into ship_info(ship_name,ship_type_code,ship_size,ship_capacity) values(
'KING',2,'60','14');
insert into ship_info(ship_name,ship_type_code,ship_size,ship_capacity) values(
'梅沙6号',1,'43','10');
insert into ship_info(ship_name,ship_type_code,ship_size,ship_capacity) values(
'华为号',1,'80','24');
insert into ship_info(ship_name,ship_type_code,ship_size,ship_capacity) values(
'荣超快艇',4,'4','2');
insert into ship_info(ship_name,ship_type_code,ship_size,ship_capacity) values(
'渔人码头快艇',3,'12','5');
select * from ship_info;
--SHIP_TPYE(TABLE)--
create table ship_type(
ship_type_code int(11) not null primary key auto_increment,
ship_type_name varchar(32));
--INSERT INTO SHIP_TYPE--
insert into ship_type(ship_type_name) values('游艇');
insert into ship_type(ship_type_name) values('帆船');
insert into ship_type(ship_type_name) values('快艇');
insert into ship_type(ship_type_name) values('摩托艇');
commit;
--INSERT INTO SHIP_TYPE END--
--SHIP_OPERATION(TABLE)--
create table ship_operation (
ship_operation_code int(11) not null primary key auto_increment,
ship_id int(11) not null,
user_id int(11) not null,
ship_state int(11) not null,
stratime timestamp not null default '0000-00-00 00:00:00',
endtime timestamp not null default '0000-00-00 00:00:00');
--SHIP_OPERATION END--
--NEWS_INFO(TABLE)--
create table news_info(
news_code int(11) not null primary key auto_increment,
news_title varchar(64) not null,
news_context text,
news_images varchar(128),
news_state int(11) not null,
user_id int(11) not null);
--NEWS_INFO END--