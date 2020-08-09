package com.practice.P1_100.P1_10;

public class myAtoi {
    /*
    NO.8
    请你来实现一个 atoi 函数，使其能将字符串转换成整数。

    首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：

    如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
    假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
    该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
    注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，
         则你的函数不需要进行转换，即无法进行有效转换。

    在任何情况下，若函数不能进行有效的转换时，请返回 0 。
    - 本题中的空白字符只包括空格字符 ' ' 。
    - 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。
        如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

     */
    int solution(String str){
        //边界控制
        if(str == null || str.equals("")) return 0;
        int res = 0;
        int n = str.length();
        char[] chars = str.toCharArray();
        //当前位
        int cur = 0;
        //正负标志位
        int flag = 1;
        //去除空格
        while(cur < n && chars[cur] == ' '){
            cur++;
        }
        if (cur>=n) return 0;
        //判断正负
        if (chars[cur] == '+'|| chars[cur] == '-'){
            if (chars[cur] == '-') flag = -1;
            cur ++;
        }

        while (cur < n && Character.isDigit(chars[cur])){

            //此处必须加上一个 -  '0'，才能保证转换的值是字符值4 ，否则会转换成ascii值52
            int temp = chars[cur] - '0';


            if (flag == 1 &&( res > Integer.MAX_VALUE/10
                    || (res == Integer.MAX_VALUE/10 && temp > 7))) return Integer.MAX_VALUE;

            //注意此处的溢出控制，对比的也是大于MAX，因为在计算过程中，我们的res始终是正数
//            只有在最后返回结果的时候，才会补充正负标志位
            if (flag == -1 &&( res > Integer.MAX_VALUE/10
                    || (res == Integer.MAX_VALUE/10 && temp > 8))) return Integer.MIN_VALUE;
//            注意，做值相加应该在溢出判断之后完成，否则，对于未溢出边界的临界值时，会被错误的认为是溢出
            res = res*10 + temp;
            cur ++;

        }

        return res*flag;
    }

}
