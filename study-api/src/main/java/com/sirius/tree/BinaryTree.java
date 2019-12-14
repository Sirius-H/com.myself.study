package com.sirius.tree;

/**
 * 描述: 二叉树规定 至多有2个节点T1 T2,都可以为空
 *
 * @author tangzhiming
 * @create 2019-11-26 19:50
 */
public class BinaryTree<T extends Comparable<? super T>> {


    /**
     *存储元素
     */
    private T element;
    /**
    左子树
     */
    private BinaryTree<T> leftTree;
    /**
     右子树
     */
    private BinaryTree<T> rightTree;


    public BinaryTree(T element, BinaryTree leftTree, BinaryTree rightTree) {
        this.element = element;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    public BinaryTree(T element) {
        this(element,null,null);
    }

    public void setLeftTree(BinaryTree<T> leftTree) {
        this.leftTree = leftTree;
    }

    public void setRightTree(BinaryTree<T> rightTree) {
        this.rightTree = rightTree;
    }

    public T getElement() {
        return element;
    }

    public BinaryTree<T> getLeftTree() {
        return leftTree;
    }

    public BinaryTree<T> getRightTree() {
        return rightTree;
    }
}