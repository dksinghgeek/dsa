package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

import java.util.ArrayList;
import java.util.List;

public class MorrisInOrderTraversal {
    public List<Node> inOrderTraversal(Node node) {
        List<Node> res = new ArrayList<>();
        Node current = node;

        while (current != null) {
            if (current.left == null) {
                res.add(current);
                current = current.right;
            } else {
                Node pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    res.add(current);
                    current = current.right;
                }
            }
        }

        return res;
    }

    public List<Node> preOrder(Node node) {
        List<Node> res = new ArrayList<>();
        Node current = node;

        while (current != null) {
            if (current.left == null) {
                res.add(current);
                current = current.right;
            } else {
                Node pre = current.left;
                while(pre.right != null && pre.right != current){
                    pre = pre.right;
                }

                if(pre.right == null){
                    pre.right = current;
                    res.add(current);
                    current = current.left;
                }else{
                    pre.right = null;
                    current = current.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TestTree tree = new TestTree();
        Node root = tree.createTreeSimple();

        MorrisInOrderTraversal op = new MorrisInOrderTraversal();
        List<Node> inOrder = op.inOrderTraversal(root);
        inOrder.forEach(n -> System.out.print(" " + n.data));

        System.out.println();

        List<Node> preOrder = op.preOrder(root);
        preOrder.forEach(n -> System.out.print(" " + n.data));
    }
}
