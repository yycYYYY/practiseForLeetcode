package com.practice.other;

/**
 * @Author: yyc
 * @Date: 2022/4/26 4:42 PM
 * @Description: 汉诺塔问题
 */
public class Hanoi {
    /**
     * 做题的时候一定要记得不必拘泥于整体，把整体抽象成一个最简的子问题，例如一个i层的塔，看成只有两层第一层为(1 ~ i-1)，第二层为i
     * 然后得出process的逻辑，很多场景都要如此
     * @param n
     */
    public void solution(int n){
        if (n > 0){
            process(n, "左", "右", "中");
        }
    }

    private void process(int i, String start, String end, String temp){
        System.out.println("移动" + i + "从" + start + "到" + end);
        if (i == 1){
            return;
        }else {
            process(i - 1, start, temp, end);
            process(i - 1, temp, end, start);
        }
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.solution(3);
    }
}
