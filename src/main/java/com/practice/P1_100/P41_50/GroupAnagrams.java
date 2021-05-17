package com.practice.P1_100.P41_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * NO.49 字母异位词分组
 * 定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * @Author yuyongchao
 **/
public class GroupAnagrams {
    /**
     * 通过哈希表或者字符串排序的方法，来进行匹配。
     * @param strs
     * @return
     */
    public List<List<String>> solution(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        List<String> tempRes = new ArrayList<>();
        if (strs == null || strs.length == 0){
            return res;
        }

        tempRes.add(strs[0]);
        res.add(tempRes);

        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < res.size(); j++) {
                String a = strSort(res.get(j).get(0));
                if (a == strSort(strs[i])){
                    res.get(j).add(strs[i]);
                }
            }
        }

        return res;
    }

    String strSort(String str){
        char[] sortTemp = str.toCharArray();
        Arrays.sort(sortTemp);
        return new String(sortTemp);
    }
}
