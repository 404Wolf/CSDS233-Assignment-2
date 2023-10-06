package bst;

public class Node <T> {
    private int key;
    private T data;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;

    Node (int key) {
        this.key = key;
    }

    Node (int key, T data) {
        this.key = key;
        this.data = data;
    }

    /**
     * Determine whether the node has any child.
     *
     * @return Whether the node has any child.
     */
    public boolean hasChild() {
        return getLeft() != null || getRight() != null;
    }

    /**
     * Get the right child of the node.
     *
     * @return The right child of the node.
     */
    public Node<T> getRight() {
        return right;
    }

    /**
     * Set the right child of the node.
     *
     * @param right The right child of the node.
     */
    public void setRight(Node<T> right) {
        this.right = right;
        right.setParent(this);
    }

    /**
     * Get the left child of the node.
     *
     * @return The left child of the node.
     */
    public Node<T> getLeft() {
        return left;
    }

    /**
     * Set the left child of the node.
     *
     * @param left The new left child of the node.
     */
    public void setLeft(Node<T> left) {
        this.left = left;
        left.setParent(this);
    }

    /**
     * Get the key.
     *
     * @return The key of the node.
     */
    public int getKey() {
        return key;
    }

    /**
     * Set the key of the node.
     *
     * @param key The key to assign to the node.
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * Get the data contained in the node.
     *
     * @return The data contained in the node.
     */
    public T getData() {
        return data;
    }

    /**
     * Set the data contained in the node.
     *
     * @param data The data to be contained in the node.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Get the parent of the node.
     *
     * @return The parent of the node.
     */
    public Node<T> getParent() {
        return parent;
    }

    private void setParent(Node<T> parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "BSTNode(key=" + getKey() + ", data=" + getData() + ")";
    }
}
