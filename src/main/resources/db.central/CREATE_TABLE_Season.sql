CREATE TABLE season (
                        id SERIAL PRIMARY KEY,
                        year_start INT NOT NULL,
                        year_end INT NOT NULL,
                        championship_id INT REFERENCES championship(id) ON DELETE CASCADE
);