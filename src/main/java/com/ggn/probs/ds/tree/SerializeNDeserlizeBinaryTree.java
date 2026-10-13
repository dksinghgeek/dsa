package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

import java.util.*;

public class SerializeNDeserlizeBinaryTree {
    public String serialzie(Node node) {
        if (node == null) return "#,";

        StringBuilder str = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            if (n == null) {
                str.append("#,");
                continue;
            }

            str.append(n.data).append(",");
            queue.offer(n.left);
            queue.offer(n.right);
        }

        return str.toString();
    }

    public Node deSerlize(String str) {
        String[] data = str.split(",");

        if (data[0].equals("#")) return null;

        Node root = new Node(Integer.parseInt(data[0]));
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty() && index < data.length) {
            Node n = queue.poll();

            if(!data[index].equals("#")){
                n.left = new Node(Integer.parseInt(data[index]));
                queue.offer(n.left);
            }

            index++;

            if(index < data.length && !data[index].equals("#")){
                n.right = new Node(Integer.parseInt(data[index]));
                queue.offer(n.right);
            }
            index++;
        }

        return root;
    }


    public void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.print(" " + node.data);
        inOrder(node.right);
    }

    public static void main(String[] args) {
        TestTree tree = new TestTree();
        Node root = tree.createTreeComplex();

        SerializeNDeserlizeBinaryTree op = new SerializeNDeserlizeBinaryTree();

        op.inOrder(root);
        System.out.println();

        String out = op.serialzie(root);
        System.out.println(out);

        op.inOrder(op.deSerlize(out));

    }
}
