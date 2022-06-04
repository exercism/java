package linkedlist

import "errors"

type List struct {
	head *Node
	tail *Node
	size int
}

type Node struct {
	Value interface{}
	next  *Node
	prev  *Node
}

var ErrEmptyList error = errors.New("empty list")

func NewList(args ...interface{}) *List {
	l := &List{}
	for _, arg := range args {
		l.Push(arg)
	}
	return l
}

func (n *Node) Next() *Node {
	if n == nil {
		return nil
	}
	return n.next
}

func (n *Node) Prev() *Node {
	if n == nil {
		return nil
	}
	return n.prev
}

func (l *List) Unshift(v interface{}) {
	newNode := &Node{
		Value: v,
		next:  l.head,
		prev:  nil,
	}
	if l.head != nil {
		l.head.prev = newNode
	}
	l.head = newNode
	if l.tail == nil {
		l.tail = l.head
	}
	l.size++
}

func (l *List) Push(v interface{}) {
	newNode := &Node{
		Value: v,
		next:  nil,
		prev:  l.tail,
	}
	if l.tail != nil {
		l.tail.next = newNode
	}
	l.tail = newNode
	if l.head == nil {
		l.head = l.tail
	}
	l.size++
}

func (l *List) Shift() (interface{}, error) {
	oldHead := l.head
	if oldHead == nil {
		return nil, ErrEmptyList
	}

	l.head = oldHead.next

	if l.head == nil {
		l.tail = nil
	} else {
		l.head.prev = nil
	}

	l.size--
	return oldHead.Value, nil
}

func (l *List) Pop() (interface{}, error) {
	oldTail := l.tail
	if oldTail == nil {
		return nil, ErrEmptyList
	}

	l.tail = oldTail.prev

	if l.tail == nil {
		l.head = nil
	} else {
		l.tail.next = nil
	}

	l.size--
	return oldTail.Value, nil
}

func (l *List) Reverse() {
	if l.head == nil || l.head.next == nil {
		return
	}
	curr := l.head
	for curr != nil {
		curr.prev, curr.next = curr.next, curr.prev
		curr = curr.prev
	}
	l.head, l.tail = l.tail, l.head
}

func (l *List) First() *Node {
	return l.head
}

func (l *List) Last() *Node {
	return l.tail
}
