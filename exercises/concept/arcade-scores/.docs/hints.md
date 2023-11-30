# Hints

## General

- A [map][maps] is an associative data structure of key-value pairs.

## 1. Define a new high score map

- It should return an empty [map][maps].
- [Create an object][create-object] of the HashMap class using the appropriate [reference type][reference-data-types] for the keys and the values.

## 2. Add players to the high score map

- The resulting map should be returned.
- One of the [built-in functions][map-put] can be used to put a value in a map under a given key.

## 3. Remove players from the score map

- The resulting map should be returned.
- One of the [built-in functions][map-remove] can be used to remove a key/value pair from a map.

## 4. Reset a player's score

- The resulting map should be returned with the player's score reset to an initial value of 0.
- One of the [built-in functions][map-put] can be used to put a value in a map under a given key.

## 5. Update a player's score

- The resulting map should be returned with the player's updated score.
- One of the [built-in functions][map-get-or-default] can be used to get a value in a map under a given key if the key is present and update the value, or add the key with a default value if it is not present..

## 6. Get a list of players

- One of the [built-in functions][map-keys] returns a set of all keys in a map.
  
[maps]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Map.html
[create-object]: https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html
[reference-data-types]: https://docs.oracle.com/javase/specs/jls/se7/html/jls-4.html#jls-4.3
[map-put]: https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html#put-K-V-
[map-remove]: https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html#remove-java.lang.Object-
[map-get-or-default]: https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html#getOrDefault-java.lang.Object-V-
[map-keys]: https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html#keySet-- 
