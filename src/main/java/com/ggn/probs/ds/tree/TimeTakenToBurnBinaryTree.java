package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class TimeTakenToBurnBinaryTree {

    public int burn(Node node, int target) {
        if (node == null)
            return 0;
        int time = 0;
        Map<Integer, Node> parentsMap = parentsMap(node);
        Node source = findSource(node, target);
        Map<Integer, Boolean> isVisited = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(source);
        isVisited.put(source.data, true);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int f = 0;
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();

                if (n.left != null && isVisited.get(n.left.data) == null) {
                    f = 1;
                    queue.offer(n.left);
                    isVisited.put(n.left.data, true);
                }

                if (n.right != null && isVisited.get(n.right.data) == null) {
                    f = 1;
                    queue.offer(n.right);
                    isVisited.put(n.right.data, true);
                }

                Node parent = parentsMap.get(n.data);
                if (parent != null && isVisited.get(parent.data) == null) {
                    f = 1;
                    queue.offer(parent);
                    isVisited.put(parent.data, true);
                }
            }

            if (f == 1) {
                time++;
            }

        }

        return time;
    }

    private Node findSource(Node node, int target) {
        if (node == null)
            return null;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node n = queue.poll();

            if (n.data == target) {
                return n;
            }

            if (n.left != null) {
                queue.offer(n.left);
            }

            if (n.right != null) {
                queue.offer(n.right);
            }

        }

        return null;
    }

    private Map<Integer, Node> parentsMap(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        if(node == null)
            return map;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        map.put(node.data, null);

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            if (n.left != null) {
                map.put(n.left.data, n);
                queue.offer(n.left);
            }

            if (n.right != null) {
                map.put(n.right.data, n);
                queue.offer(n.right);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        TestTree tree = new TestTree();
        Node root = tree.createTreeSimple();

        TimeTakenToBurnBinaryTree op = new TimeTakenToBurnBinaryTree();
        System.out.println(op.burn(root, 4));
    }
}
