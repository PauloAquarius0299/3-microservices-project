CREATE TABLE inventary (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    sku_code VARCHAR(255) DEFAULT NULL,
    quantity INTEGER DEFAULT NULL
);
