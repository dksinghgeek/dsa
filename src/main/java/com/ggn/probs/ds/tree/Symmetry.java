package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

public class Symmetry {
    public boolean isSymmetry(Node node1, Node node2){
        if(node1 == null || node2 == null){
            return node1 == node2;
        }

        if(node1.data != node2.data){
            return false;
        }

        return isSymmetry(node1.left, node2.right) && isSymmetry(node1.right, node2.left);
    }

    public static void main(String[] args) {
        TestTree tree = new TestTree();
        Node root = tree.createTreeSymmetry();

        Symmetry op = new Symmetry();

        System.out.println(op.isSymmetry(root, root));
    }
}
