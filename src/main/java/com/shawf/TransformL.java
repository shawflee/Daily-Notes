package com.shawf;

/**
 * @author shawf_lee
 * @date 2020/10/8 21:33
 *Content:
 */
public class TransformL {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }



    /**
     * 链表： (a1 -> a2 -> a3 ->... -> an-2 -> an-1 -> an)变为(a1 -> an -> a2 -> an-1 -> a3 -> an-2...)
     * 示例1：(a1 -> a2 -> a3 -> a4 -> a5 -> a6)变为(a1 -> a6 -> a2 -> a5 -> a3 -> a4)
     * @param root
     * @return root
     */
    public ListNode transform1(ListNode root) {
        int n = 0;
        ListNode node = root;
        ListNode root1 = root;
        while (node.next != null) {
            node = node.next;
            n++;
        }
        while (root1 != null) {
            if (root1.next == null || root1.next.next == null) {
                break;
            }
            node = root;
            for (int i = 1; i < n; i++) {
                node = node.next;
            }
            ListNode temp = root1.next;
            root1.next = node.next;
            root1.next.next = temp;
            node.next = null;
            root1 = root1.next.next;
        }
        return root;
    }

    /**
     * 题号24.给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 示例1： 1->2->3->4, 你应该返回 2->1->4->3.
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        ListNode res = q;
        while(q != null){
            p.next = q.next;
            q.next = p;
            if(p.next == null||p.next.next == null){
                break;
            }
            ListNode temp = p.next;
            p.next = p.next.next;
            p = temp;
            q = temp.next;

        }
        return res;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public  ListNode stringToListNode(String input) {

        int[] nodeValues = stringToIntegerArray(input);

        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public  String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) {
        TransformL transformL = new TransformL();
        ListNode root = transformL.stringToListNode("[1,2,3,4,5,6]");
        ListNode res = transformL.transform1(root);
        System.out.println(transformL.listNodeToString(res));
        System.out.println(transformL.listNodeToString(transformL.swapPairs(root)));
    }
}
