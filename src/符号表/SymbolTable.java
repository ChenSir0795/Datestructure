package 符号表;



public class SymbolTable<Key,Value> {
    private Node head;
    private int N;
    public SymbolTable(){
        head=new Node(null,null,null);
        N=0;
    }
    public int size(){
        return N;
    }
    public void put(Key key,Value value){
        Node n=head;
        while(n.next!=null){
            n=n.next;
            if(n.key.equals(key)){
                n.value=value;
                return;
            }
        }
        Node oldFirst=head.next;
        Node newFirst=new Node(key,value,oldFirst);
        head.next=newFirst;
        N++;
    }
    public void delete(Key key){
        Node n=head;
        while(n.next.key.equals(key)){
            if(n.next.key.equals(key)){
                n.next=n.next.next;
                N--;
                return;
            }
            n=n.next;
        }
    }
    public Value get(Key key){
        Node n=head;
        while(n.next!=null){
            n=n.next;
            if(n.key.equals(key)){
                return n.value;
            }

        }
        return null;
    }
    private class Node{
        public Key key;
        public Value value;
        public Node next;
        public Node (Key key, Value value, Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }


}
