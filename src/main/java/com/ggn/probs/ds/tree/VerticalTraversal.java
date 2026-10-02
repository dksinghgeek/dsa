package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.Pair;
import com.ggn.probs.ds.tree.node.TestTree;

import java.util.*;

public class VerticalTraversal {
    public List<Node> verticalTraversal(Node node, int hd) {
        if (node == null)
            return null;

        List<Node> result = new ArrayList<>();
        Map<Integer, List<Node>> map = new TreeMap<>();
        Queue<Pair<Integer, Node>> queue = new ArrayDeque<>();
        Pair<Integer, Node> pair = new Pair<>(hd, node);
        queue.offer(pair);

        while (!queue.isEmpty()) {
            Pair<Integer, Node> pairTmp = queue.poll();

            if (!map.containsKey(pairTmp.x)) {
                List<Node> list = new ArrayList<>();
                list.add(pairTmp.y);
                map.put(pairTmp.x, list);
            } else {
                List<Node> list = map.get(pairTmp.x);
                list.add(pairTmp.y);
                map.put(pairTmp.x, list);
            }

            if (pairTmp.y.left != null) {
                Pair<Integer, Node> t = new Pair<>(pairTmp.x - 1, pairTmp.y.left);
                queue.offer(t);
            }

            if (pairTmp.y.right != null) {
                Pair<Integer, Node> t = new Pair<>(pairTmp.x + 1, pairTmp.y.right);
                queue.offer(t);
            }
        }
        for(Map.Entry<Integer, List<Node>> entry : map.entrySet()){
            result.addAll(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        TestTree tree = new TestTree();
        Node root = tree.createTreeSimple();

        VerticalTraversal op = new VerticalTraversal();
        List<Node> list = op.verticalTraversal(root, 0);

        list.forEach(n -> System.out.print(" " + n.data));
    }
}
