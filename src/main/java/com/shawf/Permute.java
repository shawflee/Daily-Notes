package com.shawf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shawf_lee
 * @date 2020/9/11 9:51
 * Content: 46.给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permute {
    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        int[] visit = new int[nums.length];
        dfs(nums,visit , list);
        return res;
    }

    private void dfs(int[] nums, int[] visit, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visit[i] == 1) continue;
            list.add(nums[i]);
            visit[i] = 1;
            dfs(nums, visit, list);
            visit[i] = 0;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res1 = new Permute().permute(new int[]{1, 2, 3});
        for (List<Integer> list : res1) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
