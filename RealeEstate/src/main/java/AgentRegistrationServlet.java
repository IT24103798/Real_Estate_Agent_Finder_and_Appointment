import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AgentRegistration")
public class AgentRegistrationServlet extends HttpServlet {

    private static BinarySearchTree agentTree = new BinarySearchTree();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("Username");
        String fullName = request.getParameter("fullName");
        String licenseNumber = request.getParameter("licenseNumber");
        String agencyName = request.getParameter("agencyName");
        String areasServed = request.getParameter("areasServed");
        String bio = request.getParameter("bio");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        Agent agent = new Agent(username, fullName, licenseNumber, agencyName, areasServed, bio, email, phone, password);
        agentTree.insert(agent);

        // Save the updated tree to file
        String filePath = getServletContext().getRealPath("/Data/user.txt");
        agentTree.saveToFile(filePath);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('Signup successful. Please login.'); window.location='login.jsp';</script>");
    }
}
