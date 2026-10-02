package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

import java.util.*;

public class RightView {

    public void rightView(Node root){
        if(root == null) return;

        List<Node> result = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                Node n = queue.poll();

                if(i == size-1){
                    result.add(n);
                }

                if(n.left != null){
                    queue.offer(n.left);
                }

                if(n.right != null){
                    queue.offer(n.right);
                }
            }
        }

        result.forEach(entry -> System.out.print(" " + entry.data));
    }

    public static void main(String[] args) {
        TestTree testTree = new TestTree();
        Node node = testTree.createTreeSimple();

        RightView topView = new RightView();
        topView.rightView(node);
    }
}
