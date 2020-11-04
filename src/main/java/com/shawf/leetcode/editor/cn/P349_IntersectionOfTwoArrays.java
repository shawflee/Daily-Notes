//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 253 👎 0


package com.shawf.leetcode.editor.cn;

//两个数组的交集

import java.util.*;

public class P349_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P349_IntersectionOfTwoArrays().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection1(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            Set<Integer> set = new HashSet<>();
            int i = 0, j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    set.add(nums1[i]);
                    i++;
                    j++;
                }
            }
            Integer[] res = set.toArray(new Integer[set.size()]);
            return Arrays.stream(res).mapToInt(Integer::valueOf).toArray();
        }

        public int[] intersection2(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int num : nums1) {
                set1.add(num);
            }
            for (int num : nums2) {
                set2.add(num);
            }
            Set<Integer> set = new HashSet<>();
            if (set1.size() <= set2.size()) {
                for (int num : set1) {
                    if (set2.contains(num)) {
                        set.add(num);
                    }
                }
            } else {
                for (int num : set2) {
                    if (set1.contains(num)) {
                        set.add(num);
                    }
                }
            }
            Integer[] res = set.toArray(new Integer[set.size()]);
            return Arrays.stream(res).mapToInt(Integer::valueOf).toArray(); //慢
        }

        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> resSet = new HashSet<>();
            //把nums1中的元素全部加入到集合set1中
            for (int i = 0; i < nums1.length; i++) {
                set1.add(nums1[i]);
            }

            for (int i = 0; i < nums2.length; i++) {
                //查看nums2中的元素是否存在集合set1中，如果存在，
                //就加入到集合resSet中
                if (set1.contains(nums2[i])) {
                    resSet.add(nums2[i]);
                }
            }
            //下面一大坨是把集合reSet转换为数组
            int i = 0;
            int[] res = new int[resSet.size()];
            for (Integer num : resSet) {
                res[i++] = num;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}