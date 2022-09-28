# Elyses Enchantments

Welcome to Elyses Enchantments on Exercism's JavaScript Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

In JavaScript, an array is a list-like structure with no fixed length which can hold any type of primitives or objects, even mixed types.

To create an array, add elements between square brackets `[]`.
To read from the array, put the index in square brackets `[]` after the identifier.
The indices of an array start at zero.

For example:

```javascript
const numbers = [1, 'two', 3, 'four'];
numbers[2];
// => 3
```

To retrieve the number of elements that are in an array, use the `length` property:

```javascript
const numbers = [1, 'two', 3, 'four'];
numbers.length;
// => 4
```

To change an element in the array, you assign a value at the index:

```javascript
const numbers = [1, 'two', 3, 'four'];
numbers[0] = 'one';
numbers;
// => ['one', 'two', 3, 'four']
```

## Methods

Some of the [methods][array_methods] that are available on every Array object can be used to add or remove from the array.
Here are a few to consider when working on this exercise:

### push

> The `push()` method adds one or more elements to the end of an array and returns the new length of the array.[^1]

```javascript
const numbers = [1, 'two', 3, 'four'];
numbers.push(5); // => 5
numbers;
// => [1, 'two', 3, 'four', 5]
```

### pop

> The `pop()` method removes the last element from an array and returns that element.
> This method changes the length of the array.[^2]

```javascript
const numbers = [1, 'two', 3, 'four'];
numbers.pop(); // => four
numbers;
// => [1, 'two', 3]
```

### shift

> The `shift()` method removes the first element from an array and returns that removed element.
> This method changes the length of the array.[^3]

```javascript
const numbers = [1, 'two', 3, 'four'];
numbers.shift(); // => 1
numbers;
// => ['two', 3, 'four']
```

### unshift

> The unshift() method adds one or more elements to the beginning of an array and returns the new length of the array.[^4]

```javascript
const numbers = [1, 'two', 3, 'four'];
numbers.unshift('one'); // => 5
numbers;
// => ['one', 1, 'two', 3, 'four']
```

### splice

> The splice() method changes the contents of an array by removing or replacing existing elements and/or adding new elements in place.
> This method returns an array containing the deleted elements.[^5]

```javascript
const numbers = [1, 'two', 3, 'four'];
numbers.splice(2, 1, 'one'); // => [3]
numbers;
// => [1, 'two', 'one', 'four']
```

---

[^1]: `push`, MDN. https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/push (referenced September 29, 2021)
[^2]: `pop`, MDN. https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/pop (referenced September 29, 2021)
[^3]: `shift`, MDN. https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/shift (referenced September 29, 2021)
[^4]: `unshift`, MDN. https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/unshift (referenced September 29, 2021)
[^5]: `splice`, MDN. https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/splice (referenced September 29, 2021)

[array_methods]: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array

## Instructions

As a magician-to-be, Elyse needs to practice some basics. She has
a stack of cards that she wants to manipulate.

To make things a bit easier she only uses the cards 1 to 10 so her
stack of cards can be represented by an array of numbers. The position
of a certain card corresponds to the index in the array. That means
position 0 refers to the first card, position 1 to the second card
etc.

## 1. Retrieve a card from a stack

To pick a card, return the card at index `position` from
the given stack.

```javascript
const position = 2;
getItem([1, 2, 4, 1], position);
// => 4
```

## 2. Exchange a card in the stack

Perform some sleight of hand and exchange the card at index `position`
with the replacement card provided.
Return the adjusted stack.

```javascript
const position = 2;
const replacementCard = 6;
setItem([1, 2, 4, 1], position, replacementCard);
// => [1, 2, 6, 1]
```

## 3. Insert a card at the top of the stack

Make a card appear by inserting a new card at the top of the stack.
Return the adjusted stack.

```javascript
const newCard = 8;
insertItemAtTop([5, 9, 7, 1], newCard);
// => [5, 9, 7, 1, 8]
```

## 4. Remove a card from the stack

Make a card disappear by removing the card at the given `position` from the stack.
Return the adjusted stack.

```javascript
const position = 2;
removeItem([3, 2, 6, 4, 8], position);
// => [3, 2, 4, 8]
```

## 5. Remove the top card from the stack

Make a card disappear by removing the card at the top of the stack.
Return the adjusted stack.

```javascript
removeItemFromTop([3, 2, 6, 4, 8]);
// => [3, 2, 6, 4]
```

## 6. Insert a card at the bottom of the stack

Make a card appear by inserting a new card at the bottom of the stack.
Return the adjusted stack.

```javascript
const newCard = 8;
insertItemAtBottom([5, 9, 7, 1], newCard);
// => [8, 5, 9, 7, 1]
```

## 7. Remove a card from the bottom of the stack

Make a card disappear by removing the card at the bottom of the stack.
Return the adjusted stack.

```javascript
removeItemAtBottom([8, 5, 9, 7, 1]);
// => [5, 9, 7, 1]
```

## 8. Check the size of the stack

Check whether the size of the stack is equal to `stackSize` or not.

```javascript
const stackSize = 4;
checkSizeOfStack([3, 2, 6, 4, 8], stackSize);
// => false
```

## Source

### Created by

- @ovidiu141
- @SleeplessByte

### Contributed to by

- @peterchu999
- @pertrai1
- @nasch