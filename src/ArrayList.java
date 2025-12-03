public class ArrayList<T> implements List<T> {

    //member variables: size and array
    int size;
    private Object[] arr;

    ArrayList() {//constructor which initializes array and size
        arr = new Object[10];
        size = 0;
    }

    /**getter for size
     * @return size of array
     */
    public int size() {
        return size;
    }

    /**
     * helper method which decrements size,
     * used in the iterator
     */
    public void decSize() {
        size--;
    }

    private void growArray() { //replaces array with new one of 1.5x size, fills with old values
        int newSize =(int) (arr.length * 1.5);
        Object[] temp = new Object[newSize];

        for(int i=0; i<arr.length; i++) {
            temp[i] = arr[i];
        }

        arr = temp;
    }

    /**
     * adds a value at the end of the array
     * @param data to be added
     */
    public boolean add(T data) {// adds a value to the end of the array
        if (size == arr.length) {//if necessary, grow the array
            growArray();
        }
        arr[size++] = data;
        return true;
    }

    /**inserts a value at a given index,
     * takes data and insertion index as arguments
     */
    public void add(T data, int index) throws IndexOutOfBoundsException{//adds a value to a specific index of the array
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (size == arr.length) {
            growArray();
        }
        for (int i=size-1; i >= index; i--) { //shift everything over by one to make space to insert
            arr[i+1] = arr[i];
        }
        arr[index] = data;
        size++;
    }

    /**returns a value at a given index
     * @param index index of item to be returned
     * @return value at the index of the array
     */
    public T get(int index) throws IndexOutOfBoundsException { //returns a value at a given index
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return (T) arr[index];
    }

    /** removes a value from a given index and
     * returns it
     * @param index index of removal
     * @return value of removed item
     */
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T data = (T) arr[index];
        for (int i=index; i<size-1; i++) { //shift everything left, overwriting the data
            arr[i] = arr[i+1];
        }
        size--;
        return data;
    }

    /** Prints elements of the list in a comma
     * separated format
     */
    public void printList() { //prints elements in the list in a comma separated format
        for (int i=0; i<size; i++) {
            if (i!=0) {
                System.out.print(", ");
            }
            System.out.print(arr[i].toString());
        }
        System.out.print("\n");
    }

    /**
     * @return a new ArrayListIterator object
     */
    public ListIterator<T> iterator() {
        return new ArrayListIterator<T>(this);
    }
}


class ArrayListIterator<T> extends ListIterator<T>{ //iterator class for ArrayList
    int position;

    /**
     * constructor which initializes variables
     * @param l - list which will be iterated over
     */
    ArrayListIterator(List<T> l) {
        super(l);
        position = -1;
    }

    /**
     * returns the item at the index after "position",
     * increments position
     * @return
     */
    public T next() {
        T data = list.get(position+1);
        position++;
        return data;
    }

    /**
     *
     * @return whether there is a value in the index after "position"
     * which can be returned
     */
    public boolean hasNext() {
        return (position < list.size()-1);
    }

    /**
     * adds an item to the list.
     * @param data - the value of the item to be added
     */
    public void add(T data) {
        list.add(data, position+1);
    }

    /**
     * removes the item at the current position
     * (whichever has been returned by next())
     */
    public void remove() {
        list.remove(position);
        position--;
    }
}

