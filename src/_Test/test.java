package _Test;

import java.util.*;

public class test {
    public static void main(String[] args) {
        int[] a = new int[2];
        a[0] = 2;
        System.out.println(a[0]);
        abn(a);
        System.out.println(a[0]);

    }

    public static void abn(int[] a){
        int[] b = new int[a.length];
        b[0] = 0;
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