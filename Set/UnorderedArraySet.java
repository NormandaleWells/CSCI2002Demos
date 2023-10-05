import java.util.Iterator;

public class UnorderedArraySet<T> implements Set<T> {

    private T[] set;
    private int numItems = 0;

    @SuppressWarnings("unchecked")
    public UnorderedArraySet(int maxItems) {
        set = (T[]) new Object[maxItems];
    }

    @Override
    public void add(T key) {
        int idx = ArrayUtils.find(set, key, 0, numItems);
        if (idx == -1) {
            set[numItems++] = key;
        }
    }

    @Override
    public boolean contains(T key) {
        return ArrayUtils.find(set, key, 0, numItems) != -1;
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    private class ArrayIterator implements Iterator<T> {

        int nextIdx = 0;

        @Override
        public boolean hasNext() {
            return nextIdx < numItems;
        }

        @Override
        public T next() {
            return set[nextIdx++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }
}
