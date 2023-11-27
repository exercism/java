# Instructions

In this exercise, you're implementing a way to keep track of the high scores for the most popular game in your local arcade hall.

## 1. Define a new high score map

To make a new high score map, create an empty hashmap object with keys of type String and values of type Integer.

```java
Map<String, Integer> highScore = new HashMap();
```

## 2. Add players to the high score map

To add a player to the high score map, define `highScore.put()`, which is a function which takes 2 arguments:

- The first argument is name as a String.
- The second argument is the score as an Integer.

````java
Map<String, Integer> highScore = new HashMap<>();

// {Key: "Dave Thomas", Value: 0}
highScore.put("Dave Thomas", 0);

// {Key: "José Valim", Value: 0}
highScore.put("José Valim", 0);
````

## 3. Remove players from the score map

To remove a player from the high score map, use the `highScore.remove()` method, which takes 1 argument:

- The argument is the key of the item, in this case the name of the player.

````java
Map<String, Integer> highScore = new HashMap<>();
// Adding the player to the highScore Map
highScore.put("Dave Thomas", 0);

//Removing the player
highScore.remove("Dave Thomas");
````

## 4. Reset a player's score

To reset a player's score, define `HighScore.reset_score/2`, which takes 2 arguments:

- The first argument is the map of scores.
- The second argument is the name of the player as a string, whose score you wish to reset.

The function should also work if the player doesn't have a score.

```elixir
score_map = HighScore.new()
# => %{}
score_map = HighScore.add_player(score_map, "José Valim", 486_373)
# => %{"José Valim"=> 486_373}
score_map = HighScore.reset_score(score_map, "José Valim")
# => %{"José Valim"=> 0}
```

## 5. Update a player's score

To update a player's score by adding to the previous score, define `HighScore.update_score/3`, which takes 3 arguments:

- The first argument is the map of scores.
- The second argument is the name of the player as a string, whose score you wish to update.
- The third argument is the score that you wish to **add** to the stored high score.

The function should also work if the player doesn't have a previous score - assume the previous score is 0.

```elixir
score_map = HighScore.new()
# => %{}
score_map = HighScore.add_player(score_map, "José Valim", 486_373)
# => %{"José Valim"=> 486_373}
score_map = HighScore.update_score(score_map, "José Valim", 5)
# => %{"José Valim"=> 486_378}
```

## 6. Get a list of players

To get a list of players, define `HighScore.get_players/1`, which takes 1 argument:

- The first argument is the map of scores.

```elixir
score_map = HighScore.new()
# => %{}
score_map = HighScore.add_player(score_map, "Dave Thomas", 2_374)
# => %{"Dave Thomas" => 2_374}
score_map = HighScore.add_player(score_map, "José Valim", 486_373)
# => %{"Dave Thomas" => 2_374, "José Valim"=> 486_373}
HighScore.get_players(score_map)
# => ["Dave Thomas", "José Valim"]
```