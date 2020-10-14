package com.shawf;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shawf_lee
 * @date 2020/10/14 11:21
 *Content: 1002.给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中
 * 都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，
 * 但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 示例 1：
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 */
public class CommonChars {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        int[] num = new int[26];
        for (int i = 0; i < A[0].length(); i++) {
            num[A[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            int[] count = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                count[A[i].charAt(j) - 'a']++;
            }
            for (int j = 0; j < count.length; j++) {
                num[j] = Math.min(count[j], num[j]);
            }
        }
        for (int i = 0; i < num.length; i++) {
            while (num[i] > 0) {
                num[i]--;
                res.add((char) ('a' + i) + "");
            }
        }
        return res;
    }

    /**350. 两个数组的交集 II
     * 给定两个数组，编写一个函数来计算它们的交集。
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i = 0, j = 0; i < nums1.length && j < nums2.length;){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int []res =new int [list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> res = new CommonChars().commonChars(new String[]{"bella", "label", "roller"});
        for (String item : res) {
            System.out.println(item);
        }
        System.out.println(Arrays.toString(new CommonChars().intersect(new int[]{1,2,2,1},new int[]{2,2})));
    }
}
