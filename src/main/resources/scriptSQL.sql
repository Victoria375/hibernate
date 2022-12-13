DROP TABLE IF EXISTS product;
CREATE TABLE IF NOT EXISTS product (id BIGSERIAL, title VARCHAR(255), price int, primary key (id));

INSERT INTO product (title, price) VALUES ('Bread', 50), ('Milk', 20), ('Apple', 7), ('Orange', 10), ('Water', 5);


CREATE TABLE IF NOT EXISTS customers (id BIGSERIAL, name VARCHAR(255), primary key (id));

INSERT INTO customers (name) VALUES ('Bob'), ('Emma'), ('Mike'), ('Aria');


CREATE TABLE IF NOT EXISTS orders (id BIGSERIAL, customer_id int REFERENCES customers (id),
product_id int REFERENCES product (id), quantity int, sum int, primary key (id));


INSERT INTO orders (customer_id, product_id, quantity) VALUES (1, 3, 2), (1, 5, 1), (4, 3, 5), (2, 2, 2), (3, 1, 6), (2, 4, 4), (1, 4, 1);

--LESSON 8

--set search_path to webhib;

-- \dt посмотреть таблицы

INSERT INTO product (title, price) VALUES ('Phone', 1000), ('Computer', 5000), ('Lipstick', 100), ('Pencil', 56),
('Bag', 123), ('Hat', 135), ('Dress', 160), ('Napkins', 11), ('Scrub', 110), ('Cup', 54), ('Glass', 60), ('Mirror', 74),
('Chair', 117), ('Table', 155), ('Earrings', 111);

select * from product;

--

CREATE TABLE IF NOT EXISTS cart (id BIGSERIAL, order_id int REFERENCES orders (id),
product_id int REFERENCES product (id), quantity int, price int, primary key (id));

--

CREATE TABLE IF NOT EXISTS users (id BIGSERIAL, username VARCHAR(20), password VARCHAR(20), age int, primary key (id));

INSERT INTO users (username, password, age) VALUES
('user', '$2a$12$Tu9FBCrcvk8qKMX0hJ/p..TSSyTWcyVo2rSW0fRyoapJoWXPs30yG', 26),
('manager', '$2a$12$pHT98STytkFEG7NzK7zpteHD7mPExsNgcmj.mSm.IdzqkVr5R53vq', 22),
('admin', '$2a$12$afHxA4xM/R.MrLGWVTJ.4uTwDlUsr5uDBt2eRUKaO2IcxwCnt/cV2', 38),
('superadmin', '$2a$12$Lm8zzm3yM13.QIWRVedJA.Z1wjIikCI5fduPug17hRV1wtzln3cn6', 33);

CREATE TABLE IF NOT EXISTS roles (id BIGSERIAL, name VARCHAR(20), primary key (id));

INSERT INTO roles (name) VALUES ('ROLE_USER'), ('ROLE_MANAGER'), ('ROLE_ADMIN'), ('ROLE_SUPERADMIN');

CREATE TABLE IF NOT EXISTS users_roles (user_id int REFERENCES users (id), role_id int REFERENCES roles (id));

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1), (2, 2), (3, 3), (4, 4);


