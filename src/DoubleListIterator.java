public class DoubleListIterator<T> extends ListIterator<T>{
    DoubleNode<T> head;
    DoubleNode<T> indexNode;

    DoubleListIterator(List<T> l, DoubleNode<T> h) {
        super(l);
        head = h;
    }

    /**
     * iterates index node, returns its value
     * @return - value of next node in the sequence
     */
    public T next() {
        if (indexNode == null) {
            indexNode = head;
        } else {
            indexNode = indexNode.next;
        }
        return indexNode.data;
    }

    /**
     * returns whether there are values remaining in the list
     */
    public boolean hasNext() {
        if (indexNode == null) {
            return head != null;
        } else return indexNode.next != null;
    }

    /**
     * removes the current element in the list.
     */
    public void remove() {
        if (indexNode.previous == null) {
            list.remove(0);
        } else {
            indexNode.previous.next = indexNode.next;
            indexNode.next.previous = indexNode.previous;
            list.decSize();
        }
    }
}
