package 树;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree<Key extends Comparable<Key>,Value> {

    private class Node<Key, Value> {
        public Key key;
        private Value value;
        public Node left;
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


    private Node root;
    private int N;

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }
        int cmp = key.compareTo((Key) x.key);
        if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.value = value;
        }
        return x;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo((Key) x.key);
        if (cmp > 0) {
            return (Value) get(x.right, key);
        } else if (cmp < 0) {
            return (Value) get(x.left, key);
        } else {
            return (Value) x.value;
        }
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    public Node delete(Node x, Key key) {

        if (x == null) {
            return null;
        }
        int cmp = key.compareTo((Key) x.key);
        if (cmp > 0) {
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            x.left = delete(x.left, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    n = n.left;
                }
            }
            minNode.left = x.left;
            minNode.right = x.right;
            x = minNode;
            N--;
        }
        return x;
    }

    public Key min() {
        return (Key) min(root).key;
    }

    public Node min(Node x) {
        if (x.left != null) {
            return min(x.left);
        } else {
            return x;
        }
    }


    public Key max() {
        return (Key) max(root).key;
    }

    public Node max(Node x) {
        if (x.right != null) {
            return max(x.right);
        } else {
            return x;
        }
    }


    public Queue<Key> preErgodic() {
        Queue<Key> keys = new LinkedList<>();
        preErgodic(root, keys);
        return keys;
    }

    //获取指定树x的所有键，并放到keys队列中
    private <key> void preErgodic(Node x, Queue<key> keys) {
        if (x == null) {
            return;
        }
        //把x结点key放在keys中
        keys.add((key) x.key);
        //递归遍历左子树
        if (x.left != null) {
            preErgodic(x.left, keys);
        }
        //递归遍历右子树
        if (x.right != null) {
            preErgodic(x.right, keys);
        }
    }


    public Queue<String> layerErgodic(){
        Queue<String> keys=new LinkedList<>();
        Queue<Node> nodes=new LinkedList<>();
        nodes.add(root);
        while(!nodes.isEmpty()){
            Node x=nodes.remove();
            keys.add((String) x.key);
            if(x.left!=null){
                nodes.add(x.left);
            }
            if(x.right!=null){
                nodes.add(x.right);
            }
        }
        return  keys;
    }
}


