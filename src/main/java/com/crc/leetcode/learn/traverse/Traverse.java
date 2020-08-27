package com.crc.leetcode.learn.traverse;

/**
 * @author: crc
 * @version:1.0
 * @date: 2020-08-26 17:25
 * @descripton: 二叉树的遍历（前序遍历、中序遍历、后序遍历）
 */
public class Traverse {

    /**
     * 前序遍历
     * @param node
     * @param <T>
     */
    public static <T> void preOrderTraverse(TreeNode<T> node){
        if (node == null) return;
        // 先访问根节点
        System.out.println(node.getData());
        // 再前序遍历左子树
        preOrderTraverse(node.getLeftChild());
        // 最后前序遍历右子树
        preOrderTraverse(node.getRightChild());
    }

    /**
     * 中序遍历
     * @param node
     * @param <T>
     */
    public static <T> void inOrderTraverse(TreeNode<T> node){
        if (node == null) return;
        // 先中序遍历左子树
        inOrderTraverse(node.getLeftChild());
        // 再访问根节点
        System.out.println(node.getData());
        // 最后中序遍历右子树
        inOrderTraverse(node.getRightChild());
    }

    /**
     * 后序遍历
     * @param node
     * @param <T>
     */
    public static <T> void postOrderTraverse(TreeNode<T> node){
        if (node == null) return;
        // 先后序遍历左子树
        postOrderTraverse(node.getLeftChild());
        // 再后序遍历右子树
        postOrderTraverse(node.getRightChild());
        // 最后访问根节点
        System.out.println(node.getData());
    }

    public static void main(String[] args) {
        TreeNode<Character> leafNode1 = new TreeNode<Character>('D',null,null);
        TreeNode<Character> leafNode2 = new TreeNode<Character>('A',null,null);
        TreeNode<Character> leafNode3 = new TreeNode<Character>('S',null,null);
        TreeNode<Character> leafNode4 = new TreeNode<Character>('H',null,null);
        TreeNode<Character> childNode1 = new TreeNode<Character>('E',leafNode1,leafNode2);
        TreeNode<Character> childNode2 = new TreeNode<Character>('C',leafNode4,leafNode3);
        TreeNode<Character> rootNode = new TreeNode<Character>('G',childNode1,childNode2);

        preOrderTraverse(rootNode);
        System.out.println("-------------------");
        inOrderTraverse(rootNode);
        System.out.println("-------------------");
        postOrderTraverse(rootNode);
        System.out.println("-------------------");
    }


}
