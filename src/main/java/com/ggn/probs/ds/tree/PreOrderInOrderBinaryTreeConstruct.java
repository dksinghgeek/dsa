package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;

import java.util.HashMap;
import java.util.Map;

public class PreOrderInOrderBinaryTreeConstruct {
    private Map<Integer, Integer> map = new HashMap<>();
    private int preIndex = 0;

    public Node buildTree(int[] inOrder, int[] preOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }

        return build(preOrder, 0, inOrder.length-1);
    }

    public Node build(int[] pre, int start, int end) {
        if (start > end) return null;

        int data = pre[preIndex++];
        int inOrderIndex = map.get(data);

        Node root = new Node(data);

        root.left = build(pre, start, inOrderIndex - 1);
        root.right = build(pre, inOrderIndex + 1, end);

        return root;
    }

    public void inOrder(Node node){
        if(node == null) return;

        inOrder(node.left);
        System.out.print(" " + node.data);
        inOrder(node.right);
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6};
        int[] inorder = {4, 2, 5, 1, 3, 6};


        PreOrderInOrderBinaryTreeConstruct op = new PreOrderInOrderBinaryTreeConstruct();
        Node node = op.buildTree(inorder, preorder);

        op.inOrder(node);

    }
}
