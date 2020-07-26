package com.practice.P1_100.P81_90;

import com.practice.dataStructure.ListNode;

public class deleteDuplicates2 {
    /*
    NO.82
    给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     */

    /**
     * 分析：
     * 跟83题的思路和要求都差不多，由于链表是已经排好顺序的，可以为我们剩下很多事情。
     * 第一思路：
     * 双指针（当前值指针、遍历指针）+标志位（是否重复）
     */
    ListNode solution(ListNode head){
        ListNode res = new ListNode(-1);
        ListNode cur = new ListNode();
        ListNode iter = new ListNode();
        int isdif = 0;
        while (head.next != null){
            cur = head;
            iter = head.next;
            if (cur.val == iter.val){
                head.next = iter.next;
                isdif = 1;
            }
            head = head.next;
        }


        return res;
    }
}
