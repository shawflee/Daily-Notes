//设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。 
//
// 注意: 允许出现重复元素。 
//
// 
// insert(val)：向集合中插入元素 val。 
// remove(val)：当 val 存在时，从集合中移除一个 val。 
// getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。 
// 
//
// 示例: 
//
// // 初始化一个空的集合。
//RandomizedCollection collection = new RandomizedCollection();
//
//// 向集合中插入 1 。返回 true 表示集合不包含 1 。
//collection.insert(1);
//
//// 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
//collection.insert(1);
//
//// 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
//collection.insert(2);
//
//// getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
//collection.getRandom();
//
//// 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
//collection.remove(1);
//
//// getRandom 应有相同概率返回 1 和 2 。
//collection.getRandom();
// 
// Related Topics 设计 数组 哈希表 
// 👍 124 👎 0


package com.shawf.leetcode.editor.cn;

//O(1) 时间插入、删除和获取随机元素 - 允许重复

import java.util.*;

public class P381_InsertDeleteGetrandomO1DuplicatesAllowed {
    public static void main(String[] args) {
        //测试代码
        RandomizedCollection solution = new P381_InsertDeleteGetrandomO1DuplicatesAllowed().new RandomizedCollection();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedCollection {
        private int n;//集合大小
        private List<Integer> list;
        private Map<Integer,Set<Integer>> map;
        private Random random;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            this.n = 0;
            this.list = new ArrayList<>();
            this.map = new HashMap<>();
            this.random = new Random();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            Set set = map.get(val);
            if(set == null){
                set = new HashSet<>();
            }
            set.add(n);
            list.add(val);
            map.put(val,set);
            n++;
            return set.size() == 1;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            }
            Set set = map.get(val);
            Iterator<Integer> it = set.iterator();
            int firstIndex = it.next();
            int lastVal = list.get(n-1);
            list.set(firstIndex,lastVal);
            set.remove(firstIndex);
            map.get(lastVal).remove(n-1);
            if(firstIndex < list.size() -1) {
                map.get(lastVal).add(firstIndex);
            }
            if(set.size() == 0){
                map.remove(val);
            }
            list.remove(n-1);
            n--;
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return list.get(random.nextInt(n));
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}