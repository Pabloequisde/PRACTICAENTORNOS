package Model;

/**
 * @author Erkus00
 * @version 1.0
 * Clase Model.Equipo. En ella se establecen todas las características del Model.Equipo y en la que se actualiza la información de los mismos.
 * Está formada por setters y getters; metodos que establecen la victoria, derrota o empate; método que muestra la situacion del equipo en la clasificacion
 * y un ToString que muestra todas las características y composición de un Model.Equipo
 *
 * Sus atributos son:
 * <ul>
 *     <li>nombre - Nombre del Model.Equipo (String)</li>
 *     <li>entrenador - Model.Entrenador del Model.Equipo {@link Entrenador}</li>
 *     <li>jugadores - Listado de Jugadores pertenecientes al Model.Equipo {@link Jugador[]}</li>
 *     <li>jugador - Numero de partidos jugados (Int)</li>
 *     <li>ganados - Numero de partidos ganados (Int)</li>
 *     <li>empatados - Numero de partidos empatados (Int)</li>
 *     <li>perdidos - Numero de partidos perdidos (Int)</li>
 *     <li>gFavor - Numero de goles que el Model.Equipo ha anotado (Int)</li>
 *     <li>gContra - Numero de goles que le han anotado al Model.Equipo (Int)</li>
 *     <li>difGoles - Diferencia entre los goles a Favor y los goles en Contra (Int)</li>
 *     <li>puntos - Puntos que el equipo tiene en funcion de los resultados obtenidos (Int)</li>
 * </ul>
 */

public class Equipo extends Setting {

    //    Atributos
    private String nombre;
    private Entrenador entrenador;
    private Jugador[] jugadores = new Jugador[super.getnJugadores()];
    private int jugados;
    private int ganados;
    private int empatados;
    private int perdidos;
    private int gFavor;
    private int gContra;
    private int difGoles;
    private int puntos;
    private int licenciaentrenador;
    
    /*Agregado Artsiom 26/04 para que funcione JSP*/ /* Jose Luís también lo utiliza */
    private int Id_Equipo; 

    public int getId_Equipo() {
		return Id_Equipo;
	}

	public void setId_Equipo(int id_Equipo) {
		Id_Equipo = id_Equipo;
	}

	/*---------------------------------------------*/
	
	/**
     * Constructor del Model.Equipo. Settea todos los atributos numericos a 0
     */
    public Equipo (){

        setJugados(0);
        setGanados(0);
        setPerdidos(0);
        setEmpatados(0);
        setgFavor(0);
        setgContra(0);
        setDifGoles(0,0);
        setPuntos(0);
    }

    /**
     * Método que añade una Vitoria a un Model.Equipo
     * @param resultadoF - Numero de TouchDown que el Model.Equipo ha anotado
     * @param resultadoC - Numero de TouchDown que el Model.Equipo ha recibido
     * @param pObtenido - Puntos conseguidos al obtener una victoria
     */
    public void addVictoria(int resultadoF, int resultadoC, int pObtenido) {
        jugados++;
        ganados++;
        setPuntos(puntos+=pObtenido);
        setgFavor(gFavor+=resultadoF);
        setgContra(gContra+=resultadoC);
        setDifGoles(getgFavor(), getgContra());
    }

    /**
     * Método que añade una Derrota a un Model.Equipo
     * @param resultadoF - Numero de TouchDown que el Model.Equipo ha anotado
     * @param resultadoC - Numero de TouchDown que el Model.Equipo ha recibido
     * @param pObtenido - Puntos conseguidos al obtener una derrota
     */
    public void addDerrota(int resultadoF, int resultadoC, int pObtenido) {
        jugados++;
        perdidos++;
        setPuntos(puntos+=pObtenido);
        setgFavor(gFavor+=resultadoF);
        setgContra(gContra+=resultadoC);
        setDifGoles(getgFavor(), getgContra());
    }

    /**
     * Método que añade un Empate a un Model.Equipo
     * @param resultadoF - Numero de TouchDown que el Model.Equipo ha anotado
     * @param resultadoC - Numero de TouchDown que el Model.Equipo ha recibido
     * @param pObtenido - Puntos conseguidos al obtener un empate
     */
    public void addEmpate(int resultadoF, int resultadoC, int pObtenido){
        jugados++;
        empatados++;
        setPuntos(puntos+=pObtenido);
        setgFavor(gFavor+=resultadoF);
        setgContra(gContra+=resultadoC);
        setDifGoles(getgFavor(), getgContra());
    }

    /**
     * Método que muestra los datos del Model.Equipo en la Control.Clasificacion
     * @return un String con
     * <ul>
     *     <li>Nombre del Model.Equipo</li>
     *     <li>Nº Partidos Jugaodos</li>
     *     <li>Nº Partidos Ganados</li>
     *     <li>Nº Partidos Empatados</li>
     *     <li>Nº Partidos Perdidos</li>
     *     <li>Goles anotados por el Model.Equipo</li>
     *     <li>Goles que le han anotado al Model.Equipo</li>
     *     <li>Puntuacion del Model.Equipo en la Control.Clasificacion</li>
     * </ul>
     */
    public String infoEnClasitoString() {
        String cadena= getNombre();
        int longitud = cadena.length();
        int espacios = 53-longitud;
        for (int i=0; i<espacios;i++) {
            cadena+=" ";
        }
        cadena+="\t"+getJugados()+"\t\t"+getGanados()+"\t\t"+getEmpatados()+"\t\t"+getPerdidos()+"\t\t"+getgFavor()+"\t\t"+getgContra()+"\t\t"+getDifGoles()+"\t\t"+getPuntos()+"\t\n"+"\n";
        return cadena;
    }

