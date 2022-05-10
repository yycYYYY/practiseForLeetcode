package com.practice.p201_P300.p231_240;

import com.practice.dataStructure.ListNode;

/**
 * @Author: yyc
 * @Date: 2022/4/14 7:14 PM
 * @Description: lc 234 easy 回文链表
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2:
 * 输入：head = [1,2]
 * 输出：false
 *
 * 提示：
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 *
 * 进阶：你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class IsPalindrome {

    /**
     * 最简单的思路，通过递归复制一份原链表，将链表反转得到新链表，然后再比对值是否一样，不一样则false
     * 时间复杂度n，空间复杂度也是n
     */
    public boolean solution1(ListNode head) {
        if(head.next == null){
            return true;
        }
        ListNode temp;
        while(head.next != null && head.val != head.next.val){

        }
        return false;
    }

    /**
     * 要求让空间复杂度是1，也好办，快慢指针。慢指针翻转链表，快指针找尽头，2倍速快指针到尽头的时候，慢指针刚好到中点。
     * 然后再中点两侧开始遍历对比，如果遍历到头都相等，那就是回文的
     */
    public boolean solution2(ListNode head) {
        if(head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowAhead = null;
        ListNode slowNext = slow.next;
        ListNode frontPartPoint;
        ListNode behindPartPoint;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow.next = slowAhead;
            slowAhead = slow;
            slow = slowNext;
            slowNext = slow.next;
        }
        if (fast.next == null){
            frontPartPoint = slowAhead;
            behindPartPoint = slow.next;
        }else {
            frontPartPoint = slow;
            // 注意此处要处理指针，因为此时当前指针还没有翻转
            frontPartPoint.next = slowAhead;
            behindPartPoint = slowNext;
        }

        while (behindPartPoint != null && frontPartPoint != null){
            if (behindPartPoint.val != frontPartPoint.val){
                return false;
            }
            behindPartPoint = behindPartPoint.next;
            frontPartPoint = frontPartPoint.next;
        }

        return behindPartPoint == null && frontPartPoint == null;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
        System.out.println(isPalindrome.solution2(node1));
    }
}
