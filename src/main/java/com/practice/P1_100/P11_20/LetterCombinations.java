package com.practice.P1_100.P11_20;

import java.util.*;

public class LetterCombinations {
    /*
    NO.17 电话号码的字母组合
    给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。
    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

    示例:
    输入："23"
    输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */

    //错了，整体思路对，对题的细节要求，错了 做了一些不必要的工作
    List<String> solution(String digits){
        List<String> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        Map<Integer,String> mapping = new HashMap<Integer, String>(){
            {
                put(0,"");
                put(1,"");
                put(2,"abc");
                put(3,"def");
                put(4,"ghi");
                put(5,"jkl");
                put(6,"mno");
                put(7,"pqrs");
                put(8,"tuv");
                put(9,"wxyz");
            }
        };

        Set<Integer> nums = new HashSet<>();
        for (int i = 0;i < digits.length();i++){

                nums.add(digits.charAt(i)-'0');

        }

        for (Integer num:nums) {
            res = new ArrayList<>();
            for (int j = 0;j < mapping.get(num).length();j++){
                if (temp.isEmpty()){
                    res.add(mapping.get(num).charAt(j)+"");
                }else {
                    for (String b:temp){
                        res.add(b+mapping.get(num).charAt(j));
                    }
                }
            }
            temp = res;
        }

        return res;
    }


    /*
    回溯
    遍历digits的每一位数字，每遍历一次得到一个结果集，下一次遍历基于上一次的结果集，添加结果
    每次循环，res都new一个新对象（清空上一个结果），在上一个结果集temp的基础上，对结果集中每一个元素，增加新数字的字符，生成新的结果集
    用temp保存结果集，为下一次生成res做数据准备
     */
    List<String> solution2(String digits){
        List<String> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        Map<Integer,String> mapping = new HashMap<Integer, String>(){
            {
                put(2,"abc");
                put(3,"def");
                put(4,"ghi");
                put(5,"jkl");
                put(6,"mno");
                put(7,"pqrs");
                put(8,"tuv");
                put(9,"wxyz");
            }
        };
        for (int i = 0;i< digits.length();i++) {
            int num = digits.charAt(i)-'0';
            if (num == 0||num ==1) continue;
            res = new ArrayList<>();
            for (int j = 0;j < mapping.get(num).length();j++){
                if (temp.isEmpty()){
                    res.add(mapping.get(num).charAt(j)+"");
                }else {
                    for (String b:temp){
                        res.add(b+mapping.get(num).charAt(j));
                    }
                }
            }
            temp = res;
        }

        return res;
    }
    public static void main(String[] args) {
        LetterCombinations l = new LetterCombinations();
//        l.solution("23");
        System.out.println(l.solution2("230"));

    }
}
