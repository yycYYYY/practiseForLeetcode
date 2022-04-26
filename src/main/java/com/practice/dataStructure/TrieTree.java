package com.practice.dataStructure;

/**
 * @Author: yyc
 * @Date: 2022/4/24 6:12 PM
 * @Description: 前缀树
 */
public class TrieTree {
    private TrieNode root;

    public TrieTree(){
        root = new TrieNode();
    }

    public void insert(String word){
        if (word == null || word.isEmpty()){
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        node.pass++;
        int index;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null){
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }

    public void delete(String word){
        if (search(word) == 0){
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        node.pass--;
        int index;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            // 如果在删除过程中，有节点的pass仅有这一个word通过，可以直接删除，后续的元素由于没有引用，也会被回收。
            // 但是C++不可以，必须遍历到底去析构，否则会造成内存泄露
            if (--node.nexts[index].pass == 0){
                node.nexts[index] = null;
                return;
            }
            node = node.nexts[index];
        }
        node.end--;
    }

    /**
     * 该word出现过几次
     */
    public int search(String word){
        if (word == null || word.isEmpty()){
            return 0;
        }

        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index;
        for (int i = 0; i < chars.length; i++) {
            if (node.pass < 1){
                return 0;
            }
            index = chars[i] - 'a';
            if (node.nexts[index] == null){
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    /**
     * 有多少word以word为前缀
     */
    public int prefixCount(String word){
        if (word == null || word.isEmpty()){
            return root.pass;
        }

        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index;
        for (int i = 0; i < chars.length; i++) {
            if (node.pass < 1){
                return 0;
            }
            index = chars[i] - 'a';
            if (node.nexts[index] == null){
                return 0;
            }
            node = node.nexts[index];
        }
        return node.pass;
    }

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        trieTree.insert("abc");
        trieTree.insert("abc");
        trieTree.insert("abk");
//        trieTree.delete("abc");
        System.out.println(trieTree.prefixCount("ab"));
    }
}
