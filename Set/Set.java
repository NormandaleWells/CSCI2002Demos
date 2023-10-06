// Set - interface for the Set ADT
//
// A Set is a representation of a mathematical set
// in which all elements are the same type, and
// attempts to add a repeated element are ignored.
//
// In the real world, the Set API would include
// a method to remove an item.  For array-based
// sets this is trivial, but for a binary search
// tree it is beyond the scope of this course.
//
// Another real-world consideration is that the
// key we search for may not be all of T, but
// rather just one field.  (Consider, for example,
// a set of student records for which the key
// could be the student ID.)  Because of this,
// it could be a good idea to use a different
// type parameter on contains(), like this:
//
//      public <U> boolean contains(U key);
//
// and require that T support comparisons between
// objects of type T and U through .equals()
// (and, if necessary, compareTo()).
//
// Finally, if the code were modified to distinguish
// between T and U as above, it would be good to
// have a get() method:
//
//      public <U> <T> get(U key);
//
// that retrieves the full T for a given U.

public interface Set<T> extends Iterable<T> {

    // add - add a new item to the Set
    //      If this item already exists in the
    //      Set, the Set is unchanged.
    public void add(T item);

    // contains - check to see if a given item is
    //      in the Set.
    public boolean contains(T item);

    // size - return the number of items in the Set
    public int size();

    // isEmpty - check to see if the Set is empty
    public boolean isEmpty();
}
