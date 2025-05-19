package com.realstate.servlet;

import com.realstate.dao.AgentDAO;
import com.realstate.model.Agent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/agent")
public class AgentServlet extends HttpServlet {
    private AgentDAO agentDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        agentDAO = new AgentDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String agentId = request.getParameter("id");
        try {
            if (agentId != null && !agentId.isEmpty()) {
                // Search agent by ID
                Agent agent = agentDAO.searchById(agentId);
                request.setAttribute("agent", agent);
                request.getRequestDispatcher("/agentDetail.jsp").forward(request, response);
            } else {
                // List all agents
                List<Agent> agents = agentDAO.getAllAgents();
                request.setAttribute("agents", agents);
                request.getRequestDispatcher("/agentList.jsp").forward(request, response);
            }
        } catch (IOException e) {
            throw new ServletException("Error accessing agent data", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            if ("create".equals(action)) {
                String name = request.getParameter("name");
                String location = request.getParameter("location");
                double rating = Double.parseDouble(request.getParameter("rating"));
                String contact = request.getParameter("contact");
                String agentId = UUID.randomUUID().toString();

                Agent agent = new Agent(agentId, name, location, rating, contact);
                agentDAO.addAgent(agent);

                response.sendRedirect("agent");

            } else if ("update".equals(action)) {
                String agentId = request.getParameter("agentId");
                String name = request.getParameter("name");
                String location = request.getParameter("location");
                double rating = Double.parseDouble(request.getParameter("rating"));
                String contact = request.getParameter("contact");

                Agent agent = new Agent(agentId, name, location, rating, contact);
                agentDAO.updateAgent(agent);

                response.sendRedirect("agent");

            } else if ("delete".equals(action)) {
                String agentId = request.getParameter("agentId");
                agentDAO.deleteAgent(agentId);

                response.sendRedirect("agent");

            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
            }
        } catch (IOException e) {
            throw new ServletException("Error processing agent data", e);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid rating value");
        }
    }
}