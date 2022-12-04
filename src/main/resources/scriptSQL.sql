DROP TABLE IF EXISTS product;
CREATE TABLE IF NOT EXISTS product (id BIGSERIAL, title VARCHAR(255), price int, primary key (id));

INSERT INTO product (title, price) VALUES ('Bread', 50), ('Milk', 20), ('Apple', 7), ('Orange', 10), ('Water', 5);


CREATE TABLE IF NOT EXISTS customers (id BIGSERIAL, name VARCHAR(255), primary key (id));

INSERT INTO customers (name) VALUES ('Bob'), ('Emma'), ('Mike'), ('Aria');


CREATE TABLE IF NOT EXISTS orders (id BIGSERIAL, customer_id int REFERENCES customers (id), product_id int REFERENCES product (id), quantity int, sum int, primary key (id));


INSERT INTO orders (customer_id, product_id, quantity) VALUES (1, 3, 2), (1, 5, 1), (4, 3, 5), (2, 2, 2), (3, 1, 6), (2, 4, 4), (1, 4, 1);

--LESSON 8

--set search_path to webhib;

-- \dt посмотреть таблицы

INSERT INTO product (title, price) VALUES ('Phone', 1000), ('Computer', 5000), ('Lipstick', 100), ('Pencil', 56),
('Bag', 123), ('Hat', 135), ('Dress', 160), ('Napkins', 11), ('Scrub', 110), ('Cup', 54), ('Glass', 60), ('Mirror', 74),
('Chair', 117), ('Table', 155), ('Earrings', 111);

select * from product;