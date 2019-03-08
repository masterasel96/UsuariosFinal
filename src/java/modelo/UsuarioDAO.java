
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author 
 */
public class UsuarioDAO {
    
    
    public static ArrayList<Usuario> consultarUsuarios(){
        Statement st;
        ResultSet res;
        ArrayList<Usuario> lista = new ArrayList();
        
        
        String sql = "select * from usuarios";
  
        Conexion conexion = new Conexion();
        
        try {
            
            st = conexion.getConexion().createStatement(); 
            
            res = st.executeQuery(sql);
            while (res.next()){
                Usuario j = new Usuario();
                j.setNombre(res.getString("nombre"));
                j.setApellidos(res.getString("apellidos"));
                j.setEdad(res.getInt("edad"));
                j.setId(res.getInt("id_insti"));
               

                lista.add(j);
            }
            st.close();
            conexion.cerrarConexion();
        } catch (SQLException e) {
            System.out.println("Problemas durante la consulta en tabla usuarios");
            System.out.println(e);
            
        }

        return lista;  
    }
    
    public static int insertarUsuario(String nombre,String apellidos, int edad, int id_insti){
        
        String sql = "insert into usuarios(nombre, apellidos, edad, id_insti) values ('"+nombre+"','"+apellidos+"','"+edad+"','"+id_insti+"')";
        Conexion conexion = new Conexion();
        
        PreparedStatement prest;

        try { 
            prest = conexion.getConexion().prepareStatement(sql);



      
            int nfilas = prest.executeUpdate();
    
           
            prest.close();
            
           
            conexion.cerrarConexion();
            
            return nfilas;
        } catch (SQLException e) {
            System.out.println("Problemas durante la inserción de datos en la tabla Jugadores");
            System.out.println(e);
            return -1;
        }
    }
    
   
    
}

