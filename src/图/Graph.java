package 图;

import 线性表.Queue;

public class Graph {
    private final int V;
    private int E;
    private Queue<Integer>[] adj;
    public Graph(int V){
        this.V=V;
        this.E=0;
        this.adj=new Queue[V];
        for(int i=0;i<adj.length;i++){
            adj[i]=new Queue<Integer>();
        }
    }
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(int v,int w){
        adj[v].enqueue(w);
        adj[w].enqueue(v);
        E++;
    }
    public Queue<Integer> adj(int v){
        return adj[v];
    }
}
