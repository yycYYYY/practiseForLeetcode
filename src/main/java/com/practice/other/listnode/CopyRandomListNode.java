package com.practice.other.listnode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: yyc
 * @Date: 2022/4/18 5:16 PM
 * @Description: 链表扩展题：拷贝含有随机指针的单链表
 * 对于普通的单链表node（int val; ListNode next） 增加一个成员变量 List random，指向任意一个节点，可能是null
 * 现给定一个这样的无环单链表，要求开辟一个新内存，复制出这个链表，并返回其节点
 *
 * 要求：
 * 时间复杂度O[N]
 * 额外空间复杂度 O[1]
 */
public class CopyRandomListNode {

    /**
     * 哈希表法
     */
    public RandomListNode solution1(RandomListNode node){
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode head = new RandomListNode(0);
        head.next = node;
        // 第一轮只拷贝val
        while (node != null){
            map.put(node, new RandomListNode(node.val, node.next, node.random));
            node = node.next;
        }

        node = head.next;

        // 为拷贝后的链表重新赋值next和random
        while (node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head.next);
    }

    /**
     * 指针移位
     * 原链表: 1-> 2 -> 3 -> null 拷贝成新链表 1 -> 1^ -> 2 -> 2^ -> 3 -> 3^ -> null
     * 已知拷贝的链表元素，一定在原链表元素后方，所以二轮拷贝random指针： copiedNode.random = node.random.next
     */
    public RandomListNode solution2(RandomListNode node){
        RandomListNode head = new RandomListNode(0);
        RandomListNode copiedNode;
        head.next = node;

        // 原链表: 1-> 2 -> 3 -> null 拷贝成新链表 1 -> 1^ -> 2 -> 2^ -> 3 -> 3^ -> null
        while (node != null){
            copiedNode = new RandomListNode(node.val);
            copiedNode.next = node.next;
            node.next = copiedNode;
            node = copiedNode.next;
        }
        // 重置指针至 1
        node = head.next;
        // 拷贝随机指针
        while (node != null){
            copiedNode = node.next;
            copiedNode.random = node.random.next;
            node = copiedNode.next;
        }
        // head.next指向1^ (1的copiedNode)
        head = head.next;
        // 重置其实指针至1^
        copiedNode = head.next;
        // 去掉1 -> 1^ -> 2 -> 2^ -> 3 -> 3^ -> null中的原链表元素
        while (copiedNode != null && copiedNode.next != null){
            copiedNode.next = copiedNode.next.next;
            copiedNode = copiedNode.next;
        }

        return head.next;
    }

    static class RandomListNode{
        int val;
        RandomListNode next;
        RandomListNode random;

        public RandomListNode(int val){
            this.val = val;
        }

        public RandomListNode(int val, RandomListNode next, RandomListNode random){
            this.val = val;
            this.next = next;
            this.random = random;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RandomListNode that = (RandomListNode) o;
            return val == that.val && Objects.equals(next, that.next) && Objects.equals(random, that.random);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next, random);
        }
    }
}
