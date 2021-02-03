Bowling game - in Java using Rest APIs 

The game consists of Player, Roll, Set(comprising of 2 rolls) Etc. Entity classes representing the various objects in the approach.

There are services, parsers(to convert the string input to rolls in the set), exception, repositories and controller classes constructed in to serve the purposes of connecting to the database and calculating score based on whether the roll is a hit, miss, spare or strike.

The project is written in a Test Driven Development approach where the junits are for the coverage of above all mentioned packages.

The project uses H2 in-memory database for storing the tables of the entities (player, roll, spare, strike, set).

The APIs are for fetching the details of-

GET api for details of the player(all and a single player)
GET api for  score of the game for the player providing the score input

POST api for posting details of the game
POST api for posting the details of the Player
POST api for posting the input of the player as a set of two rolls.

Input-
The input can be given as a number(1-9) for a hit and (-) for a miss.
A strike is shown with (X)
A spare is shown with ($)

Every strike is giving a bonus of 10 points.
Every spare is giving a bonus of 5 points.
An invalid length of input(greater than 10 sets and max 2 more in case of an ending strike or spare) will result in a Parsing Exception.

E.g of APIs are-
http://localhost:8080/h2-console
http://localhost:8080/api/players
http://localhost:8080/api/players/{id} - where {id} can be the Id of a player eg. 1,2
http://localhost:8080/score/game/{gameId}/player/{playerId}/input/{input} - e.g. http://localhost:8080/score/game/-999926015/player/2/input/XXXXXXXXXXXX 

The project can be run as a spring boot project with installed maven and JDK 8 or above.
