
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author 
 */
public class InstitutoDAO {
    
    
    public static ArrayList<Instituto> consultarInstitutos(){
        Statement st;
        ResultSet res;
        ArrayList<Instituto> lista = new ArrayList();
        
        
        String sql = "select * from institutos";
  
        Conexion conexion = new Conexion();
        
        try {
            
            st = conexion.getConexion().createStatement(); 
            
            res = st.executeQuery(sql);
            while (res.next()){
                Instituto j = new Instituto();
                j.setNombre(res.getString("nombre"));
                j.setId(res.getInt("id"));
                
   
                lista.add(j);
            }
            st.close();
            conexion.cerrarConexion();
        } catch (SQLException e) {
            System.out.println("Problemas durante la consulta en tabla institutos");
            System.out.println(e);
            
        }

        return lista;  
    }
    
    public static int insertarInstituto(String instituto){
        
        String sql = "insert into institutos(nombre) values ('"+instituto+"')";
        Conexion conexion = new Conexion();
        
        PreparedStatement prest;

        try { 
            prest = conexion.getConexion().prepareStatement(sql);



      
            int nfilas = prest.executeUpdate();
    
           
            prest.close();
            
           
            conexion.cerrarConexion();
            
            return nfilas;
        } catch (SQLException e) {
            System.out.println("Problemas durante la inserción de datos en la tabla Institutos");
            System.out.println(e);
            return -1;
        }
    }
    
   
    
}
