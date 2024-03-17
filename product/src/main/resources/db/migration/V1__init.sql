create table product (id bigserial primary key, product varchar(255), product_type varchar(255));
insert into product (product,product_type)values( 'Продукт 1', 'ACCOUNT'),('Продукт 2', 'CARD'),('Продукт 3', 'ACCOUNT'),('Продукт 4', 'CARD'),('Продукт 5', 'ACCOUNT');

create table "user" (id bigserial primary key, name varchar(255));
insert into "user" (name)values('Клиент 1'),('Клиент 2'),('Клиент 3'),('Клиент 4'),('Клиент 5');

create table user_product (id bigserial primary key, product_id int, user_id int, balance numeric , account_number varchar(255));
insert into user_product (product_id ,user_id ,balance ,account_number )values(1, 1, 3254.7, 244625645),(2, 1, 4254.7, 344625645),(3, 4, 5254.7, 444625645),(4, 2, 6254.7, 544625645),(5, 3, 7254.7, 644625645),(1, 4, 8254.7, 744625645),(1, 4, 9254.7, 844625645),(3, 1, 254.7, 944625645),(3, 2, 1254.7, 044625645),(5, 2, 2254.7, 144625645);