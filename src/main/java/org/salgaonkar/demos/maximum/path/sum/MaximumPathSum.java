package org.salgaonkar.demos.maximum.path.sum;

import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.TreeVisitor;

import java.util.Scanner;

public class MaximumPathSum {

    /**
     * Root of the Binary Tree
     */
    Node root;

    public static void main(String[] args) {
        MaximumPathSum tree = new MaximumPathSum();
        tree.root                   = new Node(10);
        tree.root.left              = new Node(2);
        tree.root.right             = new Node(10);
        tree.root.left.left         = new Node(20);
        tree.root.left.right        = new Node(1);
        tree.root.right.right       = new Node(-25);
        tree.root.right.right.left  = new Node(3);
        tree.root.right.right.right = new Node(4);

        System.out.println("Maximum Path Sum is: " + tree.findMaxSum());
    }

    /**
     * Returns the maximum path sum in a tree in a given root.
     * @return maximumPathSum.
     */
    private int findMaxSum(Node node) {
        // Initialize the result.
        Res res = new Res();
        res.val = Integer.MIN_VALUE;

        // Calculate and return the result.
        findMaxSumUtil(node, res);
        return res.val;
    }

    private int findMaxSum() {
        return findMaxSum(root);
    }

    private int findMaxSumUtil(Node node, Res res) {
        // Basic case.
        if (node == null)
            return 0;

        // l and r store maximum path sum going through left and right child of the root respectively.
        int l = findMaxSumUtil(node.left, res);
        int r = findMaxSumUtil(node.right, res);

        // Max path for the parent call of the root. This path must include at-most one chile of root respectively.
        int maxSingle = Math.max(Math.max(l, r) + node.data, node.data);

        // Max top represents the sum when the node under consideration is the root of the maxsum path
        // and no ancestors of root are present in the max sum path.
        int maxTop = Math.max(maxSingle, l + r + node.data);

        // Store the Maximum result.
        res.val = Math.max(res.val, maxTop);

        return maxSingle;
    }

}
