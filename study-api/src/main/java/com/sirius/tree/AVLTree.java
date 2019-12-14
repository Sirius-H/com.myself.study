package com.sirius.tree;

/**
 * 描述:AVL树 带有平衡条件的树
 *
 *
 * 性质
 *  1.规定任意节点的左子树和右子树的高度差最大为1
 *  2.同时具备二叉查找树的性质
 *
 *  每个AVL数的节点会维护自己节点的高度
 *
 * @author tangzhiming
 * @create 2019-12-12 16:44
 */
public class AVLTree<E extends Comparable<? super E>> {


    AVLNode<E> root;


    private final static int BALANCE_POINT = 2;

    public AVLTree() {
    }


    public void insert (E element) {
        root = insert(element,root);
    }


    private AVLNode<E> insert(E element,AVLNode<E> avlNode) {
        if (avlNode == null) {
            return new AVLNode<>(element);
        }

        int result = element.compareTo(avlNode.getElement());

        if (result < 0) {
            avlNode.setLeft(insert(element,avlNode.getLeft()));
        } else if (result > 0) {
            avlNode.setRight(insert(element,avlNode.getRight()));
        } else {
            //元素相同啥也不干
        }
        return balance(avlNode);
    }

    /**
     *检查节点是否失去平衡
     */
    private final AVLNode<E> balance(AVLNode<E> avlNode) {
        if (avlNode == null) {
            return avlNode;
        }

        if (height(avlNode.getLeft()) - height(avlNode.getRight()) >= BALANCE_POINT ) {
            //外边
            if (height(avlNode.getLeft().getLeft()) >= height(avlNode.getLeft().getRight())) {
                    //单旋转
                avlNode = rotateWithLeftChild(avlNode);
            } else {
                //双旋转
                avlNode = doubleWithLeft(avlNode);
            }
        } else if (height(avlNode.getRight()) - height(avlNode.getLeft()) >= BALANCE_POINT) {
            //外边
            if (height(avlNode.getRight().getRight()) >= height(avlNode.getRight().getLeft())) {
                //单旋转
                avlNode = rotateWithRightChild(avlNode);
            } else {
                //双旋转
                avlNode = doubleWithRight(avlNode);
            }
        }

        avlNode.setHeight(Math.max(height(avlNode.getLeft()),height(avlNode.getRight())) + 1);

        return avlNode;
    }


    //左左 单旋转
    private AVLNode<E> rotateWithLeftChild(AVLNode<E> k2) {
        AVLNode<E> k1 = k2.getLeft();

        k2.setLeft(k1.getRight());

        k1.setRight(k2);

        k1.setHeight(Math.max(height(k1.getRight()),height(k1.getLeft())) + 1);

        k2.setHeight(Math.max(height(k2.getRight()),height(k2.getLeft())) + 1);
        return k1;
    }

    //右右 单旋转

    private AVLNode<E> rotateWithRightChild (AVLNode<E> k2) {
        AVLNode<E> k1 = k2.getRight();

        k2.setRight(k1.getLeft());

        k1.setLeft(k2);

        k2.setHeight(Math.max(height(k2.getRight()),height(k2.getLeft())) + 1);

        k1.setHeight(Math.max(height(k1.getRight()),height(k1.getLeft())) + 1);

        return k1;
    }

    //左右 双旋转

    private AVLNode<E> doubleWithLeft(AVLNode<E> k3) {
        k3.setLeft(rotateWithRightChild(k3));

        return rotateWithLeftChild(k3);
    }

    //右左 双旋转
    private AVLNode<E> doubleWithRight(AVLNode<E> k3) {
        k3.setRight(rotateWithLeftChild(k3));

        return rotateWithRightChild(k3);
    }

    private final int height(AVLNode avlNode){
        return avlNode == null ? -1 : avlNode.getHeight();
    }

}