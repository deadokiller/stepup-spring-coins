insert into product (id,product,product_type)
select 1,'Продукт 1', 'ACCOUNT'
union all
select 2,'Продукт 2', 'CARD'
union all
select 3,'Продукт 3', 'ACCOUNT'
union all
select 4,'Продукт 4', 'CARD'
union all
select 5,'Продукт 5', 'ACCOUNT'

insert into "user" (id ,name)
select 1,'Клиент 1'
union all
select 2,'Клиент 2'
union all
select 3,'Клиент 3'
union all
select 4,'Клиент 4'
union all
select 5,'Клиент 5'

insert into user_product (id ,product_id ,user_id ,balance ,account_number )
select 1, 1, 1, 3254.7, 244625645
union all
select 2, 2, 1, 4254.7, 344625645
union all
select 3, 3, 4, 5254.7, 444625645
union all
select 4, 4, 2, 6254.7, 544625645
union all
select 5, 5, 3, 7254.7, 644625645
union all
select 6, 1, 4, 8254.7, 744625645
union all
select 7, 1, 4, 9254.7, 844625645
union all
select 8, 3, 1, 254.7, 944625645
union all
select 9, 3, 2, 1254.7, 044625645
union all
select 10, 5, 2, 2254.7, 144625645