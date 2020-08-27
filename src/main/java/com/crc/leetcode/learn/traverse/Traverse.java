package com.crc.leetcode.learn.traverse;

import java.util.Stack;
import java.util.function.Supplier;

/**
 * @author: crc
 * @version:1.0
 * @date: 2020-08-26 17:25
 * @descripton: 二叉树的遍历（前序遍历、中序遍历、后序遍历）
 */
public class Traverse {

    /**
     * 前序遍历（递归）
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
     * 前序遍历（非递归）
     * @param node
     * @param <T>
     */
    public static <T> void preOrderTraverseWithStack(TreeNode<T> node){
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> treeNode = node;
        while (treeNode != null || !stack.isEmpty()){
            // 循环访问节点的左子节点，并入栈
            while (treeNode != null){
                System.out.println(treeNode.getData());
                stack.push(treeNode);
                treeNode = treeNode.getLeftChild();
            }

            // 如果节点没有左子节点，则出栈，并访问右子节点
            if (!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.getRightChild();
            }
        }
    }

    /**
     * 中序遍历（递归）
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
     * 中序遍历（非递归）
     * @param node
     * @param <T>
     */
    public static <T> void inOrderTraverseWithStack(TreeNode<T> node){
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> treeNode = node;
        while (treeNode != null || !stack.isEmpty()){
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.getLeftChild();
            }

            if (!stack.isEmpty()){
                treeNode = stack.pop();
                System.out.println(treeNode.getData());
                treeNode = treeNode.getRightChild();
            }
        }
    }

    /**
     * 后序遍历（递归）
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

    /**
     * 后序遍历（非递归）
     * @param node
     * @param <T>
     */
    public static <T> void postOrderTraverseWithStack(TreeNode<T> node){
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> treeNode = node;
        // 标记每次遍历最后一次访问的节点
        TreeNode<T> lastVisit = null;
        while (treeNode != null || !stack.isEmpty()){
            while (treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.getLeftChild();
            }

            if (!stack.isEmpty()){
                treeNode = stack.pop();

                // 判断节点是否有右子节点（判断lastVisit，是为了避免重复输出右子节点）
                if (treeNode.getRightChild() == null || treeNode.getRightChild() == lastVisit){
                    // 如果没有，则输出data
                    System.out.println(treeNode.getData());
                    lastVisit = treeNode;
                    treeNode = null;
                } else {
                    // 如果有，则再次入栈，并访问节点的右子节点
                    stack.push(treeNode);
                    treeNode = treeNode.getRightChild();
                }
            }
        }
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
        preOrderTraverseWithStack(rootNode);
        System.out.println("-------------------");
        inOrderTraverse(rootNode);
        System.out.println("-------------------");
        inOrderTraverseWithStack(rootNode);
        System.out.println("-------------------");
        postOrderTraverse(rootNode);
        System.out.println("-------------------");
        postOrderTraverseWithStack(rootNode);
    }


}
