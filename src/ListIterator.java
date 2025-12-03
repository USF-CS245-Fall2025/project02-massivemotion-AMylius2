public abstract class ListIterator<T> { //parent class for all list iterators
    List<T> list;
    public abstract T next();
    public abstract boolean hasNext();
    public abstract void remove();

    ListIterator(List<T> l) {
        list = l;
    }
}
