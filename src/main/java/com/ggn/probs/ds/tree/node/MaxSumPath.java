package com.ggn.probs.ds.tree.node;

import com.ggn.probs.ds.tree.TraversalDFSPreOrder;

public class MaxSumPath {
    private static int max = Integer.MIN_VALUE;
    public int maxSumPath(Node node){
        if(node == null)
            return 0;

        int l = Math.max(0, maxSumPath(node.left));
        int r = Math.max(0, maxSumPath(node.right));

        max = Math.max(max, node.data + l + r);

        return node.data + Math.max(l, r);
    }

    public static void main(String[] args){
        TestTree tree = new TestTree();
        Node root = tree.createTreeMaxSumPath();

        TraversalDFSPreOrder traversalDFSPreOrder = new TraversalDFSPreOrder();
        traversalDFSPreOrder.preOrderRecursion(root);

        System.out.println();

        MaxSumPath op = new MaxSumPath();
        op.maxSumPath(root);
        System.out.println(MaxSumPath.max);
    }
}
