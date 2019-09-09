package labs;

import java.util.Scanner;

class Browzer {
    Tab_Array[] tab1;
    int tos1 = -1;

    Browzer() {
        tab1 = new Tab_Array[1];
        Tab_Array item = new Tab_Array("Home page");
        tab1[0] = item;
    }

    void print() {
        for (int i = 0; i < tab1.length; i++) tab1[i].print();
    }

    void addTab(Tab_Array item) {
        Tab_Array[] add = new Tab_Array[tab1.length + 1];
        for (int i = 0; i < tab1.length; i++) add[i] = tab1[i];
        tab1 = add;
        add[++tos1] = item;
    }

    void closeTab() {
        if (tab1.length > 1) {
            Tab_Array add[] = new Tab_Array[tab1.length - 1];
            for (int i = 0; i < tos1; i++)
                add[i] = tab1[i];
            for (int i = tos1; i < tab1.length - 1; i++)
                add[i] = tab1[i + 1];
        } else {
            tab1[0] = null;
            System.out.println("Вы закрыли браузер!");
        }
    }

    int getTabsNumber() {
        return tab1.length;
    }

    Tab_Array goTab(int a) {
        if (a < tab1.length && a > 0)
            return tab1[a];
        else return null;
    }

}

class DemoBrowzer {
    public static void main(String[] args) {
        System.out.println();
        Tab_Array tab1 = new Tab_Array("Home page");
        Tab_Array tab2 = new Tab_Array("LMS");
        Tab_Array tab3 = new Tab_Array("Mail");


        Scanner num = new Scanner(System.in);
        Scanner read = new Scanner(System.in);
        System.out.println("Your choice: ");
        String choice = " ";
        Browzer Google = new Browzer();
        int j = 0; //закрыть бр, когда закрыли все вкладки
        while (!choice.equals("exit")) {
            choice = read.nextLine();
            if (choice.equals("close")) Google.closeTab();
            else if (choice.equals("go to")) {
                System.out.println("Number of tabs: ");
                int i = read.nextInt();
                if (i < Google.getTabsNumber()) Google.goTab(i);
                else System.out.println("Error");
            } else if (choice.equals("how much")) System.out.println(Google.getTabsNumber());
            else if (choice.equals("exit")) continue;
            else {
                System.out.println("Your choice(number): ");
                int i = num.nextInt();
                if (i == 1) Google.addTab(tab1);
                else if (i == 2) Google.addTab(tab2);
                else if (i == 3) Google.addTab(tab3);
                else System.out.println("Error");
                j = 1;
            }

            if (j == 1 && Google.getTabsNumber() == 0) break;
            System.out.println("Your choice: ");
        }

        Google.print();
    }
}
