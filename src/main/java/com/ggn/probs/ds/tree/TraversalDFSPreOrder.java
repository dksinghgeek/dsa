package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

import java.util.Stack;

public class TraversalDFSPreOrder {
    public void preOrderRecursion(Node node) {
        if (node == null)
            return;

        System.out.print(" " + node.data);
        preOrderRecursion(node.left);
        preOrderRecursion(node.right);
    }

    public void preOrderIterative(Node node) {
        if(node == null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()){
            Node temp = stack.pop();

            System.out.print(" " + temp.data);

            if(temp.right != null){
                stack.push(temp.right);
            }

            if(temp.left != null){
                stack.push(temp.left);
            }
        }
    }

    public static void main(String[] args) {
        TestTree tree = new TestTree();
        Node root = tree.createTreeSimple();

        TraversalDFSPreOrder op = new TraversalDFSPreOrder();
        op.preOrderRecursion(root);

        System.out.println();
        op.preOrderIterative(root);

    }
}
