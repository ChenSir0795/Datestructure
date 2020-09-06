package 图;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    private boolean[] marked;
    private int count;
    private Queue<Integer> waitSearch;
    public BreadthFirstSearch(Graph G,int s){
        marked =new boolean[G.V()];
        waitSearch=new LinkedList<>();
        dfs(G,s);
    }
    private void dfs(Graph G,int V){
        marked[V]=true;
        waitSearch.add(V);
        while(!waitSearch.isEmpty()){
            Integer wait=waitSearch.remove();
            for(Integer w:G.adj(wait)){
                if(!marked[w]){
                    dfs(G,w);
                }
            }
        }
        count++;
    }
    public boolean marked(int w){
        return marked[w];
    }
    public int count(){
        return count;
    }


}
