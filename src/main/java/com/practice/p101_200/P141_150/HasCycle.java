package com.practice.p101_200.P141_150;

import com.practice.dataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yyc
 * @Date: 2022/4/6 7:20 PM
 * @Description: lc 141 easy 判断链表是否有环
 *
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class HasCycle {

    /*
    注： 如何找到有环单链表的入环节点？
    先通过快慢指针（起始点出发，一个走一步一个走两步）找到环内的相遇节点；
    找到相遇节点后，开两个指针，一个指向起始点，一个指向相遇节点，依次向后单步遍历，两者再次相遇的节点就是入环节点。但是应该怎么证明？？？
     */

    /**
     * 快慢指针法
     * 一块一慢，如果相遇，就有环，不相遇就没环
     * 由于一块一慢，如果有环就一定会相遇，因为两者会不停的在环里循环跑
     * 时间复杂度:N；空间复杂度:1
     */
    public boolean solution1(ListNode head) {
        if (head == null || head.next == null || head.next.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null){
            slow = slow.next;
            fast = fast.next == null? head : fast.next;
            fast = fast.next == null? head : fast.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

    /**
     * 快慢指针判断是否有环，如果有环，返回入环节点
     * 先通过快慢指针（起始点出发，一个走一步一个走两步）找到环内的相遇节点
     * 找到相遇节点后，开两个指针，一个指向起始点，一个指向相遇节点，依次向后单步遍历，两者再次相遇的节点就是入环节点
     */
    public ListNode solutionReturnNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        ListNode root = head;
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null){
            slow = slow.next;
            fast = fast.next == null? head : fast.next;
            fast = fast.next == null? head : fast.next;
            if (slow == fast){
                break;
            }
        }
        while (root.next != slow.next){
            root = root.next;
            slow = slow.next;
        }
        return root;
    }

    /**
     * hash表法，时空复杂度都是N
     * 但是不一定比快慢指针法慢，例如环之前的链很短，但这个环非常长（环内的元素特别多），此时hash表的时空复杂度就是优于快慢指针法的
     */
    public boolean solution2(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        Set<ListNode> exists = new HashSet<>();
        while (head != null){
            if (exists.contains(head)){
                return true;
            }
            exists.add(head);
            head = head.next;
        }
        return false;
    }
}
