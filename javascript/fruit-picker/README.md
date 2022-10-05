# Fruit Picker

Welcome to Fruit Picker on Exercism's JavaScript Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

## Callback functions

Callback functions are functions passed as arguments. This programming pattern creates a sequence of function calls in both synchronous and asynchronous programming. Writing a callback function is no different from writing a function; however, the callback function must match the signature defined by the calling function.

```javascript
const squareLength = 5;

// Caller function takes a callback function
function applyToSquare(callback) {
  return callback(squareLength);
}

// Callback must expect the possible argument from the calling function
function areaOfSquare(number) {
  return number * number;
}

applyToSquare(areaOfSquare); // => 25
```

You may also write callbacks as a function expression:

```javascript
applyToSquare(function squarePerimeter(side) {
  return side * 4;
});
```

## Instructions

You are creating a new online portal for your patrons to order their fruit fresh from the grocer. The grocer has an API that you can use to see if they have the inventory desired by your customers. You need to create a small library of functions for interacting with the grocer's API.

## 1. Create a callback to be called when the order is successful

Write a callback function called `onSuccess` to be called when the order is successful. It should invoke the imported `notify` function passing a success message to it.

```javascript
onSuccess();
// => `notify` called with `{ message: 'SUCCESS' }`
```

## 2. Create a callback to be called when the order fails with an error

Write a callback function called `onError` to be called when the order encounters an error. It should invoke the imported `notify` function passing an error message to it.

```javascript
onError();
// => `notify` called with `{ message: 'ERROR' }`
```

## 3. Create a wrapper to wrap the external api function

The grocer's API provides a function to order from their inventory called `order`. It receives three arguments: a _query_, a _callback_ function to be invoked when the order is successful, and a _callback_ function to be invoked when the order encounters an error. You decide to wrap the api function call in a newly defined function `orderFromGrocer` to insulate your codebase from external changes. Your function should forward the arguments (which match the provided api function) to the api function.

The query takes the form of an _object_:

```typescript
const query = {
  variety: string,
  quantity: number,
};
```

```javascript
orderFromGrocer(
  { variety: 'pear', quantity: 12 },
  exampleSuccessCallback,
  exampleErrorCallback
);
// => `order` was called with the query and the callbacks
```

## 4. Create a convenient short function

You find that you are calling this function from many different places with the same functions. Seeing an opportunity to refactor your code, you want to create a function where you can supply the variety and quantity to order as arguments.

```javascript
postOrder('peach', 100);
// => order submitted for 100 peaches
```

## Source

### Created by

- @neenjaw

### Contributed to by

- @SleeplessByte