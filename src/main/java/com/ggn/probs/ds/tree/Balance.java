package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

public class Balance {

    public boolean isBalance(Node node){
        return check(node) > 1;
    }

    private int check(Node node){
        if(node == null)
            return 0;

        int l = check(node.left);
        if(l == -1)
            return -1;

        int r = check(node.right);
        if(r == -1)
            return -1;

        return Math.abs(l-r);
    }

    public static void main(String[] args){
        TestTree tree = new TestTree();
        Node root = tree.createTreeSimple();

        Balance op = new Balance();

        System.out.println(op.isBalance(root));

    }
}
