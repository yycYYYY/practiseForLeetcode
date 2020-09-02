package com.practice.P1_100.P11_20;

import java.util.Stack;

public class isValid {
    /*
    NO.20 有效的括号
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。

    示例 1:
    输入: "()"
    输出: true

    示例 2:
    输入: "()[]{}"
    输出: true

    示例 3:
    输入: "(]"
    输出: false

    示例 4:
    输入: "([)]"
    输出: false

    示例 5:
    输入: "{[]}"
    输出: true
     */
    Boolean solution(String s){
        if (s == null || s == "") return true;
        if (s.charAt(0)==')' || s.charAt(0)=='}' || s.charAt(0)==']' || s.length()%2 == 0) return false;
        if (s.charAt(s.length()-1)=='(' || s.charAt(s.length()-1)=='{' || s.charAt(s.length()-1)=='[')
            return false;

        Stack stack = new Stack();
        char pre = 'a';
        char cur = pre;
        for (int i = 0;i < s.length()-1;i++){
            stack.push(s.charAt(i));
        }
        while (!stack.empty()){
            pre = (char) stack.pop();
            cur = (char) stack.pop();
            String temp = pre + cur + "";
            if (temp == "()"||temp == "{}"||temp == "[]") continue;
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        isValid i = new isValid();
        System.out.println(i.solution("(())"));
    }
}
