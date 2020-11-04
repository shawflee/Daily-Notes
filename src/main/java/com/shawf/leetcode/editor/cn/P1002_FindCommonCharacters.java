//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i].length <= 100 
// A[i][j] 是小写字母 
// 
// Related Topics 数组 哈希表 
// 👍 186 👎 0


package com.shawf.leetcode.editor.cn;

//查找常用字符

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1002_FindCommonCharacters {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1002_FindCommonCharacters().new Solution();
        solution.commonChars(new String[]{"bella", "label", "roller"});
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> commonChars(String[] A) {
            List<String> res = new ArrayList<>();
            Map<Character, Integer> map = new HashMap<>();
            if(A.length == 0){
                return res;
            }
            for (int i = 0; i < A[0].length(); i++) {
                map.put(A[0].charAt(i), map.getOrDefault(A[0].charAt(i), 0) + 1);
            }
            for (int i = 1; i < A.length; i++) {
                Map<Character, Integer> temp = new HashMap<>();
                for (char a : A[i].toCharArray()) {
                    if (map.containsKey(a)) {
                        temp.put(a, Math.min(temp.getOrDefault(a, 0) + 1, map.getOrDefault(a, 0)));
                    }
                }
                map = temp;
            }
            for (Character key : map.keySet()) {
                for (int i = 0; i < map.get(key); i++) {
                    res.add(key + "");
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}