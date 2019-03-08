package modelo;
/**
 *
 * @author J. Carlos F. Vico <jfervic933@maralboran.es>
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static final String SERVIDOR = "jdbc:mysql://localhost/";
    private static final String NOMBRE_BASE_DATOS = "usuarios";
    private static final String USER = "xema";
    private static final String PASS = "123";
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    
    private Connection conexion;
    
    public Conexion(){
        
        try {
            Class.forName(DRIVER); 

            
            conexion = DriverManager.getConnection(SERVIDOR + NOMBRE_BASE_DATOS, USER, PASS);

            System.out.println("Conexión realizada con éxito.");

        } catch (SQLException | ClassNotFoundException e) {
           
            System.out.println(e);
        }
    }
    
    public Connection getConexion() {
        return conexion;
    }
    
    public void cerrarConexion() {
        try {
            conexion.close();
            System.out.println("Cerrando la conexión con la BD.");
        } catch (SQLException e) {
            System.out.println(e);
        }
        conexion = null;
    }
    
}


