package StringClass;

/**
 * 和 String 类不同的是，StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象
 * 当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类。
 * ① StringBuffer 的方法是线程安全的（能同步访问，synchronized）
 * ② StringBuilder 性能较高，线程不安全
 */
public class StringBuffer_StringBuilder {
    public static void main(String[] args) {

    }
}
