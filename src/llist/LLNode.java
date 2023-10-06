package llist;

public class LLNode <T> {
    private LLNode<T> next;
    private LLNode<T> prev;
    private T data;

    public LLNode (T data){
        this.data = data;
    }

    public LLNode (T data, LLNode<T> prev, LLNode<T> next){
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
    public void setNext(LLNode<T> next) {
        this.next = next;
    }

    /**
     * Obtain the subsequent node.
     *
     * @return The subsequent node.
     */
    public LLNode<T> getNext() {
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
    public void setPrev(LLNode<T> prev) {
        this.prev = prev;
    }

    /**
     * Obtain the prior node.
     *
     * @return The prior node.
     */
    public LLNode<T> getPrev() {
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
}
