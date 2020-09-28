package com.shawf;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shawf_lee
 * @date 2020/9/28 11:06
 *Content:
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Connect {
    //层次遍历
    public TreeNode level(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            TreeNode temp = deque.poll();
            if(temp.left != null){
                deque.add(temp.left);
            }
            if(temp.right != null){
                deque.add(temp.right);
            }
        }
        return root;
    }

    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int n = deque.size();
            Node last = null;
            for(int i = 1; i <= n; i++){
                Node temp = deque.poll();
                if(temp.left != null){
                    deque.add(temp.left);
                }
                if(temp.right != null){
                    deque.add(temp.right);
                }
                if (i != 1) {
                    last.next = temp;
                }
                last = temp;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        TreeNode root = traversal.stringToTreeNode("[1,2,3,4,5,null,7]");
        InvertTree invertTree = new InvertTree();
        String str = invertTree.treeNodeToString(new Connect().connect(root));
        System.out.println(str);
    }
}
