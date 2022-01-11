package linked;

/**
 * 链表（虚拟头节点技巧）
 * */
public class LinkedList2<E> {

    private Node dummyHead;
    private int size;

    public LinkedList2() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void add(int index, E element) {
        if (index<0 || index>size){
            throw new IllegalArgumentException("Add filed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(element, prev.next);
        size++;
    }

    public void addFirst(E element) {
        add(0,element);
    }

    public void addLast(E element) {
        add(size, element);
    }

    public E get(int index) {
        if (index<0 || index>size){
            throw new IllegalArgumentException("Get filed. Illegal index.");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size-1);
    }

    public void set(int index, E element) {
        if (index<0 || index>size){
            throw new IllegalArgumentException("Set filed. Illegal index.");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.element = element;
    }

    public boolean contains(E element) {
        Node current = dummyHead.next;
        while (current != null) {
            if (current.element.equals(element)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index<0 || index>size){
            throw new IllegalArgumentException("delete filed. Illegal index.");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node retNode = pre.next;
        pre.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.element;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node current = dummyHead.next;
        while (current != null) {
            res.append(current + "->");
            current = current.next;
        }
        res.append("NULL");
        return res.toString();
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
