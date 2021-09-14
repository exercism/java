# Gross Store

Welcome to Gross Store on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.
If you get stuck on the exercise, check out `HINTS.md`, but try and solve it without using those first :)

## Introduction

In go, `map` is a built-in data type that maps keys to values. In other programming language, you might be familiar with the concept of `map` as a dictionary, hash table, key/value store or an associative array.

Syntactically, `map` looks like this:

```go
map[KeyType]ElementType
```

_`KeyType` must be any [comparable type][gospec-comparable], while `ElementType` can be any valid type in go, which means you can store anything from primitive variable to a slice._

It is also important to know that each key is unique, meaning that assigning the same key twice will overwrite the value of the corresponding key.

`map` is reference type, which means if you pass it around, go won't copy the whole map. Instead what go will do is go copy the pointer of the map, this makes passing map to a function or variable cheap. The value of an uninitialized map is `nil`.

To create a map, you can do:

```go
  // With map literal
  foo := map[string]int{}
```

or

```go
  // or with make function
  foo := make(map[string]int)
```

Here are some operations that you can use with map

```go
  // Add a value in a map, you can use the `=` operator:
  foo["bar"] = 42
  // Here we update the element of `bar`
  foo["bar"] = 73
  // To retrieve a value map, you can use
  baz := foo["bar"]
  // To delete an item from a map, you can use
  delete(foo, "bar")
```

If you're trying to retrieve a non existed key, will return the zero value of your value type, it can confuse you, especially if your element is the same as the `ElementType` default value (for example, 0 for an int), to check whether the key exists in your map, you can use

```go
  value, exists := foo["baz"]
  // If the key "baz" doesn't exists,
  // value: 0; exists: false
```

[gospec-comparable]: https://golang.org/ref/spec#Comparison_operators

## Instructions

A friend of you has an old wholesale store called **Gross Store**, the name came from the quantity of the item that the store sell, it's all in [gross unit][gross-unit]. Your friend asked you to implement a point of sale (POS) system for his store, **but first, you want to build a prototype for it, in your prototype, your system will only record the quantity**. Your friend gave you a list of measurements to help you:

| Unit               | Score |
| ------------------ | ----- |
| quarter_of_a_dozen | 3     |
| half_of_a_dozen    | 6     |
| dozen              | 12    |
| small_gross        | 120   |
| gross              | 144   |
| great_gross        | 1728  |

## 1. Store the unit of measurement in your program

In order to use the measurement, you need to store the measurement in your program.

```go
units := Units()
fmt.Println(units)
// Output: map[...]
```

## 2. Create a new customer bill

You need to implement a function that create a new bill for the customer.

```go
bill := NewBill()
fmt.Println(bill)
// Output: map[]
```

## 3. Add item to the customer bill

To implement this, you'll need to:

- Check whether the given unit of measurement is correct
- Add the item to the customer bill, indexed by the item name. You probably also need a variable to represent the customer bill, you are expected to use `map`

```go
bill := NewBill()
ok := AddItem(bill, "carrot", "dozen")
fmt.Println(ok)
// Output: true or false
```

> Note that the returned value is type of `bool`

## 4. Remove item from the customer bill

To implement this, you'll need to:

- Check whether the given item is in the bill
- Check whether the given unit of measurement is correct
- Check whether the new quantity is less than 0, is so return `false`
- Check whether the new quantity is 0, is so return remove the item from the customer bill
- Otherwise reduce the quantity of the item

```go
bill := NewBill()
ok := RemoveItem(bill, "carrot", "dozen")
fmt.Println(ok)
// Output: true or false
```

> Note that the returned value is type of `bool`

## 5. Return the number of specific item that is in the customer bill

To implement this, you'll need to:

- Check whether the given item is in the bill
- Otherwise, return the quantity of the item

```go
bill := NewBill()
qty, ok := GetItem(bill, "carrot")
fmt.Println(qty)
// Output: 12
fmt.Println(ok)
// Output: true or false
```

> Note that the returned value are types of `int` and `bool`
> Note that there's no value returned by this function

[gross-unit]: https://en.wikipedia.org/wiki/Gross_(unit)

## Source

### Created by

- @chocopowwwa