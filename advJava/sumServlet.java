package advJava;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SumServlet")
public class SumServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve parameters from the request
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");

        // Initialize result variable
        int sum = 0;
        
        try {
            // Parse numbers and calculate sum
            int number1 = Integer.parseInt(num1);
            int number2 = Integer.parseInt(num2);
            sum = number1 + number2;
        } catch (NumberFormatException e) {
            // Handle error if parameters are not valid integers
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input");
            return;
        }

        // Set response content type
        response.setContentType("text/html");

        // Write response
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Sum Result</h1>");
        out.println("<p>The sum of " + num1 + " and " + num2 + " is: " + sum + "</p>");
        out.println("</body></html>");
    }
}
