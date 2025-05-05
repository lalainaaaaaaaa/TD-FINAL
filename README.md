FINAL PROJECT PROG3: STD23049 ~ STD23053

Football Championship Management System
The project involves developing a REST API for the Fédération Internationale de Football Association (FIFA) to track statistics for European soccer leagues. The aim is to facilitate the collection and analysis of data on teams, players and matches. The APIs enable the various leagues to record match statistics and FIFA to centralize this data to determine overall performance.

Academic objectives
The project aims to understand and illustrate the following concepts:
-JDBC API: Using Java Database Connectivity to interact with a PostgreSQL database.
-SQL queries with PostgreSQL: Executing queries to manipulate and retrieve data.
-Object-Oriented Programming (OOP) with Java: Design classes and objects to model domain entities
-Separation of Responsibilities Principle (SRP): Structure code so that each class or module has a single responsibility.
-REST API specification with OpenAPI (OAS): Document API endpoints to ensure clear, standardized use.
-REST API implementation with Spring Boot: Create RESTful web services using the Spring Boot framework.

Work to be carried out
Implement the REST API for championship management:
-Create endpoints to manage the following entities: championshisp, clubs, players, matches, and season.
-Use JDBC to interact with the PostgreSQL database.
-REST API implementation for data retrieval:
-Create endpoints to enable FIFA to retrieve global statistics: top leagues, teams, and players.
-Use the Open API specification to document endpoints, specifying parameters and expected responses.

Context
FIFA is the governing body of world soccer and would like to improve the monitoring of club competitions in Europe. The project focuses solely on club championships, excluding national teams. The key entities to be modeled include Clubs, Players, Cochs, and Matches, as well as the rules (Management) for determining rankings and champions.

Rules
Clubs vs. National Teams:
    -A club is a team that belongs to a league, not directly to a country.
    -A national team represents a country in international competitions (e.g., World Cup). Each country has only one national team.
In this project, we focus only on club competitions, not international matches.

Championships:
  Each championship has several clubs, a name, and is linked to a European country.
  This project focuses on the five major European championships:
         Premier League (England)
         La Liga (Spain)
         Bundesliga (Germany)
         Serie A (Italy)
         Ligue 1 (France)

Clubs:
    A club has a unique name, creation year, acronym, stadium name, and belongs to a championship.
    A club consists of several players and exactly one coach.

Players:
    A player has a name, a unique number within their club, a position (goalkeeper, defender, midfielder, forward), nationality, and age.

Coach:
    A coach has a name and nationality.

Season:
    Each championship is played within a season (e.g., 2024-2025), and all championships share the same season period.

Matches:
    A match is a confrontation between two distinct clubs from the same championship, played at a specific date, time, and stadium, and belongs to a defined season.
    Each club plays all other clubs twice (home and away).

Statistics:
    -Points: 3 for a win, 1 for a draw, 0 for a loss.
    -Collective stats: points, goals scored, goals conceded, goal difference, clean sheets.
    -Individual stats: goals per player, etc.
    -Standings are recalculated after each match.


TECHNOLOGY USED
    -Java 17+: The project is built with Java 17 (see <java.version>17</java.version>).
    -Spring Boot 3: The project uses Spring Boot 3.4.5 as the main framework for building REST APIs.
    -Spring Boot Web Starter: For building RESTful web services (spring-boot-starter-web).
    -Spring Boot Data JDBC: For data access using JDBC, allowing direct SQL queries with PostgreSQL (spring-boot-starter-data-jdbc.
    -PostgreSQL: The project uses PostgreSQL as the relational database, with the official JDBC driver.
    -JUnit 5 : For unit and integration testing (spring-boot-starter-test, junit-jupiter-api).
    -Mockito : For mocking dependencies in tests (mockito-core).
    -Maven : As the build and dependency management tool.

REST API ENDPOINTS
  Championship API:
      Functionality:
-GET /players: Retrieve player information,Filters: By club, name, or age range
-PUT /players: Update player details
-GET /seasons: Retrieve all seasons
-POST /seasons: Create a new season
-PUT /seasons/{seasonYear}/status: Update season status
-GET /players/{id}/statistics/{seasonYear}: Retrieve player statistics
-GET /clubs: Retrieve club information
-PUT /clubs: Update club details
-GET /clubs/{id}/players: Retrieve all players of a club
-PUT /clubs/{id}/players: Update club players
-POST /clubs/{id}/players: Add new players to a club
-POST /matchMaker/{seasonYear}: Generate matches for a season
-GET /matches/{seasonYear}: Retrieve all matches for a season
-PUT /matches/{id}/status: Update match status
-POST /matches/{id}/goals: Record goals scored in a match
-GET /clubs/statistics/{seasonYear}: Retrieve club statistics

      Quality Code:
-Adherence to SRP (Single Responsibility Principle)
-Object-Oriented Programming (POO)
-Proper use of Spring annotations-
-No unauthorized libraries (e.g., JPA, YAML Processor)

   Central API:
      Functionality:
-Retrieve championship and player rankings
-Determine best players and clubs

      Quality code:
-Adherence to SRP
-POO principles
-Use of Spring annotations


SECURITY
    -An API key is required for sensitive operations (e.g., data synchronization).
    -The key must be sent in the API-Key HTTP header.
