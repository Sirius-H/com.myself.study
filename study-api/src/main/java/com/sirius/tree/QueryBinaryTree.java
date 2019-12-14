package com.sirius.tree;

/**
 * 描述: 二叉查找树
 * 1.左子树 必须小于父亲节点
 * 2.右子树 必须大于父亲节点
 *
 * @author tangzhiming
 * @create 2019-11-26 19:46
 */
public class QueryBinaryTree<T extends Comparable<? super T>> {
    /**
     * 根节点
     */
    private BinaryTree<T> root;

    public QueryBinaryTree() {
        this.root = null;
    }

    public QueryBinaryTree(BinaryTree<T> root) {
        this.root = root;
    }

    public boolean contains(T containsObj) {
        return contains(containsObj, root);
    }

    public T findMin() {
        BinaryTree<T> min = findMin(root);
        if (min == null) {
            return null;
        }
        return min.getElement();
    }

    public T finMax() {
        BinaryTree<T> max = finMax(root);
        if (max == null) {
            return null;
        }
        return max.getElement();
    }

    public void insert(T element) {
        root = insert(element,root);
    }


    private BinaryTree<T> findMin(BinaryTree<T> tree) {
        if (tree == null) {
            return null;
        }
        if (tree.getLeftTree() != null) {
            findMin(tree.getLeftTree());
        }
        return tree;
    }

    private BinaryTree<T> finMax(BinaryTree<T> tree) {
        if (tree == null) {
            return null;
        }
        while (tree.getRightTree() != null) {
            finMax(tree.getRightTree());
        }
        return tree;
    }

    private BinaryTree<T> insert(T element, BinaryTree<T> tree) {
        if (element == null) {
            throw new NullPointerException();
        }
        if (tree == null) {
            return new BinaryTree<>(element);
        }

        int compareResult = element.compareTo(tree.getElement());

        if (compareResult < 0) {
            tree.setLeftTree(insert(element,tree.getLeftTree()));
        } else if (compareResult > 0) {
            tree.setRightTree(insert(element,tree.getRightTree()));
        }

        return tree;
    }
 
    private boolean contains(T t, BinaryTree<T> root) {
        if (t == null) {
            return false;
        }
        int compare = t.compareTo(root.getElement());

        if (compare < 0) {
            return contains(t, root.getLeftTree());
        } else if (compare > 0) {
            return contains(t, root.getRightTree());
        }
        return true;
    }

}