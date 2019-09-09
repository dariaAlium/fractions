package labs;

class TestFrectionArray {
    public static void main(String[] args) {
        FrectionArray[] f = new FrectionArray[2];
        f[0] = new FrectionArray(1, 2);
        f[1] = new FrectionArray(1, 3);

        FrectionArray[] f1 = new FrectionArray[1];
        f1[0] = new FrectionArray(1);

        Frection result = new Frection(1);
       // result = f[0].arraymult();
        //result.print();

        //Frection h = new Frection("1/2+2-4/9+5/4-3/9");

    }
}

class FrectionArray implements Sort, Sum {

    Frection[] f;

    private Integer num, den;

    FrectionArray(Integer a, Integer b) {
        num = a;
        den = b;
        if (a * b > 0) {
            num = Math.abs(a);
            den = Math.abs(b);
        } else if (a * b == 0) {
            num = 0;
            den = 1;
        } else {
            num = -Math.abs(a);
            den = Math.abs(b);
        }
        red();

    }

    FrectionArray(Integer a) {
        this(a, 1);
    }

    FrectionArray() {
        num = 0;
        den = 1;
    }

    FrectionArray(String s) {
        s.trim(); //удаляем пробелы
        int d = s.indexOf('/'); //индекс слэша
        if (d < 0) {
            num = Integer.parseInt(s);
            den = 1;
        } else {
            String s1 = s.substring(0, d);
            String s2 = s.substring(d + 1);
            num = Integer.parseInt(s1);
            den = Integer.parseInt(s2);
        }
        red();
    }

    public Frection arraysum() {
        Frection f1 = new Frection(0, 0);
        for (int i = 0; i < f.length; i++)
            f1.sum(f[i]);
        f1.print();
        return f1;
    }

    public Frection arraymult() {
        Frection f1 = new Frection(1, 1);
        for (int i = 0; i < f.length; i++)
            f1.multiplication(f[i]);
        f1.print();
        return f1;
    }

    public Frection arraydiv() {
        Frection f1 = new Frection(1, 1);
        f1.multiplication(f[0]);
        for (int i = 1; i < f.length; i++)
            f1.division(f[i]);
        f1.print();
        return f1;
    }

    public Frection arraymin() {
        Frection f1 = new Frection();
        for (int i = 0; i < f.length - 1; i++)
            f1 = f[i].min(f[i + 1]);
        return f1;
    }

    public Frection arraymax() {
        Frection f1 = new Frection();
        for (int i = 0; i < f.length - 1; i++)
            f1 = f[i].max(f[i + 1]);
        return f1;
    }

    public void sort_min() {
        for (int i = 0; i < f.length; i++)
            for (int b = f.length - 1; b > i; b--)
                if (f[b - 1].min_add(f[b])) {
                    Frection t = f[b - 1];
                    f[b - 1] = f[b];
                    f[b] = t;
                }
    }

    public void insertsort(Object[] f) {
        int size = 0;
        for (int n = 0; n < f.length; n++) {
            // Ищем место для вставки
            int ind = 0;
            if (size > 0)
                while (ind < size && ((Frection) f[ind]).min_add((Frection) f[n]))
                    ind++;
            // Вставка
            for (int m = size - 1; m >= ind; m--)
                f[m + 1] = f[m];
            f[ind] = f[n];
            size++;
        }
    }

    private void red() {
        int a = num;
        int b = den;
        num = num / nod(a, b);
        den = den / nod(a, b);
    }

    public int nod(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        int max = Math.max(a, b);
        int nod;
        for (int i = max; i > 1; i--)
            if (a % i == 0 && b % i == 0) {
                nod = i;
                return nod;
            }
        return 1;
    }

    public void sortWithCompare() {
        for (int i = 0; i < f.length; i++)
            for (int b = f.length - 1; b > i; b--)
                if (f[b - 1].compareTo(f[b]) == -1) {
                    if (f[b - 1].min_add(f[b])) {
                        Frection t = f[b - 1];
                        f[b - 1] = f[b];
                        f[b] = t;
                    }
                }
    }


}
