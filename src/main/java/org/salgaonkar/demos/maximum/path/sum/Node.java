package org.salgaonkar.demos.maximum.path.sum;

/**
 * Class containing left and right child of current node and keyy value.
 */
public class Node {

    int data;

    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}
