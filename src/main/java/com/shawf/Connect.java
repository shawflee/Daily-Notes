package com.shawf;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import jdk.nashorn.internal.ir.BinaryNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentSkipListMap;

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

    /**
     * 116. 填充每个节点的下一个右侧节点指针
     * @param root
     * @return
     */
    public Node connect(Node root){
        if(root == null){
            return null;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int n = deque.size();
            Node pre = null;
            for(int i = 0; i < n; i++){
                Node temp = deque.poll();
                if (pre != null) {
                    pre.next = temp;
                }
                pre = temp;
                if(temp.left != null){
                    deque.add(temp.left);
                }
                if(temp.right != null){
                    deque.add(temp.right);
                }
            }
        }
        return root;
    }

    /**
     * 116. 填充每个节点的下一个右侧节点指针(完全二叉树，优化版)
     * @param root
     * @return
     */
    public Node connectOp(Node root){
        if(root == null){
            return null;
        }
        Node cur = root;
        while(cur != null){
            Node temp = new Node(0);
            Node pre = temp;
            while(cur != null && cur.left != null){
                pre.next = cur.left;
                pre = pre.next;
                pre.next = cur.right;
                pre = pre.next;
                cur = cur.next;

            }
            cur = temp.next;
        }
        return root;
    }

    /**
     * 117. 填充每个节点的下一个右侧节点指针 II
     * @param root
     * @return
     */
    public Node connect2(Node root) {
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

    public Node treeNodeToNode(TreeNode root){
        Node res = new Node(root.val);
        Deque<TreeNode> deque1 = new LinkedList<>();
        Deque<Node> deque2 = new LinkedList<>();
        deque1.add(root);
        deque2.add(res);
        while(!deque1.isEmpty()){
            TreeNode temp1 = deque1.poll();
            Node temp2 = deque2.poll();
            temp2.val = temp1.val;
            if(temp1.left != null){
                deque1.add(temp1.left);
                temp2.left = new Node();
                deque2.add(temp2.left);
            }
            if(temp1.right != null){
                deque1.add(temp1.right);
                temp2.right = new Node();
                deque2.add(temp2.right);
            }
        }
        return res;
    }

    public String nodeToString(Node root){
        if (root == null) {
            return "[]";
        }

        String output = "";
        Deque<Node> nodeDeque = new LinkedList<>();
        nodeDeque.add(root);
        while(!nodeDeque.isEmpty()) {
            Node node = nodeDeque.remove();

            if (node == null) {
                output += "null, ";
                continue;
            }
            output += String.valueOf(node.val) + ", ";
            nodeDeque.add(node.left);
            nodeDeque.add(node.right);
        }
        return "[" + output.substring(0, output.length() - 2) + "]";
    }

    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        TreeNode root = traversal.stringToTreeNode("[1,2,3,4,5,6,7]");
        Connect connect = new Connect();
        Node res = connect.connect2(connect.treeNodeToNode(root));
        System.out.println(connect.nodeToString(res));
        String str = connect.nodeToString(connect.connect(res));
        System.out.println(str);
    }

}
