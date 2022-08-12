package com.udays.algorithms.trees;

import com.udays.algorithms.model.TreeNode;
import junit.framework.Assert;

import java.util.*;

/**
 *  ** Morris Postorder Traversal **
 *
 * In this method, we have to use a new data structure-Threaded Binary Tree, and the strategy is as follows:
 *
 * Step 1: Initialize current as root
 *
 * Step 2: While current is not NULL,
 *
 * If current does not have right child
 *
 *     a. Add current’s value to deque's front
 *     b. Go to the left, i.e., current = current.left
 *
 * Else
 *
 *     a. In current's right subtree, make current.left the left child of the leftmost node
 *     b. Add current's value
 *     c. Go to this right child, i.e., current = current.right
 * For example:
 *
 *
 *           1
 *         /   \
 *        2     3
 *       / \   /
 *      4   5 6
 *
 * First, 1 is the root, so initialize 1 as current, 1 has right child which is 3, the current's right subtree is
 *
 *          3
 *         /
 *        6
 * So in this subtree, the leftmost node is 6, then make the current.left(2) as the left child of 6. Set current = current.right (current = 3). The tree now looks like:
 *
 *          3
 *         /
 *        6
 *       /
 *      2
 *     / \
 *    4   5
 * For current 3, which there is no right child, so just read the value and add to deque at front. Keep doing this until we have current.right!=null
 *
 *            2
 *          /  \
 *         4    5
 * then follow the same step at above when we have current.right!=null. Finally, the postorder taversal is [4,5,2,6,3,1].
 *
 * For more details, please check Threaded binary tree and Explaination of Morris Method
 */

public class MorrisPostorderTraversal {

    //Time complexity: O(N) as we visit each node max twice, once to locate the node and other to find predecessor
    //Space complexity: O(1)

    public static List<Integer> postorderTraversal(TreeNode root){
        //output array not considered towards space complexity
        //we will be building postorder from end to start in reverse order, hence we will keep adding elements to front of queue
        Deque<Integer> res = new ArrayDeque<>();

        TreeNode curr = root;
        TreeNode pre;

        while (curr != null) {
            //if current.right is null, read the value and make current as current.left
            //current.right is null, so we visit root which is current and add to deque in front
            //make curr=curr.left so we visited root->right(null)->left in reverse order of expected postorder
            //this makes it inorder traversal
            if (curr.right == null) {
                res.addFirst(curr.val);
                curr = curr.left; // assign current to left node
            }
            //if current.right is not null, we need to store the nodes somehow to traverse back to root
            //1. from current.right, traverse to leftmost node (successor)
            //2. make leftmost.left = current.left
            //3. make current = current.right (as we stored the pointer to current.left as leftmost.left, we don't lose the left node of this right)
            else {
                //1. from current.right, traverse to leftmost node
                pre = curr.right;
                while (pre.left != null) { // find leftmost
                    pre = pre.left;
                }
                //2. make leftmost.left = current.left
                pre.left = curr.left;
                //3. read the value or right which is current
                res.addFirst(curr.val);
                //3. make current = current.right
                curr = curr.right;
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String... args){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        List<Integer> answer = postorderTraversal(tree);
        List<Integer> expected = new ArrayList<>(Arrays.asList(4, 5, 2, 6, 3, 1));
        System.out.println("Postorder traversal expected: "+expected);
        System.out.println("Postorder traversal completed: "+answer);
        Assert.assertEquals(expected, answer);
    }

}
