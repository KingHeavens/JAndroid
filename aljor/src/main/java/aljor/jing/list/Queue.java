package aljor.jing.list;

import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator;

import java.util.Iterator;

/**
 * Created by zhaijinjing on 2016/11/10.
 * Queue
 */
public class Queue<Item> implements Iterable<Item>{
    private int N;
    private Node<Item> first;
    private Node<Item> last;
    public Queue(){

    }
    public boolean isEmpty(){
        return N == 0 || first == null;
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        Node<Item> oldlast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if(isEmpty())
            first = last;
        else
            oldlast.next = last;
        N ++;
    }

    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        N --;
        if(isEmpty())
            last = null;
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
