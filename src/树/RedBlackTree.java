package 树;

public class RedBlackTree<Key extends Comparable<Key>,Value> {
    private Node root;
    private int N;
    private static final boolean RED=true;
    private static final boolean BLACK=false;
    private boolean isRed(Node x){
        if(x==null){
            return false;
        }
        return x.color==RED;
    }
    private Node rotateLeft(Node h){
        Node hRight=h.right;
        Node lhRight=hRight;
        h.right=lhRight;
        hRight.left=h;
        hRight.color=h.color;
        h.color=RED;
        return hRight;
    }
    private Node rotateRight(Node h){
        Node hLeft=h.left;
        Node rHleft=hLeft.right;
        h.left=rHleft;
        hLeft.right=h;
        hLeft.color=h.color;
        h.color=RED;
        return hLeft;
    }
    private void flipColors(Node h){
        h.color=RED;
        h.left.color=BLACK;
        h.right.color=BLACK;
    }
    public void put(Key key,Value val){
        root=put(root,key,val);
        root.color=BLACK;
    }
    private Node put(Node h,Key key,Value val){
        if(h==null){
            N++;
            return new Node(key,val,null,null,RED);
        }
        int cmp=key.compareTo(h.key);
        if(cmp<0){
            h.left=put(h.left,key,val);
        }else if(cmp>0){
            h.right=put(h.right,key,val);
        }else{
            h.value=val;
        }
        if(isRed(h.right)&& !isRed(h.left)){
            h=rotateLeft(h);
        }
        if(isRed(h.left)&&isRed(h.left.left)){
            h=rotateRight(h);
        }
        if(isRed(h.left)&&isRed(h.right)){
            flipColors(h);
        }
        return h;
    }
    public Value get(Key key){
        return get(root,key);
    }
    public Value get(Node x,Key key){
        if(x==null){
            return null;
        }
        int cmp=key.compareTo(x.key);
        if(cmp<0){
            return get(x.left,key);
        }else if(cmp>0){
            return get(x.right,key);
        }else{
            return x.value;
        }
    }
    public int size(){
        return N;
    }
    private class Node{
        public Key key;
        private Value value;
        public Node left;
        public Node right;
        public boolean color;
        public Node(Key key,Value value,Node left,Node right,boolean color){
            this.key=key;
            this.value=value;
            this.left=left;
            this.right=right;
            this.color=color;
        }


    }
}
