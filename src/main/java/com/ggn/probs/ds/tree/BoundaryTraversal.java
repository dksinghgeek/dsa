package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    private List<Node> bottom = new ArrayList<>();
    public List<Node> anticlockBoundary(Node node) {
        if (node == null) {
            return null;
        }

        List<Node> list = new ArrayList<>();
        Node cur = node.left;
        while (cur != null) {
            if (!isLeaf(cur)) list.add(cur);

            if (cur.left == null)
                cur = cur.right;
            else
                cur = cur.left;
        }

        return list;
    }

    public boolean isLeaf(Node node) {
        if (node == null) return false;

        if (node.left == null && node.right == null)
            return true;

        return false;
    }

    public List<Node> clockBoundary(Node node) {
        if (node == null) return null;

        List<Node> list = new ArrayList<>();
        Node cur = node.right;
        while (cur != null) {
            if (!isLeaf(cur)) list.add(cur);

            if (node.right == null)
                cur = cur.left;
            else
                cur = cur.right;
        }

        return list;
    }

    public void inOrderLeaf(Node node){
        if(node == null) return;

        inOrderLeaf(node.left);
        if(isLeaf(node)){
            bottom.add(node);
        }

        inOrderLeaf(node.right);
    }

    public static void main(String[] args) {
        TestTree tree = new TestTree();
        Node root = tree.createTreeMaxSumPath();

        BoundaryTraversal op = new BoundaryTraversal();
        List<Node> left = op.anticlockBoundary(root);
        left.forEach(n -> System.out.print(" " + n.data));

        System.out.println();

        List<Node> right = op.clockBoundary(root);
        right.forEach(n -> System.out.print(" " + n.data));

        System.out.println();

        op.inOrderLeaf(root);
        op.bottom.forEach(n -> System.out.print(" " + n.data));

        List<Node> res = new ArrayList<>();

        res.add(root);
        if(!left.isEmpty()){
            res.addAll(left);
        }

        if(!op.bottom.isEmpty()){
            res.addAll(op.bottom);
        }

        if(!right.isEmpty()){
            res.addAll(right);
        }

        System.out.println("\nFinal result");

        res.forEach(n -> System.out.print(" " + n.data));
    }
}
