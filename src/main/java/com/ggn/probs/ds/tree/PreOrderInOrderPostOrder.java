package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.Pair;
import com.ggn.probs.ds.tree.node.TestTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderInOrderPostOrder {
    public void traversal(Node node) {
        if (node == null)
            return;

        List<Node> preOrder = new ArrayList<>();
        List<Node> inOrder = new ArrayList<>();
        List<Node> postOrder = new ArrayList<>();

        Stack<Pair<Node, Integer>> stack = new Stack<>();
        Pair<Node, Integer> root = new Pair<>(node, 1);
        stack.push(root);

        while (!stack.isEmpty()) {
            Pair pair = stack.pop();

            if (pair.y == Integer.valueOf(1)) {
                pair.y = 2;
                stack.push(pair);

                Node temp = (Node) pair.x;
                preOrder.add(temp);
                if (temp.left != null) {
                    Pair<Node, Integer> left = new Pair<>(temp.left, 1);
                    stack.push(left);
                }
            } else if(pair.y == Integer.valueOf(2)){
                pair.y = 3;
                stack.push(pair);

                Node temp = (Node) pair.x;
                inOrder.add(temp);
                if(temp.right != null){
                    Pair<Node,Integer> right = new Pair<>(temp.right, 1);
                    stack.push(right);
                }
            } else{
                Node temp = (Node) pair.x;
                postOrder.add(temp);
            }
        }

        System.out.println("Pre Order");
        preOrder.forEach(o -> System.out.print(" " + o.data));
        System.out.println("\nIn Order");
        inOrder.forEach(o -> System.out.print(" " + o.data));
        System.out.println("\nPost Order");
        postOrder.forEach(o -> System.out.print(" " + o.data));

    }

    public static void main(String[] args) {
        TestTree tree = new TestTree();
        Node root = tree.createTreeComplex();

        PreOrderInOrderPostOrder op = new PreOrderInOrderPostOrder();
        op.traversal(root);
    }
}
