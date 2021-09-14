# Card Tricks

Welcome to Card Tricks on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

Slices in Go are similar to lists or arrays in other languages. They hold a number of elements of a specific type (or interface).

Slices in Go are based on arrays. Arrays have a fixed size. A slice, on the other hand, is a dynamically-sized, flexible view into the elements of an array.
Technically a slice consists of a pointer to a start element in an array and a length. This makes for example creating a sub-slice `s[3:7]` very efficient.
But don't worry: most of the time this knowledge is not needed in order to work with slices.

A slice is written like `[]T` with `T` being the type of the elements in the slice:

```go
var s []int
```

## Instructions

As a magician-to-be, Elyse needs to practice some basics. She has a stack of cards that she wants to manipulate.

To make things a bit easier she only uses the cards 1 to 10.

## 1. Retrieve a card from a stack

Return the card at position `index` from the given stack.

```go
GetItem([]uint8{1, 2, 4, 1}, 2)
// Output: 4
```

## 2. Exchange a card in the stack

Exchange the card at position `index` with the new card provided and return the adjusted stack.
Note that this will also change the input slice which is ok.

```go
index := 2
new_card := 6
SetItem([]uint8{1, 2, 4, 1}, index, new_card)
// Output: []uint8{1, 2, 6, 1}
```

## 3. Create a stack of cards

Create a stack of given `length` and fill it with cards of the given `value`.

```go
PrefilledSlice(8, 3)
// Output: []int{8, 8, 8}
```

## 4. Remove a card from the stack

Remove the card at position `index` from the stack and return the stack.

```go
RemoveItem([]int{3, 2, 6, 4, 8}, 2)
// Output: []int{3, 2, 4, 8}
```

## Source

### Created by

- @tehsphinx