//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2726 👎 0


package com.shawf.leetcode.editor.cn;

//三数之和

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15_ThreeSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P15_ThreeSum().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(nums == null || nums.length <= 2){
    		return res;
		}
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++){
			if (nums[i] > 0) {
				break;
			}
			//去掉重复情况
			if(i > 0 && nums[i] == nums[i-1]){
				continue;
			}
			int remain = -nums[i];
			int left = i + 1,right = nums.length - 1;
			while(left < right){
				if(nums[left] + nums[right] == remain){
					res.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
					left++;
					right--;
					while(left < right && nums[left] == nums[left - 1]){
						left++;
					}
					while(left < right && nums[right] == nums[right + 1]){
						right--;
					}
				}else if(nums[left] + nums[right] < remain){
					left++;
				}else {
					right--;
				}
			}
		}
    	return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}