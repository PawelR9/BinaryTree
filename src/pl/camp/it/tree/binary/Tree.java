package pl.camp.it.tree.binary;

public class Tree {
    private Node root;

    public void add(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            addNode(root, value);
        }
    }

    private void addNode(Node node, int value) {
        if (value > node.getValue()) {
            if (node.getRight() == null) {
                node.setRight(new Node(value));
            } else {
                addNode(node.getRight(), value);
            }
        } else {
            if (node.getLeft() == null) {
                node.setLeft(new Node(value));
            } else {
                addNode(node.getLeft(), value);
            }
        }
    }

    public boolean contains(int value) {
        return containsValue(root, value);
    }

    private boolean containsValue(Node node, int value) {

        if (node == null) {
            return false;
        }
        if (value == node.getValue()) {
            return true;

        } else if (value > node.getValue()) {

            return containsValue(node.getRight(), value);

        } else {
            return containsValue(node.getLeft(), value);
        }
    }

    public int max() {
        Node current = root;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current.getValue();

    }
    public int min() {
        Node current = root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current.getValue();
    }
}
