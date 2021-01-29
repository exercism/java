import java.util.*;

class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;
    private int nodeCount = 0;

    void insert(T value) {
        if (root == null) {
            root = new Node<>(value);
        } else {
            insert(root, value);
        }
        nodeCount++;
    }

    List<T> getAsSortedList() {
        List<T> result = new ArrayList<>(nodeCount);
        putInSortedOrderToList(root, result);
        return Collections.unmodifiableList(result);
    }

    List<T> getAsLevelOrderList() {
        List<T> result = new ArrayList<>(nodeCount);
        putInLevelOrderToList(root, result);
        return Collections.unmodifiableList(result);
    }

    Node<T> getRoot() {
        return root;
    }

    private void insert(Node<T> node, T value) {
        if (value.compareTo(node.getData()) <= 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node<>(value));
            } else {
                insert(node.getLeft(), value);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new Node<>(value));
            } else {
                insert(node.getRight(), value);
            }
        }
    }

    private void putInSortedOrderToList(Node<T> node, List<T> list) {
        if (node == null || list == null) {
            return;
        }
        if (node.getLeft() != null) {
            putInSortedOrderToList(node.getLeft(), list);
        }
        list.add(node.getData());
        if (node.getRight() != null) {
            putInSortedOrderToList(node.getRight(), list);
        }
    }

    private void putInLevelOrderToList(Node<T> node, List<T> list) {
        if (node == null || list == null) {
            return;
        }
        final Queue<Node<T>> queue = new LinkedList<>();
        Node<T> myNode;
        Node<T> left;
        Node<T> right;
        queue.add(node);
        while (!queue.isEmpty()) {
            myNode = queue.poll();
            list.add(myNode.getData());
            left = myNode.getLeft();
            right = myNode.getRight();
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
        }
    }

    static class Node<T> {

        private T data;
        private Node<T> left = null;
        private Node<T> right = null;

        Node(T data) {
            this.data = data;
        }

        Node<T> getLeft() {
            return left;
        }

        void setLeft(Node<T> left) {
            this.left = left;
        }

        Node<T> getRight() {
            return right;
        }

        void setRight(Node<T> right) {
            this.right = right;
        }

        T getData() {
            return data;
        }

    }
}
