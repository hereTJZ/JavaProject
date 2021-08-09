package StringClass;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringClass {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        char[] c = {'d','e','f'};
        String s4 = new String(c);  //初始化字符串时可以使用字符数组


        int[] a = new int[3];  //动态实例化数组时要使用中括号，实例化后赋值只能一个一个元素的赋
        int[] b = new int[] {1,2};
        float f = 1.3f;  // 4 字节，8位有效数字         末尾必须跟上f，因为默认为双精度类型
        double d = 1.3;  // 8字节，16位有效数字


        //length() 返回字符串长度
        System.out.println("length()：" + s1.length());


        //compareTo(String s) 比较字符串大小，按照字母字典顺序(ASCII码顺序)比较
        System.out.println("compareTo()：" + s1.compareTo(s2)); // 0
        System.out.println("compareTo()：" + s1.compareTo(s4)); // 小于0


        //charAt(int a) 按照数组索引
        System.out.println("charAt()：" + s1.charAt(1));  // b


        //concat(Stirng s) 字符串拼接，一般直接使用 + 也行
        System.out.println("concat()：" + s1.concat(s4));  // abcdef


        //toCharArray() 将字符串转换为字符数组
        char[] cc = s1.toCharArray();
        System.out.print("toCharArray()：");
        //字符数组的输出要用遍历！！！防止出问题
        for(int i = 0; i < cc.length; i++)
            System.out.print(cc[i]);
        System.out.println();
        //其实，任意数组可以使用Arrays工具类输出
        System.out.println("借助Arrays输出数组：" + Arrays.toString(cc));


        //contains(String) 字符串中是否包含子串
        System.out.println("contains()：" + s1.contains("b"));  // True


        //valueOf(Char[] c)或valueOf(Char[] c, int offset, int long)  将字符数组（或某部分）转换为已实例化的字符串
        //valueOf()和toString()方法差不多，但value是String类专有的转换为字符串的方法
        char[] ch1 = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};
        String Str2 = "";
        System.out.println("valueOf()：" + String.valueOf(ch1, 1, 3));  // ell
        //valueOf()是静态方法，可以通过类直接调用
        System.out.println("valueOf()：" + String.valueOf(ch1));  // hello runoob
        //实际上valueOf(Object O)函数不仅能将(字符数组)变为字符串，其它数据类型也可以，除了非字符数组


        //equals(Object anObject)  String中 == 比较引用地址是否相同，equals()比较字符串的内容是否相同
        System.out.println("s1 == s2：" + String.valueOf(s1 == s2));  //true  两者都指向相同的字符串常量
        System.out.println("s1.equals(s2)：" + s1.equals(s2));  //true
        System.out.println("s1 == s3：" + String.valueOf(s1 == s3));  //false  两者是不同的引用，s1指向字符串常量，s3指向new的对象
        System.out.println("s1.equals(s3)：" + s1.equals(s3));  //true


        //indexOf(char c)  返回第一次出现c的索引，找不到返回-1
        //indexOf(char c, int begin)  返回从begin开始检索第一次出现c的索引
        //上方char参数也可以是String类型str
        String s5 = "abcabacd";
        System.out.println(s5.indexOf('b'));  //1
        System.out.println(s5.indexOf('b', 2));  //4
        System.out.println(s5.indexOf("ab"));  //0
        System.out.println(s5.indexOf("ab", 2));  //3

        //lastIndexOf()则是从尾部开始往前检索，是检索最后一次出现c或str的索引
        System.out.println(s5.lastIndexOf('b'));  //4
        System.out.println(s5.lastIndexOf('b', 3));  //1
        System.out.println(s5.lastIndexOf("ab"));  //3
        System.out.println(s5.lastIndexOf("ab", 2));  //0


        //replace(char old, char new) 将字符串中的 old '字符' 全部替换为new
        System.out.println("replace()：" + s5.replace('b', '!'));  //a!ca!acd

        //replaceAll(String regex, String new)  正则表达式匹配字符串，匹配到的 '字符串' 结果全部替换为new
        System.out.println("replaceAll()：" + s5.replaceAll("ab", "!"));  //!c!acd
        //replaceFirst(String regex, String new)  正则表达式匹配到的第一个 '字符串' 结果全部替换为new
        System.out.println("replaceFirst()：" + s5.replaceFirst("ab", "!"));  //!cabacd


        //split(String regex)  根据给定正则表达式的匹配为分界，将字符串拆分成  字符串数组！
        String s6 = "I love you and her";
        //避坑小贴士：字符串包括空字符串 "" ，若 split("") 表示将字符串划分为单个字符的  字符串数组，注意区分：toCharArray() -> 字符数组;
        String[] ss = s6.split(" |and");  //{"I", "love", "you", "", "", "her"}    正则表达式中 '|' 表示或
        System.out.print("split(String regex)：" + Arrays.toString(ss));  //[I, love, you, , , her]
        System.out.println("       length：" + ss.length);  //字符串被划分成了6个部分

        //split(String regex, int number)   number表示划分的份数
        ss = s6.split(" ", 3);  //{"I", "love", "you and her"}  只划分为3个部分
        System.out.print("split(String regex, int number)：" + Arrays.toString(ss));  //[I, love, you and her]
        System.out.println("       length：" + ss.length);  //字符串被划分成了3个部分


        //substring(int begin)  提取字符串中 指定头索引的 子字符串
        System.out.println("substring(int begin)：" + s6.substring(15));  //you and her
        //substring(int begin, int end)  提取字符串中 指定索引区间的 子字符串（包首不包尾！！！）
        System.out.println("substring(int begin, int end)：" + s6.substring(2, 6));  //love


        //trim()  去除字符串首位若干 空白或换行符
        String s7 = "  hhhh\n";
        System.out.println("trim()：" + s7.trim());


        String lower = "qwer123asdf!";
        String upper = "QWER123ASDF!";
        //toLowerCase()  将字母全部转换为小写
        System.out.println("toLowerCase()：" + upper.toLowerCase());
        //toUpperCase()  将字母全部转换为大写
        System.out.println("toUpperCase()：" + lower.toUpperCase());

        List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");
        System.out.println(stooges.getClass());

    }
}
