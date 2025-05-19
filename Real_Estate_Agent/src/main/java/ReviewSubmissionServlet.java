import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

@WebServlet("/submitReview")
public class ReviewSubmissionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // Get logged-in user from session
        HttpSession session = request.getSession(false);
        String username = (session != null) ? (String) session.getAttribute("Username") : null;

        String agentName = request.getParameter("agentName");
        String review = request.getParameter("review");
        String rating = request.getParameter("rating");
        Random rand = new Random();
        int id = rand.nextInt(99999 - 11111 + 1) + 11111;
        String status = "Pending";
        
        // Validation
        if (username == null || agentName == null || review == null || rating == null ||
            username.isEmpty() || agentName.isEmpty() || review.isEmpty() || rating.isEmpty()) {
            response.getWriter().println("All fields and login required!");
            return;
        }

        String filePath = getServletContext().getRealPath("/Data/review.txt");
        File file = new File(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
        	 writer.write("id: " + id);
             writer.newLine();
            writer.write("Agent: " + agentName);
            writer.newLine();
            writer.write("Reviewer: " + username);
            writer.newLine();
            writer.write("Review: " + review);
            writer.newLine();
            writer.write("Rating: " + rating);
            writer.newLine();
            writer.write("Status: " + status);
            writer.newLine();
            writer.write("------------");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            response.getWriter().println("Error saving review.");
            return;
        }

        response.sendRedirect("dashboard.jsp");
    }
}
