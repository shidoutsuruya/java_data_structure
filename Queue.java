import java.util.Iterator;

public class Queue<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else {
            oldlast.next = last;
        }
        N += 1;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        N -= 1;
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("hello");
        queue.enqueue("world");
        queue.enqueue("my");
        queue.enqueue("friend");
        var a = queue.iterator();
        System.out.println(a.hasNext());
        Queue<Double> fqueue = new Queue<Double>();
        fqueue.enqueue(12.21212121);
        fqueue.enqueue(23.22121);
        System.out.print(fqueue.dequeue());

    }

}
