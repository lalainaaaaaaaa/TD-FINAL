CREATE TABLE championships (
                               id SERIAL PRIMARY KEY,
                               name VARCHAR(100) NOT NULL UNIQUE,
                               country VARCHAR(50)
);