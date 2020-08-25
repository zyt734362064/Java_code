package com.Test0825;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-08-25
 */
public class SeqList<E> {
    //当前这个 data 的类型是啥，可以当成一个 Object[]，具体代表的是那种类型
    private E[] data = (E[]) new Object[100];
    private int size;
    public E get(int index){
        return data[index];
    }
    public void add(E elem){
        data[size] = elem;
        size++;
    }

    public static void main(String[] args) {
        SeqList<String> seqList = new SeqList<>();
        //String 也是继承自 Object
        //调用 add 的时候相当于向上转型
        seqList.add("aaa");
        seqList.add("bbb");

        String str = seqList.get(0);
        SeqList<Aniaml> aniamlSeqList = new SeqList<>();
        aniamlSeqList.add(new Aniaml());
        aniamlSeqList.add(new Aniaml());

        SeqList<Integer> integerSeqList = new SeqList<>();
        Integer num = new Integer(10);
        Integer num2 = Integer.valueOf(10);
        Integer num3 = 10;
        integerSeqList.add(num);

    }

}
