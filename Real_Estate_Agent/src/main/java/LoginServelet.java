import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/login")
public class LoginServelet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String inputUsername = request.getParameter("Username"); // Renamed to avoid conflict
        String inputPassword = request.getParameter("password"); // Renamed to avoid conflict

        String filePath = getServletContext().getRealPath("/Data/user.txt");
        boolean isAuthenticated = false;
        String userRole = null;
        String storedUsername = "";
        String storedPassword = "";
        String storedPhone = "";
        String storedFullName = "";
        String storedEmail = ""; // Corrected variable name

        File file = new File(filePath);
        if (!file.exists()) {
            response.getWriter().println("Error: User data file not found.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            // Loop through the file line by line
            while ((line = reader.readLine()) != null) {
                // Check if the line starts a new user block
                if (line.startsWith("Username: ")) {
                    // Extract the stored username
                    storedUsername = line.substring("Username: ".length()).trim();

                    // Read the next lines assuming the structure: FullName, Email, Phone, Password, Action
                    line = reader.readLine(); // Read FullName line
                    if (line != null && line.startsWith("FullName: ")) {
                        storedFullName = line.substring("FullName: ".length()).trim();
                    } else {
                         // Handle unexpected format or end of file
                         continue; // Skip to the next user block or end of file
                    }

                    line = reader.readLine(); // Read Email line
                    if (line != null && line.startsWith("Email: ")) {
                        storedEmail = line.substring("Email: ".length()).trim();
                    } else {
                        continue; // Skip to the next user block or end of file
                    }

                    line = reader.readLine(); // Read Phone line
                    if (line != null && line.startsWith("Phone: ")) {
                        storedPhone = line.substring("Phone: ".length()).trim();
                    } else {
                         continue; // Skip to the next user block or end of file
                    }

                    line = reader.readLine(); // Read Password line
                    if (line != null && line.startsWith("Password: ")) {
                        storedPassword = line.substring("Password: ".length()).trim();
                    } else {
                         continue; // Skip to the next user block or end of file
                    }

                    line = reader.readLine(); // Read Action line
                    if (line != null && line.startsWith("Action: ")) {
                        userRole = line.substring("Action: ".length()).trim();
                    } else {
                         // Action line might be optional or handle as error
                         userRole = "Unknown"; // Default role if not found
                    }

                    // Check if the input credentials match the stored credentials for this user block
                    if (inputUsername.equals(storedUsername) && inputPassword.equals(storedPassword)) {
                        isAuthenticated = true;
                        // Found the user, no need to read further
                        break;
                    }
                }
                // If not a Username line, and not inside a user block being read, just continue
            }
        } catch (IOException e) {
            e.printStackTrace();
            response.getWriter().println("Error reading user data file.");
            return;
        }

        // After the loop, check if a user was authenticated
        if (isAuthenticated) {
            // Set session attributes with the details of the authenticated user
            HttpSession session = request.getSession();
            session.setAttribute("Username", storedUsername);
            session.setAttribute("role", userRole);
            session.setAttribute("email", storedEmail); // Use the corrected variable name
            session.setAttribute("phone", storedPhone);
            session.setAttribute("fullName", storedFullName);

            // Redirect to the dashboard or appropriate page based on role if needed
            // For now, redirecting to dashboard.jsp as in the original code
            response.sendRedirect("dashboard.jsp");

        } else {
            // If authentication failed, show an alert and redirect back to the login page
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('Invalid username or password.'); window.location='login.jsp';</script>");
        }
    }
}
