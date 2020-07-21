package com.practice.P1_100.P21_30;

import com.practice.dataStructure.ListNode;

public class swapPairs {
//    如同合并两个有序链表一样，本题也有递归，迭代两个解法，递归需要占用更多的栈空间
//    空间复杂度更高

    ListNode solution(ListNode ln){

        ListNode res = new ListNode(-1);
        res.next = ln;
        ListNode cur = res;

        while (ln.next != null&&ln.next.next != null){
            ListNode firstNode = ln.next;
            ListNode secondNode = ln.next.next;

            secondNode.next = firstNode;
            cur.next = firstNode;

        }
        return null;
    }
}
