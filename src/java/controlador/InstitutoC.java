package controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.InstitutoDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;


/**
 *
 * @author -----
 */
public class InstitutoC extends HttpServlet {    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        response.setContentType("text/html;charset=UTF-8");
       
       
        HttpSession sesion = request.getSession(true);
        
        
        String instituto = request.getParameter("txtInsti");
        
        sesion.setAttribute("instituto", instituto);
        
       
        
       

       

            InstitutoDAO.insertarInstituto(instituto);
        

      
         ArrayList<Usuario> lista = UsuarioDAO.consultarUsuarios();
        
        
        lista.forEach(System.out::println);
        
        
        response.sendRedirect(response.encodeRedirectURL("index.jsp"));

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    
}