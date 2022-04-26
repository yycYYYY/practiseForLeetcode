package com.practice.P101_200.p151_160;

import com.practice.P101_200.P141_150.HasCycle;
import com.practice.dataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yyc
 * @Date: 2022/4/19 11:52 AM
 * @Description: lc 160 easy 相交链表
 *
 * 你两个单链表的头节点headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * 自定义评测：
 * 评测系统 的输入如下（你设计的程序 不适用 此输入）：
 * intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
 * listA - 第一个链表
 * listB - 第二个链表
 * skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
 * skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
 * 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
 *
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 示例2：
 * 输入：intersectVal= 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [1,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 * 示例3：
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 *
 * 提示：
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 1 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]
 *
 * 进阶：你能否设计一个时间复杂度 O(m + n) 、仅用 O(1) 内存的解决方案？
 */
public class GetIntersectionNode {
    /*
    注： 如何找到有环单链表的入环节点？
    先通过快慢指针（起始点出发，一个走一步一个走两步）找到环内的相遇节点；
    找到相遇节点后，开两个指针，一个指向起始点，一个指向相遇节点，依次向后单步遍历，两者再次相遇的节点就是入环节点。但是应该怎么证明？？？
     */

    /**
     * lc原题中，题中保证了两个链表本身无环，所以可以1连2，然后判断是否有环，有环必相交
     * 但是如果采用两个链表连接成一个链表，判断有没有环的话
     *
     * 也采用另外一个方法
     * 求出两个链表的长度及最后一个节点，如果最后一个节点是相同的，说明两个链表相交，
     * 然后再让长的链表指针从头往后先走len(long) - len(short)步，然后长短链表指针一起向后移动，判断两者next是否相同，第一个相同的next就是
     * 第一个相交节点
     */
    public ListNode solutionLc(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        // 这里的len1len2可以优化成一个变量diff，遍历第一个链表时，diff++,遍历第二个链表时diff--，然后根据diff正负判断谁长
        int len1 = 0;
        int len2 = 0;
        ListNode node1= headA;
        ListNode node2 = headB;
        ListNode longList;
        ListNode shortList;

        while (headA.next != null){
            len1++;
            headA = headA.next;
        }
        while (headB.next != null){
            len2++;
            headB = headB.next;
        }
        if (headA != headB){
            return null;
        }
        longList = len1 > len2 ? node1 : node2;
        shortList = longList == node1 ? node2 : node1;

        int diff = Math.abs(len1 - len2);
        while (diff-- > 0){
            longList = longList.next;
        }
        while (longList != shortList){
            longList = longList.next;
            shortList = shortList.next;
        }
        return longList;
    }

    public ListNode optimizedSolution(ListNode headA, ListNode headB){
        if (headA == null || headB == null){
            return null;
        }
        int diff = 0;

        ListNode node1= headA;
        ListNode node2 = headB;
        ListNode longList;
        ListNode shortList;
        while (headA.next != null){
            diff++;
            headA = headA.next;
        }

        while (headB.next != null){
            diff--;
            headB = headB.next;
        }
        if (headA != headB){
            return null;
        }

        longList = diff > 0 ? node1 : node2;
        shortList = longList == node1 ? node2 : node1;
        diff = Math.abs(diff);
        while (diff-- > 0){
            longList = longList.next;
        }
        while (longList != shortList){
            longList = longList.next;
            shortList = shortList.next;
        }
        return longList;
    }

    /**
     * 两个链表无环的前提下，也可以使用哈希表法，但是会使用额外的空间
     */
    public ListNode solution(ListNode headA, ListNode headB){
        if (headA == null || headB == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headA != null){
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null){
            if (set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    /**
     * 左神题目中，可能有环也可能无环
     * 第一种，两个链表都无环，上方已经给出求解
     * 第二种，一个有环，一个无环，由于链表的性质，这样的两个链表不可能相交，只需要给个if就可以
     * 第三种，两个都有环，两种都有环的情况，又分为三种
     * 3.1 两个都有环，但是也都没相交，各自成环
     * 3.2 两个都有环，且入环节点一样，证明两者相交位置在入环节点或入环节点之前，此时我们可以把这两个链表看成两个无环链表，链表的终点就是
     *     入环的节点，逻辑复用上方无环求解方式
     * 3.3 两者有环，且相交节点在环内，不是同一个节点。此时如何判断，3.3和3.1的区别，怎么知道，两个链表在环内部有没有相交？
     *     答案是已知两个入环节点，节点1不动，节点2依次遍历到自己为止，遍历一周，如果节点2能遇到节点1，证明两链表相交是3.3的情况，
     *     返回两个节点任意一个节点就可以；如果不能遇见，证明两链表是3.1的情况
     */
    public ListNode solutionZuo(ListNode headA, ListNode headB) {
        HasCycle hasCycle = new HasCycle();
        ListNode loop1 = hasCycle.solutionReturnNode(headA);
        ListNode loop2 = hasCycle.solutionReturnNode(headB);

        // 如果两个都没环，使用上面的题解
        if (loop1 == null && loop2 == null){
            return optimizedSolution(headA, headB);
        }

        // 如果两个都有环，一个不动，另一个环内遍历，能相遇，证明两者相交
        if (loop1 != null && loop2 != null){
            ListNode start = loop1;
            loop1 = loop1.next;
            while (loop1 != start){
                if (loop1 == loop2){
                    return loop2;
                }
                loop1 = loop1.next;
            }
        }

        // 如果是其他情况，也就是一个有环一个没环，那么两个链表不可能相交
        return null;
    }
}
