package com.practice.P1_100.P21_30;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class generateParenthesis {
    /*
    NO.22 生成括号
    数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

    示例：
    输入：n = 3
    输出：[
           "((()))",
           "(()())",
           "(())()",
           "()(())",
           "()()()"
         ]
     */
    /*
    应该也是回溯
    n为1时候，只有()
    n为2时候，可以在1的结果集基础上，（）内部插入一对括号（（））。或者在1的）后面插入一对，（）（）
    n为3时候，可以在2的结果集基础上，(()),第一个）前面加一对括号((())),或者在第二个）后面加一堆括号(()())
                                ()(),在第一个）前面加一堆括号(())(),或者在第二个）前面加一对括号()(())
     */
    List<String> solution(int n){
        List<String> res = new ArrayList<>();
        if (n == 1) return new ArrayList<String>(){{add("()");}};
        if (n > 1){
            List<String> temp = solution(n-1);
            Iterator iterator = temp.iterator();
            while (iterator.hasNext()){
                String tempStr = (String) iterator.next();
                for (int i = 0; i < tempStr.length();i++){
                    if (tempStr.charAt(i) == ')' && tempStr.charAt(i-1) == '('){
                        res.add(new StringBuilder(tempStr).insert(i,"()").toString());
                        res.add(new StringBuilder(tempStr).insert(i+1,"()").toString());
                    }
//                    这里需要一个去重操作，如果是两个））连续的，就不能前后都插入（）了，都插入会造成重复
                    else if (tempStr.charAt(i) == ')' && tempStr.charAt(i-1) == '('){
                        res.add(new StringBuilder(tempStr).insert(i+1,"()").toString());
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        generateParenthesis g = new generateParenthesis();
        System.out.println(g.solution(3));
    }
}
