package Model;

public class Arbitro {
    String nombre;
    String apellidos;
    int licencia;
    public Arbitro() {
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

//    ToString
    /**
     * Método que muestra las características de un Model.Arbitro a modo de String
     * @return Un string
     * <ul>
     *  <li>Nombre</li>
     *  <li>Numero de Licencia</li>
     * </ul>
     *
     */
    @Override
    public String toString() {
        return "Model.Arbitro: "+getNombre()+" "+getApellidos()+"\n"+
                "Numero de Licencia: "+this.licencia;
    }
}
