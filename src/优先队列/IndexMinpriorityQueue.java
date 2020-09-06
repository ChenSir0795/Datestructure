package 优先队列;

public class IndexMinpriorityQueue<T extends Comparable<T>> {
    public boolean minIndex;
    private T[] items;
    private  int[] pq;
    private int[] qp;
    private int N;
    public  IndexMinpriorityQueue(int capacity){
        items=(T[]) new Comparable[capacity+1];
        pq=new int[capacity+1];
        qp=new int [capacity+1];
        N=0;
        for(int i=0;i<qp.length;i++){
            qp[i]=-1;
        }
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    private boolean less(int i,int j){
        return items[pq[i]].compareTo(items[pq[j]])<0;
    }
    private void exch(int i,int j){
        int tmp=pq[i];
        pq[i]=pq[j];
        pq[j]=tmp;
        qp[pq[i]]=i;
        qp[pq[j]]=j;
    }
   public boolean contains(int k){
        return qp[k]!=-1;
   }
   public int minIndex(){
        return pq[1];
   }
   public void insert(int i,T t){
        if(contains(i)){
            throw new RuntimeException(("该索引已经存在"));
        }
        N++;
        items[i]=t;
        pq[N]=i;
        qp[i]=N;
        swim(N);
   }
   public int delMin(){
        int minIndex=pq[1];
        exch(1,N);
        qp[pq[N]]=-1;
        pq[N]=-1;
        items[minIndex]=null;
        N--;
        sink(1);
        return minIndex;
   }
   public void delete(int i){
        int k=qp[i];
        exch(k,N);
        qp[pq[N]]=-1;
        pq[N]=-1;
        items[i]=null;
        N--;
        sink(k);
        swim(k);
   }
   public void changeItem(int i,T t){
        items[i]=t;
        int k=qp[i];
        sink(k);
        swim(k);
   }
   private void swim(int k){
       while(k>1){
           if(less(k,k/2)){
               exch(k,k/2);
           }
           k=k/2;
       }
   }
   private void sink(int k){
        while (2*k<=N){
            int min=2*k;
            if(2*k+1<=N&&less(2*k+1,2*k)){
                min=2*k+1;
            }
            if(less(k,min)){
                break;
            }
            exch(k,min);
            k=min;
        }
   }
}
