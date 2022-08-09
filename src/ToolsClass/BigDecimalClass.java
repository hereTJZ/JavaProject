package ToolsClass;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalClass {
    public static void main(String[] args) {
        // BigDecimal实例化时，一定不要直接使用 new BigDecimal(float f) 或者 new BigDecimal(double d) 形式，否则出现精度丢失情况
        System.out.println(new BigDecimal(0.2));
        double d = 0.2;  // 实际上是0.200000000000000011102230246251565404236316680908203125

        // 应该使用 new BigDecimal(String s) 的构造方法
        BigDecimal a = new BigDecimal("1.3");
        BigDecimal b = new BigDecimal("0.220");
        // 或者按如下方式，包装类Double或Float 通过toString()方法可以转化为正常的小数字符
        System.out.println(new BigDecimal(Double.toString(0.2)));
        BigDecimal c;


        /**
         * 四则运算
         */
        // 加法
        c = a.add(b);
        System.out.println("add(BigDecimal b)：" + c);  // 1.520

        // 减法n
        c = a.subtract(b);
        System.out.println("subtract(BigDecimal b)：" + c);  // 1.080
        // 乘法
        c = a.multiply(b);
        System.out.println("multiply(BigDecimal b)：" + c);  // 0.2860

        // 除法（特例）
        c = a.divide(b, RoundingMode.UP);
        System.out.println("divide(BigDecimal divisor, RoundingMode mode)：" + c);  // 6.0 默认scale
        c = a.divide(b, 10, RoundingMode.UP);
        System.out.println("divide(BigDecimal divisor, int scale, RoundingMode mode)：" + c);  // 5.9090909091 保留10位小数


        /**
         * 类型转换
         */
        // 转换成双精度数
        System.out.println("doubleValue()：" + c.doubleValue());  // 5.9090909091

        // 转换成单精度数
        System.out.println("floatValue()：" + c.floatValue());  // 5.909091

        // 转换成整数
        System.out.println("intValue()：" + c.intValue());  // 5

        // 转换成长整数
        System.out.println("longValue()：" + c.longValue());  // 5

        // 转换成byte类型数
        System.out.println("byteValue()：" + c.byteValue());  // 5


        /**
         * 比较大小
         */
        BigDecimal a1 = new BigDecimal("1.2");
        BigDecimal a2 = new BigDecimal("1.20");
        BigDecimal a3 = new BigDecimal("1.0");
        BigDecimal a4 = new BigDecimal("2.0");

        // BigDecimal 单纯比较大小用的是compareTo()方法，小于返回-1，等于返回0，大于返回1
        System.out.println("compareTo(BigDecimal b) 等于：" + a1.compareTo(a2));  // 0
        System.out.println("compareTo(BigDecimal b) 大于：" + a1.compareTo(a3));  // 1
        System.out.println("compareTo(BigDecimal b) 小于：" + a1.compareTo(a4));  // -1

        // equals()方法还需要比较两小数的保留位数是否相同
        System.out.println("equals(BigDecimal b)：" + a1.equals(a2));  // false
        System.out.println("equals(BigDecimal b)：" + a1.equals(a1));  // true


        /**
         * 其它常用方法
         */
        BigDecimal b1 = new BigDecimal("123.4560");
        BigDecimal b2 = new BigDecimal("-123.45");

        // 获取小数位数
        System.out.println("scale()：" + b1.scale());  // 4

        // 去除尾部无效位的0
        System.out.println("stripTrailingZeros()：" + b1.stripTrailingZeros());  // 123.456

        // 对一个小数进行取舍，按照需求的取舍模式
        System.out.println("setScale(int scale, RoundingMode mode)：" + b1.setScale(2, RoundingMode.HALF_UP));  // 四舍五入 123.46

        // 取最绝对值
        System.out.println("abs()：" + b2.abs());  // 123.45

        // 比较取最大值
        System.out.println("max(BigDecimal b)：" + b1.max(b2));  // 123.4560

        // 比较取最小值
        System.out.println("min(BigDecimal b)：" + b1.min(b2));  // -123.45

        // 取相反数
        System.out.println("negate()：" + b1.negate());  // -123.4560


        /**
         * 关于取舍模式的枚举类型 RoundingMode 的介绍：
         *  0、RoundingMode.UP：不管正数负数，小数部分进位（向0远离）
         *  1、RoundingMode.DOWN：不管正数负数，直接去掉小数部分（向0靠近）
         *  2、RoundingMode.CEILING：向上取整，进位（注意负数的情况）
         *  3、RoundingMode.FLOOR：向下取整，退位（注意负数的情况）
         *  4、RoundingMode.HALF_UP：四舍五入
         *  5、RoundingMode.HALF_DOWN：五舍六入
         *  6、RoundingMode.HALF_EVEN：四舍六入，五向偶数
         *  7、RoundingMode.UNNECESSARY：不需要舍入模式
         */
    }
}