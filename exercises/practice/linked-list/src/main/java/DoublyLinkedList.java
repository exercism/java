class DoublyLinkedList<T> {
    private Element<T> head;

    void push(T value) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    T pop() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    void unshift(T value) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    T shift() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    private static final class Element<T> {
        private final T value;
        private Element<T> prev;
        private Element<T> next;

        Element(T value, Element<T> prev, Element<T> next) {
            throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        }
    }
}
