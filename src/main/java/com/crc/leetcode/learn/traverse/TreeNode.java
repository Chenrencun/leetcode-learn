package com.crc.leetcode.learn.traverse;

import lombok.Builder;
import lombok.Data;

/**
 * @author: crc
 * @version:1.0
 * @date: 2020-08-26 17:16
 * @descripton:
 */
@Builder
@Data
public class TreeNode<T> {

    private T data;

    private TreeNode<T> leftChild;

    private TreeNode<T> rightChild;
}
