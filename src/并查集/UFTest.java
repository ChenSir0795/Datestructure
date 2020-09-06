package 并查集;

import java.util.Scanner;

public class UFTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请录入并查集中元素的个数");
        int N=sc.nextInt();
        UF uf=new UF(N);
        while(true){
            System.out.println("请录入您要合并的第一个点：");
            int p=sc.nextInt();
            System.out.println("请录入您要合并的第二个点：");
            int q=sc.nextInt();
            if(uf.connected(p,q)){
                System.out.println("节点："+p+"节点"+q+"已经在同一个组");
                continue;
            }
            uf.union(p,q);
            System.out.println("总共还有"+uf.count()+"个分组");
        }
    }
}
