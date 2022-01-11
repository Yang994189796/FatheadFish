package linked;

public class LinkedList<E> {

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void addFirst(E element) {
//        Node node = new Node(element);
//        node.next = head;
//        head = node;

        head = new Node(element, head);
        size++;
    }

    public void add(int index, E element) {
        if (index<0 || index>size){
            throw new IllegalArgumentException("Add filed. Illegal index.");
        }
        if (index == 0) {
            addFirst(element);
        }else {
            Node prev = head;
            for (int i = 0; i < index-1; i++) {
                prev = prev.next;
            }
            prev.next = new Node(element, prev.next);
            size++;
        }
    }

    public void addLast(E element) {
        add(size, element);
    }

    private class Node {
        public E element;
        public Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node(E element) {
            this(element, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }
}
