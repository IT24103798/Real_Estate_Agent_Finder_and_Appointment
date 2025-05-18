package com.example.agent.model;

import com.example.agent.model.Agent;
import com.example.agent.model.AgentService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class AgentServlet extends HttpServlet {

    private AgentService agentService;

    @Override
    public void init() {
        agentService = new AgentService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();
        List<Agent> agents = agentService.processAgents();

        if ("/search".equals(path)) {
            String ratingStr = request.getParameter("minRating");

            try {
                double minRating = Double.parseDouble(ratingStr);

                List<Agent> filteredAgents = agents.stream()
                        .filter(agent -> agent.getRating() >= minRating)
                        .collect(Collectors.toList());

                request.setAttribute("agents", filteredAgents);
                request.getRequestDispatcher("/result.jsp").forward(request, response);

            } catch (NumberFormatException e) {
                request.setAttribute("error", "Invalid rating input.");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }

        } else if ("/sort".equals(path)) {
            request.setAttribute("agents", agents); // already sorted in service
            request.getRequestDispatcher("/ind.jsp").forward(request, response);

        } else{ // default route "/"
            request.setAttribute("agents", agents);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }
}






