package 线性表;

public class SequenceListTest {
    public static void main(String[] args) {
        SequenceList<String> s1=new SequenceList<>(10);
        s1.insert("姚明");
        s1.insert("科比");
        s1.insert("麦迪");
        s1.insert(1,"詹姆斯");
        String getResult=s1.get(1);
        System.out.println("获取索引1处的结果为："+getResult);
        String removeResult=s1.remove(0);
        System.out.println("删除的元素是"+removeResult);
        s1.clear();
        System.out.println("清空后的线性表中的元素个数为："+s1.length());
    }
}
