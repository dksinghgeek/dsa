package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

public class Height {
    public int height(Node node){
        if(node == null)
            return 0;

        int l = height(node.left);
        int r = height(node.right);

        return 1 + Math.max(l,r);
    }

    public static void main(String[] args){
        TestTree tree = new TestTree();
        Node root = tree.createTreeSimple();

        Height op = new Height();

        System.out.println(op.height(root));

    }
}
