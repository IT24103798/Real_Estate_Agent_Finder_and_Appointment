import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/userManager") // Map this servlet to the /userManager URL
public class UserManagerServlet extends HttpServlet {
// Handles GET requests (e.g., when the UserManager.jsp page is loaded)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // --- Security Check: Ensure the logged-in user has the Admin role ---
        HttpSession session = request.getSession(false);
        if (session == null || !"Admin".equals(session.getAttribute("role"))) {
            // If not an Admin, redirect to login or an error page
            response.sendRedirect("login.jsp"); // Or an unauthorized access page
            return;
        }
        // --- End Security Check ---

        String filePath = getServletContext().getRealPath("/Data/user.txt");
        File file = new File(filePath);
        List<User> allUsers = new ArrayList<>(); // List to hold all users

        if (!file.exists()) {
            // If user data file doesn't exist, forward an empty list
            request.setAttribute("allUsers", allUsers);
            request.getRequestDispatcher("UserManager.jsp").forward(request, response);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            User currentUser = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Username: ")) {
                    // Start of a new user block
                    // Before starting a new one, add the previous user (if any) to the list
                    if (currentUser != null) {
                         allUsers.add(currentUser);
                    }
                    // Create a new User object for the current block
                    currentUser = new User();
                    currentUser.setUsername(line.substring("Username: ".length()).trim());

                } else if (line.startsWith("FullName: ")) {
                    if (currentUser != null) {
                        currentUser.setFullName(line.substring("FullName: ".length()).trim());
                    }
                } else if (line.startsWith("Email: ")) {
                    if (currentUser != null) {
                        currentUser.setEmail(line.substring("Email: ".length()).trim());
                    }
                } else if (line.startsWith("Phone: ")) {
                    if (currentUser != null) {
                        currentUser.setPhone(line.substring("Phone: ".length()).trim());
                    }
                } else if (line.startsWith("Password: ")) {
                    if (currentUser != null) {
                        currentUser.setPassword(line.substring("Password: ".length()).trim());
                    }
                } else if (line.startsWith("Action: ")) {
                    if (currentUser != null) {
                        currentUser.setRole(line.substring("Action: ".length()).trim());
                    }
                } 
                
            }
           
             if (currentUser != null) {
                 allUsers.add(currentUser);
             }

        } catch (IOException e) {
            e.printStackTrace();
           
            response.getWriter().println("Error reading user data.");
            return;
        }

        request.setAttribute("allUsers", allUsers);

        request.getRequestDispatcher("usermanagem.jsp").forward(request, response);
    }

}
