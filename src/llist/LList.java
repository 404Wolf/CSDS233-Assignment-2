package llist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LList<T> implements Iterable<T>{
    private LLNode<T> head = null;
    private LLNode<T> tail = null;
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
    public LLNode<T> getHeadNode() {
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
    public LLNode<T> getTailNode() {
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
        append(new LLNode<>(value));
    }

    /**
     * Append a node to the end of the linked list.
     *
     * @param node The node to append to the linked list.
     */
    public void append(LLNode<T> node) {
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
    public void remove(LLNode<T> node) {
        System.out.println(node.getData());
        if (length() == 1)
            head = tail = null;
        else if (node == head)
            head = node.getNext();
        else if (node == tail)
            tail = node.getPrev();
        else
            node.getPrev().setNext(node.getNext());
        count--;
    }

    /**
     * Locate a node by its contained value.
     */
    public LLNode<T> locateNode(T value) {
        LLNode<T> cursor = getHeadNode();
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
        private LLNode<T> cursor;
        private boolean exhausted = false;

        public LListIterator(LList<T> llist) {
            this.llist = llist;
            cursor = llist.head;
        }

        public boolean hasNext() {
            return !exhausted;
        }

        public T next() {
            T data = cursor.getData();
            cursor = cursor.getNext();
            if (cursor == null)
                exhausted = true;
            return data;
        }
    }
}