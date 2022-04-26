package com.practice.dataStructure;

/**
 * @Author: yyc
 * @Date: 2022/4/24 5:55 PM
 * @Description: 前缀树节点
 * 前缀树的节点，在计算字符串前缀时，一般使用边作为业务值，节点仅记录通过当前节点的路径数量、该节点被多少个路径作为结尾以及该节点包含哪些路径
 * 例如
 * ["abc", "ab", "bck"]
 * 节点(p2,e0) -a-> 节点(p2,e0) -b-> 节点(p2,e1) -c-> 节点(p1,e1)
 *     -b-> 节点(p1,e0) -c-> 节点(p1,e0) -k-> 节点(p1,e1)
 */
public class TrieNode {
    /**
     * 表明有多少路径经过该节点
     */
    public int pass;
    /**
     * 有多少路径以此节点为终点
     */
    public int end;
    /**
     * 是否直接相连于某个字符路径()
     * 如果路上的元素不仅仅是小写字符，超过26个也可以换成哈希表Map<Char, TireNode>
     * TrieNode[0] == null   没有走向a的路径
     * TrieNode[0] != null   有走向a的路径
     *      ...
     * TrieNode[25] != null   有走向z的路径
     */
    public TrieNode[] nexts;

    public TrieNode(){
        pass = 0;
        end = 0;
        this.nexts = new TrieNode[26];
    }
}
