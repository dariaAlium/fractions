package labs;

public class Tab_Array {
    String currentPage;
    private int p = -1;
    private String[] history;


    Tab_Array(String page) {
        history = new String[0];
        addPage(page);
    }

    void printcurrentPage() {
        System.out.println(currentPage);
    }

    void addPage(String r) {
        String[] add2 = new String[history.length + 1];
        for (int s = 0; s < history.length; s++) add2[s] = history[s];
        history = add2;
        currentPage = r;
        add2[++p] = r;

        for (int a = p + 1; a < add2.length; a++) add2[a] = null;

    }

    int getP() {
        return p;
    }

    void back() {
        if ((p - 1) < 0) currentPage = history[p];
        else currentPage = history[--p];
    }

    void toward() {
        if (((p + 1) >= history.length) || history[p + 1] == null) currentPage = history[p];
        else currentPage = history[++p];
    }

    void print() {
        for (int h = 0; h <= p && history[p] != null; h++)
            System.out.print(history[h]);
    }
}

class Test_Tab_Array {
    public static void main(String[] args) {
        Tab_Array hi = new Tab_Array("Home page");
        hi.addPage("LMS");
        hi.back();
        hi.toward();
    }
}