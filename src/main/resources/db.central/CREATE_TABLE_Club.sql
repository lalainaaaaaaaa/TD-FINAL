CREATE TABLE club (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(100) NOT NULL,
                      stadium VARCHAR(100),
                      championship_id INT REFERENCES championship(id) ON DELETE CASCADE
);