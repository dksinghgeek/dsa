package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

import java.util.*;

public class ZigZag {

    public List<Node> zigzag(Node node) {
        if (node == null)
            return null;

        boolean isRight = true;
        List<Node> level = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Stack<Node> stack = new Stack<>();
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();
                if (isRight) {
                    list.add(n);
                } else {
                    stack.push(n);
                }

                if (n.left != null) {
                    queue.offer(n.left);
                }

                if (n.right != null) {
                    queue.offer(n.right);
                }
            }

            isRight = !isRight;
            if (!list.isEmpty())
                level.addAll(list);

            while (!stack.isEmpty()) {
                level.add(stack.pop());
            }
        }
        return level;
    }

    public static void main(String[] args) {
        TestTree tree = new TestTree();
        Node root = tree.createTreeMaxSumPath();

        ZigZag op = new ZigZag();
        List<Node> level = op.zigzag(root);

        level.forEach(n -> System.out.print(" " + n.data));

    }
}
