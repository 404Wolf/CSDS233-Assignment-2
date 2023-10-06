package bst;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BST <T>{
    private Node<T> root;
    private int count;

    /**
     * Determine the number of nodes in the tree.
     *
     * @return The number of nodes in the tree.
     */
    public int length() { return count; }

    public void insert(int key, T data) {
        Node<T> cursor = getRootNode();
        Node<T> newNode = new Node<T>(key, data);

        if (length() == 0) {
            root = newNode;
            count++;
            return;
        }

        while (cursor.hasChild()) {
            if (key > cursor.getKey()) {
                if (cursor.getRight() == null) {
                    cursor.setRight(newNode);
                    break;
                }
                cursor = cursor.getRight();
            }
            else if (key <= cursor.getKey()) {
                if (cursor.getLeft() == null) {
                    cursor.setLeft(newNode);
                    break;
                }
                cursor = cursor.getLeft();
            }
        }

        if (key > cursor.getKey()) {
            cursor.setRight(newNode);
        }
        if (key <= cursor.getKey()) {
            cursor.setLeft(newNode);
        }
    }

    /**
     * Get the root node's data.
     *
     * @return The root node's data.
     */
    public T getRoot() {
        return (root == null ? null : root.getData());
    }

    /**
     * Get the root node itself.
     *
     * @return The root node.
     */
    public Node<T> getRootNode() {
        return root;
    }

    /**
     * Clear the BST.
     */
    public void clear() {
        root = null;
        count = 0;
    }

    /**
     * Obtain an inorder traversal queue of the items in the tree.
     *
     * @return A queue with an inorder traversal of the items in the queue.
     */
    public LinkedList<T> inorder() {
        if (length() == 0)
            return new LinkedList<T>();

        LinkedList<T> output = new LinkedList<T>();
        inorderBuilder(getRootNode(), output);
        return output;
    }

    private void inorderBuilder(Node<T> node, Queue<T> queue) {
        if (node.getLeft() != null)
            inorderBuilder(node.getLeft(), queue);

        queue.add(node.getData());

        if (node.getRight() != null)
            inorderBuilder(node.getRight(), queue);
    }
}
