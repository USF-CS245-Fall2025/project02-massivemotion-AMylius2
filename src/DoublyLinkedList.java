public class DoublyLinkedList<T> implements List<T> {
    private int size;
    DoubleNode<T> head;

    DoublyLinkedList() {
        size = 0;
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
        DoubleNode<T> insertionNode = new DoubleNode<>(data);
        if (size == 0) {
            head = insertionNode;
        } else {
            DoubleNode<T> node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = insertionNode;
            insertionNode.previous = node;
        }
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

        //create node
        DoubleNode<T> insertionNode = new DoubleNode<>(data);

        //edge case: inserting at head
        if (index == 0) {
            head.previous = insertionNode;
            insertionNode.next = head;
            head = insertionNode;
        } else { // loop to the index, insert
            DoubleNode<T> node = head;
            for (int i=0; i<index; i++) {
                node = node.next;
            }
            insertionNode.previous = node.previous;
            node.previous.next = insertionNode;
            node.previous = insertionNode;
            insertionNode.next = node;
        }
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
        //declare return data
        T data;

        //edge case: removing at the head
        if (index == 0) {
            data = head.data;
            head = head.next;
            if (head != null){
                head.previous = null;
            }

        } else {//loop to removal index, save data, remove, return
            DoubleNode<T> node = head;
            for(int i=0; i<index; i++) {
                node = node.next;
            }
            node.previous.next = node.next;
            if (node.next != null) {
                node.next.previous = node.previous;
            }
            data = node.data;
        }
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
        T data;

        if (index == 0) { //edge case for getting the head
            data = head.data;
        } else {//loop to desired index, return its value
            DoubleNode<T> node = head;
            for(int i=0; i<index; i++) {
                node = node.next;
            }
            data = node.data;
        }
        return data;
    }

    /**
     * getter for size of the list
     * @return - number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * prints the list, used in testing
     */
    public void printList() {
        if (size !=0) {
            DoubleNode<T> node = head;
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
     * @return - new DoubleListIterator object
     */
    public ListIterator<T> iterator() {
        return new DoubleListIterator<T>(this, head);
    }
}
