package Model; /**
 * @author: Erkus00
 * @version: 1.0
 *
 * Clase Model.Partido
 * Clase en la que se simula el partido entre 2 Equipos. Se genera un resultado, por medio de la elección de un número aleatorio entre 0 y 16. Después este es guardado localmente. Tambien tenemos la
 * opción de imprimir esta información
 *
 * Sus atributos son:
 * <ul>
 *     <li>equipo1 - Primer Model.Equipo del Enfrentamiento (Model.Equipo)</li>
 *     <li>equipo2 - Segundo Model.Equipo del Enfrentamiento (Model.Equipo)</li>
 *     <li>resultado1 - Resultado del primer Model.Equipo (Int)</li>
 *     <li>resultado2 - Resultado del segundo Model.Equipo (Int)</li>
 *     <li>arbitro - Model.Arbitro asignado a este enfrentamiento (Model.Arbitro)</li>
 * </ul>
 */

import Model.Arbitro;
import Model.Equipo;

import java.util.Objects;
public class Partido {

    //    Atributos
    Equipo equipo1;
    Equipo equipo2;
    int resultado1;
    int resultado2;
    Arbitro arbitro;
    String horaInicio;
    int Jornada;
    int goles_Local;
    int goles_Visitante;
    String nombre_Local;
    String nombre_Visitante;
    int id_Local;
    int id_Visitante;


   public int getJornada() {
		return Jornada;
	}

	public void setJornada(int jornada) {
		Jornada = jornada;
	}

	public int getGoles_Local() {
		return goles_Local;
	}

	public void setGoles_Local(int goles_Local) {
		this.goles_Local = goles_Local;
	}

	public int getGoles_Visitante() {
		return goles_Visitante;
	}

	public void setGoles_Visitante(int goles_Visitante) {
		this.goles_Visitante = goles_Visitante;
	}

	public String getNombre_Local() {
		return nombre_Local;
	}

	public void setNombre_Local(String nombre_Local) {
		this.nombre_Local = nombre_Local;
	}

	public String getNombre_Visitante() {
		return nombre_Visitante;
	}

	public void setNombre_Visitante(String nombre_Visitante) {
		this.nombre_Visitante = nombre_Visitante;
	}

	public int getId_Local() {
		return id_Local;
	}

	public void setId_Local(int id_Local) {
		this.id_Local = id_Local;
	}

	public int getId_Visitante() {
		return id_Visitante;
	}

	public void setId_Visitante(int id_Visitante) {
		this.id_Visitante = id_Visitante;
	}

public Partido (){

   }

    public void cambiarResultadoManualmente(int res1, int res2){
        resultado1 = res1;
        resultado2 = res2;
    }

    public int generarGoles(){
        int[] probabilidad = generadorProbabilidades();
        int indice = (int) Math.floor(Math.random()*100);
        return probabilidad[indice];
    }

    public static int[] generadorProbabilidades() {

        int[] probabilidad = new int[100];

        for (int i = 0; i < probabilidad.length; i++) {
            if (i <= 24) {
                probabilidad[i] = 1;
            }
            if (i > 24 && i <= 49) {
                probabilidad[i] = 2;
            }
            if (i > 49 && i <= 69) {
                probabilidad[i] = 3;
            }
            if (i > 69 && i <= 89) {
                probabilidad[i] = 0;
            }
            if (i > 89 && i <= 96) {
                probabilidad[i] = 4;
            }
            if (i > 96 && i <= 99) {
                probabilidad[i] = 5;
            }
        }
        return probabilidad;
    }

//    ToString
    /**
     * Método que muestra las características de una jornada
     * @return Un string con:
     * <ul>
     *     <li>Nombre Equipo1</li>
     *     <li>Nombre Equipo2</li>
     *     <li>Resultado de Ambos Equipos</li>
     *     <li>En caso de que toque descanso --> Enfrentamiento Vs Descanso (Sin resultado)</li>
     *     <li>Nombre del Model.Arbitro</li>
     *     <li>Licencia del Model.Arbitro</li>
     * </ul>
     */
    @Override
    public String toString() {
        if (Objects.equals(equipo2.getNombre(), "Descanso")) {
            return equipo1.getNombre() + " - Descanso" + "\n";
        } else if (Objects.equals(equipo1.getNombre(), "Descanso")) {
            return equipo2.getNombre() + " - Descanso" + "\n";
        }else {
            return equipo1.getNombre() + " [" + resultado1 + " : "
                    + resultado2 + "] " + equipo2.getNombre()
                    + "Horario: "+getHoraInicio()
                    + ", Model.Arbitro: " + arbitro.getNombre()+" Licencia nº: "+ arbitro.getLicencia()+ "\n";
        }
    }

//    Setters y Getters
    /**
     * Método que devuelve el primer equipo del enfrentamiento
     * @return Un Model.Equipo
     */
    public Equipo getEquipo1() {
        return equipo1;
    }

    /**
     * Método que establece el primer equipo del enfrentamiento
     * @param equipo1 - Primer Model.Equipo que participará en el encuentro
     */
    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    /**
     * Método que devuelve el resultado del primer equipo
     * @return Puntuacion obtenida por el primer equipo
     */
    public int getResultado1() {
        return resultado1;
    }

    /**
     * Método que devuelve el segundo equipo del enfrentamiento
     * @return Un equipo
     */
    public Equipo getEquipo2() {
        return equipo2;
    }

    /**
     * Método que establece el segundo equipo del enfrentamiento
     * @param equipo2 - Segundo Model.Equipo que participará en el encuentro
     */
    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    /**
     * Método que devuelve el resultado del segundo equipo
     * @return Puntuación obtenida por el segundo equipo
     */
    public int getResultado2() {
        return resultado2;
    }

    /**
     * Método que devuelve un arbitro para el partido
     * @return Un arbitro
     */
    public Arbitro getArbitro() {
        return arbitro;
    }

    /**
     * Método que establece un arbitro para un partido
     * @param arbitro - Model.Arbitro aignado a este enfrentamiento
     */
    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    //Setters para los resultados

    public void setResultado1(int resultado1){
        this.resultado1 = resultado1;
    } 

    public void setResultado2(int resultado2){
        this.resultado2 = resultado2;
    } 

}