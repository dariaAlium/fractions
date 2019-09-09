package labs;

class QueueObjectTest{
    public static void main(String[] args) {
        QueueObject object = new QueueObject(5);
        BigFrection one = new BigFrection(1,5);
        BigFrection two = new BigFrection(2,7);
        object.push(one);
        object.push(two);
        object.pop();
        object.print();
    }
}

 class QueueObject extends Parent implements Print{

    Object q[];
    private int last=-1;
    private int first=-1;

    QueueObject(int size){
        q = new Object[size];
    }

    void push(Object item){
        if(last+1==q.length);
        else enlarge(q);
        q[++last]=item;

        if(isQEmpty()) clear();

        if(aLot()) ghosts();

    }

    void pop(){
        if(nullEl());
        else ++first;
        if(isQEmpty()) clear();
        if(aLot()) ghosts();
    }

    //метод для ошибки в pop
    private boolean nullEl(){
        if(last+1==first) return true;
        else return false;
    }

    private boolean isQEmpty(){
        if(last==first)return true;
        else return false;
    }

    private void clear(){
        last=-1;
        first=-1;
    }

    private boolean aLot(){
        if(last-first<=first+1) return true;
        else return false;
    }

    private void ghosts(){
        int j = last-first;
        int l = last-first;
        for(int i=0;i<=(last-first);i++) {
            q[i] = q[j];
            j++;
        }
        first=-1;
        last=l-1;
    }

     public void print(Print s){ //метод, который печатает один объект
         s.print();
     }

    public void print(){
        for (int i = first + 1; i < last + 1; i++)
            print((Print)q[i]);
    }

    /*void printAll(){
        for(int i=0;i<q.length;i++)
            System.out.println(q[i]);
    }*/

    void getLast(){
        System.out.println(last);
    }

    void getFirst(){
        System.out.println(first);
    }
}
