public abstract class ListIterator<T> {
    List<T> list;
    public abstract T next();
    public abstract boolean hasNext();
    public abstract void remove();

    ListIterator(List<T> l) {
        list = l;
    }
}
