package com.shawf;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shawf_lee
 * @date 2020/9/16 9:25
 *Content: 226. 左右翻转二叉树
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
//        TreeNode left = root.left;
//        root.left = root.right;
//        root.right = left;
//        invertTree(root.left);
//        invertTree(root.right);

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }


    public String treeNodeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        String output = "";
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }

            output += String.valueOf(node.val) + ", ";
            nodeQueue.add(node.left);
            nodeQueue.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        String str = "[4,2,7,1,3,6,9]";
        TreeNode root = traversal.stringToTreeNode(str);
        InvertTree it = new InvertTree();
        it.invertTree(root);
        System.out.println(it.treeNodeToString(root));
    }
}
