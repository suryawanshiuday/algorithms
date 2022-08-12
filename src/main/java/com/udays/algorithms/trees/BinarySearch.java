package com.udays.algorithms.trees;

import com.udays.algorithms.model.TreeNode;
import org.junit.Assert;

/**
 * Recursive as well as iterative traversal
 * Example tree:
 *              20
 *            /    \
 *          15      25
 *         /  \    /  \
 *       10   17  22   30
 *           /  \     /
 *         16   18   28
 */
public class BinarySearch {

    public static void main(String... args){
        TreeNode tree = new TreeNode(20);
        tree.left = new TreeNode(15);
        tree.right = new TreeNode(25);
        tree.left.left = new TreeNode(10);
        tree.left.right = new TreeNode(17);
        tree.left.right.left = new TreeNode(16);
        tree.left.right.right = new TreeNode(18);
        tree.right.left = new TreeNode(22);
        tree.right.right = new TreeNode(30);
        tree.right.right.left = new TreeNode(28);
        Assert.assertTrue(recursiveFind(tree,15));
        Assert.assertFalse(recursiveFind(tree,150));
        Assert.assertTrue(iterativeFind(tree,15));
        Assert.assertFalse(iterativeFind(tree,150));
    }

    private static boolean recursiveFind(TreeNode root, int target){
        if(root==null)
            return false;
        if(root.val==target)
            return true;
        if(root.val>target)
            return recursiveFind(root.left, target);
        else
            return recursiveFind(root.right, target);
    }

    private static boolean iterativeFind(TreeNode root, int target){
        while(root!=null){
            if(target==root.val)
                return true;
            if(root.val>target)
                root = root.left;
            else
                root = root.right;
        }
        return false;
    }

}
