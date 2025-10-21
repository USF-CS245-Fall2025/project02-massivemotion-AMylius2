public class DummyListIterator<T> extends ListIterator<T>{
    LinkedNode<T> head;
    LinkedNode<T> indexNode;
    DummyListIterator(List<T> l, LinkedNode<T> h) {
        super(l);
        head = h;
    }

    /**
     * increments indexNode, returns value of the next node
     * @return - value of node after indexNode
     */
    public T next() {
        if (indexNode == null) {
            indexNode = head;
        } else {
            indexNode = indexNode.next;
        }
        return indexNode.next.data;
    }

    /**
     * @return - true if the list has more items, false otherwise
     */
    public boolean hasNext() {
        if (indexNode == null) {
            return (head.next != null);
        } else {
            if (indexNode.next == null) {
                return false;
            } else if (indexNode.next.next == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * removes index after 'indexNode'
     */
    public void remove() {
        indexNode.next = indexNode.next.next;
        list.decSize();
    }
}
