package DataStructure.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树结构的广度优先遍历（BFS）
 */
public class BFS {
    void bfs(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点加入队列
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 取出队首节点
            TreeNode node = queue.poll();

            // 访问节点
            System.out.print(node.val + " ");

            // 将子节点加入队列
            queue.addAll(node.children);
        }
    }
}
