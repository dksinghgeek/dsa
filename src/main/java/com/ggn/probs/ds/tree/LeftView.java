package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeftView {
    public void leftView(Node node){
        List<Node> list = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node n = queue.poll();
                if(i == 0){
                    list.add(n);
                }

                if(n.left != null){
                    queue.offer(n.left);
                }

                if(n.right != null){
                    queue.offer(n.right);
                }
            }
        }

        list.forEach(n -> System.out.print(" " + n.data));
    }

    public static void main(String[] args) {
        TestTree testTree = new TestTree();
        Node node = testTree.createTreeSimple();

        LeftView leftView = new LeftView();
        leftView.leftView(node);
    }
}
