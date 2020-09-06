package sort;

public class SortCompare {
    public static void main(String[] args){

    }
    public static void testShell(Integer[] a) {


        //1.获取 执行前的时间
        long start = System.currentTimeMillis();
        //2.执行算法代码
        Shell.sort(a);
        //获取执行后的时间
        long end =System.currentTimeMillis();
        //4.算出程序执行的时间并输出
        System.out.println("希尔排序的时间："+(end));
    }
//    public static void testInsertion(Integer[] a) {
//
//
//        //1.获取 执行前的时间
//        long start = System.currentTimeMillis();
//        //2.执行算法代码
//        Insertion.sort(a);
//        //获取执行后的时间
//        long end =System.currentTimeMillis();
//        //4.算出程序执行的时间并输出
//        System.out.println("选择排序的时间："+(end));
//    }

}
