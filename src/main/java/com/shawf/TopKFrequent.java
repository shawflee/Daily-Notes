package com.shawf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shawf_lee
 * @date 2020/9/7 13:28
 * Content:给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer>[] list = new ArrayList[nums.length+1];
        for(int key : map.keySet()){
            int count = map.get(key);
            if(list[count] == null){
                list[count] = new ArrayList<>();
            }
            list[count].add(key);
        }
        for(int i = list.length - 1; i > 0 && res.size() < k; i--){
            if(list[i] == null) continue;
            res.addAll(list[i]);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] res = new TopKFrequent().topKFrequent(new int[]{1,1,1,2,2,3},2);
        for(int item : res) {
            System.out.print(item +" ");
        }
    }
}
