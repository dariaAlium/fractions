package labs;

class Tab_Stack {
    private String[] st, add;
    private int tos = -1, ad = -1;

    Tab_Stack() {
        st = new String[0];
        add = new String[0];
        add_page("Home page");
    }

    String back() {
        if (get_tos(tos)) {
            String page = st[tos];
            pop(st, tos);
            pushAd(page);
            return page;
        } else return null;
    }

    String forward() {
        if (get_tos(ad)) {
            String page = add[ad];
            pop(add, ad);
            pushTos(page);
            return page;
        } else return null;
    }

    void add_page(String item) {
        delete(add);
        pushTos(item);
    }

    void pushTos(String item) {
        String[] add = new String[st.length + 1];
        for (int i = 0; i < st.length; i++) add[i] = st[i];
        st = add;
        st[++tos] = item;
    }

    void pushAd(String item) {
        String[] addddd = new String[add.length + 1];
        for (int i = 0; i < add.length; i++) addddd[i] = add[i];
        add = addddd;
        add[++ad] = item;
    }

    void print() {
        for (int h = 0; h <= tos; h++)
            System.out.print(st[h]);
    }

    void gettos() {
        System.out.println(tos);
    }

    void printCur() {
        //if(tos==-1) System.out.println(st[0]);
        System.out.println(st[tos]);
    }


    String pop(String[] st, int tos) {
        if (get_tos(tos)) return st[tos--];
        else {
            System.out.println("Вы пытаетесь взять то, чего нет");
            return "";
        }
    }

    boolean get_tos(int tos) {
        if (tos < 0) return false;
        else return true;
    }

    void delete(String[] st) {
        for (int p = 0; p < st.length; p++)
            st[p] = null;
    }
}

class Test_Tab_Stack {
    public static void main(String[] args) {
        Tab_Stack hi = new Tab_Stack();
        hi.add_page("LMS");
        hi.back();
        hi.forward();
        hi.print();
    }
}

