package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

public class CountTotalNodesInCompleteBinaryTree {
    public double count(Node node) {
        if(node == null) return 0;

        int l = heightLeft(node);
        int r = heightRight(node);

        if(l == r){
            return Math.pow(2,l) - 1;
        }

        return 1 + count(node.left) + count(node.right);
    }

    public int heightLeft(Node node){
        int h = 0;

        while(node != null){
            h++;
            node = node.left;
        }

        return h;
    }

    public int heightRight(Node node){
        int h = 0;

        while(node != null){
            h++;
            node = node.right;
        }

        return h;
    }

    public static void main(String[] args){
        TestTree tree = new TestTree();
        Node root = tree.createTreeSimple();

        CountTotalNodesInCompleteBinaryTree op = new CountTotalNodesInCompleteBinaryTree();
        System.out.println(op.count(root));
    }
}
