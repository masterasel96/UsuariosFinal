package controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import modelo.UsuarioDAO;


/**
 *
 * @author -----
 */
public class UsuarioC extends HttpServlet {    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        response.setContentType("text/html;charset=UTF-8");
       
       
        HttpSession sesion = request.getSession(true);
        
        
        String nombre = request.getParameter("txtNombre");
        
        sesion.setAttribute("nombre", nombre);
        
       
        
        String apellidos = request.getParameter("txtApellidos");
        sesion.setAttribute("apellidos", apellidos);
        
        int edad = Integer.parseInt(request.getParameter("txtEdad"));
        

        sesion.setAttribute("edad", edad);
        
        int idInsti = Integer.parseInt(request.getParameter("txtIdInsti"));
        

        sesion.setAttribute("edad", edad);

       

            UsuarioDAO.insertarUsuario(nombre,apellidos,edad,idInsti);
        

      
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
