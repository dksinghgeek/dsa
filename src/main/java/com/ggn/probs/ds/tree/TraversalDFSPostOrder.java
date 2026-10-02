package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

import java.util.Stack;

public class TraversalDFSPostOrder {
    public void postOrderRecursion(Node node) {
        if (node == null)
            return;

        postOrderRecursion(node.left);
        postOrderRecursion(node.right);
        System.out.print(" " + node.data);

    }

    public void postOrder2StackInterative(Node node) {
        if (node == null)
            return;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(node);
        while (!st1.isEmpty()) {
            Node n = st1.pop();

            st2.push(n);
            if (n.left != null) {
                st1.push(n.left);
            }

            if (n.right != null) {
                st1.push(n.right);
            }
        }

        while (!st2.isEmpty()) {
            System.out.print(" " + st2.peek().data);
            st2.pop();
        }
    }

    public void postOrder1StackIterative(Node node){
        if(node == null)
            return;
        Stack<Node> stack = new Stack<>();
        Node current = node;
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                current = current.left;
            } else{
                Node temp = stack.peek().right;
                if(temp == null){
                    temp = stack.peek();
                    System.out.print(" " + temp.data);
                    stack.pop();

                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.peek();
                        stack.pop();
                        System.out.print(" " + temp.data);
                    }

                } else{
                    current = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        TestTree tree = new TestTree();
        Node root = tree.createTreeSimple();

        TraversalDFSPostOrder op = new TraversalDFSPostOrder();
        op.postOrderRecursion(root);

        System.out.println();
        op.postOrder2StackInterative(root);
        System.out.println();
        op.postOrder1StackIterative(root);
    }
}
