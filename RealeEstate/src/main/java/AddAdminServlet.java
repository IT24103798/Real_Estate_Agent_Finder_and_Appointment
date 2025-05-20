import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AddAdmin")
public class AddAdminServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullNameToEdit = request.getParameter("fullName").trim();
        String emailToEdit = request.getParameter("email").trim();
        String newAction = "Admin";

        String filePath = getServletContext().getRealPath("/Data/user.txt");
        File file = new File(filePath);
        List<String> updatedLines = new ArrayList<>();
        boolean foundAndUpdated = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            List<String> userBlock = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Username: ")) {
                    if (!userBlock.isEmpty()) {
                        processUserBlock(userBlock, updatedLines, fullNameToEdit, emailToEdit, newAction);
                        userBlock.clear();
                    }
                }
                userBlock.add(line);
            }

            // process the last block
            if (!userBlock.isEmpty()) {
                processUserBlock(userBlock, updatedLines, fullNameToEdit, emailToEdit, newAction);
            }

        } catch (IOException e) {
            e.printStackTrace();
            response.getWriter().println("Error reading user data.");
            return;
        }

        for (String l : updatedLines) {
            if (l.equals("Action: " + newAction)) {
                foundAndUpdated = true;
                break;
            }
        }

        if (foundAndUpdated) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (String l : updatedLines) {
                    writer.write(l);
                    writer.newLine();
                }
                response.getWriter().println("User action updated successfully for " + fullNameToEdit + " (" + emailToEdit + ") to " + newAction);
            } catch (IOException e) {
                e.printStackTrace();
                response.getWriter().println("Error writing user data.");
            }
        } else {
            response.getWriter().println("User with FullName '" + fullNameToEdit + "' and Email '" + emailToEdit + "' not found.");
        }
    }

    private void processUserBlock(List<String> userBlock, List<String> updatedLines, String fullNameToEdit, String emailToEdit, String newAction) {
        String fullName = null;
        String email = null;

        for (String l : userBlock) {
            if (l.startsWith("FullName: ")) {
                fullName = l.substring("FullName: ".length()).trim();
            } else if (l.startsWith("Email: ")) {
                email = l.substring("Email: ".length()).trim();
            }
        }

        if (email != null && fullName != null && email.equalsIgnoreCase(emailToEdit) && fullName.equalsIgnoreCase(fullNameToEdit)) {
            for (String l : userBlock) {
                if (l.startsWith("Action: ")) {
                    updatedLines.add("Action: " + newAction);
                } else {
                    updatedLines.add(l);
                }
            }
        } else {
            updatedLines.addAll(userBlock);
        }
    }
}
