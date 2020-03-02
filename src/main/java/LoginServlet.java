import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet" , urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");

        //Singleton userMap
        if(sc.getAttribute("userMap") == null) {
            Map<String, String> userMap = new HashMap<>();

            userMap.put("test","test");
            sc.setAttribute("userMap", userMap);
        }

        if( !( (Map<String, String>) sc.getAttribute("userMap")).containsKey(name) ) {
            //TODO go to login in page
            request.setAttribute("msg", "User does not exist.");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

        if ( ( (Map<String, String>) sc.getAttribute("userMap")).get(name).equalsIgnoreCase(passwd) ) {
            //TODO go to shoppinglist
            request.getRequestDispatcher("WEB-INF/Shoppinglist.jsp").forward(request,response);
        }
        //TODO go to index
        request.setAttribute("msg", "The password entered was incorrect.");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
