class LinkedNode<T> { // class that contains the code for LinkedNode objects used by the
    T data;
    LinkedNode<T> next;
    LinkedNode(T d) {
        data = d;
    }
}

public class LinkedList<T> implements List<T>{
    int size;
    LinkedNode<T> head;


    /**
     * adds given data to a new node at the end of the list
     * @param data - value of item to be added
     */
    public boolean add(T data) {
        LinkedNode<T> dataNode = new LinkedNode<>(data);
        if (head == null) {//edge case: list is empty
            head = dataNode;
        } else {//iterate to the end of the list, add item
            LinkedNode<T> node = head;
            while(node.next != null) {
                node = node.next;
            }
            node.next = dataNode;
        }
        size++;
        return true;
    }

    /**
     * inserts a new item at a given index
     * @param data - value of the data of the node to be inserted
     * @param index - index of insertion
     */
    public void add(T data, int index) throws IndexOutOfBoundsException{
        if (index<0 || index > size) {//edge case: index out of bounds
            throw new IndexOutOfBoundsException();
        }
        LinkedNode<T> insertNode = new LinkedNode<>(data);
        if (index == 0) { //inserting at head
            insertNode.next = head;
            head = insertNode;
        } else {//iterate to the given index, insert
            LinkedNode<T> node = head;
            for(int i=0; i<index-1; i++) {
                node = node.next;
            }
            insertNode.next = node.next;
            node.next = insertNode;
        }
        size++;
    }

    /**
     * removes the item at a given index
     * @param index - index of removal
     * @return - value of the item at the removal index
     */
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index<0 || index >= size) { //edge case: index out of bounds
            throw new IndexOutOfBoundsException();
        }
        size--;
        if (index == 0) {
            T data = head.data;
            head = head.next;
            return data;
        }

        //iterate until removal index, remove
        LinkedNode<T> node = head;
        for(int i=0; i<index-1; i++) {
            node = node.next;
        }
        T data = node.next.data;
        node.next = node.next.next;
        return data;
    }

    /**
     * gets the value at a given index
     * @param index
     * @return
     */
    public T get(int index) throws IndexOutOfBoundsException {
        if (index<0 || index >= size) { //edge case: index out of bounds
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return head.data;
        }

        //iterate from the head to the specified index, return data
        LinkedNode<T> node = head;
        for (int i=0; i<index; i++) {
            node = node.next;
        }
        return node.data;
    }

    /**
     * getter for size
     * @return - size
     */
    public int size() {
        return size;
    }

    /**
     * helper method which decrements size, used by iterator.
     */
    public void decSize() {
        size--;
    }

    /**
     * prints the list, used in testing
     */
    public void printList() {
        if (size !=0) {
            LinkedNode<T> node = head;
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
     * @return - new LinkedListIterator object
     */
    public ListIterator<T> iterator() {
        return new LinkedListIterator<T>(this, this.head);
    }
}


class LinkedListIterator<T> extends ListIterator<T>{ //iterator class for linked list
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

