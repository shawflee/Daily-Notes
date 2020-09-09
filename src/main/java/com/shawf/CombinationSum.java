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

    40.给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

    candidates 中的每个数字在每个组合中只能使用一次。

    说明：
    所有数字（包括目标数）都是正整数。
    解集不能包含重复的组合。 
    示例 1:

    输入: candidates = [10,1,2,7,6,1,5], target = 8,
    所求解集为:
    [
    [1, 7],
    [1, 2, 5],
    [2, 6],
    [1, 1, 6]
    ]

 */
public class CombinationSum {

    private List<List<Integer>> res;
    private List<List<Integer>> res2;

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
        if(candidates == null || candidates.length == 0){
            return res2;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        dfs2(candidates, target, 0, list);
        return res2;
    }
    public void dfs2(int[] candidates, int target, int start, List<Integer> list){
        if(target < 0){
            return;
        }
        if(target == 0){
            res2.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(target - candidates[i] < 0){
                break;
            }
            //前后相同需要去重，允许不同层次的元素重复（1，1，6），而不能（1，7）和（1，7）
            if(i > start && candidates[i - 1] == candidates[i]){
                continue;
            }
            list.add(candidates[i]);
            dfs2(candidates, target - candidates[i], i+1, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println("题号39：");
        List<List<Integer>> res1 = new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : res1) {
            System.out.println(Arrays.toString(list.toArray()));
        }

        System.out.println("题号40：");
        List<List<Integer>> res2 = new CombinationSum().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        for (List<Integer> list : res2) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
