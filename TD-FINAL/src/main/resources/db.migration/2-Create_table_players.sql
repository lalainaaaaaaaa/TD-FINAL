CREATE TABLE Players (
                         id SERIAL PRIMARY KEY,
                         club_id INT,
                         name VARCHAR(100),
                         number INT,
                         age INT,
                         position VARCHAR(50),
                         nationality VARCHAR(50),
                         FOREIGN KEY (club_id) REFERENCES Clubs(id)
);
