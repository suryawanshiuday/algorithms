package com.udays.algorithms.trees;

import com.udays.algorithms.model.TreeNode;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  ** Morris Preorder Traversal **
 *
 * In this method, we have to use a new data structure-Threaded Binary Tree, and the strategy is as follows:
 *
 * Step 1: Initialize current as root
 *
 * Step 2: While current is not NULL, add current value to mark root visited
 *
 * If current does not have left child
 *
 *     Go to the right, i.e., current = current.right
 *
 * Else
 *
 *     a. In current's left subtree, make current.right the right child of the rightmost node
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
 * So in this subtree, the rightmost node is 5, then make the current.right(3) as the right child of 5. Set current = current.left (current = 2). The tree now looks like:
 *
 *          2
 *         / \
 *        4   5
 *             \
 *              3
 *             /
 *            6
 * For current 2, which has left child 4, we can continue with thesame process as we did above
 *
 *         4
 *          \
 *           5
 *            \
 *             3
 *            /
 *           6
 * then add 4 because it has no left child, then add 5, 3 one by one, for node 3 which has left child 6, do the same as above. Finally, the preorder traversal is [1,2,4,5,3,6].
 *
 * For more details, please check Threaded binary tree and Explanation of Morris Method
 */

public class MorrisPreorderTraversal {

    //Time complexity: O(N) as we visit each node max twice, once to locate the node and other to find predecessor
    //Space complexity: O(1)

    public static List<Integer> preorderTraversal(TreeNode root) {
        //output array not considered towards space complexity
        List<Integer> res = new ArrayList<>();

        TreeNode curr = root;
        TreeNode pre;

        while (curr != null) {
            //preorder visits root first and hence first read the value
            //current.left is null, and we have already visited root, assign current.right to be visited
            //this makes it preorder traversal
            res.add(curr.val);
            if (curr.left == null) {
                curr = curr.right; // assign current to right node
            }
            //if current.left is not null, we need to store the nodes somehow to traverse back to root
            //1. from current.left, traverse to rightmost node (predecessor)
            //2. make rightmost.right = current.right (no need to visit current as that is root already visited)
            //3. make current = current.left (as we stored the pointer to current as rightmost.right, we don't lose the right node of this left)
            //4. (optimization) original cur left be null, avoid infinite loops
            else {
                //1. from current.left, traverse to rightmost node
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                //2. make rightmost.right = current
                pre.right = curr.right;
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
        List<Integer> answer = preorderTraversal(tree);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 3, 6));
        System.out.println("Preorder traversal expected: "+expected);
        System.out.println("Preorder traversal completed: "+answer);
        Assert.assertEquals(expected, answer);
    }

}
