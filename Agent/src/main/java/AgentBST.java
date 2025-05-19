package com.realstate.bst;

import com.realstate.model.Agent;

import java.util.ArrayList;
import java.util.List;

public class AgentBST {
    private AgentNode root;

    public AgentBST() {
        this.root = null;
    }

    // Insert agent based on agentId (you can change criteria)
    public void insert(Agent agent) {
        root = insertRec(root, agent);
    }

    private AgentNode insertRec(AgentNode root, Agent agent) {
        if (root == null) {
            root = new AgentNode(agent);
            return root;
        }
        if (agent.getAgentId().compareTo(root.getAgent().getAgentId()) < 0) {
            root.setLeft(insertRec(root.getLeft(), agent));
        } else if (agent.getAgentId().compareTo(root.getAgent().getAgentId()) > 0) {
            root.setRight(insertRec(root.getRight(), agent));
        } else {
            // agentId already exists, update agent info (optional)
            root.getAgent().setName(agent.getName());
            root.getAgent().setLocation(agent.getLocation());
            root.getAgent().setRating(agent.getRating());
            root.getAgent().setContact(agent.getContact());
        }
        return root;
    }

    // Search by agentId
    public Agent searchById(String agentId) {
        AgentNode node = searchByIdRec(root, agentId);
        return node == null ? null : node.getAgent();
    }

    private AgentNode searchByIdRec(AgentNode root, String agentId) {
        if (root == null || root.getAgent().getAgentId().equals(agentId)) {
            return root;
        }
        if (agentId.compareTo(root.getAgent().getAgentId()) < 0) {
            return searchByIdRec(root.getLeft(), agentId);
        }
        return searchByIdRec(root.getRight(), agentId);
    }

    // Inorder traversal (to list all agents sorted by agentId)
    public List<Agent> inOrder() {
        List<Agent> agents = new ArrayList<>();
        inOrderRec(root, agents);
        return agents;
    }

    private void inOrderRec(AgentNode root, List<Agent> agents) {
        if (root != null) {
            inOrderRec(root.getLeft(), agents);
            agents.add(root.getAgent());
            inOrderRec(root.getRight(), agents);
        }
    }

    // Delete agent by agentId
    public void delete(String agentId) {
        root = deleteRec(root, agentId);
    }

    private AgentNode deleteRec(AgentNode root, String agentId) {
        if (root == null) return root;

        if (agentId.compareTo(root.getAgent().getAgentId()) < 0) {
            root.setLeft(deleteRec(root.getLeft(), agentId));
        } else if (agentId.compareTo(root.getAgent().getAgentId()) > 0) {
            root.setRight(deleteRec(root.getRight(), agentId));
        } else {
            // Node to delete found

            // Node with one or no child
            if (root.getLeft() == null) return root.getRight();
            else if (root.getRight() == null) return root.getLeft();

            // Node with two children: get inorder successor
            AgentNode successor = minValueNode(root.getRight());
            root = new AgentNode(successor.getAgent());

            // Delete inorder successor
            root.setRight(deleteRec(root.getRight(), successor.getAgent().getAgentId()));
            root.setLeft(root.getLeft());
        }
        return root;
    }

    private AgentNode minValueNode(AgentNode node) {
        AgentNode current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }
}