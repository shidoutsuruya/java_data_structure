public class LinkedList<Item>
{
    private Node first;
    private int N;
    private class Node
    {
        Item item;
        Node next;
    }
    public boolean isEmpty(){return first==null;}
    public int size(){return N;}
    public void push(Item item)
    {
        Node oldfirst=first;
        first=new Node();
        first.item=item;
        first.next=oldfirst;
        N+=1;
    }
    public Item pop()
    {
        Item item=first.item;
        first=first.next;
        N-=1;
        return item;
    }
    public static void main(String[] args)
    {
        LinkedList<String> s= new LinkedList<String>();
        s.push("hello");
        s.push("world");
        StdOut.print("hello");
    }
}

