package CollectionFramework.Collection.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueuClass {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);

        int num1 = q.peek();

        int size = q.size();

        int num2 = q.poll();

        System.out.println(q.isEmpty());
    }
}
