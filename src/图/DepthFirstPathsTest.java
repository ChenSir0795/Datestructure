package 图;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class DepthFirstPathsTest {
    public static void main(String[] args) throws Exception {
        BufferedReader reader=new BufferedReader(new InputStreamReader(DepthFirstPathsTest.class.getClassLoader().getResourceAsStream("road_find.txt")));
        int number=Integer.parseInt(reader.readLine());
        Graph G=new Graph(number);
        int roadNumber=Integer.parseInt(reader.readLine());
        for(int i=0;i<roadNumber;i++){
            String line= reader.readLine();
            int p=Integer.parseInt(line.split(" ")[0]);
            int q=Integer.parseInt(line.split(" ")[1]);
            G.addEdge(p,q);
        }
        DepthFirstPaths paths=new DepthFirstPaths(G,0);
        Stack<Integer> path=paths.pathTo(4);
        StringBuilder sb=new StringBuilder();
        for(Integer v: path){
            sb.append(v+"-");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}
