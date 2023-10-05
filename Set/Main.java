import java.util.Scanner;

public class Main {
    
    private static <T> void printSet(Set<T> set) {

        System.out.print("[ ");
        for (T item : set) {
            System.out.printf("%s ", item.toString());
        }
        System.out.println("]");
    }

    private static void testSet(Scanner sc, Set<Integer> set) {

        while (sc.hasNext()) {

            String command = sc.next();
            switch (command) {
                case "add":
                {
                    int item = sc.nextInt();
                    set.add(item);
                    break;
                }
                case "contains":
                {
                    int item = sc.nextInt();
                    boolean itemExists = set.contains(item);
                    System.out.printf("contains(%d) -> %s\n", item, itemExists);
                    break;
                }
                case "size":
                {
                    int size = set.size();
                    System.out.printf("size() -> %d\n", size);
                    break;
                }
                case "isEmpty":
                {
                    boolean empty = set.isEmpty();
                    System.out.printf("isEmpty() -> %s\n", empty);
                    break;
                }
                case "print":
                {
                    printSet(set);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<Integer> set = null;
        String type = sc.next();
        if (type.equals("ua")) {
            int maxSize = sc.nextInt();
            set = new UnorderedArraySet<>(maxSize);
        } else if (type.equals("oa")) {
            int maxSize = sc.nextInt();
            set = new OrderedArraySet<>(maxSize);
        } else if (type.equals("bst")) {
            set = new BSTSet<Integer>();
        }

        if (set != null) {
            testSet(sc, set);
        }
    }
}
