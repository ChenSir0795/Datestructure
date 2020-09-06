package 线性表;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private Node head;
    private Node last;
    private int N;
    public Queue(){
        head=new Node(null,null);
        last=null;
        N=0;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void enqueue(T t){
        if(last==null){
            last=new Node(t,null);
            head.next=last;
        }else{
            Node oldLast=last;
            last=new Node(t,null);
            oldLast.next=last;
        }
        N++;
    }
    public T dequeue(){
        if(isEmpty()){
            return null;
        }
        Node oldFirst=head.next;
        head.next=oldFirst.next;
        N--;
        if(isEmpty()){
            last=null;
        }
        return oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }
    private class QIterator implements Iterator<T>{
        private Node n=head;
        public boolean hasNext(){
            return n.next!=null;
        }
        public T next(){
            Node node=n.next;
            n=n.next;
            return node.item;
        }
    }
    private class Node{
        public T item;
        public Node next;
        public Node(T item,Node next){
            this.item=item;
            this.next=next;
        }
    }
}
