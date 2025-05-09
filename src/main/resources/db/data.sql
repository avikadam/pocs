-- Insert data into product
INSERT INTO product (name, description, price, stock_quantity, category) VALUES
('Laptop', 'High performance laptop', 1200.00, 10, 'Electronics'),
('Smartphone', 'Latest model smartphone', 800.00, 25, 'Electronics'),
('Desk Chair', 'Ergonomic office chair', 150.00, 40, 'Furniture'),
('Wireless Mouse', 'Bluetooth mouse with ergonomic design', 30.00, 100, 'Accessories'),
('Coffee Mug', 'Ceramic coffee mug', 10.00, 200, 'Kitchenware');

-- Insert data into orders
INSERT INTO orders (customer_id, order_date, status, total_amount) VALUES
('CUST001', CURRENT_TIMESTAMP, 'Pending', 1230.00),
('CUST002', CURRENT_TIMESTAMP, 'Shipped', 160.00),
('CUST003', CURRENT_TIMESTAMP, 'Delivered', 810.00);

-- Insert data into order_item
INSERT INTO order_item (order_id, product_id, quantity, unit_price) VALUES
(1, 1, 1, 1200.00),   -- Laptop
(1, 5, 3, 10.00),     -- Coffee Mugs
(2, 3, 1, 150.00),    -- Desk Chair
(2, 4, 1, 30.00),     -- Wireless Mouse
(3, 2, 1, 800.00),    -- Smartphone
(3, 5, 1, 10.00);     -- Coffee Mug
