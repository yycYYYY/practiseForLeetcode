package com.practice.P1_100.P1_10;

import java.util.HashMap;

public class sumForTwoNum {

    /*
    NO.1    两数之和
    给定 nums = [2, 7, 11, 15], target = 9

      因为 nums[0] + nums[1] = 2 + 7 = 9
      所以返回 [0, 1]

     */
    /*
    暴力法
    时间O[n],空间O[n]
     */
    public int[] twoSum(int[] nums,int target) throws Exception {

        for (int i = 0;i < nums.length;i++){
            for (int j = i+1;j < nums.length;j++){
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        throw new Exception("没有两数之和");
    }

    /*
    hash表
    时间O[1]，空间O[n]
     */
    public int[] twoSuminHash(int[] nums,int target) throws Exception {
        HashMap<Integer,Integer> numsKV = new HashMap<Integer,Integer>();
        for (int m = 0;m < nums.length;m++){
            numsKV.put(nums[m],m);
        }
        for (int n = 0;n < nums.length;n++){
            int temp = target - nums[n];
            if (numsKV.containsKey(temp)&&numsKV.get(temp)!=n){
                return new int[]{n,numsKV.get(temp)};
            }
        }
        throw new Exception("没有两数之和");
    }

//    public static void main(String[] args) {
//        sumForTwoNum s = new sumForTwoNum();
//        ClassLoader cl2 = s.getClass().getClassLoader();
//        while (cl2 != null){
//            System.out.println(cl2.toString());
//            cl2 = cl2.getParent();
//        }
//    }
}
