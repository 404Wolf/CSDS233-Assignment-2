package bst;

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
        Node<T> cursor = getRootNode(); // We'll begin our binary search from the root.
        Node<T> newNode = new Node<T>(key, data); // Create a new node to contain the key-value.
        keySum += key; // Maintain a counter of the total sum of all the keys.

        // If there are no items, then the new node becomes the root and the count ticks up by one. We can return, since
        // the insertion is complete.
        if (length() == 0) {
            root = newNode;
            count++;
            return;
        }

        while (true) {
            // Until we've reached a leaf, travel to the right if the key of our new node is greater than that of the
            // cursor, or to the left if the key is lesser.
            if (key > cursor.getKey()) {
                // Once we've reached the proper leaf, stop looping.
                if (cursor.getRight() == null)
                    break;
                cursor = cursor.getRight();
            }
            else if (key <= cursor.getKey()) {
                // We've reached a leaf so we can stop looping.
                if (cursor.getLeft() == null)
                    break;
                cursor = cursor.getLeft();
            }
        }

        // Place the cursor on the proper side of the leaf.
        if (key > cursor.getKey()) {
            cursor.setRight(newNode);
        }
        else if (key <= cursor.getKey()) {
            cursor.setLeft(newNode);
        }
    }

    /**
     * Get the root node's data.
     *
     * @return The root node's data, or null if there is no current root.
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
        // First we must remove the duplicates from the array, since we don't want to count the same element mupltiple
        // times when determining the k-th biggest element. We use a linked hash set here since it will let us
        // automatically remove duplicate elements in linear time, as opposed to doing a check for every element n times
        // which would be O(n^2).
        LinkedHashSet<T> orderedNoDuplicates = LinkedHashSet.newLinkedHashSet(length());
        orderedNoDuplicates.addAll(inorder());

        // We'll iterate the linked hash set, and stop once we've reached the desired element.
        Iterator<T> hashSetIterator = orderedNoDuplicates.iterator();
        for (int i = 0; i < orderedNoDuplicates.size(); i++)
            if (i == k - 1)
                return hashSetIterator.next();
            else
                hashSetIterator.next();

        // If we reach the end of the hash set and haven't found it, there are not enough unique elements for there to
        // be a k-th biggest for the provided k. For example, if the BST has elements inorder{7, 6, 6, 6}, there is no
        // third-biggest-element.
        throw new NoSuchElementException();
    }

    /**
     * Obtain an inorder traversal array of the items in the tree.
     *
     * @return An array with an inorder traversal of the items in the array.
     */
    public ArrayList<T> inorder() {
        // If there are no items in the BST then just return an empty array.
        if (length() == 0)
            return new ArrayList<>();

        // Construct an empty ArrayList and feed it to the recursive builder.
        ArrayList<T> output = new ArrayList<T>();
        inorderBuilder(getRootNode(), output);
        return output;
    }

    private void inorderBuilder(Node<T> node, ArrayList<T> array) {
        // Inorder is left-node-right. So, we recurse to the left, adding the node to the ArrayList at each base case,
        // add the node itself, and then recurse to the right the same way.

        if (node.getLeft() != null)
            inorderBuilder(node.getLeft(), array);

        array.add(node.getData());

        if (node.getRight() != null)
            inorderBuilder(node.getRight(), array);
    }

    /**
     * Obtain a preorder traversal array of the items in the tree.
     *
     * @return An array with a preorder traversal of the items in the array.
     */
    public ArrayList<T> preorder() {
        // If there are no items in the BST then just return an empty array.
        if (length() == 0)
            return new ArrayList<>();

        ArrayList<T> output = new ArrayList<T>();
        preorderBuilder(getRootNode(), output);
        return output;
    }

    private void preorderBuilder(Node<T> node, ArrayList<T> array) {
        // Preorder is left-right-node. So, we recurse to the left, recurse to the right, and then process the node
        // itself, adding the nodes to the array as we reach the base case.

        array.add(node.getData());

        if (node.getLeft() != null)
            preorderBuilder(node.getLeft(), array);

        if (node.getRight() != null)
            preorderBuilder(node.getRight(), array);
    }
}