    /**
     * Método que muestra las características y la composición del equipo
     * @return Un String con:
     * <ul>
     *     <li>Nombre del Model.Equipo</li>
     *     <li>Raza</li>
     *     <li>Model.Entrenador</li>
     *     <li>Plantilla de Jugadores</li>
     * </ul>
     */
    @Override
    public String toString() {
        String listadoJugadores="";

        for (Jugador j: jugadores) {
            listadoJugadores+=j+"\n";
        }
        return "Nombre del Model.Equipo: "+this.nombre+"\n"+
                "Model.Entrenador: "+ this.entrenador+"\n\n"+
                "Plantilla: "+"\n\n"+
                listadoJugadores;

    }

//    Getters y Setters

    /**
     * Método que devuelve el numero de partidos que el Model.Equipo ha jugado
     * @return Numero de partidos jugados
     */
    public int getJugados() {
        return jugados;
    }

    /**
     * Método que establece el numero de partidos que ha jugado el Model.Equipo
     * @param jugados - Numero de partidos jugados
     */
    public void setJugados(int jugados) {
        this.jugados = jugados;
    }

    /**
     * Método que devuelve el numero de partidos que ha ganado el Model.Equipo
     * @return Numero de partidos ganados
     */
    public int getGanados() {
        return ganados;
    }

    /**
     * Método que devuelve el numero de partidos que el Model.Equipo ha empatado
     * @return Numero de partidos empatados
     */
    public int getEmpatados() {
        return empatados;
    }

    /**
     * Método que devuelve el numero de partidos que el Model.Equipo ha perdido
     * @return
     */
    public int getPerdidos() {
        return perdidos;
    }

    /**
     * Método que devuelve los TouchDown totales que el Model.Equipo ha anotado
     * @return TouchDowns a favor
     */
    public int getgFavor() {
        return gFavor;
    }

    /**
     * Método que devuelve los TouchDown totales que le han anotado al Model.Equipo
     * @return
     */
    public int getgContra() {
        return gContra;
    }

    /**
     * Método que devuelve la diferencia entre los goles a favor y los goles en contra
     * @return Diferencia de goles anotados y recibidos
     */
    public int getDifGoles() {
        return difGoles;
    }

    /**
     * Método que devuelve la puntuacion de un Model.Equipo en la Control.Clasificacion
     * @return Puntos del Model.Equipo en la Control.Clasificacion
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Método que establece el numero de partidos que ha ganado el Model.Equipo
     * @param ganados - Numero de partidos ganados po el Model.Equipo
     */
    public void setGanados(int ganados) {
        this.ganados = ganados;
    }

    /**
     * Método que establece el numero de partidos que ha empatado el Model.Equipo
     * @param empatados - Numero de partidos empatados por el Model.Equipo
     */
    public void setEmpatados(int empatados) {
        this.empatados = empatados;
    }

    /**
     * Método que establece el numero de partidos que ha perdido el Model.Equipo
     * @param perdidos - Numero de partidos que ha perdido el Model.Equipo
     */
    public void setPerdidos(int perdidos) {
        this.perdidos = perdidos;
    }

    /**
     * Método que establece los TouchDown totales que ha anotado al Model.Equipo
     * @param gFavor - Numero de TouchDown que el Model.Equipo ha anotado
     */
    public void setgFavor(int gFavor) {
        this.gFavor = gFavor;
    }

    /**
     * Método que establece los TouchDown totales que le han anotado al Model.Equipo
     * @param gContra - Numero de TouchDown que le han anotado al Model.Equipo
     */
    public void setgContra(int gContra) {
        this.gContra = gContra;
    }

    /**
     * Método que calcula y establece la diferencia de TouchDown de un Model.Equipo. Se calcula mediante la diferencia entre los TouchDown anotados y los TouchDown recibidos
     * @param gFavor - Numero de TouchDown que el Model.Equipo ha anotado
     * @param gContra - Numero de TouchDown que le han anotado al Model.Equipo
     */
    public void setDifGoles(int gFavor, int gContra) {
        this.difGoles = (gFavor-gContra);
    }

    /**
     * Método que establece la puntuacion en la Control.Clasificacion del Model.Equipo
     * @param puntos - Puntos del Model.Equipo en la Control.Clasificacion
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Método que devuelve el nombre del equipo
     * @return Nombre del Model.Equipo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que establece el nombre de un equipo
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que devuelve el entrenador del equipo
     * @return Model.Entrenador del equipo
     */
    public Entrenador getEntrenador() {
        return entrenador;
    }

    /**
     * Método que establece el entrenador del equipo
     * @param entrenador
     */
    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    /**
     *Método que devuelve una lista de jugadores
     * @return Lista de jugadores del equipo
     */
    public Jugador[] getJugadores() {
        return jugadores;
    }

    /**
     * Método que establece a los jugadores del equipo
     * @param jugadores
     */
    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public int getLicenciaentrenador() {
        return licenciaentrenador;
    }

    public void setLicenciaentrenador(int licenciaentrenador) {
        this.licenciaentrenador = licenciaentrenador;
    }
}
