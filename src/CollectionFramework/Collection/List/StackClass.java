package CollectionFramework.Collection.List;

import java.util.Scanner;
import java.util.Stack;

public class StackClass {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();

        // 元素入栈
        stack.push("first");

        // 查看栈顶元素
        String s1 = stack.peek();

        // 获取stack长度
        int size = stack.size();
        
        // 查找栈中某元素自顶向下的位置（栈顶为1），不存在则返回-1
        int place = stack.search("first");

        // 取出栈顶元素
        String s2 = stack.pop();

        // 判断栈是否为空
        System.out.println(stack.empty());
    }

}
