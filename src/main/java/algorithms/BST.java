package algorithms;

/**
 * Binary search tree
 */
public class BST {

    public static void main(String[] args) {
        Node root = new Node(50);
        root = insertIterate(root, 30);
        root = insertIterate(root, 70);
        root = insertIterate(root, 20);
        root = insertIterate(root, 40);
        root = insertIterate(root, 60);
        root = insertIterate(root, 80);

        System.out.println(search(root, 15) != null ? "Found" : "Not found");
        System.out.println(search(root, 40) != null ? "Found" : "Not found");
    }

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (root.key == key) {
            return root;
        }
        if (root.key > key) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }

        return root;
    }

    public static Node insertIterate(Node root, int key) {
        Node temp = new Node(key);
        if (root == null) {
            return temp;
        }
        if (root.key == key) {
            return root;
        }
        Node parent = null;
        Node curr = root;
        while (curr != null) {
            parent = curr;
            if (curr.key > key) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if (parent.key > key) {
            parent.left = temp;
        } else {
            parent.right = temp;
        }

        return root;
    }

    public static Node search(Node root, int key) {
        if (root == null || root.key == key) {
            return root;
        }

        if (root.key > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static class Node {
        private final int key;
        private Node left;
        private Node right;

        public Node(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    public static boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }
}
