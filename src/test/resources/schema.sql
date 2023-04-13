
CREATE TABLE product_types
(
    id   UUID         NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_product_types PRIMARY KEY (id)
);

CREATE TABLE products
(
    id              UUID         NOT NULL,
    name            VARCHAR(255) NOT NULL,
    product_type_id UUID,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

ALTER TABLE products
    ADD CONSTRAINT FK_PRODUCTS_ON_PRODUCT_TYPE FOREIGN KEY (product_type_id) REFERENCES product_types (id);