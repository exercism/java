# Instructions

In this exercise, you're implementing a way to keep track of the high scores for the most popular game in your local arcade hall.

## 1. Define a new high score map

To make a new high score map, create an empty hashmap object with keys of type String and values of type Integer.

```java
Map<String, Integer> highScores = new HashMap<>();
```

## 2. Add players to the high score map

To add a player to the high score map, define `highScores.addPlayer()`, which is a function which takes 2 arguments:

- The first argument is the players name as a String.
- The second argument is the players score as an Integer.

````java
Map<String, Integer> highScores = new HashMap<>();

// {Dave Thomas=78}
highScores.put("Dave Thomas", 0);

// {José Valim=81}
highScores.put("José Valim", 0);
````

## 3. Remove players from the score map

To remove a player from the high score map, define the `highScores.removePlayer()` method, which takes 1 argument:

- The argument is the key of the item, in this case the name of the player.

````java
Map<String, Integer> highScores = new HashMap<>();
// Adding the player to the highScores HashMap
highScores.put("Dave Thomas", 0);

//Removing the player
highScores.remove("Dave Thomas");
````

## 4. Reset a player's score

To reset a player's score, use the `highScores.resetScore()` method, which takes 2 arguments:

- The first argument is the players name.
- The second argument is the new score for the player, in this case 0.

The function should also work if the player doesn't have a score.

```java
Map<String, Integer> highScores = new HashMap<>();
// Resetting Daves score to 0
highScores.put("Dave Thomas", 0);
```

## 5. Update a player's score

To update a player's score by adding to the previous score, define `highScore.update_score/3`, which takes 3 arguments:

- The first argument is the map of scores.
- The second argument is the name of the player as a string, whose score you wish to update.
- The third argument is the score that you wish to **add** to the stored high score.

The function should also work if the player doesn't have a previous score - assume the previous score is 0.

```java
Map<String, Integer> highScores = new HashMap<>();
// Add players score to the highScores map
highScores.put("Dave Thomas", 19);

// Save t
Integer oldScore = highScores.get("Dave Thomas");

highScores.put("Dave Thomas", oldScore + score);


```

## 6. Get a list of players

To get a list of players, reference the `highScores` object by printing it:

````java
Map<String, Integer> highScores = new HashMap<>();

// Key: "Dave Thomas", Value: 78
highScores.put("Dave Thomas", 78);

// Key: "José Valim", Value: 81
highScores.put("José Valim", 81);

// Print the highScore HashMap
// Returns {Dave Thomas=78, José Valim=81}
System.out.println(highScores);
````

Or we can simply return highScores:

````java
Map<String, Integer> highScores = new HashMap<>();

// Key: "Dave Thomas", Value: 78
highScores.put("Dave Thomas", 78);

// Key: "José Valim", Value: 81
highScores.put("José Valim", 81);

Map<String, Integer> listOfPlayers(){
     // Returns {Dave Thomas=78, José Valim=81}
        return highscores;
}
````