package com.shawf;

import java.util.Arrays;

/**
 * @author shawf_lee
 * @date 2020/10/13 16:10
 *Content:
 */
public class SplitListToParts {

    /**
     * 725.给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
     * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
     * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
     * 返回一个符合上述规则的链表的列表。
     * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
     * 示例：输入 root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
     * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
     * 解释:输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
     * @param root
     * @param k
     * @return
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        int n = 0;
        ListNode node = root;
        while (node != null) {
            n++;
            node = node.next;
        }
        //数组中链表元素长度为len,前mod个链表元素的长度为len+1
        int len = n / k;
        int mod = n % k;
        ListNode[] res = new ListNode[k];
        node = root;
        for (int i = 0; i < k && node != null; i++) {
            res[i] = node;
            int lastLen = len;
            if (mod > 0) {
                lastLen = lastLen + 1;
                mod--;
            }
            for (int j = 0; j < lastLen - 1; j++) {
                node = node.next;
            }
            ListNode next = node.next;
            node.next = null;
            node = next;
        }
        return res;
    }

    public static void main(String[] args) {
        TransformL transformL = new TransformL();
        ListNode head = transformL.stringToListNode("[1,2,3,4,5,6,7,8,9,10]");
        int k = 3;
        ListNode[] res = new SplitListToParts().splitListToParts(head, k);
        String[] resStr = new String[k];
        for (int i = 0; i < k; i++) {
            resStr[i] = transformL.listNodeToString(res[i]);
        }
        System.out.println(Arrays.toString(resStr));
    }
}
