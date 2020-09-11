package com.practice.P1_100.P21_30;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenerateParenthesis {
    /*
    这个题目刷几道DFS和回溯之后，要好好的反复多看几遍，被坑惨了！！！
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

    在这个解题思路里，对于结果集的去重，十分的麻烦，没有想出特别好的办法，如果再手动去去重，复杂度太高了，放弃，还是看答案吧
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

    /*
    看了答案，不知道这该算是回溯，还是该算是二叉树的深度遍历DFS
    用DFS思路对题的理解是这样的，有效的括号里n也就是有n个‘(’，也有n个‘)’
    那我们可以从空字符串“ ”开始，每次往里填一个括号（或者），每次遍历都拿上一层的结果集去增加一个括号（或者）
    填充时，对二叉树的分支，做一下过滤，）右括号数量多于（左括号时，这个分支被废弃，他一定不是“有效的括号”
    直到n个(和n个）都被我们所填充完毕，所剩下的二叉树最底层节点，就是我们所要的结果集。

     */
    List<String> solution2(int n){
        List<String> res = new ArrayList();
        dfs_gp(res,n,n,"");
        return res;
    }

    //注意此处src不能使用StringBuilder，否则，下面调用两次dfs_gp时会出问题，想要不出问题，需要做一下逻辑判断
    void dfs_gp(List<String> res, int left, int right, String src){
        if (left == 0 && right == 0){
            res.add(src.toString());
            return;
        }
        if (left < 0) {
            return ;
        }

        if (left > right) return ;
//        用StringBuilder这里会出问题
        dfs_gp(res,left-1,right,src+"(");
        dfs_gp(res,left,right-1,src+")");
    }



    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        g.solution2(2);
        System.out.println(g.solution2(2));
    }
}
