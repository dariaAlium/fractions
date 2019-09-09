package labs;

class TestFrection {
    public static void main(String[] args) {
       /* Frection f = new Frection(1,2);
        Frection f1 = new Frection(1);
        Frection f2 = new Frection("2/4");
        f.multiplication(f1);*/

        Frection math = new Frection("1+1/2-1/2", 0);
        //math.print();
    }
}

class Frection implements Comparable<Object>, Print {
    private Integer num, den;

    //для стека
    private int tos = -1;
    Frection[] st;

    Frection(Integer a, Integer b) {
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

    Frection(Integer a) {
        this(a, 1);
    }

    Frection() {
        num = 0;
        den = 1;
    }

    Frection(String s) {
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

    int getNum() {
        return num;
    }

    int getDen() {
        return den;
    }

    public void print() {
        System.out.println(num + "/" + den);
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

    public void multiplication(Frection f) {
        num = num * f.num;
        den = den * f.den;
        red();
    }

    public void division(Frection f) {
        num = num * f.den;
        den = den * f.num;
        red();
    }

    public Frection sum(Frection f) {
        num = f.den * num + f.num * den;
        den = f.den * den;
        red();
        return this;
    }

    public Frection vich(Frection f) {
        num = f.den * num - f.num * den;
        den = f.den * den;
        return f;
    }

    public Frection arraysum(Frection[] f) {
        Frection f1 = new Frection(0, 0);
        for (int i = 0; i < f.length; i++) {
            if (f[i] != null)
                f1.sum(f[i]);
        }
        return f1;
    }

    public Frection min(Frection f2) {
        if (num * f2.den < f2.num * den) return this;
        else return f2;
    }

    public boolean min_add(Frection f2) {
        if (min(f2) == this) return true;
        else return false;
    }

    public Frection max(Frection f2) {
        if (num * f2.den > f2.num * den) return this;
        else return f2;
    }

    ///для стека

    private void push(Frection item) {
        st[++tos] = item;
    }

    void push_endless(Frection item) {
        Frection[] add = new Frection[st.length + 1];
        for (int i = 0; i < st.length; i++) add[i] = st[i];
        st = add;
        push(item);
    }

    Frection pop() {
        if (get_tos()) return st[tos--];
        else {
            System.out.println("Вы пытаетесь взять то, чего нет");
            return null;
        }
    }

    boolean get_tos() {
        if (tos < 0) return false;
        else return true;
    }

    void printS() {
        System.out.print("Конечный стек: ");
        one:
        {
            for (int w = 0; w < st.length; w++) {
                System.out.print(st[w]);

            }
        }

    }

    @Override
    public int compareTo(Object f1) {
        if (f1 == this) return 0;
        else if (min((Frection) f1) == this) return -1;
        else return 1;
    }

    Frection(String s, int l) {
        s.trim();
        int plus = s.indexOf("+");
        int minus = s.indexOf("-");
        int[] ind = indexsChars(s, '-', '+'); //ищет индексы знаков
        int oneSize = 0; //если стоит первым положительное число, то оно записываетясв массив положительных не смотря на то, что нет знака +
        if(s.charAt(0)!='-') oneSize++;
        Frection[] p = new Frection[countLess(s, '+')+oneSize]; //создает массив
        int po = 0; //индекс в положительном массиве

        Frection[] o = new Frection[countLess(s, '-')];
        int ot = 0;
        //for (int i = 0; i < ind.length; i++) System.out.print(ind[i]);

        for (int j = 0; j < ind.length; j++) {
            if (s.charAt(ind[j]) == '+') { //если знак + в массиве знаков
                if (j == ind.length - 2) p[po] = new Frection(s.substring(ind[j] + 1, ind[j + 1])); //если это не последнее число, то дробь от знака до знака
                else p[po] = new Frection(s.substring(ind[j] + 1)); //если последнее
                //System.out.print(po);
                po++;
            } else {
                if (j == ind.length - 2) o[ot] = new Frection(s.substring(ind[j] + 1, ind[j + 1]));
                else o[ot] = new Frection(s.substring(ind[j] + 1));
                ot++;
            }
        }

        if (plus == -1) {
            if (s.charAt(0) != '-') {
                Frection add = new Frection(s.substring(0, ind[0]));
                num = o[0].arraysum(o).sum(add).getNum();
            } else num = o[0].arraysum(o).getNum();
            den = o[0].arraysum(o).getDen();
            //System.out.print("1");
        } else if (minus == -1) {
            num = p[0].arraysum(p).getNum();
            den = p[0].arraysum(p).getDen();
            //
            //System.out.print("2");
        } else {
            if (s.charAt(0) != '-') {
                Frection add = new Frection(s.substring(0, ind[0]));
                num = p[0].arraysum(p).vich(o[0].arraysum(o)).sum(add).getNum();
            }
            else num = p[0].arraysum(p).vich(o[0].arraysum(o)).getNum();
            den = p[0].arraysum(p).vich(o[0].arraysum(o)).getDen();
            //System.out.print(num+""+den);
            // System.out.print("3");
        }
//        for(int i=0;i<o.length;i++) o[i].print();
        red();
        Frection res1 = p[0].arraysum(p);
        Frection res2 = o[0].arraysum(o);
        Frection res3 = res1.vich(res2);

        //res1.print();
        //
        //res2.print();
        //res3.print();
        for(int i=0;i<p.length;i++) p[i].print();
    }


    static int[] indexsChars(String str, char ch, char ch1) {
        int[] a = new int[count(str, ch, ch1)];
        int l = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ch || str.charAt(i) == ch1) {
                a[l] = i;
                l++;
            }
        return a;
    }

    static int count(String str, char ch, char ch1) {
        int j = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ch || str.charAt(i) == ch1) j++;
        return j;
    }

    static int countLess(String str, char ch) {
        int j = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ch) j++;
        return j;
    }

}
