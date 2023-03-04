package com.practice.p101_200.P141_150;

import java.util.*;

/**
 *
 * 非常多的边界，很容易就空指针！！！！
 *
 * @Author: yyc
 * @Date: 2022/5/17 11:05 上午
 * @Description: lc mid 146 LRU缓存
 * 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；
 * 如果不存在，则向缓存中插入该组key-value 。如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 示例：
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
 * 提示：
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 *
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache {

    class LinkedNode{
        int key;
        int val;
        LinkedNode pre;
        LinkedNode next;
        public LinkedNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, LinkedNode> map;
    int capacity;
    LinkedNode head;
    LinkedNode tail;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        new LinkedHashMap<>(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {

        LinkedNode res = map.get(key);
        if (res != null){
            moveLatestElementToTail(res);
            return res.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        LinkedNode cur = map.get(key);

        if (cur == null){
            cur = new LinkedNode(key, value);
            addNewElement(cur);
        }else {
            cur.val = value;
            moveLatestElementToTail(cur);
        }
        map.put(key, cur);
    }

    private void addNewElement(LinkedNode cur){
        // 超出容量，移除最久未操作元素
        if (map.size() == capacity){
            removeOldestElement();
        }

        // 如果容器内是空的
        if (tail == null){
            tail = cur;
            head = cur;
            return;
        }

        tail.next = cur;
        cur.pre = tail;
        tail = tail.next;
    }

    private void moveLatestElementToTail(LinkedNode cur){

        if (cur == tail){
            return;
        }

        if (cur == head){
            head = head.next;
        }else {
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
        }
        tail.next = cur;
        cur.pre = tail;
        cur.next = null;
        tail = tail.next;
    }

    private void removeOldestElement(){
        map.remove(head.key);
        // 删除最久未使用过的元素
        if (head.next == null){
            head = null;
            tail = null;
        }else {
            head = head.next;
            head.pre = null;
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        lRUCache.put(12, 1);
//        System.out.println(lRUCache.get(2));
//        synchronized (lRUCache){
//            lRUCache.wait();
//        }
//        lRUCache.put(15, 11);
//        lRUCache.put(5, 2);
//        lRUCache.put(1, 15);
//        lRUCache.put(4, 2);
//        System.out.println(lRUCache.get(5));
//        lRUCache.put(15, 15);        LRUCache lRUCache = new LRUCache(1);


//        lRUCache.put(4, 4);
//        System.out.println(lRUCache.get(1));
//        System.out.println(lRUCache.get(3));
//        System.out.println(lRUCache.get(4));
    }
}
