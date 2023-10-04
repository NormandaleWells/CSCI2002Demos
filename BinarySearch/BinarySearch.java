public class BinarySearch {
    
    public static <T extends Comparable<T>> int index(T[] a, T key) {

        int lo = 0;
        int hi = a.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int c = a[mid].compareTo(key);

            if (c < 0)
                lo = mid + 1;
            else if (c > 0)
                hi = mid;
            else
                return mid;
        }

        return -1;
    }

    public static <T extends Comparable<T>> int lowerBound(T[] a, T key) {

        int lo = 0;
        int hi = a.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid].compareTo(key) < 0)
                lo = mid + 1;
            else
                hi = mid;
        }

        return hi;
    }

    public static <T extends Comparable<T>> int upperBound(T[] a, T key) {

        int lo = 0;
        int hi = a.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid].compareTo(key) <= 0)
                lo = mid + 1;
            else
                hi = mid;
        }

        return hi;
    }
}
