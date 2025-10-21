public class ArrayListIterator<T> extends ListIterator<T>{
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
