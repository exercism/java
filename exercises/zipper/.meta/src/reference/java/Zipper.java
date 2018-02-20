public class Zipper {

    private int value;
    BinaryTree tree; // Only the root node will bind to the BinaryTree
    Zipper up;
    Zipper left;
    Zipper right;

    public Zipper(int val) {
        value = val;
        tree = null;
        up = null;
        left = null;
        right = null;
    }

    /**
     * Get a zipper out of a rose tree, the focus is on the root node
     */
    public Zipper fromTree() {
        Zipper current = this;
        while (current.up != null) {
            current = current.up;
        }
        return current;
    }

    public BinaryTree toTree() {
        Zipper current = this;
        while (current.up != null) {
            current = current.up;
        }
        return current.tree;
    }

    public int getValue() {
        return value;
    }

    public Zipper setLeft(Zipper leftChild) {
        left = leftChild;
        if (leftChild != null) {
            leftChild.up = this;
            leftChild.tree = null;
        }
        return this;
    }

    public Zipper setRight(Zipper rightChild) {
        right = rightChild;
        if (rightChild != null) {
            rightChild.up = this;
            rightChild.tree = null;
        }
        return this;
    }

    /**
     * Move the focus to the previous child of the same parent
     * @return a new Zipper
     * Conditions: 1. The current Zipper must have a parent, i.e. it is not the root node.
     * 2. The current Zipper must be the right child of its parent
     */
    public Zipper getPrev() {
        Zipper current = this;
        try {
            current = this.up;
            current = current.left;
            return current;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Move the focus to the next child of the same parent
     * @return a new Zipper
     * Conditions: 1. The current Zipper must have a parent, i.e. it is not the root node.
     * 2. The current Zipper must be the left child of its parent
     */
    public Zipper getNext() {
        Zipper current = this;
        try {
            current = this.up;
            current = current.right;
            return current;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Move the focus to the parent
     * @return a new Zipper
     */
    public Zipper getUp() {
        return up;
    }

    /**
     * Set the value of the focus node, returns a new zipper
     * @param val
     */
    public void setValue(int val) {
        this.value = val;
    }

    /**
     * Insert a new subtree before the focus node, it becomes the prev of the focus node
     * @return a new Zipper
     */
    public Zipper insertBefore(Zipper toTheLeft) {
        this.left = toTheLeft;
        return this.left;
    }

    /**
     * Insert a new subtree after the focus node, it becomes the next of the focus node
     * @return a new Zipper
     */
    public Zipper insertAfter(Zipper toTheRight) {
        this.right = toTheRight;
        return this.right;
    }

    /**
     * Removes the focus node and all subtrees
     * Focus moves to the next node if possible otherwise to the prev node if possible, otherwise to the parent node
     * @return a new zipper
     */
    public Zipper delete() {
        Zipper current = this;
        if (current.up == null) {
            current = null;
        } else {
            if (current.up.left == current) {
                current = current.up;
                current.left = null;
                if (current.right != null) {
                    current = current.right;
                }
            } else {
                current = current.up;
                current.right = null;
                if (current.left != null) {
                    current = current.left;
                }
            }
        }
        return current;
    }

}

class BinaryTree {

    private Zipper root;

    public BinaryTree(int value) {
        root = new Zipper(value);
        root.tree = this;
    }

    public BinaryTree(Zipper root) {
        this.root = root;
        this.root.tree = this;
    }

    public Zipper getRoot() {
        return root;
    }

    public void setRoot(Zipper zipper) {
        root = zipper;
        root.tree = this;
    }

    public String toString(Zipper zipper) {
        String str = "";
        if (zipper.left == null && zipper.right == null) {
            str += "value: " + zipper.getValue() + ", left: " + null + ", right: " + null;
        } else if (zipper.left == null) {
            str += "value: " + zipper.getValue() + ", left: " + null + ", right: { " + toString(zipper.right) + " }";
        } else if (zipper.right == null) {
            str += "value: " + zipper.getValue() + ", left: { " + toString(zipper.left) + " }, right: " + null;
        } else {
            str += "value: " + zipper.getValue() +
                    ", left: { " + toString(zipper.left) + " }, right: { " + toString(zipper.right) + " }";
        }
        return str;
    }

    public String toString() {
        return toString(root);
    }

}
