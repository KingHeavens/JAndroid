package aljor.jing.list;

import java.util.Iterator;

/**
 * Created by zhaijinjing on 2016/11/10.
 * Stack
 */

public class Stack<Item> implements Iterable<Item>{
    private int N; //item size
    private Node<Item> first;// top of this stack
    public Stack(){

    }
    public boolean isEmpty(){
        return N == 0 || first == null;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        N ++;
    }

    public Item pop(){
        Item item= first.item;
        first = first.next;
        N --;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node<Item> current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }
}
