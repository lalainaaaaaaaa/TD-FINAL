CREATE TABLE coach (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       nationality VARCHAR(50),
                       club_id INT REFERENCES club(id) ON DELETE SET NULL
);