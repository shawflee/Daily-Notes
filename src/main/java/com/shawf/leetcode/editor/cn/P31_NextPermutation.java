//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 748 👎 0


package com.shawf.leetcode.editor.cn;

//下一个排列

public class P31_NextPermutation {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P31_NextPermutation().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int cur = nums.length - 2;
            while (cur >= 0 && nums[cur] >= nums[cur + 1]) {
                cur--;
            }
            if(cur >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[cur] >= nums[j]) {
                    j--;
                }
                swap(nums,cur,j);
            }
            int left =cur + 1;
            int right = nums.length -1;
            while(left  < right){
                swap(nums,left,right);
                left++;
                right--;
            }
        }
        public void swap(int[] nums,int i,int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}