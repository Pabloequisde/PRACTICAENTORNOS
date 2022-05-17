package Model;

public class Entrenador {
    String nombre;
    String apellidos;
    int licencia;

    
    public Entrenador() {

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
    public int getLicencia() {
        return licencia;
    }
    public void setLicencia(int licencia) {
        this.licencia = licencia;
    }

    /**
     * Método que muestra las características del entrenador
     * @return Un string con
     * <ul>
     *  <li>Nombre</li>
     *  <li>Numero</li>
     * </ul>
     * el nombre del entrenador, su raza y su número de licencia
     */
    @Override
    public String toString(){
        return "Nombre: "+getNombre()+" "+getApellidos() +"\n"+
                "Numero de Licencia: "+this.licencia;
    }

}
