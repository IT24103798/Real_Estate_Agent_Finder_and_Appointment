import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BinarySearchTree {
    private class Node {
        Agent agent;
        Node left, right;

        Node(Agent agent) {
            this.agent = agent;
        }
    }

    private Node root;

    public void insert(Agent agent) {
        root = insertRec(root, agent);
    }

    private Node insertRec(Node root, Agent agent) {
        if (root == null) return new Node(agent);
        if (agent.getFullName().compareToIgnoreCase(root.agent.getFullName()) < 0)
            root.left = insertRec(root.left, agent);
        else
            root.right = insertRec(root.right, agent);
        return root;
    }

    public void saveToFile(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            saveInOrder(root, writer);
        }
    }

    private void saveInOrder(Node node, BufferedWriter writer) throws IOException {
        if (node == null) return;
        saveInOrder(node.left, writer);
        writer.write(node.agent.toFileFormat());
        writer.newLine();
        saveInOrder(node.right, writer);
    }
}
