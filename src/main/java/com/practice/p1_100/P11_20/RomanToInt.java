package com.practice.p1_100.P11_20;

public class RomanToInt {
    /*
    NO.13   罗马数字转int
    罗马数字包含以下七种字符:I，V，X，L，C，D和M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：

I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。

示例1:

输入:"III"
输出: 3
示例2:

输入:"IV"
输出: 4
示例3:

输入:"IX"
输出: 9
示例4:

输入:"LVIII"
输出: 58
解释: L = 50, V= 5, III = 3.
示例5:

输入:"MCMXCIV"
输出: 1994
解释: M = 1000, CM = 900, XC = 90, IV = 4.
     */

    /*
    IV = 5-1
    VI = 5+1
    所有的两位特殊标识的数字都是这个规律，可得下方的规律
    把每一位罗马数字都转成对应值的int，倒叙相加，如果当前位的int值小于上一位，那么res-temp,反之则res+temp
     */
    int solution(String s){
        if (s == null ||s.length() == 0) return 0;

        int res = 0;
        int pre = 0;
        int temp = 0;
        char v = 'a';
        for (int i = 1;i <= s.length();i++){
            v = s.charAt(s.length() - i);
            switch(v) {
                case 'I':
                    temp = 1;
                    break;
                case 'V':
                    temp = 5;
                    break;
                case 'X':
                    temp = 10;
                    break;
                case 'L':
                    temp = 50;
                    break;
                case 'C':
                    temp = 100;
                    break;
                case 'D':
                    temp = 500;
                    break;
                case 'M':
                    temp = 1000;
                    break;
            }
            if (temp < pre){
                res -= temp;
            }else {
                res += temp;
            }
            pre = temp;
        }
        return res;
        }

    public static void main(String[] args) {
        RomanToInt r = new RomanToInt();
        System.out.println(r.solution("LVIII"));
    }


    }
