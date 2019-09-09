package labs;

class StackObjectTest{
    public static void main(String[] args) {
        StackObject fr = new StackObject();
        Frection one = new Frection(1,2);
        Frection two = new Frection(3,7);
        fr.push_endless(one);
        fr.print(fr);
    }

}


class StackObject extends Parent implements Print{
    private int tos = -1;
    private Object[] st;

    StackObject(int size) {
        st = new Object[size];
    }

    public void print(Print s){ //метод, который печатает один объект
        s.print();

    }

    StackObject() {
        st = new Object[0];
    }

    void push(Object item) {
        st[++tos] = item;
    }

    void push_endless(Object item) {
        enlarge();
        push(item);
    }

    Object pop() {
        if (get_tos()) return st[tos--];
        else {
            System.out.println("Вы пытаетесь взять то, чего нет");
            return "";
        }
    }

    //метод из интерфейса, содержащий метод из данного класса
    public void print() {
        System.out.print("Конечный стек: ");
        one:
        for (int w = 0; w < this.st.length; w++) {
            if (this.st[w] == null) break one;
            print((Print) st[w]);
        }
    }

    boolean get_tos() {
        if (tos < 0) return false;
        else return true;
    }

    void enlarge() {
        Object add[] = new Object[st.length + 1];
        for (int i = 0; i < st.length; i++)
            add[i] = st[i];
        st = add;
    }
}
