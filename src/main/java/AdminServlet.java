import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AdminServlet", urlPatterns = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        String name = request.getParameter("name");

        if( !(( (Map<String, String>)sc.getAttribute("userMap")).containsKey(name))) {
            request.setAttribute("msg", "User does not exist.");
            request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request,response);
        }
        ( (Map<String, String>) sc.getAttribute("userMap") ).remove(name);
        request.setAttribute("msg", "User "+ name +" has been deleted.");
        request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
