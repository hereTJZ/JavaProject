package Leetcode;

public class BinaryAddition {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        String a = "1101";
        String b = "10101";
        System.out.println(BinaryAddition.addBinary(a, b));
    }

    /**
     *
     * @param a 二进制加数1
     * @param b 二进制加数2
     * @return
     */
    static public String addBinary(String a, String b){
        StringBuilder result = new StringBuilder();
        int maxLen = Math.max(a.length(), b.length());  //最大字符串长度
        int carry = 0;  //进位
        int sum = 0;  //位总合
        for (int i = 0; i < maxLen; i++) {
            // a、b 两字符串谁大谁小未知
            sum = (a.length() > i ? (a.charAt(a.length() - 1 - i) - '0') : 0) +  // a 字符串（可能较小）缺位补0
                    (b.length() > i ? (b.charAt(b.length() - 1 - i) - '0') : 0) +  // b 字符串（可能较小）缺位补0
                    carry;
            result.append(sum % 2); //位结果
            carry = sum / 2;
        }
        if(carry > 0)  //最后一位判断，进位加1
            result.append(1);

        return result.reverse().toString();  //StringBuilder的append方法是按顺序添加，要反转一下
    }
}
