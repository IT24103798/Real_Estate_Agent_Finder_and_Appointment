import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/adminManagement") // Map this servlet to the /adminManagement URL
public class AdminManagementServlet extends HttpServlet {
	
    // Handles GET requests (e.g., when the AdminManagement.jsp page is loaded)
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
        List<User> adminUsers = new ArrayList<>(); // List to hold only Admin users

        if (!file.exists()) {
            // If user data file doesn't exist, forward an empty list
            request.setAttribute("adminUsers", adminUsers);
            request.getRequestDispatcher("AdminManagement.jsp").forward(request, response);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            User currentUser = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Username: ")) {
                    // Start of a new user block
                    // Before starting a new one, check if the previous user was an Admin and add
                    if (currentUser != null && "Admin".equals(currentUser.getRole())) {
                        adminUsers.add(currentUser);
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
                } else if (line.equals("------------") && currentUser != null) {
                     // End of a user block
                     // Check if the current user is an Admin and add to the list
                     if ("Admin".equals(currentUser.getRole())) {
                         adminUsers.add(currentUser);
                     }
                     currentUser = null; // Reset for the next block
                }
                // Note: You might have other fields like license Number, agencyName, areasServed, bio
                // You would need to add logic to read those if necessary,
                // but they are not included in the basic User class here.
            }
             // Add the last user if the file doesn't end with "------------" and is an Admin
             if (currentUser != null && "Admin".equals(currentUser.getRole())) {
                 adminUsers.add(currentUser);
             }

        } catch (IOException e) {
            e.printStackTrace();
            // Handle potential file reading errors
            response.getWriter().println("Error reading user data."); // Provide feedback
            return;
        }

        // Set the list of admin users as a request attribute
        request.setAttribute("adminUsers", adminUsers);

        // Forward the request and response to the JSP page
        // Ensure this path is correct relative to your web application context
        request.getRequestDispatcher("/AdminManagement.jsp").forward(request, response);
    }

    // Handles POST requests (e.g., from the "Add New Admin" form)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // --- Security Check: Ensure the logged-in user has the Admin role ---
        HttpSession session = request.getSession(false);
        if (session == null || !"Admin".equals(session.getAttribute("role"))) {
            // If not an Admin, send an error response
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Unauthorized access");
            return;
        }
        // --- End Security Check ---

        // Get parameters from the form
        String fullName = request.getParameter("adminName"); // Assuming form input name is 'adminName'
        String email = request.getParameter("adminEmail");   // Assuming form input name is 'adminEmail'

        // Basic validation
        if (fullName == null || fullName.trim().isEmpty() || email == null || email.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Full Name and Email are required.");
            return;
        }

        // --- Logic to add the new admin to user.txt ---
        String filePath = getServletContext().getRealPath("/Data/user.txt");
        File file = new File(filePath);

        try (FileWriter fw = new FileWriter(file, true); // Use true for append mode
             BufferedWriter writer = new BufferedWriter(fw)) {

           
            String username = email.substring(0, email.indexOf('@')); // Simple example: use part of email

           
            String password = "defaultpassword"; // !!! INSECURE !!!

           
            writer.newLine(); // Add a new line before the new entry
            writer.write("Username: " + username);
            writer.newLine();
            writer.write("FullName: " + fullName);
            writer.newLine();
            writer.write("Email: " + email);
            writer.newLine();
            writer.write("Phone: "); // Assuming phone is optional or added later
            writer.newLine();
            writer.write("Password: " + password); // !!! INSECURE !!!
            writer.newLine();
            writer.write("Action: Admin"); // Set the role as Admin
            writer.newLine();
            writer.write("------------"); // Separator
            writer.newLine(); // Add a new line after the separator

        } catch (IOException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error writing to user data file.");
            return;
        }

        response.sendRedirect("adminManagement"); 
    }
}
