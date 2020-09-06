package 堆;

public class HeapSort {
    public static void sort(Comparable[] source) {
        //1.创建一个比原数组大1的数组
        Comparable[] heap=new Comparable[source.length+1];
        creatHeap(source,heap);
        int N=heap.length-1;
        while(N!=1){
            exch(heap,1,N);
            N--;
            sink(heap,1,N);
        }
        System.arraycopy(heap,1,source,0,source.length);
    }
    private static void creatHeap(Comparable[] source,Comparable[] heap){
        System.arraycopy(source,0,heap,1,source.length);
        for(int i=(heap.length-1)/2;i>0;i--){
            sink(heap,i,heap.length-1);
        }
    }
    private static boolean less(Comparable[] heap,int i,int j){
        return heap[i].compareTo(heap[j])<0;
    }
    private static void exch(Comparable[] heap,int i,int j){
        Comparable tmp=heap[i];
        heap[i]=heap[j];
        heap[j]=tmp;
    }
    private  static void sink(Comparable[] heap,int target,int range){
        while (2*target<=range){
            int max=2*target;
            if(target*2+1<=range){
                if(less(heap,2*target,2*target)){
                    max=2*target+1;
                }
            }
            if(less(heap,target,max)){
                exch(heap,target,max);
            }
            target=max;
        }
    }
}
