package com.example.agent.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AgentService {

    static class BSTNode {
        String name;
        BSTNode left, right;

        BSTNode(String name) {
            this.name = name;
        }
    }

    static class BinarySearchTree {
        private BSTNode root;

        void insert(String name) {
            root = insertRec(root, name);
        }

        private BSTNode insertRec(BSTNode root, String name) {
            if (root == null) return new BSTNode(name);
            if (name.compareToIgnoreCase(root.name) < 0) root.left = insertRec(root.left, name);
            else if (name.compareToIgnoreCase(root.name) > 0) root.right = insertRec(root.right, name);
            return root;
        }

        void inOrderTraversal(BufferedWriter writer) throws IOException {
            inOrderRec(root, writer);
        }

        private void inOrderRec(BSTNode node, BufferedWriter writer) throws IOException {
            if (node != null) {
                inOrderRec(node.left, writer);
                writer.write(node.name + "\n");
                inOrderRec(node.right, writer);
            }
        }
    }

    private final List<Agent> agents = new ArrayList<>();

    public List<Agent> processAgents() {
        agents.clear();
        BinarySearchTree bst = new BinarySearchTree();

        try (BufferedReader reader = new BufferedReader(
                new FileReader("C:\\Users\\akila\\Desktop\\New folder (5)\\untitled41 (2)\\untitled41\\src\\main\\webapp\\Agent.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String name = parts[0].trim();
                    double rating = Double.parseDouble(parts[1].trim());
                    agents.add(new Agent(name, rating));
                    bst.insert(name);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("C:\\Users\\akila\\Desktop\\New folder (5)\\untitled41 (2)\\untitled41\\src\\main\\webapp\\names.txt"))) {
            bst.inOrderTraversal(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        selectionSortByRating(agents);

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("C:\\Users\\akila\\Desktop\\New folder (5)\\untitled41 (2)\\untitled41\\src\\main\\webapp\\output.txt"))) {
            for (Agent agent : agents) {
                writer.write(agent.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return agents;
    }

    private void selectionSortByRating(List<Agent> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getRating() > list.get(maxIdx).getRating()) {
                    maxIdx = j;
                }
            }
            Agent temp = list.get(i);
            list.set(i, list.get(maxIdx));
            list.set(maxIdx, temp);
        }
    }
}



