CREATE TABLE Clubs (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(100),
                       acronym VARCHAR(10),
                       year_established INT,
                       stadium VARCHAR(100),
                       coach VARCHAR(100),
                       nationality VARCHAR(50)
);
