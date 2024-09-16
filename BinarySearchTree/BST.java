package BinarySearchTree;

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // insert node on a BST or build BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        }
        else {
            root.right = insert(root.right, val);
        }

        return root;
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

    // search in a BST - O(H)
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data > key) {
            return search(root.left, key); // left subtree
        }
        else if (root.data == key) {
            return true;
        }
        else {
            return search(root.right, key); // right subtree
        }
    }

    // delete a node
    public static Node delete(Node root, int key) {
        if (root.data > key) {
            root.left = delete(root.left, key);
        } else if (root.data < key) {
            root.right = delete(root.right, key);
        }
        else {
            // case-1
            if (root.left == null && root.right == null) {
                return null;
            }

            // case-2
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case-3
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    // finding in-order successor
    public static Node inorderSuccessor(Node root) {
        while (root.left != null) { // left most node of right subtree
            root = root.left;
        }
        return root;
    }

    public static void main(String [] args) {
        int[] values = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for (int i=0; i<values.length; i++) {
            root = insert(root, values[i]);
        }

        inOrder(root);
        if (search(root, 3)) {
            System.out.println("Node found");
        } else {
            System.out.println("Node not found");
        }

        delete(root, 5);
        inOrder(root);
    }
}
