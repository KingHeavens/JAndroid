package aljor.jing.list;

import java.awt.print.PrinterAbortException;
import java.util.Iterator;

/**
 * Created by zhaijinjing on 2016/11/10.
 * Bag
 */

public class Bag<Item> implements Iterable<Item>{
    private int N;
    private Node<Item> first;
    public boolean isEmpty(){
        return  first == null || N == 0;
    }
    public int size(){
        return N;
    }
    public void add(Item item){
        Node<Item> lastfirst = first;
        first = new Node<>();
        first.item = item;
        first.next = lastfirst;
        N ++;
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
