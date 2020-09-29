package com.shawf;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shawf_lee
 * @date 2020/9/29 11:24
 *Content:  1588. 所有奇数长度子数组的和
                  给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
                  子数组 定义为原数组中的一个连续子序列。
                  请你返回 arr 中 所有奇数长度子数组的和 。
            示例一：
            输入：arr = [1,4,2,5,3]
            输出：58
            解释：所有奇数长度子数组和它们的和为：
            [1] = 1
            [4] = 4
            [2] = 2
            [5] = 5
            [3] = 3
            [1,4,2] = 7
            [4,2,5] = 11
            [2,5,3] = 10
            [1,4,2,5,3] = 15
            我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58

 */
public class SumOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i ++){
            for(int j = i; j < arr.length; j++){
                list.add(arr[j]);
                if(list.size() % 2 != 0){
                    for(int t : list){
                        res += t;
                    }
                }
            }
            list.clear();
        }
        return res;
    }

    public int sumOddLengthSubarrays2(int[] arr) {
        int len = arr.length;
        int ans = 0;
        for(int i = 0; i < len; i ++){
            int leftOddCnt = (i + 1) / 2;
            int leftEvenCnt = i / 2 + 1;
            int rightOddCnt = (len - i) / 2;
            int rightEvenCnt = (len - 1 - i) / 2 + 1;
            ans += arr[i] * (leftOddCnt * rightOddCnt + leftEvenCnt * rightEvenCnt);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new SumOddLengthSubarrays().sumOddLengthSubarrays(new int[]{1,4,2,5,3}));

    }
}
