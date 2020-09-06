package 图;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    public DepthFirstSearch(Graph G,int s){
        marked=new boolean[G.V()];
        dfs(G,s);
    }
    private void dfs(Graph G,int V){
        marked[V]=true;
        for(Integer w:G.adj(V)){
            if(!marked[w]){
                dfs(G,w);
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
