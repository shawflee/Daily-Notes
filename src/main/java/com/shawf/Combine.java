package com.shawf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shawf_lee
 * @date 2020/9/8 10:45
 * Content: 77.给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combine {
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n < 1 || k < 1 || n < k) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        dfs(n, k, 1, list);
        return res;
    }

    public void dfs(int n, int k, int first, List<Integer> list) {
        if (k == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 剪枝：n - (k - list.size()) + 1 ,由于每一位数不可重复,由此可得：
        // 第一层循环 i 只需要遍历至 (n - k + 1)
        // 第二层循环 i 只需要遍历至 (n - (k - 1) + 1)
        // 第三层循环 i 只需要遍历至 (n - (k - 2) + 1)
        // 以此类推
        for (int i = first; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            dfs(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res1 = new Combine().combine(4, 2);
        for (List<Integer> list : res1) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
