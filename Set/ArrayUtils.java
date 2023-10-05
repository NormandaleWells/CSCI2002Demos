class ArrayUtils {

    public static <T> int find(T[] a, T value, int lo, int hi) {
        for (int i = lo; i < hi; i++)
            if (a[i].equals(value))
                return i;
        return -1;
    }

    public static <T> int find(T[] a, T value) {
        return find(a, value, 0, a.length);
    }

    public static <T> void rotateLeft(T[] a, int lo, int hi) {

        if (hi - lo < 2) return;

        T t = a[lo];
        for (int i = lo+1; i < hi; i++)
            a[i-1] = a[i];
        a[hi-1] = t;
    }

    public static <T> void rotateRight(T[] a, int lo, int hi) {

        if (hi - lo < 2) return;

        T t = a[hi-1];
        for (int i = hi-1; i > lo; --i)
            a[i] = a[i-1];
        a[lo] = t;
    }
}
