package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

public class Diameter {
    private static int max = Integer.MIN_VALUE;

    public int diameter(Node node) {
        if (node == null)
            return 0;

        int l = diameter(node.left);
        int r = diameter(node.right);

        max = Math.max(max, l + r);

        return 1 + Math.max(l, r);
    }

    public static void main(String[] args) {
        TestTree tree = new TestTree();
        Node root = tree.createTreeComplex();

        Diameter op = new Diameter();
        op.diameter(root);
        System.out.println(Diameter.max);
    }
}
