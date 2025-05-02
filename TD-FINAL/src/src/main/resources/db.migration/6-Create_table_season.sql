CREATE TABLE season (
                        year INT NOT NULL,
                        championshipId INT NOT NULL,
                        FOREIGN KEY (championshipId) REFERENCES Championships(id),
                        PRIMARY KEY (year, championshipId)
);