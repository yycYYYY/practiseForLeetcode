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
     * 错的要命，思路复杂的要命，solution12自己想的都是垃圾。还是答案靠谱
     *
     * 这个题是一个很精巧的题，如果只是考虑着当前指针内的值，进行比较然后在移动指针，很难控制头指针和
     * 遍历到最后时的最后一个指针。
     * 如果采用当前指针的next的值，就能很好的控制了哨兵指针的next和最后一位指针的判定！！！！
     * 还有就是一定要利用好当前链表已经
     */

    ListNode solution3(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;
        ListNode cur = head;

        while (cur != null && cur.next != null){
            if (pre.next.val != cur.next.val){
                pre = pre.next;
                cur = cur.next;
            }else {
                while (pre.next.val == cur.next.val)
                    cur = cur.next;
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return res.next;
    }



    ListNode solution1 (ListNode head){
        ListNode res = null;
        ListNode pre = head;
        ListNode cur = head.next;
        int isDif = 1;
        if (cur == null) return head;

        while (cur != null){
            if (cur.val == pre.val){
                isDif = 0;
                cur = cur.next;
                pre.next = cur;
                continue;
            }else {
                if (isDif == 1) res = (res == null)?pre:res;
                cur = cur.next;
                pre = pre.next;
                isDif = 1;
            }
        }
        return res;
    }

    ListNode solution2(ListNode head){
        ListNode pre = new ListNode(-1);
        ListNode cur = head;
        ListNode aft = head.next;
        int isDif = 1;
        while(true){
            if (cur.val == aft.val){
                isDif = 0;
                aft = aft.next;
                cur.next = aft;
                continue;
            }else {
                if (isDif == 0) pre.next = cur.next;
                if (isDif == 1) pre = pre.next;
                cur = cur.next;
                aft = aft.next;
                isDif = 1;
            }
        }
    }
}
