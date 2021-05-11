package com.practice.P1_100.P31_40;

import java.util.*;

/**
 * NO.39
 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 candidates中的数字可以无限制重复被选取。

 说明：
 所有数字（包括target）都是正整数。
 解集不能包含重复的组合。

 示例1：
 输入：candidates = [2,3,6,7], target = 7,
 所求解集为：
 [
 [7],
 [2,2,3]
 ]

 示例2：
 输入：candidates = [2,3,5], target = 8,
 所求解集为：
 [
 [2,2,2,2],
 [2,3,3],
 [3,5]
 ]

 提示：
 1 <= candidates.length <= 30
 1 <= candidates[i] <= 200
 candidate 中的每个元素都是独一无二的。
 1 <= target <= 500
 */
public class CombinationSum {

    /*
    这是以前的暴力解法，但是有问题
    暴力思路：
    单次结果List res    目标值target   每次计算中间值temp   当前位置（数组中的位置）cur
    当前计算位置（每次循环的计算位置）tempCur
    数组排序[6,2,3,7] --> [2,3,6,7]    目标7
    tempCur = cur
    在数组内，从后往前减target - candidates[tempCur]得到temp，并且往res存入一次当前candidates[tempCur]
    如果temp是0，直接返回res，小于零本次小循环结束啥也不返回，大于0，再减一次
    直到temp为0，返回res
    tempCur为0之后，结束小循环
    当cur变成0之后，结束大循环
     */
    public List<List<Integer>> solution(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        int cur = candidates.length - 1;
        Arrays.sort(candidates);
        while (cur >= 0){
            int tempCur = cur;
            int temp = target;

            List<Integer> resList = new ArrayList<>();
            while (tempCur >= 0){

                //是这里有问题，会丢失一部分结果
                if (temp < candidates[tempCur]){
                    tempCur--;
                    continue;
                }
                temp = temp -candidates[tempCur];
                resList.add(candidates[tempCur]);
                if (temp == 0){
                    res.add(resList);
                    break;
                }

            }

            cur--;
        }
        return res;
    }

    /*
    回溯的几个关键条件：
    1、结果集：声明distance = target - 几个数（path），distance为零时添加结果集（也就是几个数相加等于target时）
    2、遍历规则：dfs，每层的节点，都是candidates数组中的所有数
    3、回溯条件和回溯操作：distance等于0获得结果，小于零，剪枝回溯。遍历操作：path加当前数，distance减当前数，回溯操作：反过来，path减当前数，distance加当前数
    4、剪枝操作：有点难待确定：去重，大概率先排序？？
    关于去重剪枝，最后还是看了答案，这个剪枝和全排列的剪枝不一样，走的是另外一条路，全排列的剪枝，是通过used[]来记录，当前元素有没有被使用过，
    被使用过就直接跳到下一次循环。而这个剪枝，也很巧妙，把candidates排序之后，记录同一层树第二个节点遍历candidates数组时的起始位置，
    如果上一个节点已经用过第一个元素了，那么第二个节点本身及下面所有子树，就不能再使用第一个元素了，这个方法，很巧妙的解决的重复的问题。
    举个例子，candidates[2,3,5]  target 8
    遍历过程：
    8-2-2-2-2 = 0  ---》「2，2，2，2」
    8-2-3-3 = 0    ---》「2，3，3」
    上面两个是遍历树的第一节点（也就是减2）及其子树，最后得到的结果
    下面第二个节点（减3）以及第三个节点（减5），及其子树就不允许使用第一个元素（2）了，也就是不能减2了

    那么第二个节点及其子树的遍历，就只能得到一个结果
    8-3-5 = 0 ---》 「3，5」
    实际上8-3-3-2 = 0也能遍历到结果，但是由于我们的限制，同层第二个节点，不能使用第一个节点所使用的元素，也就是不能减2，8-3-2-*这条路径被剪掉了

    同理的，第三个节点（减5），不能再使用第一第二个节点的元素，不能减3，也不能减2，
    所以这一个节点及其子树，全被剪掉了，只剩了一个节点，遍历不出来有效的结果
     */
    public List<List<Integer>> solution2(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return res;
        }
        Deque<Integer> path = new LinkedList<>();
        int length = candidates.length;
        Arrays.sort(candidates);

        dfs(candidates, 0, res, path, target, length);

        return res;
    }

    /*
    使用起始位置begin，进行去重剪枝，非常巧妙的一个方法
     */
    public void dfs(int[] candidates, int begin, List<List<Integer>> res, Deque<Integer> path, int distance, int length){
        if (distance == 0){
            //怎么剪枝，还是有点想不出来，还是用下面4行笨方法先把题过了，得到所有结果，对path排序，看res里有没有和path一样的list，有就不加了
//            List<Integer> pathRes = new ArrayList<>(path);
//            Collections.sort(pathRes);
//            if (res.contains(pathRes)){
//                return;
//            }
            //千万注意此处，一定要做一下path的copy，java方法是值传递
            res.add(new ArrayList<>(path));
            return;
        }
//        原来for循环里的distance判断，写的是break，但是后来发现，可以写成return，即把下面这个return操作，换到for循环里
//        因为，当for循环里面distance小于零，break之后，本次的dfs递归还是会正常结束，和return的结果是一样的，也就是，写break和return实际没有区别
//        因此下面这个三行的判断，永远也走不到
//        if (distance < 0){
//            return;
//        }

        for (int i = begin; i < length; i++) {
            //这里是对剪枝做的优化，由于candidates已经排序（从小到大）了，
            // 如果减到第二个数时，distance已经小于0了，后面的减法实际没有必要做了
            // 这里的小优化，有一点点提升但，更重要的还是去重部分的剪枝
            if (distance < 0){
                return;
            }
            path.addLast(candidates[i]);
            distance -= candidates[i];

            //千万要注意，这里的begin是i而不是i+1，因为这里的递归是向下一层遍历，而不是向同层下一个节点遍历
            //那么向同层下一个节点遍历的操作，也就是begin+1的操作在哪？在for循环那里，那里是在同层向下一个节点遍历
            dfs(candidates, i, res, path, distance, length);

            distance += candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        int[] can = new int[]{2,3,6,7};
        List<List<Integer>> res;
        res = c.solution2(can,7);
        System.out.println(res.toString());

    }
}
