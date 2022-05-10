package com.practice.p1_100.P81_90;

import com.practice.dataStructure.ListNode;

import java.util.HashMap;
import java.util.Map;

public class DeleteDuplicates {
    /*
    NO.83
    删除链表中重复的元素
    给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     */
    /**
     * 总结：
     * 对题干观察不仔细，排序链表，已经排序后的链表
     * 不在需要哈希表去查重，直接去昭和后一位的数值是否相等就可以
     * 相等就跳过当前的值
     */
    ListNode solution2(ListNode head){
        if (head == null) return head;

        ListNode res = head;

        while(head.next != null){
            if (head.val == head.next.val){
                head.next = head.next.next;
                continue;
            }
            head = head.next;
        }
        return res;
    }

    /**
     *  本题的思路比较简单，直接：
     *  对链表进行循环遍历，将每一位元素存到哈希表中，以LN的value当做Map中的key
     *  对每一位的元素进行遍历的同时，查询map中是否存在这个值，如果存在则删除这个与元素
     */
    ListNode solution(ListNode head){

        ListNode res = head;
        ListNode pre = new ListNode();
        Map<Integer,Integer> temp = new HashMap<>();

        while(head != null){
            if (temp.containsKey(head.val)){
                pre.next = head.next;
            }else {
                temp.put(head.val,1);
                pre = head;
            }
            head = head.next;
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(2);

        DeleteDuplicates d = new DeleteDuplicates();
        ListNode res = d.solution2(l1);

        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }


    }
}
