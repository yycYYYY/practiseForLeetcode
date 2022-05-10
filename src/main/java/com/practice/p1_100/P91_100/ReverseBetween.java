package com.practice.p1_100.P91_100;

import com.practice.dataStructure.ListNode;
/**
 *
 *未完成
 92.反转链表
 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 示例1：
 输入：head = [1,2,3,4,5], left = 2, right = 4
 输出：[1,4,3,2,5]

 示例 2：
 输入：head = [5], left = 1, right = 1
 输出：[5]

 提示：
 链表中节点数目为 n
 1 <= n <= 500
 -500 <= Node.val <= 500
 1 <= left <= right <= n
 */
public class ReverseBetween {

    public ListNode solution(ListNode head, int left, int right){
        if (head == null || head.next == null){
            return head;
        }
        ListNode res = new ListNode(0, head);
        ListNode cur = head;
        ListNode pre = res;
        ListNode temp;

        for (int i = 0; i < left - 1; i++) {
            cur = cur.next;
            pre = pre.next;
        }

        /*
         * [1,2,3,4,5]   2, 4
         * pre指向不需要反转的最后一位（也就是数值1的位置），遍历反转链表时，每次都把需要反转的链表放到pre之后的第一位
         * cur永远指向node2，node2不断向后遍历，node2的next逐渐从3-》4 。。。。 不断的把node2也就是cur后面的元素挪到pre的next
         * 挪到最后，区间的反转就完成了
         */
        for (int i = 0; i < right - left; i++) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        ReverseBetween r = new ReverseBetween();

        ListNode res = r.solution(node1, 2, 4);

        while (res.next != null){
            System.out.println(res.val);
            res = res.next;
        }
        System.out.println(res.val);
    }
}
