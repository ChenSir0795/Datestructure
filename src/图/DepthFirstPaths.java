package 图;

import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private int s;
    private int[] edgeTo;
    public DepthFirstPaths(Graph G,int s){
        marked=new boolean[G.V()];
        edgeTo=new int[G.V()];
        this.s=s;
        dfs(G,s);
    }
    private void dfs(Graph G,int v){
        marked[v]=true;
        for(Integer w: G.adj(v)){
            if(!marked[w]){
                edgeTo[w]=v;
                dfs(G,w);
            }
        }
    }
   public boolean hasPathTo(int v){
        return marked[v];
   }
   public Stack<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        Stack<Integer> path=new Stack<Integer>();
        for(int x=v;x!=s;x=edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
   }
}
