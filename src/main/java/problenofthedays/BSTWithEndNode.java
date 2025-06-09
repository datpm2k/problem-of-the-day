package problenofthedays;

public class BSTWithEndNode {

    public static void main(String[] args) {
        int[] arr = {8, 5, 9, 2, 7, 1};
        // int[] arr = {269, 1, 934, -1, 188, 755, -1, 2, 216, 746, -1, -1, -1, -1, -1, 510, -1, 358, 641, 279, -1, 546, 706, -1, -1, -1, -1, -1, 714};

        Node root = null;
        for (int value : arr) {
            root = insertIterate(root, value);
        }

        System.out.println(isDeadEnd(root));
    }

    static boolean isDeadEnd(Node root) {
        return isDeadEndRecursive(root, 1, Integer.MAX_VALUE);
    }

    static boolean isDeadEndRecursive(Node root, int min, int max) {
        if (root == null) {
            return false;
        }

        if (min == max) {
            return true;
        }

        return isDeadEndRecursive(root.left, min, root.data - 1)
                || isDeadEndRecursive(root.right, root.data + 1, max);
    }

    private static Node insertIterate(Node root, int data) {
        Node temp = new Node(data);
        if (root == null) {
            return temp;
        }
        if (root.data == data) {
            return root;
        }
        Node parent = null;
        Node curr = root;
        while (curr != null) {
            parent = curr;
            if (curr.data > data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if (parent.data > data) {
            parent.left = temp;
        } else {
            parent.right = temp;
        }

        return root;
    }

    private static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
}
