// Adapted from _Algorithms, 4th edition_
// by Sedgewick and Wayne, section 1.2.

public class Counter {

    // Instance variables.
    private final String name;
    private int count = 0;

    // Constructor.
    public Counter(String name) {
        this.name = name;
    }

    // Instance method.
    public void increment() {
        count += 1;
    }

    // Instance method.
    public int tally() {
        return count;
    }

    // Instance method, inherited from Object.
    public String toString() {
        return String.format("%s %d", name, count);
    }
}
