import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/agentsuserDB")
public class userDBAgentsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Agent> agentList = new ArrayList<>();

        String filePath = getServletContext().getRealPath("/Data/user.txt");
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        Agent agent = null;
        boolean isAgent = false;

        while ((line = reader.readLine()) != null) {
            line = line.trim();

            if (line.startsWith("Username:")) {
                agent = new Agent();
                agent.setUsername(line.split(":", 2)[1].trim());
            } else if (agent != null && line.startsWith("FullName:")) {
                agent.setFullName(line.split(":", 2)[1].trim());
            } else if (agent != null && line.startsWith("Email:")) {
                agent.setEmail(line.split(":", 2)[1].trim());
            } else if (agent != null && line.startsWith("Phone:")) {
                agent.setPhone(line.split(":", 2)[1].trim());
            } else if (agent != null && line.startsWith("Password:")) {
                agent.setPassword(line.split(":", 2)[1].trim());
            } else if (agent != null && line.startsWith("Action:")) {
                String action = line.split(":", 2)[1].trim();
                isAgent = "Agent".equalsIgnoreCase(action); // Only continue if user is Agent
            } else if (agent != null && line.startsWith("licenseNumber:")) {
                agent.setLicenseNumber(line.split(":", 2)[1].trim());
            } else if (agent != null && line.startsWith("agencyName:")) {
                agent.setAgencyName(line.split(":", 2)[1].trim());
            } else if (agent != null && line.startsWith("areasServed:")) {
                agent.setAreasServed(line.split(":", 2)[1].trim());
            } else if (agent != null && line.startsWith("bio:")) {
                agent.setBio(line.split(":", 2)[1].trim());
                if (isAgent) {
                    agentList.add(agent); // Only add if Action was Agent
                }
                agent = null;
                isAgent = false;
            }
        }

        reader.close();
        request.setAttribute("agents", agentList);
        request.getRequestDispatcher("userDBAgents.jsp").forward(request, response);
    }
}
