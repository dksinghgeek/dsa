package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversal {
    public void levelOrder(Node node){
        if(node == null)
            return;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(node);

        while (!q.isEmpty()){
            Node temp = q.poll();
            System.out.print(" " + temp.data);

            if(temp.left != null){
                q.offer(temp.left);
            }

            if(temp.right != null){
                q.offer(temp.right);
            }
        }
    }

    public static void main(String[] args){
        TestTree tree = new TestTree();
        Node root = tree.createTreeSimple();

        LevelOrderTraversal op = new LevelOrderTraversal();
        op.levelOrder(root);
    }
}
