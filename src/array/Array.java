package array;

/**
 * 数组
 *
 * 数组最大的优点:查询速度快;
 * 数组最好应用于"索引有语义"的情况;
 *
 * @date 2021-12-2 22:51:31
 * */
public class Array<T> {
    private T[] data;
    private int size;

    /**
     * 构造函数,传入数组的容量capacity构造Array
     * */
    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 无参构造函数,默认容量为10
     * */
    public Array() {
        this(10);
    }

    /**
     * 获取数组容量
     * */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 获取数组中元素的个数
     * */
    public int getSize() {
        return size;
    }

    /**
     * 向数组最后添加元素
     * */
    public void addLast(T element) {
        add(size,element);
    }

    /**
     * 向数组最前添加元素
     * */
    public void addFirst(T element) {
        add(0, element);
    }

    /**
     * 向数组指定index位置添加元素
     * */
    public void add(int index, T element) {
        if (size==data.length){
            throw new IllegalArgumentException("AddLast failed. Array is full.");
        }
        if (index<0 || index>size) {
            throw new IllegalArgumentException("AddLast failed. Require index >=0 and index < =size.");
        }
        for (int i = size-1; i >= index ; i--) {
            data[i+1] = data[i];
        }
        data[index] = element;
        size++;
    }

    /**
     * 修改数组
     * */
    public void update(int index, T element) {
        if (index<0 || index>size) {
            throw new IllegalArgumentException("AddLast failed. Index is illegal");
        }
        data[index] = element;
    }

    /**
     * 获取数组指定位置元素
     * */
    public T get(int index) {
        if (index<0 || index>size) {
            throw new IllegalArgumentException("AddLast failed. Index is illegal");
        }
        return data[index];
    }
}
