package com.shawf;

/**
 * @author shawf_lee
 * @date 2020/9/23 9:10
 *Content: 617.合并二叉树
        给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
        你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，
        那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 */
public class MergeTree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if(t1 == null) {
            return t2;
        }
        if(t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        TreeNode t1 = traversal.stringToTreeNode(new String("[1,3,2,5]"));
        TreeNode t2 = traversal.stringToTreeNode(new String("[2,1,3,null,4,null,7]"));
        InvertTree invertTree = new InvertTree();
        String str =invertTree.treeNodeToString(new MergeTree().mergeTrees(t1,t2));
        System.out.println(str);
    }
}
