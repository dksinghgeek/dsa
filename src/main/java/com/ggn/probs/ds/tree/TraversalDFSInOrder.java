package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

import java.util.Stack;

public class TraversalDFSInOrder {
    public void inOrderRecursion(Node node){
        if(node == null)
            return;

        inOrderRecursion(node.left);
        System.out.print(" " + node.data);
        inOrderRecursion(node.right);
    }

    public void inOrderIterative(Node node){
        if(node == null)
             return;
        Stack<Node> stack = new Stack<>();
        Node current = node;
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                current = current.left;
            } else{
                Node temp = stack.pop();
                System.out.print(" " + temp.data);

                current = temp.right;
            }
        }
    }

    public static void main(String[] args){
        TestTree tree = new TestTree();
        Node root = tree.createTreeSimple();

        TraversalDFSInOrder op = new TraversalDFSInOrder();
        op.inOrderRecursion(root);

        System.out.println();
        op.inOrderIterative(root);
    }
}
