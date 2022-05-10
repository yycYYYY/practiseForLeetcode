package com.practice.p1_100.P41_50;

import java.util.*;

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
     * 通过字符串排序比对的方法，来进行匹配。
     * solution1没毛病，但是效率低，跑case超时了
     * @param strs 不为空的字符串数组
     * @return res
     */
    public List<List<String>> solution1(String[] strs) {
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
                if (a.equals(strSort(strs[i]))){
                    res.get(j).add(strs[i]);
                    break;
                }else if (j == res.size() - 1){
                    tempRes = new ArrayList<>();
                    tempRes.add(strs[i]);
                    res.add(tempRes);
                    //注意这里一定要有一个break，因为，这上面res新加了一个tempRes，如果break，j循环会多循环一次，然后
                    //strs[i]会在44-45行里，多增加一次，导致出现重复元素
                    break;
                }
            }
        }

        return res;
    }
    //由于是值传递，并且返回的是新的String对象，不会对原数组中的对象造成影响
    String strSort(String str){
        char[] sortTemp = str.toCharArray();
        Arrays.sort(sortTemp);
        return new String(sortTemp);
    }

    /**
     *  题解中的方法更好，利用哈希表，效率高很多，我这个solution1就有点蠢了
     * @param strs 不为空的字符串数组
     * @return res
     */
    public List<List<String>> solution2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            // 这里利用排好序的str作为key，如果是异位词，那key肯定一样，getOrDefault方法是获取该key的value，
            // 如果map里没这个key，就返回一个default value，方法的第二个参数就是default value
            List<String> list  = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams g = new GroupAnagrams();
        System.out.println(g.solution2(strs));
    }
}
