/**
 * 线程总体分两类：用户线程和守候线程。
 * 守护线程是依赖于用户线程，用户线程退出了，守护线程也就会退出，典型的守护线程如垃圾回收线程。
 * 用户线程是独立存在的，不会因为其他用户线程退出而退出，主线程属于用户线程。
 * 通过setDaemon(true)方法可将某线程设置为守护线程
 */
package MultiThread;

/*
 * 在 Java 中实现多线程有两种手段:
 * ①一种是继承 Thread 类，
 * ②另一种就是实现 Runnable 接口。
 * ③还有一种就是实现 Callable 接口。
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ①继承 Thread 类（其实Thread本身就是实现Runnable接口而来的类）
 * 现实中可以直接使用Thread类也可以继承使用，但最好是继承使用，可以自定义需求的多线程
 */
class Mythread1 extends Thread {
    private final String name;  // 表示线程的名称

    /**
     * default：即不加任何访问修饰符，通常称为“默认访问模式“，该模式下，只允许在同一个包中进行访问。
     */
    Mythread1(String name) {  // 通过构造方法配置name属性
        this.name = name;
    }

    public void run() {  // 覆盖run()方法，作为线程的操作主体，此方法通过start（）方法启动
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread线程 " + name + "启动运行 " + (i + 1));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


/**
 * ② 实现 Runnable 接口
 */
class Mythread2 implements Runnable {
    private final String name;  // 表示线程的名称

    Mythread2(String name) {  // 通过构造方法配置name属性
        this.name = name;
    }

    @Override  //接口方法必须重写，接口方法全为抽象方法
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Runnable线程 " + name + "启动运行 " + (i + 1));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


/**
 * ③ 实现 Callable<T> 接口
 */
class Mythread3 implements Callable<String> {
    private final String name;  // 表示线程的名称

    Mythread3(String name) {  // 通过构造方法配置name属性
        this.name = name;
    }

    @Override  //接口方法必须重写，接口方法全为抽象方法
    public String call() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Callable线程 " + name + "启动运行 " + (i + 1));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return name + " value";
    }
}


/**
 * =====================================================================================================================
 */
public class multiThread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /**
         * ① 继承Thread类
         */
        // 运行继承Thread的Thread1多线程
        Mythread1 T1 = new Mythread1("T1");
        T1.start();
        Mythread1 T2 = new Mythread1("T2");
        T2.start();

        Thread.sleep(500);
        System.out.println("============================");

        /**
         * ② 实现runnable接口
         */
        // 直接调用接口实现类的run方法，并没有实现多线程
        new Mythread2("test T").run();
        // 正确做法：在Thread中传入实现Runnable接口的类，运行多线程
        Thread T3 = new Thread(new Mythread2("T3"));
        T3.start();
        Thread T4 = new Thread(new Mythread2("T4"));
        T4.start();

        Thread.sleep(500);
        System.out.println("============================");

        /**
         * ③ 实现callable<T>接口
         */
        Mythread3 callable = new Mythread3("T5");
        FutureTask<String> futureTask = new FutureTask<>(callable);
        //FutureTask注入到Thread中运行
        Thread T5 = new Thread(futureTask);
        T5.start();
        // 简写
        new Thread(new FutureTask<>(new Mythread3("T6"))).start();
        // 获取线程返回值
        System.out.println(futureTask.get());

    }
}
