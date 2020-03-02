import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CreateUserServlet", urlPatterns = "/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");

        if( ((Map<String, String>)sc.getAttribute("userMap")).containsKey(name)) {
            request.setAttribute("msg", "User already exists.");
            request.getRequestDispatcher("WEB-INF/CreateUser.jsp").forward(request,response);
        }
        ((Map<String, String>)sc.getAttribute("userMap")).put(name, passwd);
        request.setAttribute("msg", "User created!");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
