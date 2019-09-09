package labs;

class TestArraysUtils {

    public static void main(String[] args) {

        ArraysUtils array = new ArraysUtils(10);
        array.findMax();
        array.findMin();
        System.out.println(array.time());

    }

}

class ArraysUtils {

    private int max = 0;
    private int min = 0;
    private int[] array;

    ArraysUtils(int size) {
        array = new int[size];
        for (int q = 0; q < size; q++)
            array[q] = (int) (Math.random() * 200);

    }

    void findMax() {
        max = array[0];
        int i;
        for (i = 0; i < array.length; ++i)
            if (array[i] > array[0])
                max = array[i];
        System.out.println("max: " + max);

        for (int m = 0; m < array.length; ++m)
            if (max == array[m]) {
                i = m;
                System.out.println("array[" + i + "]");
            }
    }

    void findMin() {
        min = array[0];
        int i;
        for (i = 0; i < array.length; ++i)
            if (array[i] < array[0])
                min = array[i];
        System.out.println("min: " + min);

        for (int m = 0; m < array.length; ++m)
            if (min == array[m]) {
                i = m;
                System.out.println("array[" + i + "]");
            }
    }

    void sort() {
        for (int i = 1; i < array.length; i++)
            for (int b = array.length - 1; b >= i; b--)
                if (array[b - 1] > array[b]) {
                    int t = array[b - 1];
                    array[b - 1] = array[b];
                    array[b] = t;
                }
        System.out.print("\nOтcopтиpoвaнный массив:");
        for (int p = 0; p < array.length; p++)
            System.out.print(" " + array[p]);
    }

    boolean isSorted(int[] array) {
        boolean bol = true;
        for (int i = 0; i < (array.length - 1); i++) {
            if (array[i] < array[i + 1]) bol = true;
            else bol = false;
        }
        return bol;
    }

    long time() {
        long before = System.currentTimeMillis();
        sort();
        long after = System.currentTimeMillis();
        return after - before;
    }

    @Override
    public String toString() {
        String a;
        char[] b = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            b[i] = (char) array[i];
        }
        a = String.valueOf(b);
        return a;
    }
}
