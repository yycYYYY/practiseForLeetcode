package com.practice.p1_100.P21_30;

import com.practice.dataStructure.ListNode;

public class SwapPairs {
    /*
    NO.24

        如同合并两个有序链表一样，本题也有递归，迭代两个解法，递归需要占用更多的栈空间
    空间复杂度更高
     */


    ListNode solution(ListNode ln){

        if (ln == null || ln.next == null) return ln;

        ListNode res = new ListNode(-1);
        ListNode pre = new ListNode();
        
        res.next = ln.next;
        while (ln != null&&ln.next != null){
            ListNode firstNode = ln;
            ListNode secondNode = ln.next;

            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            ln = secondNode;

            pre.next = ln;
            ln = ln.next.next;
            pre = firstNode;

        }
        return res.next;
    }
}
