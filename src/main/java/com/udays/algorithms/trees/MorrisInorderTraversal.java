package com.udays.algorithms.trees;

import com.udays.algorithms.model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Assert.*;

/**
 *  ** Morris Inorder Traversal **
 *
 * In this method, we have to use a new data structure-Threaded Binary Tree, and the strategy is as follows:
 *
 * Step 1: Initialize current as root
 *
 * Step 2: While current is not NULL,
 *
 * If current does not have left child
 *
 *     a. Add current’s value
 *
 *     b. Go to the right, i.e., current = current.right
 *
 * Else
 *
 *     a. In current's left subtree, make current the right child of the rightmost node
 *
 *     b. Go to this left child, i.e., current = current.left
 * For example:
 *
 *
 *           1
 *         /   \
 *        2     3
 *       / \   /
 *      4   5 6
 *
 * First, 1 is the root, so initialize 1 as current, 1 has left child which is 2, the current's left subtree is
 *
 *          2
 *         / \
 *        4   5
 * So in this subtree, the rightmost node is 5, then make the current(1) as the right child of 5. Set current = cuurent.left (current = 2). The tree now looks like:
 *
 *          2
 *         / \
 *        4   5
 *             \
 *              1
 *               \
 *                3
 *               /
 *              6
 * For current 2, which has left child 4, we can continue with thesame process as we did above
 *
 *         4
 *          \
 *           2
 *            \
 *             5
 *              \
 *               1
 *                \
 *                 3
 *                /
 *               6
 * then add 4 because it has no left child, then add 2, 5, 1, 3 one by one, for node 3 which has left child 6, do the same as above. Finally, the inorder taversal is [4,2,5,1,6,3].
 *
 * For more details, please check Threaded binary tree and Explaination of Morris Method
 */

public class MorrisInorderTraversal {

    //Time complexity: O(N) as we visit each node max twice, once to locate the node and other to find predecessor
    //Space complexity: O(1)

    public static List<Integer> inorderTraversal(TreeNode root) {
        //output array not considered towards space complexity
        List<Integer> res = new ArrayList<>();

        TreeNode curr = root;
        TreeNode pre;

        while (curr != null) {
            //if current.left is null, read the value and make current as current.right
            //current.left is null, so we visit root which is current and then assign current.right to be visited
            //this makes it inorder traversal
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // assign current to right node
            }
            //if current.left is not null, we need to store the nodes somehow to traverse back to root
            //1. from current.left, traverse to rightmost node (predecessor)
            //2. make rightmost.right = current
            //3. make current = current.left (as we stored the pointer to current as rightmost.right, we don't lose the parent node of this left)
            //4. (optimization) original cur left be null, avoid infinite loops
            else {
                //1. from current.left, traverse to rightmost node
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                //2. make rightmost.right = current
                pre.right = curr;
                //3. make current = current.left
                //4. (optimization) original cur left be null, avoid infinite loops
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null;
            }
        }
        return res;
    }

    public static void main(String... args){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        List<Integer> answer = inorderTraversal(tree);
        List<Integer> expected = new ArrayList<>(Arrays.asList(4,2,5,1,6,3));
        System.out.println("Inorder traversal expected: "+expected);
        System.out.println("Inorder traversal completed: "+answer);
        Assert.assertEquals(expected, answer);
    }

}
