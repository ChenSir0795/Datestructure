package 图;

import java.util.function.DoubleToIntFunction;

public class DepthFirstSearchTest {
    public static void main(String[] args) {
        Graph G=new Graph(13);
        G.addEdge(0,5);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,6);
        G.addEdge(5,3);
        G.addEdge(5,4);
        G.addEdge(3,4);
        G.addEdge(4,6);
        G.addEdge(7,8);
        G.addEdge(9,11);
        G.addEdge(9,10);
        G.addEdge(9,12);
        G.addEdge(11,12);
      // DepthFirstSearch search=new DepthFirstSearch(G,0);
        BreadthFirstSearch search=new BreadthFirstSearch(G,0);
       int count =search.count();
        System.out.println("与起点0想通的顶点数量为："+count);
        boolean marked1=search.marked(5);
        System.out.println("顶点5和顶点0是否想通"+marked1);
        boolean marked2=search.marked(7);
        System.out.println("顶点7和顶点0是否想通"+marked2);
    }

}
