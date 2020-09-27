package com.shawf;

/**
 * @author shawf_lee
 * @date 2020/9/27 18:22
 *Content:  235. 二叉搜索树的最近公共祖先
 *  示例： [6,2,8,0,4,7,9,null,null,3,5]  2  4
 *  输出   2
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = root;
        while(true){
            if(p.val < res.val && q.val < res.val){
                res = res.left;
            }else if(p.val > res.val && q.val > res.val){
                res = res.right;
            }else{
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        TreeNode root = traversal.stringToTreeNode("[6,2,8,0,4,7,9,null,null,3,5]");
        TreeNode p = traversal.stringToTreeNode("[2]");
        TreeNode q =traversal.stringToTreeNode("[4]");
        TreeNode res = new LowestCommonAncestor().lowestCommonAncestor(root,p,q);
        InvertTree invertTree = new InvertTree();
        System.out.println(invertTree.treeNodeToString(res));
    }
}
