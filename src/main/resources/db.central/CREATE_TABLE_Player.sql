CREATE TABLE player (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        position VARCHAR(50),
                        nationality VARCHAR(50),
                        age INT,
                        club_id INT REFERENCES club(id) ON DELETE SET NULL
);