package com.practice.other;

import com.practice.dataStructure.ListNode;

/**
 * @Author: yyc
 * @Date: 2022/4/18 4:36 PM
 * @Description: 链表扩展题
 * 给定一个单链表头结点head，节点的值为int，在给定一个具体的值pivot。实习哪一个调整链表的函数
 * 链表左侧都是小于pivot的节点，中间部分都是等于pivot的节点，右侧都是大于pivot的节点
 * 进阶要求：
 * 小于等于大于三段内的节点，相对位置同调整前一致
 * 时间复杂度O[N]，空间复杂度O[1]
 */
public class ListNodeExtend {

    public ListNode solutionEasy(ListNode node, int pivot){
        if (node == null || node.next == null){
            return node;
        }
        ListNode sH = null;
        ListNode sL = null;
        ListNode eH = null;
        ListNode eL = null;
        ListNode mH = null;
        ListNode mL = null;
        ListNode next;

        while (node != null){
            next = node.next;
            node.next = null;
            // 节点值小于pivot
            if (node.val > pivot){
                if (sH == null){
                    sH = node;
                    sL = node;
                }else {
                    sL.next = node;
                    sL = sL.next;
                }
                // 节点值等于 pivot
            }else if (node.val == pivot){

                if (eH == null){
                    eH = node;
                    eL = node;
                }else {
                    eL.next = node;
                    eL = eL.next;
                }
                // 节点值大于pivot
            }else {

                if (mH == null){
                    mH = node;
                    mL = node;
                }else {
                    mL.next = node;
                    mL = mL.next;
                }
            }
            node = next;
        }

        if (sL != null){
            sL.next = eH;
            eL = eL == null ? sL : eL;
        }

        if (eL != null){
            eL.next = mH;
        }

        return sH != null ? sH : ( eH != null ? eH : mH);
    }

}
