package com.shawf;

/**
 * @author shawf_lee
 * @date 2020/9/22 10:00
 *Content: 968.给定一个二叉树，我们在树的节点上安装摄像头。
               节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
               计算监控树的所有节点所需的最小摄像头数量。
            示例1：
            输入：[0,0,null,0,0]
            输出：1
            解释：如图所示，一台摄像头足以监控所有节点。
 */
public class MinCameraCover {
    private int res = 0;
    public int minCameraCover(TreeNode root){
        if(lrd(root) == 0){
            res ++;
        }
        return res;
    }

    /**
     * 后续遍历
     * 0 未覆盖 1已覆盖 2已装摄像头
     * @param node
     * @return
     */
    public int lrd(TreeNode node){
        if(node == null){
            return 1;
        }
        int left = lrd(node.left);
        int right = lrd(node.right);
        if(left == 0 || right == 0){
            res ++;
            return 2;
        }
        if(left == 1 && right == 1){
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        TreeNode root = traversal.stringToTreeNode(new String("[0,0,null,0,0]"));
        System.out.println(new MinCameraCover().minCameraCover(root));
    }
}
