package bst;

import java.lang.reflect.Array;
import java.util.*;

public class BST <T>{
    private Node<T> root;
    private int count;
    private int keySum;

    /**
     * Determine the number of nodes in the tree.
     *
     * @return The number of nodes in the tree.
     */
    public int length() { return count; }

    /**
     * Get the total sum of all the keys in the tree.
     *
     * @return The total sum of all the keys in the tree.
     */
    public int keySum() {
        return keySum;
    }

    public void insert(int key, T data) {
        Node<T> cursor = getRootNode();
        Node<T> newNode = new Node<T>(key, data);
        keySum += key;

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
        keySum = 0;
    }

    /**
     * Find the k-th biggest element in the tree.
     *
     * @param k The index of the item of the sorted array to return.
     */
    public T kthBiggest(int k) {
        LinkedHashSet<T> orderedNoDuplicates = LinkedHashSet.newLinkedHashSet(length());
        for (T element : inorder()) {
            orderedNoDuplicates.add(element);
        }

        Iterator<T> hashSetIterator = orderedNoDuplicates.iterator();
        for (int i = 0; i < orderedNoDuplicates.size(); i++)
            if (i == k - 1)
                return hashSetIterator.next();
            else
                hashSetIterator.next();

        throw new NoSuchElementException();
    }

    /**
     * Obtain an inorder traversal array of the items in the tree.
     *
     * @return An array with an inorder traversal of the items in the array.
     */
    public ArrayList<T> inorder() {
        if (length() == 0)
            return new ArrayList<>();

        ArrayList<T> output = new ArrayList<T>();
        inorderBuilder(getRootNode(), output);
        return output;
    }

    private void inorderBuilder(Node<T> node, ArrayList<T> array) {
        if (node.getLeft() != null)
            inorderBuilder(node.getLeft(), array);

        array.add(node.getData());

        if (node.getRight() != null)
            inorderBuilder(node.getRight(), array);
    }
}
