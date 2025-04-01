package DataStructure.Tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;

    // 子节点列表
    List<TreeNode> children;

    TreeNode(int value) {
        this.val = value;
        this.children = new ArrayList<>();
    }
}
