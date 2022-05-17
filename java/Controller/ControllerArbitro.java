package Controller;
import java.util.ArrayList;
import Model.Arbitro;
import Model.Partido;
import Model.Jugador;
import java.sql.*;


public class ControllerArbitro {
	/* Atributos privados. Constantes y est�ticos. */
	public final static String URL = "jdbc:mysql://ligafutbol.csiagfyvzpdu.eu-west-3.rds.amazonaws.com:3306/liga_futbol";
	public final static String USER = "usuario1";
	public final static String PASSWORD = "Usuario1.";
	private static Connection con;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);

			System.out.println("Conexión realizada con éxito.");

		} catch (Exception e) {
			System.out.println("Error al realizar la conexión.");
			System.out.println(e);
		}
	}

	/***
	 * M�todo que lee unn jugador de una Base de Datos.
	 * @return ArrayList de Jugador.
	 */
	public static ArrayList<Jugador> traerJugadores(int numeroJugadores) {

		ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();

		try {
			String sql = "SELECT Id_Jugador,Nombre, Apellidos FROM jugador";

			// Objeto para realizar la conexion
			Statement st = con.createStatement();

			// Objeto que contendra los resultados de la consulta.
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				Jugador jugadorTemporal = new Jugador();

				int Id_Jugador = rs.getInt("Id_Jugador");
				String NombreJugador = rs.getString("Nombre");
				String ApellidosJugador = rs.getString("Apellidos");


				jugadorTemporal.setId_Jugador(Id_Jugador);
				jugadorTemporal.setNombre(NombreJugador);
				jugadorTemporal.setApellidos(ApellidosJugador);


				listaJugadores.add(jugadorTemporal);
			}

			rs.close();

		} catch (Exception e) {
			System.out.println("No se ha podido recuperar los datos.");
			System.out.println(e);
		}

		return listaJugadores;
	}
	
	
	
	
	
	public static ArrayList<Arbitro> traerArbitros(int Licencia) {
		ArrayList<Arbitro> listaArbitros = new ArrayList<Arbitro>();

		try {

			String sentenciaSql = "SELECT * FROM liga_futbol.arbitro where Licencia =?";


			PreparedStatement st = con.prepareStatement(sentenciaSql); 
			st.setInt(1,Licencia);


			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				Arbitro arbitroTemporal = new Arbitro();

				int licencia = rs.getInt("Licencia");
				String nombre = rs.getString("Nombre");
				String apellidos = rs.getString("Apellidos");

				arbitroTemporal.setLicencia(licencia);
				arbitroTemporal.setNombre(nombre);
				arbitroTemporal.setApellidos(apellidos);

				listaArbitros.add(arbitroTemporal);

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return listaArbitros;
	}
	public static ArrayList<Partido> traerPartidos(int Licencia) {
		ArrayList<Partido> listaPartido = new ArrayList<Partido>();

		try {

			String sentenciaSql = 
					"SELECT partido.Id_Equipo_Local, partido.Id_Equipo_Visitante, partido.Jornada, partido.Goles_Local, partido.Goles_Visitante, e1.Nombre, e2.Nombre\r\n"
					+"FROM partido, equipo e1, equipo e2, arbitro\r\n"
					+"where partido.Licencia_Arbitro = arbitro.Licencia\r\n"
					+"and partido.Id_Equipo_Local = e1.Id_Equipo\r\n"
					+"and partido.Id_Equipo_Visitante = e2.Id_Equipo\r\n"
					+"and arbitro.Licencia=?";


			PreparedStatement st = con.prepareStatement(sentenciaSql); 
			st.setInt(1,Licencia);


			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				Partido partidoTemporal = new Partido();

				String nombre_local = rs.getString("e1.Nombre");
				String nombre_visitante = rs.getString("e2.Nombre");
				int Jornada = rs.getInt("partido.Jornada");
				int Goles_Local = rs.getInt("partido.Goles_Local");
				int Goles_Visitante = rs.getInt("partido.Goles_Visitante");
				int Id_Local = rs.getInt("Id_Equipo_Local");
				int Id_Visitante = rs.getInt("Id_Equipo_Visitante");
				
				partidoTemporal.setJornada(Jornada);
				partidoTemporal.setGoles_Local(Goles_Local);
				partidoTemporal.setGoles_Visitante(Goles_Visitante);
				partidoTemporal.setNombre_Local(nombre_local);
				partidoTemporal.setNombre_Visitante(nombre_visitante);
				partidoTemporal.setId_Local(Id_Local);
				partidoTemporal.setId_Visitante(Id_Visitante);

				listaPartido.add(partidoTemporal);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return listaPartido;
	}
	
	public static ArrayList<Arbitro> traerListaArbitros() {
		ArrayList<Arbitro> listaArbitros = new ArrayList<Arbitro>();

		try {

			String sentenciaSql = "SELECT * FROM arbitro";


			PreparedStatement st = con.prepareStatement(sentenciaSql); 

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				Arbitro arbitroTemporal = new Arbitro();

				int licencia = rs.getInt("Licencia");
				String nombre = rs.getString("Nombre");
				String apellidos = rs.getString("Apellidos");

				arbitroTemporal.setLicencia(licencia);
				arbitroTemporal.setNombre(nombre);
				arbitroTemporal.setApellidos(apellidos);

				listaArbitros.add(arbitroTemporal);

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return listaArbitros;
	}
}
