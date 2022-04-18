package com.practice.P201_P300.P201_P210;

import com.practice.dataStructure.ListNode;

public class ReverseList {
    /*
    反转一个单链表。

    示例:
    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
    进阶:
    你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     */

    /**
    使用递归或迭代
    迭代：拿个temp节点，作为中间量存储，然后遍历头尾反转。
    注意边界case，[] [1,2]  [1]
     */
    public ListNode solution1(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;
        /*
        cur是当前要改变next的元素、pre是之前已经被反转的node，temp是存储的cur修改next之前的next，防止改了新的next之后旧的丢失
        循环：先temp保存的旧的next，cur的next指向pre（完成cur位的反转），将pre替换位cur（当前的cur已经被反转了，属于pre了），
        将cur替换为之前temp中保存的旧的下一位，直至循环结束，pre是反转后的第一位元素，也是之前的最后一个元素。
         */
        while (cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
    递归，将链表递归成last->cur->pre(null)，如果cur不是最后一个元素，那就递归至cur为止
    保证每一次操作，都是last->cur->pre三者的排列

    递归的要点：
    明确递归函数的定义；明确边界case
     */
    public ListNode solution2(ListNode head){
        if (head.next == null) {
            return head;
        }
        //注意head.next,而不是head自己
        ListNode last = solution2(head.next);
        //把当前位置的node的下一node的next指向自己，即4->5改为 4->5->4
        head.next.next = head;
        //把当前位的next清除。即 4->5->5 改为 4->null     5->4
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);

        ReverseList r = new ReverseList();

        ListNode res = r.solution1(node1);

        while (res.next != null){
            System.out.println(res.val);
            res = res.next;
        }
        System.out.println(res.val);

    }
}
