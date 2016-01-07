public final class Deque<T> {
    private Element head;

    public void push(T value) {
        if (head == null) {
            head = new Element(value, null, null);
            head.setNext(head);
            head.setPrev(head);
            return;
        }

        Element oldTail = head.getPrev();
        Element tail = new Element(value, oldTail, head);
        oldTail.setNext(tail);
        head.setPrev(tail);
    }

    public T pop() {
        head = head.getPrev();
        return shift();
    }

    public void unshift(T value) {
        push(value);
        head = head.getPrev();
    }

    public T shift() {
        Object value = head.getValue();

        Element newHead = head.getNext();
        Element newTail = head.getPrev();

        if (newHead == head) {
            head = null;
        }
        else {
            newHead.setPrev(newTail);
            newTail.setNext(newHead);
            head = newHead;
        }

        return (T) value;
    }
}
