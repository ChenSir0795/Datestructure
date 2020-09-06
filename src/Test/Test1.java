package Test;

public class Test1 {
    public static void main(String[] args){
        int[] a={9,8,5,7,6,4};
//        for(int i=0;i<arr.length;i++){
//            for(int j=i+1;j<arr.length;j++){
//                if(arr[i]>arr[j]){
//                    int temp=arr[i];
//                    arr[i]=arr[j];
//                    arr[j]=temp;
//                }
//
//            }
//        }
        for(int i=a.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(a[j+1]<a[j]){
                    int temp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
            }
        }

        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
