package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;

import java.util.HashMap;
import java.util.Map;

public class PostOrderInOrderBinaryTreeConstruct {
    static private Map<Integer, Integer> map = new HashMap<>();
    static private int postIndex;


    public Node buildTree(int[] postOrder, int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }

        postIndex = postOrder.length - 1;

        return build(postOrder, 0, inOrder.length - 1);
    }

    private Node build(int[] postOrder, int start, int end) {
        if (start > end) return null;

        int data = postOrder[postIndex--];
        int inOrderIndex = map.get(data);

        Node root = new Node(data);

        root.right = build(postOrder, inOrderIndex + 1, end);
        root.left = build(postOrder, start, inOrderIndex - 1);


        return root;
    }

    public void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.print(" " + node.data);
        inOrder(node.right);
    }

    public static void main(String[] args) {
        int[] postOrder = {9, 15, 7, 20, 3};
        int[] inOrder = {9, 3, 15, 20, 7};

        PostOrderInOrderBinaryTreeConstruct op = new PostOrderInOrderBinaryTreeConstruct();
        Node node = op.buildTree(postOrder, inOrder);

        op.inOrder(node);
    }
}
