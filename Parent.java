package labs;

public abstract class Parent {

    void enlarge(Object[] q){
        Object add[] = new Object[q.length +1];
        for(int i=0;i<q.length;i++)
            add[i]=q[i];
        q=add;
    }

    public abstract void print();
}
