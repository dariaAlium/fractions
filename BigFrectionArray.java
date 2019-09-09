package labs;

import java.math.BigInteger;

class TestBigFrectionArray {

    public static void main(String[] args) {

        BigFrectionArray[] f = new BigFrectionArray[2];
        f[0] = new BigFrectionArray(1, 5);
        f[1] = new BigFrectionArray(1);
        f[0].sort_min();

    }

}

class BigFrectionArray implements Sort, Sum {

    BigFrection[] f;

    BigInteger num;
    BigInteger den;

    BigFrectionArray(int a, int b) {
        String sta = String.valueOf(a);
        String stb = String.valueOf(b);
        num = new BigInteger(sta);
        den = new BigInteger(stb);

        if (num.multiply(den).compareTo(BigInteger.ZERO) == 1) {
            num = num.abs();
            den = den.abs();
        } else if (num.multiply(den).compareTo(BigInteger.ZERO) == 0) {
            num = BigInteger.ZERO;
            den = BigInteger.ONE;
        } else {
            num = num.abs();
            num = num.negate();
            den = den.abs();
        }

    }

    BigFrectionArray(Integer a) {
        this(a, 1);
    }

    BigFrectionArray() {
        num = BigInteger.ZERO;
        den = BigInteger.ONE;
    }

    BigFrectionArray(String s) {
        s.trim(); //удаляем пробелы
        int d = s.indexOf('/'); //индекс слэша
        if (d < 0) {
            num = new BigInteger(s);
            den = BigInteger.ONE;
        } else {
            String s1 = s.substring(0, d); //строка num
            String s2 = s.substring(d + 1, s.length());  //строка den
            num = new BigInteger(s1);
            den = new BigInteger(s2);
        }

    }

    void sum(Object o) {

    }

    public BigFrection arraysum() {
        BigFrection f1 = new BigFrection(0, 0);
        for (int i = 0; i < f.length; i++) {
            f1.sum(f[i]);
        }
        f1.print();
        return f1;
    }

    public BigFrection arraymult() {
        BigFrection f1 = new BigFrection(1, 1);
        for (int i = 0; i < f.length; i++)
            f1.multiplication(f[i]);
        f1.print();
        return f1;
    }

    public BigFrection arraydiv() {
        BigFrection f1 = new BigFrection(1, 1);
        f1.multiplication(f[0]);
        for (int i = 1; i < f.length; i++)
            f1.division(f[i]);
        f1.print();
        return f1;
    }

    public BigFrection arraymin() {
        BigFrection f1 = new BigFrection();
        for (int i = 0; i < f.length - 1; i++)
            f1 = f[i].min(f[i + 1]);
        return f1;
    }

    public BigFrection arraymax() {
        BigFrection f1 = new BigFrection();
        for (int i = 0; i < f.length - 1; i++)
            f1 = f[i].max(f[i + 1]);
        return f1;
    }

    void sort_min() {
        for (int i = 0; i < f.length; i++)
            for (int b = f.length - 1; b > i; b--)
                if (f[b - 1].min_add(f[b])) {
                    BigFrection t = f[b - 1];
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
                while (ind < size && ((BigFrection) f[ind]).min_add((BigFrection)f[n]))
                    ind++;
            // Вставка
            for (int m = size - 1; m >= ind; m--)
                f[m + 1] = f[m];
            f[ind] = f[n];
            size++;
        }
    }

    public void sortWithCompare() {
        for (int i = 0; i < f.length; i++)
            for (int b = f.length - 1; b > i; b--)
                if (f[b - 1].compareTo(f[b]) == -1)
                    if (f[b - 1].min_add(f[b])) {
                        BigFrection t = f[b - 1];
                        f[b - 1] = f[b];
                        f[b] = t;
                    }
    }

}
