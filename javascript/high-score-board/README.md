# High Score Board

Welcome to High Score Board on Exercism's JavaScript Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

## Explanation

Besides primitive data types like `number` and `string`, there is another important data type in JavaScript called `object`.
Objects are collections of key-value pairs.
As such, they can be used as what is often referred to as maps or dictionaries in other languages.

In other languages, all values in a map often need to have the same data type.
In JavaScript, only the type of the key is restricted: it has to be a string.
The values inside one object can have different types.
They can be primitive types like numbers but also arrays, other objects or even functions.
This makes objects very versatile so that they are also key entities for [object-oriented programming][oop] (OOP) in JavaScript.

In the following, we will focus on objects as collections or maps. Other use cases of objects will be covered in other concepts, see e.g., [Classes][concept-classes].

## Creating an Object

You create an object using curly brackets.
You can also directly include some entries.
For that, state the key first, followed by a colon and the value.

```javascript
const emptyObject = {};

const obj = {
  favoriteNumber: 42,
  greeting: 'Hello World',
  useGreeting: true,
  address: {
    street: 'Trincomalee Highway',
    city: 'Batticaloa',
  },
  fruits: ['melon', 'papaya'],
  addNumbers: function (a, b) {
    return a + b;
  },
};
```

The trailing comma after the last entry is optional in JavaScript.

You might wonder why the keys are not wrapped in quotation marks although they are supposed to be strings.
This is a short-hand notation.
If the key follows the naming rules for a JavaScript [identifier][mdn-identifier], you can omit the quotation marks.
For keys with special characters in the name, you need to use the usual string notation.

```javascript
const obj = {
  '1keyStartsWithNumber': '...',
  'key/with/slashes': '...',
  'key-with-dashes': '...',
  'key with spaces': '...',
  '#&()[]{}èä樹keyWithSpecialChars': '...',
};
```

## Retrieving a Value

There are two ways to retrieve the value for a given key, dot notation and bracket notation.

```javascript
const obj = { greeting: 'hello world' };

obj.greeting;
// => hello world

obj['greeting'];
// => hello world

// Bracket notation also works with variables.
const key = 'greeting';
obj[key];
// => hello world
```

Using the dot notation as a shorthand has the same restriction as omitting the quotation marks.
It only works if the key follows the identifier naming rules.

## Adding or Changing a Value

You can add or change a value using the assignment operator `=`.
Again, there are dot and bracket notations available.

```javascript
const obj = { greeting: 'hello world' };

obj.greeting = 'Hi there!';
obj['greeting'] = 'Welcome.';

obj.newKey1 = 'new value 1';
obj['new key 2'] = 'new value 2';

const key = 'new key 3';
obj[key] = 'new value 3';
```

## Deleting an Entry

You can delete a key-value pair from an object using the `delete` keyword.

```javascript
const obj = {
  key1: 'value1',
  key2: 'value2',
};

delete obj.key1;
delete obj['key2'];
```

## Checking Whether a Key Exists

You can check whether a certain key exists in an object with the `hasOwnProperty` method.

```javascript
const obj = { greeting: 'hello world' };

obj.hasOwnProperty('greeting');
// => true

obj.hasOwnProperty('age');
// => false
```

## Looping Through an Object

There is a special `for...in` loop to iterate over all keys of an object.

```javascript
const obj = {
  name: 'Ali',
  age: 65,
};

for (let key in obj) {
  console.log(key, obj[key]);
}
// name Ali
// age 65
```

To avoid subtle errors, you should always assume the `for...in` loop visits the keys in an arbitrary order.
Also, be aware that `for...in` includes [inherited keys][concept-inheritance] in its iteration.

[oop]: https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Objects/Object-oriented_JS
[concept-classes]: /tracks/javascript/concepts/classes
[mdn-identifier]: https://developer.mozilla.org/en-US/docs/Glossary/Identifier
[concept-inheritance]: /tracks/javascript/concepts/inheritance

## Instructions

In this exercise, you are implementing a way to keep track of the high scores for the most popular game in your local arcade hall.

You have 6 functions to implement, mostly related to manipulating an object that holds high scores.

## 1. Create a new high score board

Create a function `createScoreBoard` that creates an object that serves as a high score board.
The keys of this object will be the names of the players, the values will be their scores.
For testing purposes, you want to directly include one entry in the object.
This initial entry should consist of `The Best Ever` as player name and `1000000` as score.

```javascript
createScoreBoard();
// returns an object with one initial entry
```

## 2. Add players to a score board

To add a player to the high score board, define the function `addPlayer`.
It accepts 3 parameters:

- The first parameter is an existing score board object.
- The second parameter is the name of a player as a string.
- The third parameter is the score as a number.

The function returns the same score board object that was passed in after adding the new player.

```javascript
addPlayer({ 'Dave Thomas': 0 }, 'José Valim', 486373);
// => {'Dave Thomas': 0, 'José Valim': 486373}
```

## 3. Remove players from a score board

If players violate the rules of the arcade hall, they are manually removed from the high score board.
Define `removePlayer` which takes 2 parameters:

- The first parameter is an existing score board object.
- The second parameter is the name of the player as a string.

This function should remove the entry for the given player from the board and return the board afterwards.
If the player was not on the board in the first place, nothing should happen to the board.
It should be returned as is.

```javascript
removePlayer({ 'Dave Thomas': 0 }, 'Dave Thomas');
// => {}

removePlayer({ 'Dave Thomas': 0 }, 'Rose Fanaras');
// => { 'Dave Thomas': 0 }
```

## 4. Increase a player's score

If a player finishes another game at the arcade hall, a certain amount of points will be added to the previous score on the board.
Implement `updateScore`, which takes 3 parameters:

- The first parameter is an existing score board object.
- The second parameter is the name of the player whose score should be increased.
- The third parameter is the score that you wish to **add** to the stored high score.

The function should return the score board after the update was done.

```javascript
updateScore({ 'Freyja Ćirić': 12771008 }, 'Freyja Ćirić', 73);
// => {"Freyja Ćirić", 12771081}
```

## 5. Apply Monday bonus points

The arcade hall keeps a separate score board on Mondays.
At the end of the day, each player on that board gets 100 additional points.

Implement the function `applyMondayBonus` that accepts a score board.
The function adds the bonus points for each player that is listed on that board.
Afterwards, the board is returned.

```javascript
const scoreBoard = {
  'Dave Thomas': 44,
  'Freyja Ćirić': 539,
  'José Valim': 265,
};

applyMondayBonus(scoreBoard);
// => { 'Dave Thomas': 144, 'Freyja Ćirić': 639, 'José Valim': 365 }
```

## 6. Normalize a high score

Different arcade halls award different score points.
To celebrate the best arcade player in town, a player's score needs to be normalized so scores from different arcade halls become comparable.

Write a function `normalizeScore`.
To practice your object skills, instead of two parameters this function should accept one object as a parameter.
That object contains a key `score` with the value being a player's score (a number).
There is also a second key `normalizeFunction` that has a function as its value.
This function takes a score as an argument and returns the corrected score.

Your function `normalizeScore` should return the normalized score that you get after applying the normalization function to the score that was passed in.

```javascript
function normalize(score) {
  return 2 * score + 10;
}

const params = { score: 400, normalizeFunction: normalize };
normalizeScore(params);
// => 810
```

## Source

### Created by

- @junedev