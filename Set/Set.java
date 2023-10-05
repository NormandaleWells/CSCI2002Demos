public interface Set<T> extends Iterable<T> {
    public void add(T item);
    public boolean contains(T item);
    public int size();
    public boolean isEmpty();
}
