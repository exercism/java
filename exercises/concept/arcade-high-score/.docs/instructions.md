# Instructions

In this exercise, you're implementing a way to keep track of the high scores for the most popular game in your local arcade hall.

## 1. Define a new high score map

To make a new high score map, create an empty `HashMap` object by initialising the `Map<String, Integer> highScores` declaration provided.

```java
ArcadeHighScore arcadeHighScore = new ArcadeHighScore();
arcadeHighScore.getHighScores();
// => {} 
```

## 2. Add players to the high score map

To add a player to the high score map, implement the `ArcadeHighScore.addPlayer()` method, which takes the player's name and score as arguments.

When called, it should store the player and their score in the `highScores` map.

````java
arcadeHighScore.addPlayer("Dave Thomas", 0);
arcadeHighScore.getHighScores();
// => {Dave Thomas=0}
````

## 3. Remove players from the score map

To remove a player from the high score map, implement the `ArcadeHighScore.removePlayer()` method, which takes the player's name as an argument.

When called, it should remove the entry associated to the player from the `highScores` map.

````java
arcadeHighScore.removePlayer("Dave Thomas");
arcadeHighScore.getHighScores();
// => {}
````

## 4. Reset a player's score

To reset a player's score, implement the `ArcadeHighScore.resetScore()` method, which takes the player's name as an argument.

When called, it should reset the score of the player to `0` in the `highScores` map.

```java
arcadeHighScore.resetScore("Dave Thomas");
arcadeHighScore.getHighScores();
// => (Dave Thomas=0);
```

## 5. Update a player's score

To update a player's score by adding to the previous score, implement `ArcadeHighScore.updateScore()` method, which takes the player's name and their new score as arguments.

When called, it should _add_ the new score to the player's previous score stored in the `highScores` map.

If the player doesn't have a previous score, assume the previous score is `0`.

```java
ArcadeHighScore arcadeHighScore = new ArcadeHighScore();
// Adding a players score to update
arcadeHighScore.addPlayer("Lionel Messi", 48);
arcadeHighScore.updateScore("Lionel Messi", 40);
arcadeHighScore.getHighScores();
// => {Lionel Messi=88}
        
// Updating a players score who doesn't have a previous score
arcadeHighScore.updateScore("Dave Thomas", 57);
arcadeHighScore.getHighScores();
// => {Lionel Messi=88, Dave Thomas=57}
```

## 6. Get a list of players

To get a list of players, implement the `ArcadeHighScore.getPlayers()` method.

When called, it should return a collection containing all player's names currently stored in the `highScores` map.

````java
arcadeHighScore.getPlayers();
// => {Lionel Messi, Dave Thomas}
````
