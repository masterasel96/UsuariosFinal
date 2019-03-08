<%-- 
    Author    
--%>

<%@page import="modelo.Instituto"%>
<%@page import="modelo.InstitutoDAO"%>
<%@page import="modelo.UsuarioDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultados</title>
        <link href="./css/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Tabla usuarios</h1>

        <table border ="1">

            <tr>
                <th>
                    <b>Nombre</b>
                </th>
                <th>
                    <b>Apellidos</b>
                </th>
                <th>
                    <b>Edad</b>
                </th>
                <th>
                    <b>Instituto</b>
                </th>
            </tr>

            <%
                
                ArrayList<Usuario> lista = UsuarioDAO.consultarUsuarios();
                for (Usuario j : lista) {
                    out.print("<tr><td>");
                    out.print(j.getNombre());
                    out.print("</td><td>");
                    out.print(j.getApellidos());
                    out.print("</td><td>");
                    out.print(j.getEdad());
                    out.print("</td><td>");
                    out.print(j.getId());
                    out.print("</td>");
                    out.print("</tr>");

                }
            %>

        </table>
            
            <h1>Tabla Institutos</h1>

        <table border ="1">

            <tr>
                 <th>
                    <b>Id_instituto</b>
                </th>
                <th>
                    <b>Instituto</b>
                </th>
                
            </tr>

            <%
                
                ArrayList<Instituto> lista1 = InstitutoDAO.consultarInstitutos();
                for (Instituto j : lista1) {
                    out.print("<tr><td>");
                    out.print(j.getId());
                   
                    out.print("</td><td>");
                    
                     out.print(j.getNombre());
                    out.print("</td></tr>");
                    

                }
            %>

        </table>

        <h2>Registrar usuario</h2>
        
      
        <form action="./Usuario" method="POST">

            <p> Nombre <input type="text" size="30" name="txtNombre" required>   </p>
            <p> Apellidos <input type="text" size="30" name="txtApellidos" required> </p>
            <p> Edad     <input type="number" size="2" name="txtEdad" required> </p>
            
            <p> Instituto     <select name="txtIdInsti" required>
                <%
                    for (Instituto j : lista1) {
                    
                    out.print("<option value='"+j.getId()+"'>"+j.getNombre()+"</option>");
                    out.print(j.getId());
                   
                    out.print("</td><td>");
                    
                     out.print(j.getNombre());
                    out.print("</td></tr>");
                    

                    }
                  %>
                    
               </select> </p>
            <p> <input type="submit" name="buttonSubmit" value="Registrar Usuario"> 
                <input type="reset" name="buttonReset" value="Reset"> </p>
        </form>
        
        <h2>Registrar instituto</h2>
        
      
        <form action="./Instituto" method="POST">

            <p> Nombre <input type="text" size="30" name="txtInsti" required>   </p>
           
            <p> <input type="submit" name="buttonSubmit" value="Registrar Instituto"> 
                <input type="reset" name="buttonReset" value="Reset"> </p>
        </form>

    </body>
</html>
