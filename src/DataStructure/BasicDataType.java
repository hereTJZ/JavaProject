package DataStructure;

public class BasicDataType {
    public static void main(String[] args) {
        /**
         * 整数型包括：byte short int long，默认是int整数表示
         *   所有整数型都可以使用 不同进制 表示
         *     ·二进制：0b开头
         *     ·八进制：0开头
         *     ·十六进制：0x开头
         */
        // byte 1字节，共8位
        byte byte_min = -128; // byte最小值
        byte byte_max = 127; // byte最大值

        // short 2字节
        short short_min = -32768; // short最小值
        short short_max = 32767; // short最大值

        // int 4字节。整数默认为int类型
        int int_min = -2147483648; // int最小值
        int int_max = 2147483647; // int最大值
        int i = 0b101; // 二进制
        int i2 = 076; // 八进制
        int i3 = 0xA6ef; //十六进制


        // long 8字节。注意long的表示要在结尾加上 l或L
        long long_min = (long) -Math.pow(2, 63); // long最小值
        long long_max = 9223372036854775807L; // long最大值

        /**
         * 浮点型表示小数，包括：float、double，默认是double小数
         */
        // float 4字节
        float f = 1;
//      float f2 = 1.0; 编译不通过
        float f2 = 1.0f; // 结尾要加上 f

        // double 8字节。小数默认为double类型
        double d = 1.0;
        double d2 = 1.0d; // 默认d可省略
        double d3 = 0x88888888L; // 所有 整数型 都可以赋值
        double d4 = 1.0f; // float 也可以赋值
        // 科学计数法表示浮点型e： aeb 表示 a*10^b
        double d5 = 2e-6;

        // char 4字节，在Java中使用 Unicode 编码，该编码包含了 ASCII（0~127）编码，ASCII是Unicode的子集
        char c = 'a';
        char c1 = 65535; // 所有 整数型 型都可以，表示Unicode码，范围在 0~65535 之间
        // 也可以使用其它进制表示
        char c2 = 0b10110;
        char c3 = 076;
        char c4 = 0xA6ef;
        char c5 = '\u001e'; // Unicode的字符编码形式：\u0000（共4位十六进制数字）
        char c6 = '\0'; // 空字符
        char c7 = '\\'; // 字符'\'需要转义表示
    }
}
