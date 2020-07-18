package com.practice.P1_100.P1_10;

import com.practice.dataStructure.ListNode;

import java.util.Objects;

public class addTwoNums {
    /*
            2、两数之和
      给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
      并且它们的每个节点只能存储 一位 数字。如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
      您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

     */

    ListNode addTwoNumsSimple(ListNode l1, ListNode l2){

        ListNode res = new ListNode(0);
        ListNode cur = res;
        int carry = 0;

        while (Objects.nonNull(l1)||Objects.nonNull(l2)){
            int a = l1 == null?0:l1.val;
            int b = l2 == null?0:l2.val;

            cur.next = (new ListNode((a+b+carry)%10));
            carry = (a+b+carry)/10;

            cur = cur.next;

            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }

        }

        if (carry > 0){
            cur.next = new ListNode(carry);
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(2);
        addTwoNums a = new addTwoNums();
        System.out.println(a.addTwoNumsSimple(l1,l2).val+" "+a.addTwoNumsSimple(l1,l2).next.val);
    }
}
