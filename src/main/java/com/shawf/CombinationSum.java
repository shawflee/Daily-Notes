package com.shawf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shawf_lee
 * @date 2020/9/8 16:38
 * Content: 39.定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 40.给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * <p>
 * 216.找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 *  
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * <p>
 * 377.给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 * <p>
 * 示例:
 * nums = [1, 2, 3]
 * target = 4
 * <p>
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * <p>
 * 请注意，顺序不同的序列被视作不同的组合。
 * 因此输出为 7。
 */
public class CombinationSum {

    private List<List<Integer>> res;
    private List<List<Integer>> res2;
    private List<List<Integer>> res3;

    //题号39
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        //排序是为了剪枝
        Arrays.sort(candidates);
        dfs(candidates, target, 0, list);
        return res;
    }

    public void dfs(int[] candidates, int target, int start, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 候选数组已经有序，直接剪掉后续
            if (target - candidates[i] < 0) {
                break;
            }
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }

    //题号40
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res2 = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res2;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        dfs2(candidates, target, 0, list);
        return res2;
    }

    public void dfs2(int[] candidates, int target, int start, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res2.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            //前后相同需要去重，允许不同层次的元素重复（1，1，6），而不能（1，7）和（1，7）
            if (i > start && candidates[i - 1] == candidates[i]) {
                continue;
            }
            list.add(candidates[i]);
            dfs2(candidates, target - candidates[i], i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    //题号216
    public List<List<Integer>> combinationSum3(int k, int n) {
        res3 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs3(k, n, 1, list);
        return res3;
    }

    private void dfs3(int k, int n, int start, List<Integer> list) {
        if (k == 0 && n == 0) {
            res3.add(new ArrayList<>(list));
            return;
        }
        if (k <= 0 || n < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            dfs3(k - 1, n - i, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    //题号377 回溯超出时间限制
//    public int combinationSum4(int[] nums, int target) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int res4 = 0;
//        Arrays.sort(nums);
//        List<Integer> list = new ArrayList<>();
//        dfs4(nums, target, list);
//        return res4;
//    }
//
//    public void dfs4(int[] candidates, int target, List<Integer> list) {
//        if (target < 0) {
//            return;
//        }
//        if (target == 0) {
//            res4++;
//            return;
//        }
//        for (int i = 0; i < candidates.length; i++) {
//            if (target - candidates[i] < 0) {
//                break;
//            }
//            list.add(candidates[i]);
//            dfs4(candidates, target - candidates[i] , list);
//            list.remove(list.size() - 1);
//        }
//    }

    //题号377 动态规划
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if(i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println("题号39：");
        List<List<Integer>> res1 = new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : res1) {
            System.out.println(Arrays.toString(list.toArray()));
        }

        System.out.println("题号40：");
        List<List<Integer>> res2 = new CombinationSum().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> list : res2) {
            System.out.println(Arrays.toString(list.toArray()));
        }

        System.out.println("题号216：");
        List<List<Integer>> res3 = new CombinationSum().combinationSum3(3, 7);
        for (List<Integer> list : res3) {
            System.out.println(Arrays.toString(list.toArray()));
        }

        System.out.println("题号377：");
        System.out.println(new CombinationSum().combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
