package com.shawf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shawf_lee
 * @date 2020/9/24 15:30
 *Content: 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

    假定 BST 有如下定义：

    结点左子树中所含结点的值小于等于当前结点的值
    结点右子树中所含结点的值大于等于当前结点的值
    左子树和右子树都是二叉搜索树
    例如：
    给定 BST [1,null,2,2],
    返回[2].
 */
public class FindMode {
    private List<Integer> res;
    private int count = 0;
    private int maxCount = 0;
    private int curr = 0;
    public int[] findMode(TreeNode root) {
        res = new ArrayList<>();
        if(root == null){
            return new int[0];
        }
        ldr(root);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
    public void ldr(TreeNode root){
        if(root == null){
            return;
        }
        ldr(root.left);
        if(curr == root.val){
            count ++;
        }else{
            curr = root.val;
            count = 1;
        }
        if(count == maxCount){
            res.add(root.val);
        }else if(count > maxCount){
            res.clear();
            res.add(root.val);
            maxCount = count;
        }
        ldr(root.right);
    }

    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        TreeNode root = traversal.stringToTreeNode(new String("[1,null,2,2]"));
        System.out.println(Arrays.toString(new FindMode().findMode(root)));
    }
}
