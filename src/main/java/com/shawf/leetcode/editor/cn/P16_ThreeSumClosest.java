//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 622 👎 0


package com.shawf.leetcode.editor.cn;

//最接近的三数之和

import java.util.Arrays;

public class P16_ThreeSumClosest{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P16_ThreeSumClosest().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int res = 100000;
    	for(int i = 0; i < nums.length; i++){
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
    		int left = i+1,right = nums.length -1;
			while(left < right){
				int sum = nums[i] + nums[left]+nums[right];
				if(sum == target){
					return target;
				}
				if(Math.abs(sum - target) < Math.abs(res - target)){
					res = sum;
				}
				if(sum < target){
					left++;
					while (left < right && nums[left] == nums[left - 1]){
						left++;
					}
				}else {
					right--;
					while (left < right && nums[right] == nums[right + 1]){
						right--;
					}
				}
			}
		}
    	return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}