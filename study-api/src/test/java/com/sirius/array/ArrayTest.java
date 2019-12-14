package com.sirius.array;

import com.sirius.tree.AVLTree;
import com.sirius.tree.QueryBinaryTree;
import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import org.testng.annotations.Test;


/**
 * 描述:
 * 数组test
 *
 * @author tangzhiming
 * @create 2018-11-29 23:39
 */
public class ArrayTest {

    @Test
    public void test_arrayList () {
        Array array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);
        System.out.println(array.toString());
    }


    public static void main(String[] args) {
//        QueryBinaryTree<Integer> queryBinaryTree = new QueryBinaryTree<>();
//
//        queryBinaryTree.insert(4);
//
//        queryBinaryTree.insert(3);

//        queryBinaryTree.insert(2);

       AVLTree<Integer> avlTree = new AVLTree<>();

       avlTree.insert(3);

       avlTree.insert(2);

       avlTree.insert(1);

        for (int i = 4; i < 17; i++) {
            avlTree.insert(i);
        }

        System.out.println(1);
    }

}