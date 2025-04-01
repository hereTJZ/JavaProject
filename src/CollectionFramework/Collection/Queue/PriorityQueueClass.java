package CollectionFramework.Collection.Queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueClass {
    public static void main(String[] args) {
        // ① 创建一个优先级队列（使用元素自身的 compareTo() 方法比较优先级）
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 添加元素
        queue.offer(10);
        queue.offer(5);
        queue.offer(20);

        // 遍历元素
        queue.forEach(System.out::println);

        // ② 自定义优先级比较方法（通过 Comparator 实现自定义比较器类，初始化队列）
        PriorityQueue<Object> customizeQueue = new PriorityQueue<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 1;
            }
        });
    }
}
