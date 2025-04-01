package DataStructure.Tree;

import java.util.Collections;
import java.util.Stack;

/**
 * 树结构的深度优先遍历（DFS）
 */
public class DFS {
    /**
     * ① 递归方式实现
     *
     * @param node node
     */
    void dfsByRecursion(TreeNode node) {
        if (node == null) return;

        // 访问节点
        System.out.print(node.val + " ");

        for (TreeNode child : node.children) {
            // 递归遍历子节点
            dfsByRecursion(child);
        }
    }

    /**
     * ② 栈方式实现
     *
     * @param root root
     */
    void dfsByStack(TreeNode root) {
        // 处理空树
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        // 将根节点压入栈中
        stack.push(root);

        while (!stack.isEmpty()) {
            // 弹出栈顶节点
            TreeNode node = stack.pop();

            // 访问节点
            System.out.print(node.val + " ");

            // 反向遍历子节点，以便保持原来的顺序
            Collections.reverse(node.children);
            for (TreeNode child : node.children) {
                stack.push(child);
            }
        }
    }
}
