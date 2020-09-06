package sort;

import java.util.Arrays;

public class Test{
    public static void main(String[] args) throws Exception {
        Integer[] arr={8,4,5,7,1,3,6,2};
        Merge.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}