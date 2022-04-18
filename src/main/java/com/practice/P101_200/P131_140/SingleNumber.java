package com.practice.P101_200.P131_140;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yyc
 * @Date: 2022/4/6 9:35 PM
 * @Description: lc 136 easy 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 注：：！！  异或其实就是单个位的无进位相加
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 还有一个变种题，如果有两个数，只出现了一次，怎么找出这两个数
 */
public class SingleNumber {
    /**
     * 这个是我能想到的，比较简单的哈希表法，遍历数组，如果表里不存在元素，就添加，如果存在元素，就删除，最后一定留下的就是一次的
     */
    public int solution1(int[] nums) {
        if (nums.length == 0){
            throw new RuntimeException("数组预期应不为空");
        }
        if (nums.length == 1){
            return nums[0];
        }

        Set<Integer> exists = new HashSet<>();
        for (int i : nums){
            if (exists.contains(i)){
                exists.remove(i);
            }else {
                exists.add(i);
            }
        }
        if (exists.isEmpty()){
            throw new RuntimeException("没有预期的结果");
        }

        if (exists.size() > 1){
            throw new RuntimeException("含有多个预期结果");
        }

        return exists.stream().findFirst().get();
    }

    /**
     * 答案里的异或运算法，也不难，尽管知道不要求额外空间，一般就是位运算也没想到使用异或，基础太差需要恶补基础。
     * 数组里包含一堆成对的数字，和一个单独的数字，由于异或本身的性质，
     * 把所有数字依次异或掉，剩下的就是那个单独的数字。主要是不清楚异或竟然也满足交换律和结合律
     */
    public int solution2(int[] nums){
        if (nums.length == 0){
            throw new RuntimeException("数组预期应不为空");
        }
        if (nums.length == 1){
            return nums[0];
        }
        // 注意起始计算值应是0
        int res = 0;

        for (int i : nums){
            res ^= i;
        }
        return res;
    }

    /**
     * 变种题，有两个出现1次，多个数出现两次
     * 要求题解仍然使用常数级别的空间以及n级别的时间（如果使用n级别的空间很简单，直接就hash表就行）
     * 思路：先是同问题1题解，nums元素异或得到题解两个出现1次的元素的异或 eor =  a^b ，接下来，就是精髓了，很经典的位运算技巧：
     * 得到eor的二进制中最右侧的1（假如eor是3：0100，最右侧的1就是3），然后根据这个标志位（3）作区分，所有跟它与运算后为1的，分为一组，依次异或
     * 得到res(a或b中的一个)，再通过eor ^ res 得到另外一个结果
     * 为什么选择这个标志位，因为a ^ b 不为0，就注定a和b的二进制位中，某一位，两者是不同的(即一个是1另一个是0)，而除开a、b两个数外，其他的所有数，
     * 无论这个位置是0还是1，这个数都出现了两次或零次，所以可被异或掉
     */
    public int solutionPlus(int[] nums){
        int eor = 0;

        for (int i :nums){
            eor ^= i;
        }
        // 提取出eor二进制中最右侧的1
        int rightOne = eor & (~eor + 1);

        int res = 0;
        for (int j : nums){
            if ((j & rightOne) == 0){
                res ^= j;
            }
        }
        // 另一个数为 eor ^ res
        return res;
    }
}
