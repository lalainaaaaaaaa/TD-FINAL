CREATE TABLE Team (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(100) NOT NULL UNIQUE,
                      acronym VARCHAR(10),
                      yearFounded INT,
                      stadium VARCHAR(100)
);