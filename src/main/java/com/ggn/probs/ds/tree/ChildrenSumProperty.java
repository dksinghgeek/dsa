package com.ggn.probs.ds.tree;

import com.ggn.probs.ds.tree.node.Node;
import com.ggn.probs.ds.tree.node.TestTree;

public class ChildrenSumProperty {
    public void changeChild(Node node) {
        if(node == null)
            return;

        int child = 0;
        if(node.left != null) child += node.left.data;
        if(node.right != null) child += node.right.data;

        if(child >= node.data){
            node.data = child;
        } else{
            if(node.left != null){
                node.left.data = node.data;
            }

            if(node.right != null){
                node.right.data = node.data;
            }
        }

        changeChild(node.left);
        changeChild(node.right);

        int tot = 0;
        if(node.left != null){
            tot += node.left.data;
        }

        if(node.right != null){
            tot += node.right.data;
        }

        if(node.left != null || node.right != null){
            node.data = tot;
        }
    }

    public static void main(String[] args) {
        TestTree tree = new TestTree();
        Node root = tree.createTreeSimple();

        ChildrenSumProperty op = new ChildrenSumProperty();
        op.changeChild(root);

        LevelOrderTraversal tr = new LevelOrderTraversal();
        tr.levelOrder(root);
    }
}
