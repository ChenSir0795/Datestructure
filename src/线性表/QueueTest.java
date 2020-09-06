package 线性表;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue=new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        for(String str:queue){
            System.out.println(str+" ");
        }
        System.out.println("-------------------------");
        String result=queue.dequeue();
        System.out.println("出列了元素"+result);
        System.out.println(queue.size());
    }
}
