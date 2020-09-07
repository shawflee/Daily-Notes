package com.shawf;

import java.util.PriorityQueue;

/**
 * @author shawf_lee
 * @date 2020/9/7 16:35
 * Content: 215.在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

    示例 1:
    输入: [3,2,1,5,6,4] 和 k = 2
    输出: 5

 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        // 方法一
        // Arrays.sort(nums);
        //return nums[nums.length-k];

        // 方法二
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num : nums){
            queue.add(num);
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3,2,1,5,6,4},2));
    }
}
