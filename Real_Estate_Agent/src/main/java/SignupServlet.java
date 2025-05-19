import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String Username = request.getParameter("Username");
    	String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String Action = "User";
        
        // Get path to user.txt
        String filePath = getServletContext().getRealPath("/Data/user.txt");

        File file = new File(filePath);
        file.getParentFile().mkdirs(); // Create directories if not exist
       

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
        	writer.write("Username: " + Username);
            writer.newLine();
        	writer.write("FullName: " + firstName+" "+lastName);
            writer.newLine();
            writer.write("Email: " + email);
            writer.newLine();
            writer.write("Phone: " + phone);
            writer.newLine();
            writer.write("Password: " + password);
            writer.newLine();
            writer.write("Action: " + Action);
            writer.newLine();
            writer.newLine(); // blank line between users
        }

        // Redirect after signup
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('Signup successful. Please login.'); window.location='login.jsp';</script>");
    }
}
