package labs;
import java.math.BigInteger;

class TestBigFrection{
    public static void main(String[] args) {
        BigFrection f = new BigFrection("111111111/22222222222");
        BigFrection u = new BigFrection(1111111,4444444);
        f.multiplication(u);
        f.print();
    }
}

class BigFrection implements Comparable<Object>, Print{
    BigInteger num;
    BigInteger den;

    BigFrection(int a, int b) {
        String sta = String.valueOf(a);
        String stb = String.valueOf(b);
        num = new BigInteger(sta);
        den = new BigInteger(stb);

        if (num.multiply(den).compareTo(BigInteger.ZERO)==1) {
            num = num.abs();
            den = den.abs();
        } else if (num.multiply(den).compareTo(BigInteger.ZERO)==0) {
            num = BigInteger.ZERO;
            den = BigInteger.ONE;
        } else {
            num = num.abs();
            num = num.negate();
            den = den.abs();
        }

    }

    BigFrection(Integer a) {
        this(a, 1);
    }

    BigFrection() {
        num = BigInteger.ZERO;
        den = BigInteger.ONE;
    }

    BigFrection(String s) {
        s.trim(); //удаляем пробелы
        int d = s.indexOf('/'); //индекс слэша
        if(d<0){
            num = new BigInteger(s);
            den =BigInteger.ONE;
        }
        else{
            String s1 = s.substring(0, d); //строка num
            String s2 = s.substring(d + 1, s.length());  //строка den
            num = new BigInteger(s1);
            den = new BigInteger(s2);}

    }


    public void sum(BigFrection f) { //сумма
        num = f.den.multiply(num).add(f.num.multiply(den));
        den = f.den.multiply(den);

    }

    public void print() {
        System.out.println(num + "/" + den);
    }

    public void multiplication(BigFrection f) { // умножение
        num = num.multiply(f.num);
        den = den.multiply(f.den);
    }

    public void division(BigFrection f) { //деление
        num = num.multiply(f.den);
        den = den.multiply(f.num);
    }

    public BigFrection min(BigFrection f2) {
        if (num.multiply(f2.den).compareTo(f2.num.multiply(den))==-1) return this;
        else return f2;
    }

    public boolean min_add(BigFrection f2) {
        min(f2);
        if (min(f2) == this) return true;
        else return false;
    }

    public BigFrection max(BigFrection f2) {
        if (num.multiply(f2.den).compareTo(f2.num.multiply(den))==1) return this;
        else return f2;
    }

    @Override
    public int compareTo(Object f1) {
        if (f1 == this) return 0;
        else if(min((BigFrection)f1)==this) return -1;
        else return 1;
    }

}
