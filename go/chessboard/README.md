# Chessboard

Welcome to Chessboard on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

In Go, you can iterate over a `slice` using `for` and an index, or you can use `range`.
`range` also allows you to iterate over a `map`.

Every iteration returns two values: the index/key and a copy of the element at that index/key.

## Iterate over a slice

Easy as pie, loops over a slice, ordered as expected.

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

## Iterate over a map

Iterating over a map raises a new problem. The order is now random.

```go
hash := map[int]int{9: 10, 99: 20, 999: 30}
for k, v := range hash {
  fmt.Println(k, v)
}
// outputs, for example:
// 99 20
// 999 30
// 9 10
```

## Iteration omitting key or value

In Go an unused variable will raise an error at build time.
Sometimes you only need the value, as per the first example:

```go
xi := []int{10, 20, 30}
for i, x := range xi {
  fmt.Println(x)
}
// Go build failed: i declared but not used
```

You can replace the `i` with `_` which tells the compiler we don't use that value:

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

If you want to only print the index, you can replace the `x` with `_`,
or simply omit the declaration:

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

## Non-struct types

You've previously seen defining struct types.
It is also possible to define non-struct types which you can use as an alias for a built-in type declaration, and you can define receiver functions on them to extend them in the same way as struct types.

```go
type Name string
func SayHello(n Name) {
  fmt.Printf("Hello %s\n", n)
}
n := Name("Fred")
SayHello(n)
// Output: Hello Fred
```

You can also define non-struct types composed of arrays and maps.

```go
type Names []string
func SayHello(n Names) {
  for _, name := range n {
    fmt.Printf("Hello %s\n", name)
  }
}
n := Names([]string{"Fred", "Bill"})
SayHello(n)
// Output:
// Hello Fred
// Hello Bill
```

## Instructions

As a chess enthusiast, you would like to write your own version of the game. Yes, there may be plenty of implementations of chess available online already, but yours will be unique!

Each square of the chessboard is identified by a letter-number pair:
 - The vertical columns of squares, called files, are numbered 1 through 8.
 - The horizontal rows of squares, called ranks, are labelled A through H.

```
  1 2 3 4 5 6 7 8
A # _ # _ _ _ _ # A
B _ _ _ _ # _ _ _ B
C _ _ # _ _ _ _ _ C
D _ _ _ _ _ _ _ _ D
E _ _ _ _ _ # _ # E
F _ _ _ _ _ _ _ _ F
G _ _ _ # _ _ _ _ G
H # # # # # # _ # H
  1 2 3 4 5 6 7 8
```

## 1. Given a Chessboard and a Rank, count how many squares are occupied

Implement the `CountInRank(board Chessboard, rank string) int` function.
It should count the total number of occupied squares by ranging over a map. Return an integer.
Return a count of zero (`0`) if the given rank cannot be found in the map.

```go
CountInRank(board, "A")
// => 6
```

## 2. Given a Chessboard and a File, count how many squares are occupied

Implement the `CountInFile(board Chessboard, file int) int` function.
It should count the total number of occupied squares by ranging over the given file. Return an integer.
Return a count of zero (`0`) if the given file is not a valid one (not between `1` and `8`, inclusive).

```go
CountInFile(board, 2)
// => 5
```

## 3. Count how many squares are present in the given chessboard

Implement the `CountAll(board Chessboard) int` function.
It should count how many squares are present in the chessboard and returns
an integer. Since you don't need to check the content of the squares,
consider using range omitting both `index` and `value`.

```go
CountAll(board)
// => 64
```

## 4. Count how many squares are occupied in the given chessboard

Implement the `CountOccupied(board Chessboard) int` function.
It should count how many squares are occupied in the chessboard.
Return an integer.

```go
CountOccupied(board)
// => 15
```

## Source

### Created by

- @brugnara
- @tehsphinx