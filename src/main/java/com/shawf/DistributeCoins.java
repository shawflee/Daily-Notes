package com.shawf;

/**
 * @author shawf_lee
 * @date 2020/9/22 15:14
 *Content: 979. 在二叉树中分配硬币
        给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。
        在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。
        (移动可以是从父结点到子结点，或者从子结点移动到父结点。)。
        返回使每个结点上只有一枚硬币所需的移动次数。
 示例1： 输入：[3,0,0]
        输出：2
        解释：从树的根结点开始，我们将一枚硬币移到它的左子结点上，一枚硬币移到它的右子结点上。
 */
public class DistributeCoins{
    private int res = 0;
    public int distributeCoins(TreeNode root) {
        if(lrd(root) == 0){
            return res;
        }
        //题目的用例都有解
        return -1;
    }
    public int lrd(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = lrd(node.left);
        int right = lrd(node.right);
        res += Math.abs(left) + Math.abs(right);
        return left + right + node.val - 1;
    }

    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        TreeNode root = traversal.stringToTreeNode(new String("[3,0,0]"));
        System.out.println(new DistributeCoins().distributeCoins(root));
    }
}
