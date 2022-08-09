/**
 * 线程总体分两类：用户线程和守候线程。
 *  守护线程是依赖于用户线程，用户线程退出了，守护线程也就会退出，典型的守护线程如垃圾回收线程。
 *  用户线程是独立存在的，不会因为其他用户线程退出而退出，主线程属于用户线程。
 *  通过setDaemon(true)方法可将某线程设置为守护线程
 */
package MultiThread;

/*
 * 在 Java 中实现多线程有两种手段:
 * ①一种是继承 Thread 类，
 * ②另一种就是实现 Runnable 接口。
 */


/** ①
 * 继承 Thread 类，作为线程的实现类（其实Thread本身就是实现Runnable接口而来的类）
 * 现实中可以直接使用Thread类也可以继承使用，但最好是继承使用，可以自定义需求的多线程
 */
class Mythread1 extends Thread {
    private String name;  // 表示线程的名称

    /**
     * default：即不加任何访问修饰符，通常称为“默认访问模式“，该模式下，只允许在同一个包中进行访问。
     */
    Mythread1(String name) {  // 通过构造方法配置name属性
        this.name = name;
    }

    public void run() {  // 覆盖run()方法，作为线程的操作主体，此方法通过start（）方法启动
        for (int i = 0; i < 10; i++) {
            System.out.println("线程A " + name + "启动运行 " + (i+1));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



/** ②
 * 实现 Runnable 接口
 */
class Mythread2 implements Runnable {
    private String name;  // 表示线程的名称

    Mythread2(String name) {  // 通过构造方法配置name属性
        this.name = name;
    }

    @Override  //接口方法必须重写，接口方法全为抽象方法
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程B " + name + "启动运行 " + (i+1));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class multiThread {
    public static void main(String[] args) {

        // 运行继承Thread的Thread1多线程
        Mythread1 T1 = new Mythread1("T1");
        Mythread1 T2 = new Mythread1("T2");
        T1.start();
        T2.start();

        // 运行实现Runnable接口的Thread2多线程
        Mythread2 T3 = new Mythread2("T3");
        T3.run();
    }
}
