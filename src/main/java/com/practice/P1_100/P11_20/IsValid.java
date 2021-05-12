package com.practice.P1_100.P11_20;

import java.util.Stack;

public class IsValid {
    /*
    NO.20 有效的括号
    给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。

    有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。

    示例 1:
    输入: "()"
    输出: true

    示例2:
    输入: "()[]{}"
    输出: true

    示例3:
    输入: "(]"
    输出: false

    示例4:
    输入: "([)]"
    输出: false

    示例5:
    输入: "{[]}"
    输出: true
     */
    Boolean solution(String s){
        if (s == null || s == "") return true;
        if (s.charAt(0)==')' || s.charAt(0)=='}' || s.charAt(0)==']' || s.length()%2 == 1) return false;
        if (s.charAt(s.length()-1)=='(' || s.charAt(s.length()-1)=='{' || s.charAt(s.length()-1)=='[')
            return false;

        Stack stack = new Stack();
        for(int i = 0;i < s.length();i++){

            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }

            if (s.charAt(i) == ')'){
                if (!stack.empty()&&(char)stack.pop() == '(') continue;
                return false;
            }

            if (s.charAt(i) == '}'){
                if (!stack.empty()&&(char)stack.pop() == '{') continue;
                return false;
            }

            if (s.charAt(i) == ']'){
                if (!stack.empty()&&(char)stack.pop() == '[') continue;
                return false;
            }

        }
        if (stack.empty()){
            return true;
        } else return false;
    }

    public static void main(String[] args) {
        IsValid i = new IsValid();
        i.solution("{{)}}");
        System.out.println(i.solution("()}}"));
    }
}
