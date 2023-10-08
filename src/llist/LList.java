package llist;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class LList<T> implements Iterable<T>{
    private Node<T> head = null;
    private Node<T> tail = null;
    private int count = 0;

    public LList () {
        super();
    }

    public LList (T[] elements) {
        for (T element : elements)
            append(element);
    }

    /**
     * Get the data contained in the head.
     *
     * @return The data contained in the head.
     */
    public T getHead() {
        return head.getData();
    }

    /**
     * Get the head node.
     *
     * @return The head node.
     */
    public Node<T> getHeadNode() {
        return head;
    }

    /**
     * Set the data contained in the head.
     *
     * @param data The data to place into the head.
     */
    public void setHead(T data) {
        head.setData(data);
    }

    /**
     * Obtain the data contained in the tail.
     *
     * @return The data contained in the tail.
     */
    public T getTail() {
        return tail.getData();
    }

    /**
     * Obtain the tail node.
     *
     * @return The tail node.
     */
    public Node<T> getTailNode() {
        return tail;
    }

    /**
     * Set the data contained in the tail.
     *
     * @param data The data to place into the tail.
     */
    public void setTail(T data) {
        this.tail.setData(data);
    }

    public void append(T value) {
        append(new Node<>(value));
    }

    /**
     * Append a node to the end of the linked list.
     *
     * @param node The node to append to the linked list.
     */
    public void append(Node<T> node) {
        if (length() == 0) {
            head = node;
            tail = node;
        }
        else if (length() == 1) {
            tail = node;
            head.setNext(node);
            tail.setPrev(head);
        }
        else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        count++;
    }

    /**
     * Remove the node with a given element from the linked list.
     *
     * @param toRemove The element to remove.
     */
    public void remove(T toRemove) {
        remove(locateNode(toRemove));
    }

    /**
     * Remove a node from the linked list.
     *
     * @param node The node to remove.
     */
    public void remove(Node<T> node) {
        if (length() == 1)
            head = tail = null;
        else if (node == head)
            head = node.getNext();
        else if (node == tail)
            tail = node.getPrev();
        else {
            node.getNext().setPrev(node.getPrev());
            node.getPrev().setNext(node.getNext());
        }
        count--;
    }

    /**
     * Locate a node by its contained value.
     */
    public Node<T> locateNode(T value) {
        Node<T> cursor = getHeadNode();
        while (cursor != null) {
            if (cursor.getData().equals(value))
                return cursor;
            cursor = cursor.getNext();
        }

        throw new NoSuchElementException("No such node exists in linked list.");
    }

    /**
     * Check to see if an element is contained in the list.
     *
     * @param value The value to check the presence of.
     */
    public boolean contains(T value) {
        try { locateNode(value); return true; }
        catch (NoSuchElementException e) { return false; }
    }

    /**
     * Swap two elements.
     *
     * @param value1 The first value.
     * @param value2 The value of the node to swap the with the node containing the first value with.
     */
    public void swap(T value1, T value2) {
        swap(locateNode(value1), locateNode(value2));
    }

    /**
     * Swap two nodes.
     *
     * @param node1 The first node.
     * @param node2 The node to swap the first node with.
     */
    public void swap(Node<T> node1, Node<T> node2) {
        if (node1 == node2) {
            return;
        }

        Node<T> node1Next = node1.getNext();
        Node<T> node1Prev = node1.getPrev();

        Node<T> node2Next = node2.getNext();
        Node<T> node2Prev = node2.getPrev();

        // The algorithm is broken into two different cases. Either the nodes are subsequent, or the nodes are not
        // subsequent. The first two cases handle the swap if the nodes are subsequent.
        if (node1Next == node2) {
            if (node1 == getHeadNode()) {
                head = node2;
            }
            if (node2Next != null)
                node2Next.setPrev(node1);
            if (node1Prev != null)
                node1Prev.setNext(node2);
            node2.setNext(node1);
            node2.setPrev(node1Prev);
            node1.setPrev(node2);
            node1.setNext(node2Next);
        }
        else if (node2Next == node1) {
            if (node2 == getTailNode()) {
                tail = node1;
            }
            if (node1Next != null)
                node1Next.setPrev(node2);
            if (node2Prev != null)
                node2Prev.setNext(node1);
            node1.setNext(node2);
            node1.setPrev(node2Prev);
            node2.setPrev(node1);
            node2.setNext(node1Next);
        }
        // Nodes are not subsequent.
        else {
            node2.setPrev(node1Prev);
            node2.setNext(node1Next);
            if (node1Prev != null)
                node1Prev.setNext(node2);
            if (node1Next != null)
                node1Next.setPrev(node2);

            node1.setPrev(node2Prev);
            node1.setNext(node2Next);
            if (node2Prev != null)
                node2Prev.setNext(node1);
            if (node2Next != null)
                node2Next.setPrev(node1);

            if (node1.getNext() == null)
                tail = node1;
            if (node1.getPrev() == null)
                head = node1;

            if (node2.getNext() == null)
                tail = node2;
            if (node2.getPrev() == null)
                head = node2;
        }
        head.clearPrev();
        tail.clearNext();
    }

    /**
     * Compare two LLists.
     */
    @Override
    public boolean equals(Object other) {
        if (!((other) instanceof Iterable))
            return false;

        LListIterator ourIterator = iterator();
        Iterator theirIterator = ((Iterable) other).iterator();

        while (ourIterator.hasNext() && theirIterator.hasNext()) {
            if (!ourIterator.next().equals(theirIterator.next()))
                return false;
        };
        return true;
    }

    public String toString() {
        if (length() == 0)
            return "[]";
        StringBuilder output = new StringBuilder();
        output.append("[");
        for (T element : this) {
            output.append(element.toString()).append(", ");
        }
        output.setLength(output.length() - 2);
        output.append("]");
        return output.toString();
    }

    /**
     * Clear the list.
     */
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Obtain the length of the linked list.
     *
     * @return The length of the linked list.
     */
    public int length() {
        return count;
    }

    public LListIterator iterator() {
        return new LListIterator(this);
    }

    private class LListIterator implements Iterator<T> {
        public LList<T> llist;
        private Node<T> cursor;
        private boolean exhausted = false;

        public LListIterator(LList<T> llist) {
            this.llist = llist;
            cursor = llist.getHeadNode();
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T data = cursor.getData();
                cursor = cursor.getNext();
                return data;
            }
            return null;
        }
    }
}