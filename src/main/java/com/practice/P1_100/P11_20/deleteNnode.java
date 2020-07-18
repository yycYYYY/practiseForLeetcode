package com.practice.P1_100.P11_20;

import com.practice.dataStructure.ListNode;

import java.util.Objects;
import java.util.Stack;

public class deleteNnode {
    /*
    NO.19
    给定一个链表，删除链表的倒数第n个节点，并返回链表的头节点。
    默认给定的n是有效的
     */


    /**
     * 思路一：
     *  1、保存头节点，把链表压入栈内
     *  2、然后再弹栈，弹到第n-1个保存到中间变量；
     *  3、弹到第n个，删除（不管了），弹到第n+1个，改变其next指向中间变量内的节点
     *  4、返回头节点
     *
     *  优点：
     *  思路简单
     *  缺点：
     *  1、需要额外的存储空间
     *  2、最慢需要遍历两边链表
     */
    ListNode solution1(ListNode l,int N){
        //边界输入判定
        if (l.next == null){
            return null;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode cur = new ListNode();

        while (Objects.nonNull(l.next)){
            stack.push(l);
            l = l.next;
        }
        for (int a = 0;a < N;a++){
            cur = stack.pop();
        }
         stack.pop();
        cur.next = stack.pop();

        return l;
    }

    /**
     * 思路二：
     *      双指针法
     *      1、保存头节点，设立一个pre指针，从头节点开始往后走n个节点
     *      2、设立cur指针，指向头节点
     *      3、cur指针，跟着pre指针一起，往后走（向后遍历）
     *      4、当pre到头后，改变cur指针的next指向。（如果cur指向a，next就指向a+1）
     *      5、返回头节点
     */
    ListNode solution2(ListNode l,int N){
        ListNode pre = l;

        ListNode cur = l;
        for (int a = 0;a < N;a++){
            pre = pre.next;
        }

        //注意这里需要对ListNode的边界输入做判定，即如果输入的链表只有一个节点，应返回为空

        if (pre == null){
            return null;
        }

        while (Objects.nonNull(pre.next)){
            pre = pre.next;
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return l;
    }
}
