package com.ggn.probs.ds.tree.node;

public class TestTree {
    public Node createTreeSimple(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        return n1;
    }

    public Node createTreeComplex(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n4.left = n6;
        n6.left = n7;

        return n1;
    }

    public Node createTreeMaxSumPath(){
        Node n1 = new Node(-10);
        Node n2 = new Node(20);
        Node n3 = new Node(7);
        Node n4 = new Node(15);
        Node n5 = new Node(6);
        Node n6 = new Node(-12);
        Node n7 = new Node(-5);
        Node n8 = new Node(1);
        Node n9 = new Node(2);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;

        n4.right = n7;

        n3.right = n6;
        n3.left = n5;

        n5.right = n8;
        n8.right = n9;

        return n1;
    }

    public Node createTreeSymmetry(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        Node n22 = new Node(2);
        Node n33 = new Node(3);
        Node n44 = new Node(4);
        Node n55 = new Node(5);
        Node n66 = new Node(6);

        n1.left = n2;
        n2.left = n4;
        n2.right = n5;
        n5.left= n6;

        n1.right = n22;
        n22.left = n55;
        n22.right = n44;
        n55.right= n66;

        return n1;
    }
}
