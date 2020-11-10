package com.shawf;

import java.util.*;

/**
 * @author shawf_lee
 * @date 2020/9/14 10:05
 * Content: 题号144，94，145：二叉树的先中后遍历（递归、迭代）
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Traversal {
    //先序递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    //先序迭代
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(root == null) {
            return res;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode curr = stack.pollLast();
            if(curr != null){
                if(curr.right != null){
                    stack.add(curr.right);
                }
                if(curr.left != null){
                    stack.add(curr.left);
                }
                stack.add(curr);
                stack.add(null);
            }else{
                //如果弹出的节点为空节点，表明当前栈顶节点已经访问过
                res.add(stack.pollLast().val);
            }
        }
        return res;
    }


    //中序递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }


    //中序迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(root == null) {
            return res;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode curr = stack.pollLast();
            if(curr != null){
                if(curr.right != null){
                    stack.add(curr.right);
                }
                stack.add(curr);
                stack.add(null);
                if(curr.left != null){
                    stack.add(curr.left);
                }
            }else{
                res.add(stack.pollLast().val);
            }
        }
        return res;
    }


    //后序递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    //后序迭代
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(root == null) {
            return res;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode curr = stack.pollLast();
            if(curr != null){
                stack.add(curr);
                stack.add(null);
                if(curr.right != null){
                    stack.add(curr.right);
                }
                if(curr.left != null){
                    stack.add(curr.left);
                }
            }else{
                res.add(stack.pollLast().val);
            }
        }
        return res;
    }

    //层次遍历
    public List<Integer> levelTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if(root == null){
            return res;
        }deque.add(root);
        while(!deque.isEmpty()){
            TreeNode temp = deque.poll();
            res.add(temp.val);
            if(temp.left != null){
                deque.add(temp.left);
            }
            if(temp.right != null){
                deque.add(temp.right);
            }
        }
        return res;
    }


    //自下向上,自右向左，即层次遍历逆向
    public List<Integer> levelTraversalReverse(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return res;
        }deque.add(root);
        while(!deque.isEmpty()){
            TreeNode temp = deque.poll();
            stack.push(temp);
            if(temp.left != null){
                deque.add(temp.left);
            }
            if(temp.right != null){
                deque.add(temp.right);
            }
        }
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.add(temp.val);
        }
        return res;
    }

    public TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        //0代表空
        String str = "[1,null,2,3]";
        TreeNode root = traversal.stringToTreeNode(str);
        //先序遍历
        System.out.println(Arrays.toString(traversal.preorderTraversal(root).toArray()));
        System.out.println(Arrays.toString(traversal.preorderTraversal2(root).toArray()));

        //中序遍历
        System.out.println(Arrays.toString(traversal.inorderTraversal(root).toArray()));
        System.out.println(Arrays.toString(traversal.inorderTraversal2(root).toArray()));

        //后序遍历
        System.out.println(Arrays.toString(traversal.postorderTraversal(root).toArray()));
        System.out.println(Arrays.toString(traversal.postorderTraversal2(root).toArray()));

        //层次遍历
        System.out.println(Arrays.toString(traversal.levelTraversal(root).toArray()));

        //层次遍历逆向
        System.out.println(Arrays.toString(traversal.levelTraversalReverse(root).toArray()));
    }
}
