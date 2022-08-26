create database demo;
use demo;
create table Products(
	id int auto_increment primary key,
    productCode varchar(40) unique,
    productName varchar(255),
    productPrice double default 0,
    productAmount int,
    productDescription varchar(255),
    productStatus varchar(255)
);

insert into Products
values(1, 'PR0001', 'Tủ lạnh', 200000000, 4,'mlem', 'perfect'),
	  (2, 'PR0002', 'Máy giặt', 600000000, 5,'mlem', 'perfect'),
      (3, 'PR0003', 'Tivi', 12000000000, 15,'mlem', 'perfect'),
      (4, 'PR0004', 'Quạt', 120000, 30,'mlem', 'perfect'),
      (5, 'PR0005', 'Bếp điện', 3400000, 12,'mlem', 'perfect'),
      (6, 'PR0006', 'Điều Hòa', 1400000, 6,'mlem', 'perfect'),
      (7, 'PR0007', 'Máy hút bụi', 400000, 5,'mlem', 'perfect'),
      (8, 'PR0008', 'Bếp siêu tốc', 200000, 20,'mlem', 'perfect'),
      (9, 'PR0009', 'Loa', 1003134, 10,'mlem', 'perfect'),
      (10, 'PR0010', 'Robot', 1200000000, 3,'mlem', 'perfect');
-- Step 3
create unique index productCode_index on products(productCode);
create index price_name on products(productName, productPrice);
explain select * from products where productCode ='PR0002';
explain select * from products where productName ='tivi' and productPrice = 12000000000;

-- Step 4
create view products_view as
select productCode, productName, productPrice, productStatus from products;

select* from products_view;
update products_view
set productStatus = 'terrible'
where productCode = 'PR0010';
drop view products_view;

-- Step 5
drop procedure if exists info_product;
DELIMITER //
create procedure info_product()
BEGIN
	select * from products;
END //
DELIMITER ;

call info_product();

DELIMITER //
create procedure add_product(IN id1 int, IN pCode varchar(40), IN pName varchar(40))
begin
	insert into products(id, productCode, productName)
    values(id1,pCode, pName);
END // 
DELIMITER ;
call add_product(11, 'PR0011', 'SUPERMEN');

drop procedure if exists update_product;
DELIMITER //
create procedure update_product(IN id1 int, IN price double)
BEGIN
	update Products
    set productPrice = price
    where id = id1;
END //
DELIMITER ;
call update_product(4, 123456789);

DELIMITER //
create procedure delete_product(IN id1 int)
BEGIN
	DELETE FROM products WHERE (id = id1);
END // 
DELIMITER ;

call delete_product(7);