package com.practice.dataStructure;

import java.util.Objects;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }

    public ListNode() {

    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        if (Objects.isNull(next)) return null;
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
