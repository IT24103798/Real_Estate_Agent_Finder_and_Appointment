import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/DeleteUser")
public class DeleteUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 String usernameToDelete = request.getParameter("no");
        String filePath = getServletContext().getRealPath("/Data/user.txt"); 
        File file = new File(filePath);
        List<String> lines = new ArrayList<>();
        boolean foundAndDeleted = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Username: ") && line.substring("Username: ".length()).trim().equals(usernameToDelete)) {
                    // Delete කරන user ගේ data ටික skip කරනවා.
                    while ((line = reader.readLine()) != null && !line.startsWith("Username: ")) {
                        // User block එක ඉවර වෙනකන් skip කරනවා.
                    }
                    foundAndDeleted = true;
                    if (line != null) {
                         lines.add(line); // ඊලග user name එක add කරනව
                    }
                    
                } else {
                    lines.add(line); // අනිත් data ටික array එකට add කරනවා.
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            response.getWriter().println("Error reading user data.");
            return;
        }

        if (foundAndDeleted) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
                response.getWriter().println("User with Username '" + usernameToDelete + "' deleted successfully.");
            } catch (IOException e) {
                e.printStackTrace();
                response.getWriter().println("Error writing user data.");
            }
        } else {
            response.getWriter().println("User with Username '" + usernameToDelete + "' not found.");
        }
    }
}
