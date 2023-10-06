// OrderedArraySet - implements the Set interface with an ordered array
//
// For simplicity, we're assuming a fixed-size array is sufficient.
//
// Note that to support an ordered array, we need the type parameter
// to support Comparable.

import java.util.Iterator;

public class OrderedArraySet<T extends Comparable<T>> implements Set<T> {

    // Each instance needs an array and a count of the number of items
    // in the Set.  [0..numItems) is the half-open range of valid Set
    // elements.
    private T[] set;
    private int numItems = 0;

    @SuppressWarnings("unchecked")
    public OrderedArraySet(int maxItems) {
        // For ArrayStack and ArrayQueue, we could allocate an array
        // of Object, since every type is an Object.  However, not
        // every Object is Comparable, so we need to be more specific
        // about the type of array we allocate.
        set = (T[]) new Comparable[maxItems];
    }

    @Override
    public void add(T key) {
        // Since the array is ordered, we can use a binary search
        // to look for the key.  lowerBound is our friend here,
        // since if the item isn't present, the index returned
        // is where it should be placed.
        // But there is one caveat: lowerBound will return numItems
        // if the item being searched for is less than all the
        // keys currently in the Set, so before dereferencing
        // the index returned by lowerBound we need to guard
        // agains that case, and treat is a non-present key.
        int idx = BinarySearch.lowerBound(set, key, 0, numItems);
        if (idx == numItems || !set[idx].equals(key)) {
            // Since we already have rotateRight() written,
            // we'll just add the key to the end and rotate
            // it into position.
            set[numItems++] = key;
            ArrayUtils.rotateRight(set, idx, numItems);
        }
    }

    @Override
    public boolean contains(T key) {
        // A simple binary search will suffice here.
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
