import java.util.Iterator;

public class BSTSet<T extends Comparable<T>> implements Set<T> {

    private class Node {
        T key;
        int height = 1;
        Node left = null;
        Node right = null;

        Node(T key) {
            this.key = key;
        }
    }

    private Node root = null;
    private int numItems = 0;

    private int computeHeight(Node n) {
        if (n == null) return 0;
        return Math.max(computeHeight(n.left), computeHeight(n.right)) + 1;
    }

    private Node add(Node r, T key) {

        if (r == null) {
            numItems += 1;
            return new Node(key);
        }

        int c = key.compareTo(r.key);
        if (c < 0)
            r.left = add(r.left, key);
        else if (c > 0)
            r.right = add(r.right, key);

        r.height = computeHeight(r);
        return r;
    }

    @Override
    public void add(T key) {
        root = add(root, key);
    }

    @Override
    public boolean contains(T key) {
        Node n = root;
        while (n != null) {
            int c = key.compareTo(n.key);
            if (c < 0)
                n = n.left;
            else if (c > 0)
                n = n.right;
            else
                return true;
        }
        return false;
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    private void inorder(Node n, Queue<T> queue) {
        if (n == null) return;
        inorder(n.left, queue);
        queue.enqueue(n.key);
        inorder(n.right, queue);
    }

    @Override
    public Iterator<T> iterator() {
        ArrayQueue<T> queue = new ArrayQueue<T>(numItems);
        inorder(root, queue);
        return queue.iterator();
    }
}
