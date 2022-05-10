package com.practice.p1_100.P21_30;

import com.practice.dataStructure.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKLists {
    /*
    NO.23
    合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     */

    /**
     * K指针法：
     * 在一个while循环中定义一个minNode最小节点中间变量，和一个minPoint最小变量位置，
     * 通过for循环遍历出首位的最小node，将cur当前指针指向本次for循环中最小node，
     * 然后在该node位置指向node.next，直到遍历完成。
     *
     * 时间复杂度：
     * 空间复杂度：
     */
    ListNode solution1(ListNode[] lists){
        int len = lists.length;
        ListNode res = new ListNode();
//        第一次写的错误为，忘记定义cur，minNode只是为了找到一轮循环中最小的node，不能当做迭代next指针的cur
        ListNode cur = res;

        while(true) {
//            这里也要注意，minNode必须定义在while循环体内，如果带有着上一次while循环的minNode，将会造成提早退出
//            循环的问题
            ListNode minNode = null;
            int minPoint = -1;//这个point定义在哪里比较好

            for (int i = 0; i < len; i++) {
                if (lists[i] == null) continue;

//                程序在这里暴露出一个错误，就是i的定位不准确的问题，在当前的实现方法内无论是<还是<=
//                都是不准确的
                if (minNode == null || lists[i].val <= minNode.val) {
                    minNode = lists[i];
                    minPoint = i;
                }
            }

            if (minPoint == -1) break;

            cur.next = minNode;
            cur = cur.next;
            lists[minPoint] = lists[minPoint].next;

        }
        return res.next;
    }

    /**
     *
     * 容器排序法：思路上最简单粗暴，把所有的值全都放在一个数组里，
     * 把数组排序后复原成链表
     */
    ListNode solution2(ListNode[] lists){
        List<Integer> valueArray = new ArrayList<>();
        for (int i = 0;i < lists.length;i++){

            while (lists[i] != null){

                valueArray.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        Collections.sort(valueArray);
        ListNode res = new ListNode();
        ListNode cur = res;
        for (int j = 0;j < valueArray.size();j++){
            cur.next = new ListNode(valueArray.get(j));
            cur = cur.next;
        }
        return res.next;
    }

    /**
     *
     * 基于双链表二并，迭代合并。
     * 在合并两条顺序链表的基础上，每两条合并一次。
     */
    ListNode solution3(ListNode[] lists){
        return null;
    }



    public static void main(String[] args) {
        MergeKLists m = new MergeKLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode[] ls = {l1,l2,l3};

//        m.solution1(ls);
        ListNode res = m.solution2(ls);
        while (res.next != null){
            System.out.println(res.val);
            res = res.next;
        }

    }
}
