package com.shawf;


import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author shawf_lee
 * @date 2020/10/15 15:37
 *Content: 199.给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *      输入: [1,2,3,null,5,null,4]
 *      输出: [1, 3, 4]
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    public void dfs(TreeNode node, List<Integer> res, int depth) {
        if (node == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(node.val);
        }
        dfs(node.right, res, depth + 1);
        dfs(node.left, res, depth + 1);
    }

    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        List<Integer> res = new RightSideView().
                rightSideView(traversal.stringToTreeNode("[1,2,3,null,5,null,4]"));
        System.out.println(Arrays.toString(res.toArray()));
    }
}
