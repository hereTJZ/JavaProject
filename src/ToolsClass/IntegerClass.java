package ToolsClass;

public class IntegerClass {
    public static void main(String[] args) {
        Integer v1 = 10;
        Integer v2 = 10;
        // Integer比较特殊，v1 和 v2 是同一个引用，指向同一个对象！！！
        System.out.println(v1 == v2); // true
        Integer v3 = new Integer(10);
        System.out.println(v1 == v3);// false
        // 包装类数值比较应该使用equals()
        System.out.println(v1.equals(v3)); // true

        
        int decimal = 123;
        //十进制转二进制字符串
        String binary  = Integer.toBinaryString(decimal);
        System.out.println("2进制字符串：" + binary);
        //十进制转8进制字符串
        String octal  = Integer.toOctalString(decimal);
        System.out.println("8进制字符串：" + octal);
        //十进制转16进制字符串
        String hex = Integer.toHexString(decimal);
        System.out.println("16进制字符串：" + hex);

        //默认将字符串转换为十进制整数
        System.out.println("默认十进制字符数字转十进制整数：" + Integer.parseInt(binary));
        //将指定进制的字符串转换为十进制整数
        decimal = Integer.parseInt(binary, 2);
        System.out.println("2进制的字符转换为十进制整数：" + decimal);
        System.out.println("8进制的字符转换为十进制整数：" + Integer.parseInt(octal, 8));
        System.out.println("16进制的字符转换为十进制整数：" + Integer.parseInt(hex, 16));

    }
}
