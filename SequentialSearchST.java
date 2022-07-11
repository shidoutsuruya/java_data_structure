public class SequentialSearchST<Key, Value> {
    private Node first;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key == x.key) {
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key == x.key) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
    }

    public static void main(String[] args) {
        SequentialSearchST<String, String> dict = new SequentialSearchST<String, String>();
        dict.put("John", "Summer");
        dict.put("Jane", "Winter");
        System.out.println(dict.get("John"));
    }
}
