package aljor.jing.simple;

import java.util.Iterator;

/**
 * Created by zhaijinjing on 2016/11/4.
 * simple resizing stack of custom item elements impl
 * Stack结构，泛型、可迭代， 是所有集合类抽象数据类型的一个实现模板
 *
 * 它将所有元素保存在了数组当中，并且可以动态调整数组的大小，保证栈的大小比数组小一倍
 */
public class ResizingArrayStack<Item>{
    private int N;
    private Item[] stackArray = (Item[]) new Object[1];
    public ResizingArrayStack(){

    }
    private void reverse(int size){
        Item[] temps = (Item[]) new Object[size];
        for(int i = 0; i < stackArray.length; i ++){
            temps[i] = stackArray[i];
        }
        stackArray = temps;
    }

    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public void push(Item item){
        if(stackArray.length == N)
            reverse(stackArray.length * 2);
        stackArray[N++] = item;
    }

    public Item pop(){
        Item item = stackArray[--N];
        stackArray[N] = null;
        if(N > 0 && N == stackArray.length / 4)
            reverse(stackArray.length / 2);
        return item;
    }

    public Iterator<Item> iterotor(){
        return  new ReverseIterator();
    }
    private class ReverseIterator implements Iterator<Item>{
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return stackArray[--i];
        }

        @Override
        public void remove() {

        }
    }
}
