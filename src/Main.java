import array.Array;

public class Main {
    public static void main(String[] args) {
        Array arr = new Array(20);
        for (int i = 0; i < 18; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(13);
        System.out.println(arr);
    }
}
