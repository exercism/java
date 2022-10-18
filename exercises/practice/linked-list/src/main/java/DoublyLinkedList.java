class DoublyLinkedList<T> {
    private Element<T> head;

    void push(T value) {
        throw new UnsupportedOperationException("Please implement the DoublyLinkedList.push() method.");
    }

    T pop() {
        throw new UnsupportedOperationException("Please implement the DoublyLinkedList.pop() method.");
    }

    void unshift(T value) {
        throw new UnsupportedOperationException("Please implement the DoublyLinkedList.unshift() method.");
    }

    T shift() {
        throw new UnsupportedOperationException("Please implement the DoublyLinkedList.shift() method.");
    }

    private static final class Element<T> {
        private final T value;
        private Element<T> prev;
        private Element<T> next;

        Element(T value, Element<T> prev, Element<T> next) {
            throw new UnsupportedOperationException("Please implement the Element constructor.");
        }
    }
}
