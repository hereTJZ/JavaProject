package CollectionFramework.Collection.List;

import java.util.Scanner;
import java.util.Stack;

public class StackClass {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();

        stack.push("first");

        String s1 = stack.peek();

        int size = stack.size();

        String s2 = stack.pop();

        System.out.println(stack.empty());
    }

}
