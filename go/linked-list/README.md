# Linked List

Welcome to Linked List on Exercism's Go Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Instructions

Implement a doubly linked list.

Like an array, a linked list is a simple linear data structure. Several
common data types can be implemented using linked lists, like queues,
stacks, and associative arrays.

A linked list is a collection of data elements called *nodes*. In a
*singly linked list* each node holds a value and a link to the next node.
In a *doubly linked list* each node also holds a link to the previous
node.

You will write an implementation of a doubly linked list. Implement a
Node to hold a value and pointers to the next and previous nodes. Then
implement a List which holds references to the first and last node and
offers an array-like interface for adding and removing items:

* `push` (*insert value at back*);
* `pop` (*remove value at back*);
* `shift` (*remove value at front*).
* `unshift` (*insert value at front*);

To keep your implementation simple, the tests will not cover error
conditions. Specifically: `pop` or `shift` will never be called on an
empty list.

If you want to know more about linked lists, check [Wikipedia](https://en.wikipedia.org/wiki/Linked_list).

You will write an implementation of a doubly linked list. Implement a
`Node` to hold a value and pointers to the next and previous nodes. Then
implement a `List` which holds references to the first and last node and
offers functions for adding and removing items.

Your `Node` should have the following fields and methods:

* `Val`: the node's value (we will use `interface{}`).
* `Next() *Node`: pointer to the next node.
* `Prev() *Node`: pointer to the previous node.

You should have a function `NewList()` that creates and returns a `List`:

* `NewList(args ...interface{}) *List`: creates a new linked list preserving the order of the values.

Your `List` should have the following methods:

* `First() *Node`: returns a pointer to the first node (head).
* `Last() *Node`: returns a pointer to the last node (tail).
* `PushBack(v interface{})`: insert value at the back of the list.
* `PopBack() (interface{}, error)`: remove value from the back of the list.
* `PushFront(v interface{}) `: insert value at the front of the list.
* `PopFront() (interface{}, error)`: remove value from the front of the list.
* `Reverse()`: reverse the linked list.

## Source

### Created by

- @exklamationmark

### Contributed to by

- @bitfield
- @brugnara
- @ekingery
- @hilary
- @Hiyorimi
- @kytrinyx
- @leenipper
- @sebito91

### Based on

Classic computer science topic