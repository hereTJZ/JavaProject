package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class io {
    public static void main(String[] args) throws IOException {

        //①方法一：Scanner类读取
        /**
         * System.in为控制台输入
         */
        Scanner in = new Scanner(System.in);
//
//        System.out.println("1、请输入你的姓名:");
//        String a = "";
//        for (int i = 0; i < 3; i++) {
//            String name = in.nextLine();//以Enter为结束符，返回的是输入回车及其之前的所有字符，没有输入内容也会读取（以字符类型的方式读入），但读入结果不会保存回车符
//            a += name;
//            System.out.println(a);
//        }
//
//
//        System.out.println("2、请输入你的年龄：");
//        int age = in.nextInt();//整数类型的输入方式，没有输入则继续尝试读取，以空格或tab作为分隔符
//        System.out.println(age);
//
//
//        System.out.println("3、请输入你的身高：");
//        BigDecimal high = in.nextBigDecimal();
//        System.out.println(high);
//
//
//        //如果要读取带空格的一串字符串还是需要使用nextLine()
//        System.out.println("4、请在同一行输入带空格的任意一串字符串（一次性读入）：");
//        /**
//         * next()、nextDouble()、nextFloat()、nextInt()、nextBigDecimal()等不读取任何空格、tab或换行符，且读取到有一个效数据前都能跳过他们读取，会一直读取到有效数据直到空格或换行符之前，
//         * 其实每行末尾面还有一个回车未读取出来，若此时后面跟上一个nextLine()读取的是该回车，导致nextLine()读不到数据。
//         * 所以，next()、nextDouble()、nextFloat()、nextInt()、nextBigDecimal()等后面邻接的一个nextLine()是无效的，因此可直接加一个in.nextLine()来消除回车
//         */
//        in.nextLine();//清除回车
//        String s = in.nextLine();
//        System.out.println(s);
//
//
//        System.out.println("5、请在同一行输入以\"#\"结尾带空格的任意一串字符串（分次读入）：");
//        /**
//         * 这里要说一下，无参数hasNext()和hasNextLine()函数会判断当前是否有的输入，没有则阻塞等待继续输入，并不会返回false！！！
//         * 有则返回true
//         * 注意，它们只做当前判断但不更改扫描程序的状态（游标不会改变），不可用于控制台是否有输入的循环终止判断条件！！！否则会一直判断同一位置的数据，结果进入无限循环。
//         * ================================================
//         * 但是文档流输入可以使用它们进行判断，读完文档后会返回false。
//         * ================================================
//        */
////        for (int i = 0; in.hasNextLine(); i++) {  //in是系统控制台输入，一旦有输入，将进入无限循环
////            //System.out.println(in.next());
////            System.out.println(i);
////        }
//        //文档流输入就可以
//        File path = new File("src/Default/1.txt");
//        Scanner inner = new Scanner(path);  //使用相对路径，java.io默认定位到当前工程根目
//        for (int i = 0; inner.hasNext(); i++) {
//            System.out.println(inner.next());
//            System.out.println(i);
//        }
//
//        //只能使用它们的重载带参函数做循环终止判断条件。
//        for (int i = 0; !in.hasNext("#"); i++) {  //只有读取到单独的“#”时才会停止输入
//            String str = in.next();//一定要读取到有效字符后才可以结束输入，否则将继续读取，有效字符后入的空白作为分隔符或者结束符（以字符类型的方式读入）
//            System.out.println(str);
//        }
//
//        in.close();//关闭Scanner




        //②方法二：BufferedReader
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String str = null;
        System.out.println("Enter your value:");
        str = br.readLine();
        System.out.println("your value is :"+str);
    }
}
