CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    order_name VARCHAR(255) NOT NULL,
    price NUMERIC NOT NULL,
    quantity INT NOT NULL,
    sku_code VARCHAR(255) NOT NULL
);
