// This class represents a tree of integers
public class IntSearchTree {
    private IntTreeNode overallRoot;

    // Constructs the tree shown
    public IntSearchTree() {
        overallRoot = null;
    }

    public IntSearchTree(int[] values) {
        overallRoot = constructorHelper(values, 0);
    }

    private IntTreeNode constructorHelper(int[] values, int i) {
        if (i < values.length) {
            IntTreeNode root = new IntTreeNode(values[i]);
            root.left = constructorHelper(values, i*2 + 1);
            root.right = constructorHelper(values, i*2 + 2);
            return root;
        } else {
            return null;
        }
    }

    public boolean contains(int value) {
        return contains(overallRoot, value);
    }

    private boolean contains(IntTreeNode root, int value) {
        if (root == null) {
            return false;
        } else if (root.data == value) {
            return true;
        } else if (value < root.data) {
            return contains(root.left, value);
        } else {    // value > root.data
            return contains(root.right, value);
        }
    }

    public void add(int value) {
        overallRoot = add(overallRoot, value);
    }

    private IntTreeNode add(IntTreeNode root, int value) {
        if (root == null) {
            root = new IntTreeNode(value);
        } else if (value < root.data) {
            root.left = add(root.left, value);
        } else {    // value > root.data
            root.right = add(root.right, value);
        }
        return root;
    }

    public String toString() {
        return toString(overallRoot);
    }

    private String toString(IntTreeNode node) {
        if (node == null) {
            return "empty";
        } else if (node.left == null && node.right == null) {
            return "" + node.data;
        } else {
            String result = "(" + node.data + ", ";
            result += toString(node.left);
            result += ", " + toString(node.right) + ")";
            return result;
        }
    }

    // prints out all data contained in the tree on a single line
    // based on a preorder traversal sequence
    public void preOrderTraversal() {
        preOrderTraversal(overallRoot);
    }

    private void preOrderTraversal(IntTreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    // prints out all data contained in the tree on a single line
    // based on an inorder traversal sequence
    public void inOrderTraversal() {
        inOrderTraversal(overallRoot);
    }

    private void inOrderTraversal(IntTreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    // prints out all data contained in the tree on a single line
    // based on a postorder traversal sequence
    public void postOrderTraversal() {
        postOrderTraversal(overallRoot);
    }

    private void postOrderTraversal(IntTreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    private void printSideways(IntTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }

    public void addRand(int size) {
        for(int i = 0; i < size; i++) {
            int random = (int) (Math.random() * 101);
            this.add(random);
        }
    }

    // Class that represents a single node in the tree
    private static class IntTreeNode {
        public int data; // data stored at this node
        public IntTreeNode left; // reference to left subtree
        public IntTreeNode right; // reference to right subtree

        // Constructs a leaf node with the given data.
        public IntTreeNode(int data) {
            this(data, null, null);
        }

        // Constructs a leaf or branch node with the given data and links.
        public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}