package com.shawf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author shawf_lee
 * @date 2020/10/22 13:45
 *Content:  763. 划分字母区间
 *          字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
 *          同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *          示例 1：
            输入：S = "ababcbacadefegdehijhklij"
            输出：[9,7,8]
            解释：
            划分结果为 "ababcbaca", "defegde", "hijhklij"。
            每个字母最多出现在一个片段中。
            像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。

 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        //记录每个字母最后出现的位置
        int [] last = new int[26];
        for(int i = 0; i < S.length(); i++){
            last[S.charAt(i)-'a'] = i;
        }
        int start = 0,end = 0;
        for(int i = 0; i < S.length(); i++){
            end = Math.max(end,last[S.charAt(i)-'a']);
            if(end == i){
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }

    //56. 合并区间
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if(intervals == null || intervals.length  <= 1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        for(int i = 0; i < intervals.length; i++){
            int l = intervals[i][0];
            int r = intervals[i][1];
            while(i+1 < intervals.length && r >= intervals[i+1][0]){
                r = Math.max(r, intervals[i+1][1]);
                i++;
            }
            res.add(new int[]{l,r});
        }
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        List<Integer> res = new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(Arrays.toString(res.toArray()));
        int [][] arr = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int [][] resArr = new PartitionLabels().merge(arr);
        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(resArr));
    }
}
