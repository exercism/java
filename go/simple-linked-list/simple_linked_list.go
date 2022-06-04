package linkedlist

import "errors"

type List struct {
	head *Element
	size int
}

type Element struct {
	value int
	next  *Element
}

func New(elements []int) *List {
	l := &List{}
	for _, element := range elements {
		l.Push(element)
	}
	return l
}

func (l *List) Size() int {
	if l == nil {
		return 0
	}
	return l.size
}

func (l *List) Push(element int) {
	e := &Element{
		value: element,
		next:  nil,
	}

	last := l.last()
	if last != nil {
		last.next = e
	} else {
		l.head = e
	}
	l.size++
}

func (l *List) last() *Element {
	if l == nil || l.head == nil {
		return nil
	}
	curr := l.head
	for curr.next != nil {
		curr = curr.next
	}
	return curr
}

func (l *List) Pop() (int, error) {
	last := l.last()
	if last == nil {
		return 0, errors.New("list is empty")
	}

	curr := l.head
	for curr.next != nil && curr.next != last {
		curr = curr.next
	}

	if curr.next == nil {
		l.head = nil
	} else {
		curr.next = nil
	}

	l.size--
	return last.value, nil
}

func (l *List) Array() []int {
	if l == nil {
		return nil
	}
	var elements []int
	curr := l.head
	for curr != nil {
		elements = append(elements, curr.value)
		curr = curr.next
	}
	return elements
}

func (l *List) Reverse() *List {
	if l == nil {
		return nil
	}
	elements := l.Array()
	reversed := make([]int, len(elements))
	for i, element := range elements {
		reversed[len(elements)-i-1] = element
	}
	return New(reversed)
}
