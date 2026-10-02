package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

public class Identical {
    public boolean isIdentical(Node node1, Node node2) {
        if (node1 == null || node2 == null)
            return node1 == node2;
        return (node1.data == node2.data && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right));
    }

    public static void main(String[] args) {
        TestTree tree = new TestTree();

        Node node1 = tree.createTreeSimple();
        Node node2 = tree.createTreeSimple();

        Identical op = new Identical();
        if (op.isIdentical(node1, node2)) {
            System.out.println("Identical");
        } else {
            System.out.println("Not identical");
        }
    }
}
