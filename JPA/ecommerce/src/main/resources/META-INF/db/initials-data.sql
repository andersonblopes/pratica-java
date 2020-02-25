INSERT INTO product (id, name, price, description) VALUES (1, 'iPad', 559, 'Like a computer. Unlike any computer.');
INSERT INTO product (id, name, price, description) VALUES (3, 'Apple Watch Series 5', 399, 'You’ve never seen a watch like this.');

INSERT INTO client (id, name, gender) VALUES (1, 'Anderson Lopes', "MALE");
INSERT INTO client (id, name, gender) VALUES (2, 'Elaine Lopes', "FEMALE");

INSERT INTO purchase_order (id, client_id, order_date, total, order_status) VALUES (1, 1, sysdate(), 100.0, 'WAIT');

INSERT INTO purchase_order_item (id, order_id, product_id, product_price, amount) values (1, 1, 1, 5.0, 2);
