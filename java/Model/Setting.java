package Model;

/**
 * @author Erkus00
 * @version 1.0
 *
 * Clase Control.Setting
 * En esta se establecen los ajustes que servirán para crear la Liga. Se crea de inicio con una serie de valores predeterminados
 *
 * Sus atributos son:
 * <ul>
 *     <li>nombre - Nombre de la Liga (String)</li>
 *     <li>nEquipos - Numero de Equipos que tiene la Liga (Int)</li>
 *     <li>nJugadores - Numero de Jugadores que hay en cada Model.Equipo(Int)</li>
 *     <li>victoria - Puntuación obtenida por una Victoria (Int)</li>
 *     <li>empate - Puntuación obtenida por un empate (Int)</li>
 *     <li>derrota - Puntuación obtenida por una derrota (Int)</li>
 * </ul>
 */

public class Setting {

    //    Atributos
    private String nombre;
    private int nEquipos;
    private int nJugadores;
    private int diaInicio;
    private String mesInicio;
    private int victoria;
    private int empate;
    private int derrota;

    /**
     * Constructor de Control.Setting. Posee un método que setea los valores tal y
     * como se hayan establecido aqui {@link Setting#predeterminado()}
     */
    public Setting(){
        predeterminado();
    }

//    Getters y Setters
    /**
     *Método que devuelve el numero de equipos que hay en la liga
     * @return Numero de Equipos que tiene la Liga
     */
    public int getnEquipos() {
        return nEquipos;
    }

    /**
     * Método que establece el numero de equipos que hay en la liga
     * @param nEquipos - Numero de Equipos que tiene la Liga
     */
    public void setnEquipos(int nEquipos) {
        this.nEquipos = nEquipos;
    }

    /**
     * Método que devuelve el número de jugadores que tiene cada equipo
     * @return El número de jugadores
     */
    public int getnJugadores() {
        return nJugadores;
    }

    /**
     * Método que establece el número de jugadores que tiene cada equipo
     * @param nJugadores - Número de Jugadores que tiene un Model.Equipo
     */
    public void setnJugadores(int nJugadores) {
        this.nJugadores = nJugadores;
    }

    /**
     * Método que establece los puntos ganados al conseguir una victoria
     * @param victoria - Puntos ganados al conseguir una victoria
     */
    public void setVictoria(int victoria){
        this.victoria=victoria;
    }

    /**
     * Método que devuelve los puntos que se obtendrán al conseguir una victoria
     * @return Puntos por victoria
     */
    public int getVictoria() {
        return victoria;
    }

    /**
     * Método que establece los puntos obtenidos al conseguir un empate
     * @param empate - Puntos ganados al conseguir una empate
     */
    public void setEmpate(int empate) {
        this.empate = empate;
    }

    /**
     * Método que devuelve los puntos que se obtendrán al conseguir un empate
     * @return Puntos por empate
     */
    public int getEmpate() {
        return empate;
    }

    /**
     * Método que devuelve los puntos que se obtendrán al conseguir una derrota
     * @param derrota - Puntos ganados al conseguir una derrota
     */
    public void setDerrota(int derrota) {
        this.derrota = derrota;
    }

    /**
     * Método que devuelve los puntos que se obtendrán al conseguir una derrota
     * @return Puntos por derrota
     */
    public int getDerrota() {
        return derrota;
    }

    /**
     * Método que establece el nombre de la Liga
     * @param nombre - Nombre que deseamos establecer a la Liga
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve el nombre que se le ha puesto a la Liga
     * @return Nombre de la Liga
     */
    public String getNombre() {
        return nombre;
    }

    public int getDiaInicio() {
        return diaInicio;
    }

    public void setDiaInicio(int diaInicio) {
        this.diaInicio = diaInicio;
    }

    public String getMesInicio() {
        return mesInicio;
    }

    public void setMesInicio(String mesInicio) {
        this.mesInicio = mesInicio;
    }

    //    Métodos
    /**
     * Funcion que establece los valores que se establecen en el momento de lanzar el programa y que se mantendrán a menos que sean modificados.
     * Estos son:
     * <ul>
     *     <li>Nombre de la Liga: "La Justa de los Caballeros de la Mesa Cuadrada" </li>
     *     <li>Numero de Equipos: 4</li>
     *     <li>Numero de Jugadores: 11</li>
     *     <li>Puntos Obtenidos por una Victoria: 3</li>
     *     <li>Puntos Obtenidos por un Empate: 1</li>
     *     <li>Puntos Obtenidos por una Derrota: 0</li>
     * </ul>
     */
    public void predeterminado(){
        this.nombre = "La Justa de los Caballeros de la Mesa Cuadrada";
        this.nEquipos = 3;
        this.nJugadores = 5;
        this.victoria = 3;
        this.empate = 1;
        this.derrota = 0;
        this.diaInicio = 1;
        this.mesInicio = "Enero";
    }

//    ToString
    /**
     * Método que muestra los ajustes establecidos en la Liga
     * @return Un String con:
     * <ul>
     *     <li>Nombre de la Liga</li>
     *     <li>Numero de Equipos que hay en la Liga</li>
     *     <li>Numero de Jugadores que hay en cada Model.Equipo</li>
     *     <li>Puntos conseguidos por una Victoria</li>
     *     <li>Puntos conseguidos por un Empate</li>
     *     <li>Puntos conseguidos por una Derrota</li>
     * </ul>
     */
    public String toString(){
        return (" Nombre de la Liga: "+getNombre()+"\n"+
                " Numero Equipos: "+getnEquipos()+" Numero Jugadores: "+getnJugadores()+"\n"+
                " Puntos: Victoria: "+getVictoria()+" | Empate: "+getEmpate()+" | Derrota: "+getDerrota()+"\n"+
                " Fecha Inicio: "+getDiaInicio()+" de "+getMesInicio()+" del 2022");
    }
}
