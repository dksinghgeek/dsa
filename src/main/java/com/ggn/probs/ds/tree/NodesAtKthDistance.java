package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

import java.util.*;

public class NodesAtKthDistance {

    public void nodesAtKthDistance(Node node, int target, int k) {
        if (node == null) return;

        Node start =  findNode(node,target);
        if(findNode(node,target) == null) return;

        List<Node> res = new ArrayList<>();
        Map<Integer, Boolean> isVisited = new HashMap<>();
        Map<Node, Node> map = mapParents(node);
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        isVisited.put(start.data,Boolean.TRUE);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if(level == k) break;
            level++;
            for(int i = 0; i < size; i++){
                Node n = queue.poll();

                if(n.left != null && isVisited.get(n.left.data) == null) {
                    queue.offer(n.left);
                    isVisited.put(n.left.data,Boolean.TRUE);
                }
                if(n.right != null && isVisited.get(n.right.data) == null){
                    queue.offer(n.right);
                    isVisited.put(n.right.data,Boolean.TRUE);
                }
                Node parent = map.get(n);
                if(parent != null && isVisited.get(parent.data) == null){
                    queue.offer(parent);
                    isVisited.put(parent.data,Boolean.TRUE);
                }
            }
        }

        while(!queue.isEmpty()){
            res.add(queue.poll());
        }

        res.forEach(n -> System.out.print(" " + n.data));
    }

    public Node findNode(Node node, int target){
        if(node == null) return null;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            Node n = queue.poll();

            if(n.data == target) return n;

            if(n.left != null) queue.offer(n.left);
            if(n.right != null) queue.offer(n.right);
        }

        return null;
    }

    public Map<Node, Node> mapParents(Node node) {
        Map<Node, Node> map = new HashMap<>();

        if (node == null) return map;

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            if (n.left != null) {
                map.put(n.left, n);
                queue.offer(n.left);
            }

            if (n.right != null) {
                map.put(n.right, n);
                queue.offer(n.right);
            }
        }

        return map;
    }

    public static void main(String[] args) {
        TestTree tree = new TestTree();
        Node root = tree.createTreeComplex();

        NodesAtKthDistance op = new NodesAtKthDistance();
        op.nodesAtKthDistance(root, 4,2);
    }
}
