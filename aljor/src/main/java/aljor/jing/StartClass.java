package aljor.jing;


import algs4.StdIn;
import algs4.StdOut;
import aljor.jing.list.Queue;
import aljor.jing.list.Stack;

public class StartClass {
    public static void main(String[] args){
        //stackTest();
        queueTest();
    }

    /**
     * Queue test
     */
    private static void queueTest(){
        Queue<String> quequ = new Queue<>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!"-".equals(item)){
                quequ.enqueue(item);
            }else if(!quequ.isEmpty()){
                StdOut.print(quequ.dequeue() + " ");
            }else
                break;
        }
        StdOut.print("(" + quequ.size() + " left on queue)");
    }

    /**
     * Stack test case
     */
    private static void stackTest(){
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if("exit".equals(item))
                break;
            if(!"-".equals(item)){
                stack.push(item);
            }else if(!stack.isEmpty()){
                StdOut.print(stack.pop() + " ");
            }
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
