CREATE TABLE Matches (
                         id SERIAL PRIMARY KEY,
                         home_club_id INT,
                         away_club_id INT,
                         stadium VARCHAR(100),
                         status VARCHAR(50),
                         home_score VARCHAR(255),
                         away_score VARCHAR(255),
                         FOREIGN KEY (home_club_id) REFERENCES Clubs(id),
                         FOREIGN KEY (away_club_id) REFERENCES Clubs(id)
);
