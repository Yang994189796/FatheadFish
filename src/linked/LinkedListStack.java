package linked;

import stack.Stack;

public class LinkedListStack implements Stack {
    private LinkedList2 list;

    public LinkedListStack() {
        this.list = new LinkedList2();
    }

    @Override
    public void push(Object element) {
        list.addFirst(element);
    }

    @Override
    public Object pop() {
        return list.removeFirst();
    }

    @Override
    public Object peek() {
        return list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
