package _Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int count = in.nextInt();    //随机数总数
            int[] data = new int[count];
            for(int i=0; i < count; i++)    //读入生成的随机数
                data[i] = in.nextInt();

            Arrays.sort(data);    //使用库函数排序
            System.out.println(data[0]);    //打印排序后的第一个数（必不重复）
            for(int i=1; i < count; i++){    //打印其他数字，需与前面数字比较，不重复才能打印
                if(data[i] != data[i-1])
                    System.out.println(data[i]);
            }
        }

    }

    public void abn(){
        System.out.println("非static方法，实例化内部类~");
        ListNode a = new ListNode(20);
    }
}

class ListNode {
    int value;
    ListNode next = null;

    ListNode(){}
    ListNode(int value) {
        this.value = value;
    }
    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

}