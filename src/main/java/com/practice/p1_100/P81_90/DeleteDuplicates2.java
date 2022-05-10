package com.practice.p1_100.P81_90;

import com.practice.dataStructure.ListNode;

import java.util.HashMap;
import java.util.Map;

public class DeleteDuplicates2 {
    /*
    NO.82
    给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     */

    /**
     * 由于自己的思路的不清晰，这道题越想越复杂，浅尝了网友的思路加上自己的不恰当运用，代码逻辑上搞得非常复杂，
     * 现在从头来看这道题。
     * 先回顾昨天的问题：
     * 1、不要盲目的追求并认可网友的方案和思路，保持独立思考，不要被别人答案影响自己的思路。
     * 2、在基本思路没达到完全正确（所有边界case）前，不要盲目追求最优解
     * 3、一开始就给出一个多个的思路切入点，不要抱着一条路啃两天
     * 4、基于第三条，不要被题干的提示或现有的信息或普通的正向思路，禁锢住思维。明确初始条件和最终输出
     *    至于实现逻辑和复杂度，是题解完全之前之后的事
     * 5、算法题和考试其实差不多，结果和过程同样重要，哪怕写出了满足所有case的sout作为答案，只要慢速所有case
     *    的预期，那它就是正确答案的一种。
     *
     *
     * 回到本题目，其实总的来看，解题思路有两种。
     * 1、找出所有重复的节点，把当前链表中重复的删掉
     * 2、找出所有不重复的点，再把不重复的按顺序拼接返回
     *
     * 对于思路1有三种实现，哈希表统计重复元素（用来实现思路二更简单）；快慢指针删除重复；递归删除列表内重复的元素（废弃，时空复杂都不是很优秀）
     * 对于思路二：哈希表最合适
     */
//   开满指针
     ListNode solution1(ListNode head){

         if (head == null || head.next == null) return head;
         ListNode res = new ListNode(-1);
         ListNode slow = res;
         ListNode fast = head;
         res.next = head;

         while (slow.next != null && fast.next != null){
             if (slow.next.val != fast.next.val){
                 fast = fast.next;
                 slow = slow.next;
             }else {
                 while (fast.next != null && slow.next.val == fast.next.val){
                     fast.next = fast.next.next;
                 }
                 slow.next = fast.next;
                 fast = fast.next;
             }
         }
         return res.next;
     }

//   思路二,思路上最简单
     ListNode solution2(ListNode head){

         if (head == null || head.next == null) return head;

         HashMap<Integer,Integer> nodes = new HashMap<>();
         ListNode res = new ListNode(-1);
         ListNode dummy = res;
         while (head != null){
             if (nodes.containsKey(head.val)){
                 nodes.put(head.val,(nodes.get(head.val) + 1));
                 head = head.next;
             }else {
                 nodes.put(head.val,1);
                 head = head.next;
             }
         }
         for (Map.Entry<Integer,Integer> entry:nodes.entrySet()){
             if (entry.getValue() == 1){
                 dummy.next = new ListNode(entry.getKey());
                 dummy = dummy.next;
             }
         }
         return res.next;
     }




    /*
     * 分析：
     * 跟83题的思路和要求都差不多，由于链表是已经排好顺序的，可以为我们剩下很多事情。
     * 第一思路：
     * 双指针（当前值指针、遍历指针）+标志位（是否重复）
     * 错的要命，思路复杂的要命，solution12自己想的都是垃圾。还是答案靠谱
     *
     * 这个题是一个很精巧的题，如果只是考虑着当前指针内的值，进行比较然后在移动指针，很难控制头指针和
     * 遍历到最后时的最后一个指针。
     * 如果采用当前指针的next的值，就能很好的控制了哨兵指针的next和最后一位指针的判定！！！！
     * 还有就是一定要利用好当前链表已经排序
     */
    public static void main(String[] args) {
        DeleteDuplicates2 d = new DeleteDuplicates2();
        ListNode l = new ListNode(1);
        l.next = new ListNode(1);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(3);
        l.next.next.next.next= new ListNode(3);
        ListNode res = d.solution1(l);
        while (res != null){

            System.out.println(res.val);
            res = res.next;
        }
    }
}
