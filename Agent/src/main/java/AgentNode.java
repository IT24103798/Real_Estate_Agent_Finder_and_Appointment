package com.realstate.bst;

import com.realstate.model.Agent;

public class AgentNode {
    private Agent agent;
    private AgentNode left;
    private AgentNode right;

    public AgentNode(Agent agent) {
        this.agent = agent;
        this.left = null;
        this.right = null;
    }

    // Getters and setters
    public Agent getAgent() {
        return agent;
    }

    public AgentNode getLeft() {
        return left;
    }

    public void setLeft(AgentNode left) {
        this.left = left;
    }

    public AgentNode getRight() {
        return right;
    }

    public void setRight(AgentNode right) {
        this.right = right;
    }
}