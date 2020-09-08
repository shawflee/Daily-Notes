package com.shawf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shawf_lee
 * @date 2020/9/8 16:38
 * Content: 39.定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

    candidates 中的数字可以无限制重复被选取。

    说明：
    所有数字（包括 target）都是正整数。
    解集不能包含重复的组合。 
    示例 1：

    输入：candidates = [2,3,6,7], target = 7,
    所求解集为：
    [
    [7],
    [2,2,3]
    ]

 */
public class CombinationSum {

    private List<List<Integer>> res;

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

    public static void main(String[] args) {
        List<List<Integer>> res1 = new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : res1) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
