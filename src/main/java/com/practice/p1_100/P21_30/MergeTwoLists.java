package com.practice.p1_100.P21_30;

import com.practice.dataStructure.ListNode;

public class MergeTwoLists {
    /*
    NO.21
    合并两个有序链表
    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */

    /**
     *
     * 指针法，比递归法更省空间
     */
    ListNode solution1(ListNode l1,ListNode l2){

        if (l1 == null) return l2;

        if (l2 == null) return l1;

        ListNode pre = new ListNode();
//        这里错误了，为什么错误了，有时间想下
//        while (l1.next != null&&l2.next !=null){
        while (l1 != null&&l2 !=null){

            if (l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 =l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null?l2:l1;
        return pre.next;
    }

    /*
     * 递归法，思路简单，相对于指针法浪费空间和时间
     */
}
