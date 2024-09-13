package BinaryTree;
import com.sun.source.tree.Tree;

import java.util.*;

public class BinaryTreeQS {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;

        public static Node buildTree(int[] nodes) {
            index++; // Increment index
            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);  // Build left subtree
            newNode.right = buildTree(nodes); // Build right subtree

            return newNode;
        }
    }

    // pre-order traversal - O(n)
    public static void preOrder(Node root) {
            if (root == null) {
                return;
            }
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
    }

    // in-order traversal
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    // post-order traversal
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    // level-order traversal
    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node currNode = queue.remove();

            if (currNode == null) {
                System.out.println();
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            }
            else {
                System.out.print(currNode.data);
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }
    }

    // count of nodes
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    // sum of nodes
    public static int sumNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sumNodes(root.left);
        int rightSum = sumNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    // height of a binary tree
    public static int heightTree(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = heightTree(root.left);
        int rightHeight = heightTree(root.right);

        int totalHeight = Math.max(leftHeight, rightHeight) + 1;

        return totalHeight;
    }

    // diameter of tree --> approach1 O(n^2)
    public static int diameter1(Node root) {
        if (root == null) {
            return 0;
        }

        int diameter1 = diameter1(root.left);
        int diameter2 = diameter1(root.right);
        int diameter3 = heightTree(root.left) + heightTree(root.right) + 1;

        return Math.max(diameter3, Math.max(diameter1, diameter2));
    }

    // diameter of tree --> approach2 O(n)
    static class TreeInfo {
        int height;
        int diameter;

        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }

        public static TreeInfo diameter2(Node root) {
            if (root == null) {
                return new TreeInfo(0, 0);
            }

            TreeInfo left = diameter2(root.left);
            TreeInfo right = diameter2(root.right);

            int totalHeight = Math.max(left.height, right.height) + 1;

            int diameterA = left.diameter;
            int diameterB = right.diameter;
            int diameterC = left.height + right.height + 1;

            int totalDiameter = Math.max(Math.max(diameterA, diameterB), diameterC);

            TreeInfo myInfo = new TreeInfo(totalHeight, totalDiameter);

            return myInfo;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        preOrder(root);
        inOrder(root);
        postOrder(root);
        levelOrder(root);
        System.out.println("Total no. of nodes: " + countNodes(root));
        System.out.println("Sum of nodes: " + sumNodes(root));
        System.out.println("Height of tree: " + heightTree(root));
        System.out.println("Diameter of tree (Approach-1): " + diameter1(root));
    }
}
