
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/AgentsReview")
public class AgentList2Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filePath = getServletContext().getRealPath("/Data/user.txt"); // Adjust the path if needed
        File file = new File(filePath);

        Set<String> agentUsernames = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String currentUsername = null;
            boolean isAgent = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Username: ")) {
                    currentUsername = line.substring("Username: ".length()).trim();
                    isAgent = false; // reset for each block
                } else if (line.startsWith("Action: ")) {
                    String action = line.substring("Action: ".length()).trim();
                    if ("Agent".equalsIgnoreCase(action) && currentUsername != null) {
                        agentUsernames.add(currentUsername);
                        isAgent = true;
                    }
                } else if (line.equals("") && isAgent) {
                    // Reset at end of record block (if needed)
                    currentUsername = null;
                    isAgent = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            response.getWriter().println("Error reading user data.");
            return;
        }

        // Send agent usernames to JSP or output directly
        request.setAttribute("agents", agentUsernames);
        request.getRequestDispatcher("Review.jsp").forward(request, response);
    }
}
