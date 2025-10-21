public class LinkedListIterator<T> extends ListIterator<T>{
    LinkedNode<T> head;
    LinkedNode<T> indexNode;
    LinkedListIterator(List<T> l, LinkedNode<T> h) {
        super(l);
        head = h;
    }

    /**
     * returns the next value in the list
     * @return - data of the next node in the list
     */
    public T next() {  //revise so that "current" (maybe rename to indexNode?) is the node before the one returned
        if (indexNode == null) {
            indexNode = new LinkedNode<T>(null);
            indexNode.next = head;
        } else {
            indexNode = indexNode.next;
        }
        return indexNode.next.data;
    }

    /**
     * returns whether there are more values left in the list (after the current index)
     */
    public boolean hasNext() {
        if (indexNode!= null) {
            if (indexNode.next != null) {
                return (indexNode.next.next != null);
            } else  return false;
        } else { return head != null; }
    }

    /**
     * removes the next item in the list (the item after indexNode)
     */
    public void remove() {
        // edge case for first index
        if (indexNode.next == head) {
            list.remove(0);
        } else {
            indexNode.next = indexNode.next.next;
            list.decSize();
        }
    }
}
