package DataStructure.CircleQueue;

import java.util.Scanner;

/**
 * 底层数组结构 实现循环队列结构
 */
public class CircleArrayQueue {
    //该队列最大容量
    private int maxSize;
    //该队列列首指针（索引），指向队列第一个元素
    private int front = 0;  //默认值为0
    //该队列末尾指针（索引），指向队列末尾元素 后一个位置
    private int rear = 0;  //默认值为0
    //队列当前大小
    private int size = 0;
    //该队列存放数据的数组
    private int[] content;

    //构造函数，数组实例化时必须指定队列最大容量
    CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        /**
         * rear指向的是最后元素下一个位置，不让rear追上front，需要多出一个位置来作为约定，解决 isFull 和 isEmpty 判断条件冲突的问题
         */
        content = new int[maxSize + 1];
    }

    //判断队列是否已满
    //仅剩一个约定空位置时表示满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //末尾添加数据
    public void add(int n) {
        //判断队列是否已满
        if (isFull())
            System.out.println("队列已满，不能再添加数据了！");
        else {
            content[rear] = n;
            //直接 rear++ 可能导致数组越界;
            rear = (rear + 1) % maxSize;
            size++;
        }
    }

    //队首取出数据
    public int get() {
        //判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列为空，不能取出数据！");
            return 0;
        }
        else {
            int result = content[front];
            //直接 front++ 可能导致数组越界;
            front = (front + 1) % maxSize;
            size--;
            return result;
        }
    }

    //显示队列所有数据
    public void show() {
        //判断队列是否为空
        if (isEmpty())
            System.out.println("队列为空，不能获取数据！");
        else {
            //从front开始遍历，
            for (int index = front; index != rear; index = (index + 1) % maxSize) {
                System.out.print(content[index] + "  ");
            }
            System.out.println();
        }
    }

    //返回当前队列大小
    public void size() {
        int size = (rear + maxSize - front) % maxSize;
        System.out.println(size);
        //return size;
    }



    //执行测试
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(3);  //容量为2的队列
        Scanner in = new Scanner(System.in);
        loop: while(true) {
            System.out.println("========================");
            System.out.println("请输入以下指令：");
            System.out.println("a：向队列末尾添加元素");
            System.out.println("g：获取队首元素，并移出队列");
            System.out.println("s：打印当前队列");
            System.out.println("size：获取当前队列大小");
            System.out.println("e：退出当前程序~");
            switch (in.nextLine()){
                case "a":
                    System.out.println("输入要添加的数据：");
                    queue.add(in.nextInt());
                    in.nextLine();  //清除回车
                    break;
                case "g":
                    int get = queue.get();
                    System.out.println(get);
                    break;
                case "s":
                    queue.show();
                    break;
                case "size":
                    queue.size();
                    break;
                case "e":
                    break loop;
                default:
                    System.out.println("请输入指定命令！！");
            }
        }
        System.out.println("========================");
        System.out.println("退出程序！");
    }
}
