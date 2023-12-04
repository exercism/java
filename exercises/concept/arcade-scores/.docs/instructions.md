# Instructions

In this exercise, you're implementing a way to keep track of the high scores for the most popular game in your local arcade hall.

## 1. Define a new high score map

To make a new high score map, create an empty hashmap object with keys of type String and values of type Integer using the `Map<String, Integer> highScores` declaration provided.

```java
System.out.println(ArcadeHighScore.highScores);
// => {} 
```

## 2. Add players to the high score map

To add a player to the high score map, define `ArcadeHighScore.addPlayer()`, which is a function which takes two arguments:

- The first argument is the players name as a String.
- The second argument is the players score as an Integer.

````java
ArcadeHighScore.addPlayer("Dave Thomas", 0);

// => {Dave Thomas=0}
````

## 3. Remove players from the score map

To remove a player from the high score map, define the `ArcadeHighScore.removePlayer()` method, which takes one argument:

- The argument is the key of the item, in this case the name of the player.

````java
ArcadeHighScore.removePlayer("Dave Thomas");

// => {}
````

## 4. Reset a player's score

To reset a player's score, define the `ArcadeHighScore.resetScore()` method, which takes 1 argument:

- The first argument is the players name.

The function should also work if the player isn't currently present in the map.

```java
ArcadeHighScore.resetScore("Dave Thomas");
// => (Dave Thomas=0);
```

## 5. Update a player's score

To update a player's score by adding to the previous score, define `ArcadeHighScore.updateScore()`, which takes two arguments:

- The first argument is the name of the player whose score you wish to update.
- The second argument is the score that you wish to **add** to their current high score.

The function should also work if the player doesn't have a previous score - assume the previous score is 0.

```java
// Adding a players score to update.
ArcadeHighScore.addPlayer("Lional Messi", 48);
// => {Lionel Messi=18}

ArcadeHighScore.updateScore("Lionel Messi", 40);
// => {Lionel Messi=88}
        
// Updating a players score who doesn't have a previous score
ArcadeHighScore.updateScore("Dave Thomas", 57);
// => {Lionel Messi=88, Dave Thomas=57}
```

## 6. Get a list of players

To get a list of players, define the `ArcadeHighScore.listOfPlayers()`, which takes no arguments:

````java
ArcadeHighScore.listOfPlayers();
// => {Lionel Messi, Dave Thomas}
````
