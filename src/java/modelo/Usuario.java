package modelo;

/**
 *
 * @author J. Carlos F. Vico <jfervic933@maralboran.es>
 */
public class Usuario {
    
    private int id_insti;
    private String nombre;
    private String apellidos;
    private int edad;
    
    public int getId() {
        return id_insti;
    }

    public void setId(int id) {
        this.id_insti = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    

    
    

   
}

