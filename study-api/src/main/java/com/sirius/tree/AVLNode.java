package com.sirius.tree;

/**
 * 描述: AVL树节点
 *
 * @author tangzhiming
 * @create 2019-12-12 16:46
 */
public class AVLNode<E extends Comparable<? super E>> {

    private E element;

    private AVLNode<E> left;

    private AVLNode<E> right;

    private int height;


    public AVLNode(E element) {
        this(element,null,null);
    }

    public AVLNode(E element, AVLNode<E> left, AVLNode<E> right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.height = 0;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setLeft(AVLNode<E> left) {
        this.left = left;
    }

    public void setRight(AVLNode<E> right) {
        this.right = right;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public E getElement() {
        return element;
    }

    public AVLNode<E> getLeft() {
        return left;
    }

    public AVLNode<E> getRight() {
        return right;
    }

    public int getHeight() {
        return height;
    }
}