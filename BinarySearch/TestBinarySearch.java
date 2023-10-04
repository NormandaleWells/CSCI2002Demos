
public class TestBinarySearch {

    public static void main(String[] args) {

        Integer[] a = { 1, 2, 2, 2, 4, 4, 5, 5, 5, 5, 6, 7, 8, 8, 8, 9, 9, 9, 10, 10 };

        System.out.println("Number  idx  lb  ub  #");

        for (int i = 0; i <= 11; i++) {
            int idx = BinarySearch.index(a, i);
            int lb = BinarySearch.lowerBound(a, i);
            int ub = BinarySearch.upperBound(a, i);
            System.out.printf("    %2d   %2d  %2d  %2d  %d\n", i, idx, lb, ub, ub - lb);
        }
    }
}
