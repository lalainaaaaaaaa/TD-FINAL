CREATE TABLE Match (
                       id SERIAL PRIMARY KEY,
                       homeTeam VARCHAR(100) NOT NULL,
                       awayTeam VARCHAR(100) NOT NULL,
                       dateTime TIMESTAMP,
                       stadium VARCHAR(100),
                       season VARCHAR(20)
);