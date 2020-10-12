package com.shawf;

/**
 * @author shawf_lee
 * @date 2020/10/8 21:33
 *Content:
 */
public class TransformL {
    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
        }
    }

    /**
     * 链表： (a1 -> a2 -> a3 ->... -> an-1 -> an-1 -> an)变为(a1 -> an -> a2 -> an-1 -> a3 -> an-2...)
     * 示例1：(a1 -> a2 -> a3 -> a4 -> a5 -> a6)变为(a1 -> a6 -> a2 -> a5 -> a3 -> a4)
     * @param root
     * @return root
     */
    public Node transform1(Node root) {
        int n = 0;
        Node node = root;
        Node root1 = root;
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
            Node temp = root1.next;
            root1.next = node.next;
            root1.next.next = temp;
            node.next = null;
            root1 = root1.next.next;
        }
        return root;
    }

    public Node toNode(int n) {
        Node root = new Node(1);
        Node root1 = root;
        for (int i = 2; i <= n; i++) {
            root1.next = new Node(i);
            root1 = root1.next;
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new TransformL().toNode(6);
        Node res = new TransformL().transform1(root);
        while (res != null) {
            System.out.println(res.data);
            if (res.next == null) {
                res = null;
            } else {
                res = res.next;
            }
        }
    }
}
