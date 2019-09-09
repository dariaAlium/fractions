package labs;

import java.util.Random;
import java.util.Scanner;

class TestStack {

    public static void main(String[] args) {
        /////командная строка
        Stack cm = new Stack();
        /************************************
         1-pop
         2-print
         3-exit
         else push
         ************************/
        int choice = 0;
        int i = 0;
        while (choice != 3) {
            choice = Integer.parseInt(args[i]);
            if (choice == 1) cm.pop();
            else if (choice == 2) cm.print();
            else if (choice == 3) continue;
            else cm.push_endless(Integer.toString(choice));
        }

        //консоль
        Stack consol = new Stack();
        Scanner in = new Scanner(System.in);
        int num = 0;
        while (num != 3) {
            num = in.nextInt();
            if (num == 1) consol.pop();
            else if (num == 2) consol.print();
            else if (num == 3) continue;
            else consol.push_endless(Integer.toString(num));
        }

        //random

        Stack rand = new Stack();
        Random rnd = new Random();
        int random = 1 + rnd.nextInt(30);
        int[] array = new int[random];
        genforrnd(array);
        for (int h = 0; h < array.length; h++) {
            if (array[h] ==1)
                rand.pop();
            else if (array[h] == 2)
                rand.print();
            else if (array[h] == 3)
                break;
            else rand.push_endless(Integer.toString(array[h]));
        }

    }
    static void genforrnd(int[] nullandone) {
        for (int add = 0; add < nullandone.length; add++)
            nullandone[add] = (int) (Math.random() * 10);
    }
}

class Stack extends Parent {
    private int tos = -1;
    private String[] st;

    Stack(int size) {
        st = new String[size];
    }

    Stack() {
        st = new String[0];
    }

    void push(String item) {
        st[++tos] = item;
    }

    void push_endless(String item) {
        enlarge();
        push(item);
    }

    String pop() {
        if (get_tos()) return st[tos--];
        else {
            System.out.println("Вы пытаетесь взять то, чего нет");
            return "";
        }
    }

   public void print() {
        System.out.print("Конечный стек: ");
        one:
        for (int w = 0; w < st.length; w++) {
            if (st[w] == null) break one;
            System.out.print(st[w]);
        }
    }

    boolean get_tos() {
        if (tos < 0) return false;
        else return true;
    }

    void enlarge() {
        String add[] = new String[st.length + 1];
        for (int i = 0; i < st.length; i++)
            add[i] = st[i];
        st = add;
    }

}
