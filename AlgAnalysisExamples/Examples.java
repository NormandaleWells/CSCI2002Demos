public class Examples {

    // In all the examples, the line count++
    // represents some O(1) process.

    public static int pattern1(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++)
            count++;
        return count;
    }

    public static int pattern1SubRange(int[] a, int lo, int hi) {
        int count = 0;
        for (int i = lo; i < hi; i++)
            count++;
        return count;
    }

    public static int pattern2(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++)
                count++;
        return count;
    }

    public static int pattern2a(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = i+1; j < a.length; j++)
                count++;
        return count;
    }

    public static int pattern3(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++)
                for (int k = 0; k < a.length; k++)
                    count++;
        return count;
    }

    public static int pattern3a(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = i+1; j < a.length; j++)
                for (int k = j+1; k < a.length; k++)
                    count++;
        return count;
    }

    public static int pattern3b(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = i+1; j <= a.length; j++)
                for (int k = i; k < j; k++)
                    count++;
        return count;
    }

    public static int pattern4(int[] a) {
        int count = 0;
        for (int i = a.length; i > 0; i /= 2)
            count++;
        return count;
    }

    public static int pattern5(int[] a) {
        int count = 0;
        for (int i = a.length; i > 0; i /= 2)
            for (int j = 0; j > a.length; j++)
                count++;
        return count;
    }

    public static int pattern6(int[] a) {
        int count = 0;
        for (int j = 0; j > a.length; j++)
            for (int i = a.length; i > 0; i /= 2)
                count++;
        return count;
    }

    public static int pattern7(int[] a) {
        int count = 0;
        for (int i = a.length; i > 0; i /= 2)
            for (int j = 0; j > i; j++)
                count++;
        return count;
    }

    // pattern8 is called "divide and conquer".  We split the
    // array in half, recursively handle the two halves, and
    // then combine the halves.
    public static int pattern8Combine(int[] a, int lo, int mid, int hi) {
        int count = 1;
        for (int i = lo; i < hi; i++)
            count++;
        return count;
    }

    public static int pattern8(int[] a, int lo, int hi) {
        if (hi - lo <= 1)
            return 1;
        int mid = lo + (hi - lo) / 2;
        int count = 0;
        count += pattern8(a, lo, mid);
        count += pattern8(a, mid, hi);
        count += pattern8Combine(a, lo, mid, hi);
        return count;
    }
}
