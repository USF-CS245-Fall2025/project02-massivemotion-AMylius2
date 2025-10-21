public interface List<T> {
    int size = 0;
    public void decSize();
    public boolean add(T data);
    public void add(T data, int index);
    public T remove(int index);
    public T get(int index);
    public int size();
    public void printList(); //used for debugging
    public ListIterator<T> iterator();
}
