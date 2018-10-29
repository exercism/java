final class DoublyLinkedList<T> {
    private Element<T> head;

    void push(T value) {
        if (head == null) {
            head = new Element<>(value, null, null);
            head.next = head;
            head.prev = head;
            return;
        }

        Element<T> oldTail = head.prev;
        Element<T> tail = new Element<>(value, oldTail, head);
        oldTail.next = tail;
        head.prev = tail;
    }

    T pop() {
        head = head.prev;
        return shift();
    }

    void unshift(T value) {
        push(value);
        head = head.prev;
    }

    T shift() {
        T value = head.value;

        Element<T> newHead = head.next;
        Element<T> newTail = head.prev;

        if (newHead == head) {
            head = null;
        } else {
            newHead.prev = newTail;
            newTail.next = newHead;
            head = newHead;
        }

        return value;
    }

    private static final class Element<T> {
        private final T value;
        private Element<T> prev;
        private Element<T> next;

        Element(T value, Element<T> prev, Element<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
