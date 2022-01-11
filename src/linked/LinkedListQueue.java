package linked;

import queue.Queue;

/**
 * 链表实现队列（基础版）
 * */
public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList2<E> list;

    public LinkedListQueue() {
        list = new LinkedList2<E>();
    }

    @Override
    public void enqueue(E element) {
        list.addLast(element);
    }

    @Override
    public E dequeue() {
        return list.removeFirst();
    }

    @Override
    public E getFront() {
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
}
