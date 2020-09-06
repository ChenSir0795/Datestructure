package 优先队列;

public class IndexMinpriorityQueueTest {
    public static void main(String[] args) {
        String[] arr={"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        IndexMinpriorityQueue<String> indexMinPQ=new IndexMinpriorityQueue<>(20);
        for(int i=0;i<arr.length;i++){
            indexMinPQ.insert(i,arr[i]);

        }
        System.out.println(indexMinPQ.size());
        System.out.println(indexMinPQ.minIndex);
        indexMinPQ.changeItem(0,"Z");
        int minIndex=-1;
        while(!indexMinPQ.isEmpty()){
            minIndex=indexMinPQ.delMin();
            System.out.print(minIndex+",");
        }
    }
}
