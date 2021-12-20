CREATE TABLE Products
(
    id          SERIAL PRIMARY KEY,
    description VARCHAR(300),
    price       INTEGER(10),
    amount      INTEGER
);

CREATE TABLE Customers
(
    id      PRIMARY KEY,
    name    VARCHAR(30),
    surname VARCHAR(30)
);

CREATE TABLE Orders
(
    id          SERIAL PRIMARY KEY,
    product_id  INTEGER,
    FOREIGN KEY (product_id) REFERENCES Products (id),
    customer_id INTEGER,
    FOREIGN KEY (customer_id) REFERENCES Customers (id),
    date_time TIMESTAMP WITH TIME ZONE DEFAULT current_timestamp,
    amount INTEGER
);

insert into Products (description, price, amount) values ('Помпа для пениса вакуумная', 3140, 10);
insert into Products (description, price, amount) values ('Анальная пробка с вибрацией', 4195, 20);
insert into Products (description, price, amount) values ('Жидкий вибратор', 1745, 14);
insert into Products (description, price, amount) values ('Массажёр простаты', 5180, 9);
insert into Products (description, price, amount) values ('Мужской вибратор', 4290, 12);


insert into Customers (name, surname) values ('Дональд', 'Трамп');
insert into Customers (name, surname) values ('Джозеф', 'Байден');
insert into Customers (name, surname) values ('Ангела', 'Меркель');
insert into Customers (name, surname) values ('Владимир', 'Зеленский');


insert into Orders(product_id, customer_id, amount) values (1, 1, 2);
insert into Orders(product_id, customer_id, amount) values (2, 1, 3);
insert into Orders(product_id, customer_id, amount) values (2, 4, 6);
insert into Orders(product_id, customer_id, amount) values (4, 4, 10);
insert into Orders(product_id, customer_id, amount) values (3, 2, 2);


SELECT *
FROM Products p
         INNER JOIN Orders o ON p.id = o.product_id;

SELECT name, surname
FROM Customers
WHERE customers.id IN (SELECT customer_id
                       FROM Orders
                       WHERE product_id IN (SELECT id FROM Products WHERE description = 'Массажер простаты'));

SELECT description
FROM Products
WHERE price > 3000
  AND Products.id IN
      (SELECT product_id
       FROM Orders
       WHERE customer_id IN
             (SELECT id FROM Customers WHERE name = 'Дональд'));

