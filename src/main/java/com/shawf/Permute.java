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
 *
 * 47. 全排列 II
    给定一个可包含重复数字的序列，返回所有不重复的全排列。
    示例:
    输入: [1,1,2]
    输出:
    [
    [1,1,2],
    [1,2,1],
    [2,1,1]
    ]
 */
public class Permute {
    private List<List<Integer>> res;
    private List<List<Integer>> res1;
    private boolean[] visit;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        int[] visit = new int[nums.length];
        dfs(nums, visit, list);
        return res;
    }

    private void dfs(int[] nums, int[] visit, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] == 1) continue;
            list.add(nums[i]);
            visit[i] = 1;
            dfs(nums, visit, list);
            visit[i] = 0;
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        res1 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        visit = new boolean[nums.length];
        Arrays.sort(nums);
        dfs2(nums, list);
        return res1;
    }

    public void dfs2(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res1.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) {
                continue;
            }

            //升序排序后，剪掉前一个元素等于当前元素的，!visit[i-1] 与 visit[i-1] 剪枝区别与更彻底问题见题解
            if (i > 0 && !visit[i - 1] && nums[i - 1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            visit[i] = true;
            dfs2(nums, list);
            visit[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> res1 = permute.permute(new int[]{1, 2, 3});
        List<List<Integer>> res2 = permute.permuteUnique(new int[]{1, 1, 2});
        System.out.println("46.全排列Ⅰ：");
        for (List<Integer> list : res1) {
            System.out.println(Arrays.toString(list.toArray()));
        }
        System.out.println("47.全排列Ⅱ：");
        for (List<Integer> list : res2) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
