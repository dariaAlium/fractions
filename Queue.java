package labs;

import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

class TestQueue {

    public static void main(String[] args) {


        /////командная строка
        //Queue cm = new Queue(10);
        /************************************
         1-pop
         2-print
         3-exit
         else push
         ************************/
        /*
        int choice = 0;
        int i = 0;
        while (choice != 3) {
            choice = Integer.parseInt(args[i]);
            if (choice == 1) cm.pop();
            else if (choice == 2) cm.print();
            else if (choice == 3) continue;
            else cm.push(Integer.toString(choice));
        }

        //консоль
        Queue consol = new Queue(5);
        Scanner in = new Scanner(System.in);
        int num = 0;
        while (num != 3) {
            num = in.nextInt();
            if (num == 1) consol.pop();
            else if (num == 2) consol.print();
            else if (num == 3) continue;
            else consol.push(Integer.toString(num));
        } */

        //random

        Queue rand = new Queue(5);
        Random rnd = new Random();

        int[] library = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int tos = 0; //стрелка в библ

        int[] array = new int[100];
        genforrnd(array);
        //for(int i=0;i<array.length;i++)
        //System.out.print(array[i]);

        long before = System.currentTimeMillis();
        for (int h = 0; h < array.length; h++) {
            if (array[h] == 1)
                rand.pop();
            else {
                rand.push(library[tos]);
                if(tos!=8) tos++;
                else tos=0;
            }
        }
        long after = System.currentTimeMillis();
        long time = after-before;
tos=0;
        //Севин варик

        Seva q = new Seva(5);
        int rando = 1 + rnd.nextInt(30);


        int[] arrays = new int[100];
        genforrnd(arrays);
        long before1 = System.currentTimeMillis();
        for (int h = 0; h < array.length; h++) {
            if (arrays[h] == 1)
                q.out();
            else {
                q.in(library[tos]);
                if(tos!=8) tos++;
                else tos=0;
            }
        }
        long after1 = System.currentTimeMillis();
        long time1 = after1-before1;


        if(time>time1) System.out.print("Севина вариация быстрее");
        else if(time==time1)System.out.print("Время работы примерно одинакого");
        else System.out.print("Ваша вариация быстрее. Поздравляю ");

        //системная очередь
/*
        PriorityQueue<Integer> q1 = new PriorityQueue<Integer>();
        q1.add(1);
        q1.poll();
        q1.add(1);
        System.out.println(q1.peek());*/
    }

    static void genforrnd(int[] nullandone) {
        for (int add = 0; add < nullandone.length; add++)
            nullandone[add] = (int) (Math.random() * 2);
    }

}


class Queue {
    int q[];
    private int last = -1;
    private int first = -1;

    Queue(int size) {
        q = new int[size];
    }

    void push(int item) {
        if (last + 1 == q.length) ;
        else enlarge();
        //System.out.print(last);
        if(last==-2) last =-1;
        q[++last] = item;

        if (isQEmpty()) clear();

        if (aLot()) ghosts();

    }

    void pop() {
        if (nullEl()) ;
        else ++first;
        if (isQEmpty()) clear();
        if (aLot()) ghosts();
    }

    //метод для ошибки в pop
    private boolean nullEl() {
        if (last + 1 == first) return true;
        else return false;
    }

    private boolean isQEmpty() {
        if (last == first) return true;
        else return false;
    }

    private void clear() {
        last = -1;
        first = -1;
    }

    private boolean aLot() {
        if (last - first <= first + 1) return true;
        else return false;
    }

    private void ghosts() {
        int j = last - first;
        int l = last - first;
        for (int i = 0; i <= (last - first); i++) {
            q[i] = q[j];
            j++;
        }
        first = -1;
        last = l - 1;
    }

    public void print() {
        for (int i = first + 1; i < last + 1; i++)
            System.out.println(q[i]);
    }

    void printAll() {
        for (int i = 0; i < q.length; i++)
            System.out.println(q[i]);
    }

    void getLast() {
        System.out.println(last);
    }

    void getFirst() {
        System.out.println(first);
    }

    void enlarge() {
        int add[] = new int[q.length + 1];
        for (int i = 0; i < q.length; i++)
            add[i] = q[i];
        q = add;
    }
}

class Seva extends Vector{

    public void in(int elem) {
        append(elem);
    }

    public int out() {
       // if(isEmpty());
        //int toReturn = elementAt(0);
        if(isEmpty()) {
            clear();
        }
        return 0;
    }

    public Seva(int capacity) {
        super(capacity);
    }

    public Seva() {
        this(100);
    }
}

class Vector{
    protected int[] vector;
    private int ptr;

    public int getSize() {
        return ptr + 1;
    }

    public int getCapacity() {
        return this.vector.length;
    }

    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    public void ensureCapacity(int capacity) {
        if(capacity > this.vector.length) {
            int[] buffer = new int[capacity];
            System.arraycopy(vector, 0, buffer, 0, vector.length);
            vector = buffer;
        }
    }

    public void append(int elem) {
        if(vector.length <= ++ptr) {
            ensureCapacity((int)Math.floor(vector.length * 1.5));
        }
        vector[ptr] = elem;
    }

    public int peekAt(int index) {
        if(isEmpty()) ;
        return this.vector[index];
    }

    public int elementAt(int index) {
        if(isEmpty());
        int toReturn = peekAt(index);
        int[] buffer = new int[this.getCapacity() - 1];
        System.arraycopy(vector, 0, buffer, 0, index);
        System.arraycopy(vector, index + 1, buffer, index, buffer.length - index);
        vector = buffer;
        if(ptr >= index) {
            ptr--;
        }
        return toReturn;
    }

    public void clear() {
        ptr = -1;
    }


    public Vector(int capacity) {
        this.vector = new int[capacity];
        ptr = -1;
    }

    public Vector() {
        this(100);
    }
}


