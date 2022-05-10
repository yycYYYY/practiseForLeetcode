package com.practice.p1_100.P41_50;

import java.util.*;

/**
 * 剑指offer，38和NO47基本一样，多了一些字符串操作啥的
 */
public class Permutation {
    public String[] solution(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return (String[])res.toArray(new String[0]);
        }
        int length = s.length();
        Deque<Character> path = new LinkedList();
        boolean[] used = new boolean[length];

        char[] c = s.toCharArray();
        Arrays.sort(c);
        dfs(c, 0, length, path, used, res);

        return res.toArray(new String[0]);
    }

    public void dfs(char[] c, int depth, int length, Deque<Character> path, boolean[] used, List res){
        if(depth == length){
            StringBuilder resStr = new StringBuilder();
            for (char n:path){
                resStr.append(n);
            }
            res.add(new String(resStr));
            return;
        }

        for(int i = 0;i < length;i++){
            if(i > 0 && c[i] == c[i - 1] && !used[i - 1]){
                continue;
            }
            if(!used[i]){
                path.addLast(c[i]);
                used[i] = true;
                dfs(c, depth + 1, length, path, used, res);
                path.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
//        char[] c = {'a','b'};
//        String s = String.valueOf(c);
//
//        Deque<Character> re = new LinkedList<>();
//        re.addLast('a');
//        re.addLast('b');
//        re.addLast('a');
//
//
//        System.out.println(s);
        String s = "abc";
        Permutation test = new Permutation();
        String[] res = test.solution(s);
        for (String temp: res){
            System.out.println(temp);
        }

    }
}
