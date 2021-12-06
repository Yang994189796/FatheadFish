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
        if (index<0 || index>size) {
            throw new IllegalArgumentException("Add failed. Require index >=0 and index < =size.");
        }
        if (size==data.length){
            resize(2*size);
        }
        for (int i = size-1; i >= index ; i--) {
            data[i+1] = data[i];
        }
        data[index] = element;
        size++;
    }

    public int find(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

    public int[] findAll(T element){
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])){
                res[i]=i;
            }
        }
        return res;
    };

    public boolean contain(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])){
                return true;
            }
        }
        return false;
    }

    public T remove(int index) {
        if (index<0 || index>size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }
        size--;
        T removeElement = data[index];
        for (int i = index; i < size ; i++) {
            data[i] = data[i+1];
        }
        if (size == data.length/2){
            resize(data.length/2);
        }
        data[size]=null;
        return removeElement;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size-1);
    }

    public void removeAll(T element) {
        int[] indexs = findAll(element);
        for (int i = indexs.length-1; i >= 0; i--) {
            if (0 != indexs[i]){
                remove(indexs[i]);
            }
        }
    }

    public void removeElement(T element) {
        int index = find(element);
        if (-1 != index) {
            remove(index);
        }
    }

    /**
     * 修改数组
     * */
    public void update(int index, T element) {
        if (index<0 || index>size) {
            throw new IllegalArgumentException("Update failed. Index is illegal");
        }
        data[index] = element;
    }

    /**
     * 获取数组指定位置元素
     * */
    public T get(int index) {
        if (index<0 || index>size) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        return data[index];
    }

    private void resize(int newCapacity) {
        T[] newData = (T[])new Object[newCapacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array：size = %d ，capacity = %d\n",size,data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i!=size-1){
                res.append("，");
            }
        }
        res.append("]");
        return res.toString();
    }
}
