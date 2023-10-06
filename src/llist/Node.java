package llist;

public class Node<T> {
    private Node<T> next;
    private Node<T> prev;
    private T data;

    public Node(T data){
        this.data = data;
    }

    public Node(T data, Node<T> prev, Node<T> next){
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    /**
     * Set the data contained in the node.
     *
     * @param data The data to contain in the node.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Set the subsequent node.
     *
     * @param next The next node.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Clear the next node.
     */
    public void clearNext() {
        setNext(null);
    }

    /**
     * Obtain the subsequent node.
     *
     * @return The subsequent node.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Determine whether there is a subsequent node.
     *
     * @return Whether there is a subsequent node.
     */
    public boolean hasNext() {
        return getNext() != null;
    }

    /**
     * Set the prior node.
     *
     * @param prev The node to set the prior node to.
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    /**
     * Clear the prior node.
     */
    public void clearPrev() {
        setPrev(null);
    }

    /**
     * Obtain the prior node.
     *
     * @return The prior node.
     */
    public Node<T> getPrev() {
        return prev;
    }

    /**
     * Determine whether there is a prior node.
     *
     * @return Whether there is a prior node.
     */
    public boolean hasPrev() {
        return getPrev() != null;
    }

    @Override
    public String toString() {
        return "LLNode(" + getData() + ")";
    }
}
