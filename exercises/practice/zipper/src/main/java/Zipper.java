class Zipper {
    Zipper up;
    Zipper left;
    Zipper right;

    Zipper(int val) {
        throw new UnsupportedOperationException("Please implement the Zipper(int) constructor.");
    }

    BinaryTree toTree() {
        throw new UnsupportedOperationException("Please implement the Zipper.toTree() method.");
    }

    int getValue() {
        throw new UnsupportedOperationException("Please implement the Zipper.getValue() method.");
    }

    Zipper setLeft(Zipper leftChild) {
        throw new UnsupportedOperationException("Please implement the Zipper.setLeft() method.");
    }

    Zipper setRight(Zipper rightChild) {
        throw new UnsupportedOperationException("Please implement the Zipper.setRight() method.");
    }

    void setValue(int val) {
        throw new UnsupportedOperationException("Please implement the Zipper.setValue() method.");
    }
}

class BinaryTree {
    BinaryTree(int value) {
        throw new UnsupportedOperationException("Please implement the BinaryTree(int) constructor.");
    }

    BinaryTree(Zipper root) {
        throw new UnsupportedOperationException("Please implement the BinaryTree(Zipper) constructor.");
    }

    Zipper getRoot() {
        throw new UnsupportedOperationException("Please implement the BinaryTree.getRoot() method.");
    }

    String printTree() {
        throw new UnsupportedOperationException("Please implement the BinaryTree.printTree() method.");
    }
}
