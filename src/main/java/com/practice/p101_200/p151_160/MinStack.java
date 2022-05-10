package com.practice.p101_200.p151_160;

import java.util.Arrays;

/**
 * @Author: yyc
 * @Date: 2022/4/25 2:50 PM
 * @Description: LC 155 easy 最小栈
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 * 示例 1:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 提示：
 * -231<= val <= 231- 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push,pop,top, andgetMin最多被调用3 * 104次
 */
public class MinStack {
    int[] elements;
    int size;
    int min;
    int minCounts;
    // 或者使用优先队列维护最小值
//    PriorityQueue<Integer> minQueue = new PriorityQueue<>();PriorityQueue<>;
    private static final Integer DEFAULT_SIZE = 128;
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    public MinStack() {
        this.elements = new int[DEFAULT_SIZE];
        this.size = 0;
        this.min = Integer.MAX_VALUE;
        this.minCounts = 0;
    }

    public MinStack(int capacity) {
        this.elements = new int[capacity];
        this.size = 0;
        this.min = Integer.MAX_VALUE;
        this.minCounts = 0;
    }

    public void push(int val) {
        ensureCapacity();
        elements[size++] = val;
        if (val == min){
            minCounts++;
        }else if (val < min){
            min = val;
            minCounts = 1;
        }
    }

    public void pop() {
        int val = elements[--size];
        if (val == min && --minCounts == 0){
            min = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++){
                min = Math.min(elements[i], min);
            }
            minCounts = 1;
        }
    }

    public int top() {
        return elements[size - 1];
    }

    public int getMin() {
        return min;
    }

    private void ensureCapacity(){
        if (size >= elements.length - 1){
            // 注意要加括号，加法运算优先级大于位运算
            elements = Arrays.copyOf(elements, elements.length + (elements.length >> 1));
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        stack.pop();
        System.out.println(stack.getMin());
    }
}
