package queue;

/**
 * 循环队列---去除size变量方式
 */
public class LoopQueue2<E> implements Queue<E> {

    private E[] data;
    private int front, tail;

    public LoopQueue2(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public LoopQueue2() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        if (front > tail) {
            return (data.length - front) + tail;
        } else {
            return tail-front;
        }
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E element) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = element;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Empty queue.");
        }
        return data[front];
    }

    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(i + front) % data.length];
        }
        tail = getSize();
        front = 0;
        data = newData;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue2：front = %d ，tail = %d ，size = %d ，capacity = %d\n",front,tail,getSize(),getCapacity()));
        res.append("LoopQueue2: ");
        res.append("[");
        for (int i = 0; i < getSize(); i++) {
            res.append(data[(i + front) % data.length]);
            if (tail != ((front+i+1)%data.length)){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
