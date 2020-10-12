package com.shawf;


/**
 * @author shawf_lee
 * @date 2020/10/12 9:27
 *Content:  530. 二叉搜索树的最小绝对差
 *            给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值
 *            输入：
                1
                \
                3
                /
                2

                输出：
                1
                解释：
                最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 */
public class GetMinimumDifference {
    private int res = Integer.MAX_VALUE;
    private int preVal = -1;

    public int getMinimumDifference(TreeNode root){
        ldr(root);
        return res;
    }

    public void ldr(TreeNode node){
        if(node == null){
            return;
        }
        ldr(node.left);
        if(preVal != -1){
            res = Math.min(res, Math.abs(preVal - node.val));
        }
        preVal = node.val;
        ldr(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new Traversal().stringToTreeNode(new String("[1,null,3,2]"));
        System.out.println(new GetMinimumDifference().getMinimumDifference(root));
    }
}
