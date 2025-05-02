CREATE TABLE Player (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        number INT NOT NULL UNIQUE,
                        position VARCHAR(50),
                        nationality VARCHAR(50),
                        age INT
);