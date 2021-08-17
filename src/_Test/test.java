package _Test;

import java.util.*;

public class test {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(64577));
        Map<Integer,Integer> hashMap = new HashMap<Integer,Integer>();


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