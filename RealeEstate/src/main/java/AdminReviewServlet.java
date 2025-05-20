import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ReadReviewData")
public class AdminReviewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filePath = getServletContext().getRealPath("/Data/review.txt"); // Adjust the path if needed.
        File file = new File(filePath);
        List<Review> reviews = new ArrayList<>();

        if (!file.exists()) {
            // Handle the case where the file doesn't exist.
            response.getWriter().println("Review data file not found.");
            return; // Important: Exit the method to prevent errors.
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            Review review = null; // Declare review outside the loop
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("id:")) {
                    review = new Review(); // Create a new Review object for each new review entry
                    try {
                        review.setId(Integer.parseInt(line.substring(line.indexOf(":") + 1).trim())); //handling the NumberFormatException
                    } catch(NumberFormatException e){
                        System.out.println("Error parsing id: " + line); //logging the error
                        review = null; //set review to null so it does not get added to the list
                        continue; //go to the next line
                    }

                } else if (line.startsWith("Agent:")) {
                    review.setAgentName(line.substring(line.indexOf(":") + 1).trim());
                } else if (line.startsWith("Reviewer:")) {
                    review.setUserName(line.substring(line.indexOf(":") + 1).trim());
                } else if (line.startsWith("Review:")) {
                    review.setComment(line.substring(line.indexOf(":") + 1).trim());
                } else if (line.startsWith("Rating:")) {
                    try{
                        review.setRating(Integer.parseInt(line.substring(line.indexOf(":") + 1).trim()));
                    } catch(NumberFormatException e){
                        System.out.println("Error parsing rating: " + line);
                        review.setRating(0); //set default value
                    }

                } else if (line.startsWith("Status:")) {
                    review.setStatus(line.substring(line.indexOf(":") + 1).trim());
                } else if (line.startsWith("------")) {
                    // End of a review entry, add the review to the list
                    if(review != null){
                         reviews.add(review);
                    }
                    review = null; // Reset review to null for the next entry
                }
            }
            // Add the last review if it didn't end with "------"
            if (review != null) {
                reviews.add(review);
            }

        } catch (IOException e) {
            e.printStackTrace();
            response.getWriter().println("Error reading review data: " + e.getMessage()); // Include the error message
            return;
        }

        // Set the reviews list as an attribute so it can be accessed in the JSP.
        request.setAttribute("reviews", reviews);
        // Forward the request to the JSP page to display the data.  Make sure this path is correct!
        request.getRequestDispatcher("AdminReview.jsp").forward(request, response);
    }

   
}


