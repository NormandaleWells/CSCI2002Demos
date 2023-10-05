import java.util.Iterator;

public class OrderedArraySet<T extends Comparable<T>> implements Set<T> {

    private T[] set;
    private int numItems = 0;

    @SuppressWarnings("unchecked")
    public OrderedArraySet(int maxItems) {
        set = (T[]) new Comparable[maxItems];
    }

    @Override
    public void add(T key) {
        int idx = BinarySearch.lowerBound(set, key, 0, numItems);
        if (idx == numItems || !set[idx].equals(key)) {
            set[numItems++] = key;
            ArrayUtils.rotateRight(set, idx, numItems);
        }
    }

    @Override
    public boolean contains(T key) {
        return BinarySearch.index(set, key, 0, numItems) != -1;
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
