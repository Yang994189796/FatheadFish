import array.Array;

public class Main {
    public static void main(String[] args) {
        Array arr = new Array(20);
        arr.addLast(-1);
        arr.addLast(0);
        arr.addLast(1);
        arr.addLast(3);
        arr.addLast(4);
        arr.addLast(10);
        arr.addLast(25);
        arr.addLast(50);
        arr.addLast(50);
        arr.addLast(50);
        arr.addLast(100);
        arr.addLast(100);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(-1);
        System.out.println(arr);

        int[] res = arr.findAll(50);
        for (int re : res) {
            System.out.print(re+",");
        }

        arr.removeAll(50);
        System.out.println("\n"+arr);
    }
}
