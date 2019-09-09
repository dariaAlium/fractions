package labs;

class BrowzerStack {

    Tab_Stack[] tab1;
    int tos1;

    BrowzerStack() {
        tab1 = new Tab_Stack[1];
        Tab_Stack item = new Tab_Stack();
        tab1[0] = item;
        tos1 = 0;
    }

    void print() {
        for (int i = 0; i < tab1.length; i++) tab1[i].printCur();
    }

    void addTab(Tab_Stack item) {
        Tab_Stack[] add = new Tab_Stack[tab1.length + 1];
        for (int i = 0; i < tab1.length; i++) add[i] = tab1[i];
        tab1 = add;
        tab1[++tos1] = item;
    }

    void closeTab() {
        if (tab1.length > 1) {
            Tab_Stack add[] = new Tab_Stack[tab1.length - 1];
            for (int i = tos1; i < tab1.length-1; i++)
                add[i] = tab1[i];
            tab1=add;
        } else {
            tab1[0] = null;
            System.out.println("Вы закрыли браузер!");
        }
        tos1--;
    }

    int getTabsNumber() {
        return tab1.length;
    }

    int getTos() {
        return tos1;
    }

    void printTab(){
        tab1[tos1].print();
    }
}

class DemoBrowzerStack {

    public static void main(String[] args) {
        BrowzerStack Google = new BrowzerStack();
        Tab_Stack first = new Tab_Stack();
        first.add_page("LMS");
        Google.addTab(first);
        Tab_Stack second = new Tab_Stack();
        second.add_page("Mail");
        Google.addTab(second);
        Google.print();

    }

}
