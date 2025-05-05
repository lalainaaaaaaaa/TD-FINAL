CREATE TABLE match (
                       id SERIAL PRIMARY KEY,
                       match_date DATE NOT NULL,
                       season_id INT REFERENCES season(id) ON DELETE CASCADE,
                       home_club_id INT REFERENCES club(id) ON DELETE CASCADE,
                       away_club_id INT REFERENCES club(id) ON DELETE CASCADE,
                       home_score INT,
                       away_score INT
);