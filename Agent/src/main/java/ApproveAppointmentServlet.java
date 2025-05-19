import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/approveAppointment")
public class ApproveAppointmentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String appointmentIdToApprove = request.getParameter("appointmentId");

        String filePath = getServletContext().getRealPath("/Data/Appointment.txt");
        File file = new File(filePath);
        List<String> lines = new ArrayList<>();
        boolean foundAndUpdated = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("AppointmentID:")) {

                    String currentAppointmentId = line.substring(line.indexOf(":") + 1).trim();

                    if (currentAppointmentId.equals(appointmentIdToApprove)) {
                        // Read the rest of the appointment data
                        String clientLine = reader.readLine();
                        String agentLine = reader.readLine();
                        String typeLine = reader.readLine();
                        String datetimeLine = reader.readLine();
                        String statusLine = reader.readLine();
                        String usernameLine = reader.readLine();
                        lines.add(line);
                        lines.add(clientLine);
                        lines.add(agentLine);
                        lines.add(typeLine);
                        lines.add(datetimeLine);
                        lines.add("Status: Completed"); // Update the status
                        lines.add(usernameLine);
                        lines.add("------------");

                        foundAndUpdated = true;
                    } else {
                        lines.add(line);
                    }
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            response.getWriter().println("Error reading appointment data.");
            return;
        }

        if (foundAndUpdated) {
            try (FileWriter fileWriter = new FileWriter(file);
                 BufferedWriter writer = new BufferedWriter(fileWriter)) { //try with resources
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
                writer.flush(); // Ensure all data is written to the file
                response.getWriter().println("Appointment ID " + appointmentIdToApprove + " approved.");
            } catch (IOException e) {
                e.printStackTrace();
                response.getWriter().println("Error writing appointment data.");
            }
        } else {
            response.getWriter().println("Appointment ID " + appointmentIdToApprove + " not found.");
        }
        response.sendRedirect("ReadAppointmentData"); // Redirect to the appointment list page
    }
}
