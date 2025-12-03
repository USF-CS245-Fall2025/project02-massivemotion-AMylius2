public interface List<T> {
    int size = 0;
    public void decSize();
    public boolean add(T data);
    public void add(T data, int index) throws IndexOutOfBoundsException;
    public T remove(int index) throws IndexOutOfBoundsException;
    public T get(int index) throws IndexOutOfBoundsException;
    public int size();
    public void printList(); //used for debugging
    public ListIterator<T> iterator();
}
