public class DummyHeadLinkedList<T> implements List<T>{
    private int size;
    private final LinkedNode<T> dummyHead;

    DummyHeadLinkedList() {
        size = 0;
        dummyHead = new LinkedNode<>(null);
    }

    /**
     * helper method which decrements size, used by iterator.
     */
    public void decSize() {
        size--;
    }

    /**
     * adds an item to the end of the list
     * @param data - value of item to be added
     */
    public boolean add(T data) {
        LinkedNode<T> insertionNode = new LinkedNode<>(data);
        LinkedNode<T> node = dummyHead;
        while(node.next != null) {
            node = node.next;
        }
        node.next = insertionNode;
        size++;
        return true;
    }

    /**
     * inserts an item at a given index
     * @param data - value of item to be added
     * @param index - index of insertion
     */
    public void add(T data, int index) {
        if (index<0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        LinkedNode<T> insertionNode = new LinkedNode<>(data); //create node to be inserted

        //start from the head, loop until the desired index
        LinkedNode<T> node = dummyHead;
        for(int i=0; i<index; i++) {
            node = node.next;
        }

        //insert
        insertionNode.next = node.next;
        node.next = insertionNode;
        size++;
    }

    /**
     * removes a given index
     * @param index - index of removal
     * @return - value of removed index
     */
    public T remove(int index) {
        if (index<0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        LinkedNode<T> node = dummyHead;
        for(int i=0; i<index; i++) {
            node = node.next;
        }
        T data = node.next.data;
        node.next = node.next.next;
        size--;
        return data;
    }

    /**
     * returns the value of a given index
     * @param index - index to be returned
     * @return - value of the data at the given index
     */
    public T get(int index) {
        if (index<0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        LinkedNode<T> node = dummyHead;
        for(int i=0; i<index; i++) {
            node = node.next;
        }
        return node.next.data;
    }

    /**
     * getter for size
     */
    public int size() {
        return size;
    }

    /**
     * prints the list, used in testing
     */
    public void printList() {
        if (size !=0) {
            LinkedNode<T> node = dummyHead.next;
            while(node != null) {
                System.out.print(node.data);
                if (node.next != null) {
                    System.out.print(", ");
                }
                node = node.next;
            }
            System.out.print("\n");
        }
    }

    /**
     * returns an iterator
     * @return - new DummyListIterator object
     */
    public ListIterator<T> iterator() {
        return new DummyListIterator<>(this, dummyHead);
    }
}
