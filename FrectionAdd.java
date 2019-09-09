package labs;

class Demo {

    public static void main(String[] args) {
        FrectionAdd math = new FrectionAdd("1+4*1");
        math.print();
    }

}

class FrectionAdd {
    int num, den;

    FrectionAdd(String s) {
        s.trim(); //удаляем лищние пробелы

        /**** часть с умножением и делением ****/
        int[] ind1 = indexsChars(s, '-', '+'); //ищет индексы + и -
        int[] dif = indexsChars(s, '*', ':'); //ищем индексы умножения
        for (int i = 0; i < dif.length; i++) {
            if(i!=dif.length-1) {
                if (s.charAt(dif[i]) == '*') {
                    Frection mult1 = new Frection(s.substring(arroundBefore(ind1, dif[i]), dif[i]));
                    Frection mult2 = new Frection(s.substring(dif[i] + 1, next(ind1, dif[i])));
                    mult1.multiplication(mult2);
                    //заменяем умножение на одну дробь
                    s = s.substring(0, arroundBefore(ind1, dif[i])) + symbol(mult1) + String.valueOf(mult1.getNum()) + "/" + String.valueOf(mult1.getDen()) + s.substring(next(ind1, dif[i]));
                } else {
                    Frection div1 = new Frection(s.substring(arroundBefore(ind1, dif[i]), dif[i]));
                    Frection div2 = new Frection(s.substring(dif[i] + 1, next(ind1, dif[i])));
                    div1.division(div2);
//заменяем деление на одну дробь
                    s = s.substring(0, arroundBefore(ind1, dif[i])) + symbol(div1) + String.valueOf(div1.getNum()) + "/" + String.valueOf(div1.getDen()) + s.substring(next(ind1, dif[i]));
                }
            }
            //обработка случая когда *: посл операция
            else{
                if (s.charAt(dif[i]) == '*') {
                    Frection mult1 = new Frection(s.substring(arroundBefore(ind1, dif[i]), dif[i]));
                    Frection mult2 = new Frection(s.substring(dif[i] + 1));
                    mult1.multiplication(mult2);
//заменяем умножение на одну дробь
                    s = s.substring(0, arroundBefore(ind1, dif[i])) + symbol(mult1) + String.valueOf(mult1.getNum()) + "/" + String.valueOf(mult1.getDen());
                } else {
                    Frection div1 = new Frection(s.substring(arroundBefore(ind1, dif[i]), dif[i]));
                    Frection div2 = new Frection(s.substring(dif[i] + 1));
                    div1.division(div2);
//заменяем деление на одну дробь
                    s = s.substring(0, arroundBefore(ind1, dif[i])) + symbol(div1) + String.valueOf(div1.getNum()) + "/" + String.valueOf(div1.getDen());
                }
            }
        }
//System.out.print(s);
        /****** *********************************************************/
        int[] ind = indexsChars(s, '-', '+'); //ищет индексы + и -
        int oneSize = 0; //если стоит первым положительное число, то оно записываетясв массив положительных не смотря на то, что нет знака +
        if (s.charAt(0) != '-') oneSize++;
        Frection[] p = new Frection[ind.length + oneSize]; //создает массив
        int po = 0; //индекс в положительном массиве
        //for (int i = 0; i < ind.length; i++) System.out.print(ind[i]);

        if (oneSize == 1) { //обработка случая, когда первым пол число
            p[po] = new Frection(s.substring(0, (ind[0])));
            po++;
        }

        for (int j = 0; j < ind.length; j++) {
            if (s.charAt(ind[j]) == '+') { //если знак + в массиве знаков
                if (j == ind.length - 2)
                    p[po] = new Frection(s.substring(ind[j] + 1, ind[j + 1])); //если это не последнее число, то дробь от знака до знака
                else p[po] = new Frection(s.substring(ind[j] + 1)); //если последнее
                po++;
            } else { //случай с минусом
                if (j == ind.length - 2)
                    p[po] = new Frection(s.substring(ind[j], ind[j + 1])); //записывается на индекс раньше, чттобы записать мнус
                else p[po] = new Frection(s.substring(ind[j]));
                po++;
            }
        }
        num = p[0].arraysum(p).getNum();
        den = p[0].arraysum(p).getDen();
        red();
    }

    //метод с массивом индексов
    private static int[] indexsChars(String str, char ch, char ch1) {
        int[] a = new int[count(str, ch, ch1)];
        int l = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ch || str.charAt(i) == ch1) {
                a[l] = i;
                l++;
            }
        return a;
    }

    //метод для indexsChars
    private static int count(String str, char ch, char ch1) {
        int j = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ch || str.charAt(i) == ch1) j++;
        return j;
    }

    private void red() {
        int a = num;
        int b = den;
        num = num / nod(a, b);
        den = den / nod(a, b);
    }

    private int nod(int a, int b) {
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

    public void print() {
        System.out.println(num + "/" + den);
    }

    private int arroundBefore(int[] ind, int n) {
        if (contains(ind, n - 2)) return n - 2;
        else return n - 4;
    }

    private boolean contains(int[] array, int n) {
        boolean b = false;
        for (int i = 0; i < array.length; i++) if (array[i] == n) b = true;
        return b;

    }

    private int next(int[] array, int n) {
        int chislo = -1;
        for (int i = 0; i < array.length; i++)
            if (array[i] > n) {
                chislo = array[i];
                break;
            }
        return chislo;
    }

    //метод для *:
    private char symbol(Frection f) {
        if (f.getNum() > 0) return '+';
        else return '-';
    }
}
