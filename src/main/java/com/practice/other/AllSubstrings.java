package com.practice.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: yyc
 * @Date: 2022/4/26 5:16 PM
 * @Description: 求一个字符串的所有子串，包括null
 * 给定abc，返回呢list: abc ab ac bc a b c null
 *
 */
public class AllSubstrings {

    /**
     * 把str做成一个二叉树，每个分支就是下一个字符是否拼装到字符串里，添加则左树，不要则右树
     * 例如
     *                          要c
     *                  要b
     *          要a             不要c
     *                          要c
     *                  不要b
     *                          不要c
     * null
     *                          要C
     *                  要b
     *          不要a            不要c
     *                          要c
     *                  不要b
     *                          不要c
     * 上面的树，深度遍历后得到子集
     * @param str
     * @return
     */
    public List<String> solution(String str){
        List<String> res = new ArrayList<>();
        return res;
    }

    private void process(int i, char[] str, List<Character> res){
        if (i == str.length){
            // 遍历到底了，添加结果
            return;
        }
        // 递归左树，添加下一个字符
        List<Character> addNextList = copyList(res);
        addNextList.add(str[i]);
        process(i + 1, str, addNextList);

        // 递归右树，不要下一个字符
        List<Character> notNextList = copyList(res);
        process(i + 1, str, notNextList);

    }

    private List<Character> copyList(List<Character> characters){
        return Collections.emptyList();
    }


}
