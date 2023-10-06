// UnorderedArraySet - implements the Set interface with an unordered array
//
// For simplicity, we're assuming a fixed-size array is sufficient.

import java.util.Iterator;

public class UnorderedArraySet<T> implements Set<T> {

    // Each instance needs an array and a count of the number of items
    // in the Set.  [0..numItems) is the half-open range of valid Set
    // elements.
    private T[] set;
    private int numItems = 0;

    // See ArrayQueue or ArrayStack for an explanation of
    // the hoops Java requires us to jump through to allocate
    // an array of a parameterized type.
    @SuppressWarnings("unchecked")
    public UnorderedArraySet(int maxItems) {
        set = (T[]) new Object[maxItems];
    }

    @Override
    public void add(T key) {

        // Check to see if we already have this item.  Note
        // that were using the subrange version of find(),
        // since we may not be using the entire array.
        int idx = ArrayUtils.find(set, key, 0, numItems);
        if (idx == -1) {
            // Since the array is unordered, we can simply
            // add the new item at the end.
            set[numItems++] = key;
        }
    }

    @Override
    public boolean contains(T key) {

        // Again, a simple call to the subrange version of
        // find() is all we need here.
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

    // ArrayIterator simply allows us to is the Java for-each
    // loop.  Knowing how this works is beyond the scope of
    // this course, but implementing it is necessary to allow
    // OrderedArraySet to act like a Java collection type.
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
