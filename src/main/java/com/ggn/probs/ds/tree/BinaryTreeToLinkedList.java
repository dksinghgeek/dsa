package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

public class BinaryTreeToLinkedList {
    Node next = null;
    public void flatten(Node node){
        if(node == null)
            return;

        flatten(node.right);
        flatten(node.left);

        node.left = null;
        node.right = next;
        next = node;
    }

    public static void main(String[] args){
        TestTree tree = new TestTree();
        Node root = tree.createTreeSimple();

        BinaryTreeToLinkedList op = new BinaryTreeToLinkedList();
        op.flatten(root);

        Node current = root;
        while(current != null){
            System.out.print(" " + current.data);
            current = current.right;
        }

    }
}
