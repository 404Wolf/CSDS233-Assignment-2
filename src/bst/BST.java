package bst;

import java.util.Iterator;

public class BST <T extends Comparable<T>> implements Iterable {
    private Node<T> root;
    private int count;

    /**
     * Determine the number of nodes in the tree.
     *
     * @return The number of nodes in the tree.
     */
    public int length() { return count; }

    public void insert(T key) {

    }

    public void iterator() {

    }

    private class InorderBSTIterator implements Iterator<T> {
        private BST<T> bst;

        public InorderBSTIterator (BST<T> bst) {
            this.bst = bst;
        }

        @Override
        public boolean hasNext() {
            return false;
        }
    }
}
