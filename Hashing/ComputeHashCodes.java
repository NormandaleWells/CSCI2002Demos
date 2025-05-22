import java.util.Scanner;

public class ComputeHashCodes {

    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            int hc = s.hashCode();
            int idx = Math.abs(hc) % m;
            System.out.printf("%s: hc = %d, idx = %d\n", s, hc, idx);
        }

        sc.close();
    }
}