# Chessboard

Welcome to Chessboard on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

In Go, you can iterate a `slice` using `for` but you could also use
`range`. You will find this useful to iterate over a `map`.

Every iteration returns two values: the index/key and a copy of the element at
that index/key.

## Iterate a slice

Easy as pie, loops a slice, ordered as expected.

```go
xi := []int{10, 20, 30}
for i, x := range xi {
  fmt.Println(i, x)
}
// outputs:
// 0, 10
// 1, 20
// 2, 30
```

## Iterate a map

Iterating a map raises a new problem. The order is now random.

```go
hash := map[int]int{0: 10, 1: 20, 2: 30}
for k, v := range hash {
  fmt.Println(k, v)
}
// outputs, for example:
// 1 20
// 2 30
// 0 10
```

## Iteration omitting key or value

In Go an unused variable will raise an error at build time, so if you only
need to use the value, as per the first example:

```go
xi := []int{10, 20, 30}
for i, x := range xi {
  fmt.Println(x)
}
// Go build failed: i declared but not used
```

So, let's replace the `i` with `_` telling the compiler we don't use that
value at all:

```go
xi := []int{10, 20, 30}
for _, x := range xi {
  fmt.Println(x)
}
// outputs:
// 10
// 20
// 30
```

Now, if you want to only print the index, you can replace the `x` with `_`,
or simply omit the declaration at all:


```go
xi := []int{10, 20, 30}
// for i, _ := range xi {
for i := range xi {
  fmt.Println(i)
}
// outputs:
// 0
// 1
// 2
```

Last but not least, if you are required to perform some action but you are not
interested in values nor keys of the slice or map, you can omit both index and
value:

```go
xi := []int{10, 20, 30}
count := 0
for range xi {
  count++
}
// count value:
// 3
```

## Instructions

As a chess enthusiast, you would like to write your own version of the game. Yes, there maybe plenty of implementations of chess available online already, but yours will be unique!

Each square of the chessboard is identified by a letter-number pair. The vertical columns of squares, called files, are labeled A through H. The horizontal rows of squares, called ranks, are numbered 1 to 8.

## 1. Given a Chessboard and a Rank, count how many squares are occupied

Decorate the `Chessboard` type with the `CountInRank(rank byte) int` function.
It should count occupied squares ranging over a map. Return an integer.

```go
CountInRank('A')
// => 6
```

## 2. Given a Chessboard and a File, count how many squares are occupied

Decorate the `Chessboard` type with the `CountInFile(file int) int` function.
It should count occupied squares ranging over the given file. Return an integer.

```go
CountInFile(2)
// => 5
```

## 3. Count how many squares are present in the given chessboard

Decorate the `Chessboard` type with the `CountAll() int` function.
It should count how many squares are present in the chessboard and returns
an integer. Since you don't need to check the content of the squares,
consider using range omitting both `index` and `value`.

```go
CountAll()
// => 64
```

## 4. Count how many squares are occupied in the given chessboard

Decorate the `Chessboard` type with the `CountOccupied() int` function.
It should count how many squares are occupied in the chessboard.
Return an integer.

```go
CountOccupied()
// => 15
```

## Source

### Created by

- @brugnara
- @tehsphinx