package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.*;
import java.sql.*;

/*----------------------------CONEXION-------------------------------------------------------------------------------*/
public class ControllerJugadores {
	/* Atributos privados. Constantes y est�ticos. */
	public final static String URL = "jdbc:mysql://ligafutbol.csiagfyvzpdu.eu-west-3.rds.amazonaws.com:3306/liga_futbol";
	public final static String USER = "usuario1";
	public final static String PASSWORD = "Usuario1.";
	public static Connection con;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);

			System.out.println("Conexión realizada con éxito");
		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	/*---------------TRAER TODOS JUGADORES---------------------------------------------------------------------------------------*/
	/***
	 * M�todo que lee unn jugador de una Base de Datos.
	 * @return ArrayList de Jugador.
	 */
	
	public static ArrayList<Jugador> traerJugadores() {

		ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();

		try {
			String sql = "SELECT * FROM jugador";

			// Objeto para realizar la conexion
			Statement st = con.createStatement();

			// Objeto que contendra los resultados de la consulta.
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				Jugador jugadorTemporal = new Jugador();

				int Id_Jugador = rs.getInt("Id_Jugador");
				String NombreJugador = rs.getString("Nombre");
				String ApellidosJugador = rs.getString("Apellidos");
				int Edad = rs.getInt("Edad");
				int Dorsal = rs.getInt("Dorsal");
				String Posicion = rs.getString("Posicion");
				int Id_Equipo = rs.getInt("Id_Equipo");


				jugadorTemporal.setId_Jugador(Id_Jugador);
				jugadorTemporal.setNombre(NombreJugador);
				jugadorTemporal.setApellidos(ApellidosJugador);
				jugadorTemporal.setEdad(Edad);
				jugadorTemporal.setDorsal(Dorsal);
				jugadorTemporal.setPosicion(Posicion);
				jugadorTemporal.setId_Equipo(Id_Equipo);
				


				listaJugadores.add(jugadorTemporal);
			}

			rs.close();

		} catch (Exception e) {
			System.out.println("No se ha podido recuperar los datos.");
			System.out.println(e);
		}

		return listaJugadores;
	}
	
	/*---------------TRAER UN JUGADOR QUE DEPENDE DE ID_JUGADOR---------------------------------------------------------------------------------------*/
	
	public static Jugador traerJugador(int id_jugador) {

		Jugador jug = new Jugador();
		

		try {
			String sql = "SELECT jugador.* FROM jugador where jugador.Id_Jugador = '"+id_jugador+"'";
			

			// Objeto para realizar la conexion
			Statement st = con.createStatement();

			// Objeto que contendra los resultados de la consulta.
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				 
				Jugador jugadorTemporal = new Jugador();
				
				int Id_Jugador = rs.getInt("Id_Jugador");
				String NombreJugador = rs.getString("Nombre");
				String ApellidosJugador = rs.getString("Apellidos");
				int Edad = rs.getInt("Edad");
				int Dorsal = rs.getInt("Dorsal");
				String Posicion = rs.getString("Posicion");
				int Id_Equipo = rs.getInt("Id_Equipo");
				String EquipoNombre = rs.getString("Nombre");


				jugadorTemporal.setId_Jugador(Id_Jugador);
				jugadorTemporal.setNombre(NombreJugador);
				jugadorTemporal.setApellidos(ApellidosJugador);
				jugadorTemporal.setEdad(Edad);
				jugadorTemporal.setDorsal(Dorsal);
				jugadorTemporal.setPosicion(Posicion);
				jugadorTemporal.setId_Equipo(Id_Equipo);
				


				jug = jugadorTemporal;
				
			}

			rs.close();

		} catch (Exception e) {
			System.out.println("No se ha podido recuperar los datos.");
			System.out.println(e);
		}

		return jug;
	}
	
	public static Equipo traerEquipo (int id_jugador) {

		Equipo equipo = new Equipo();
		

		try {
			String sql = "SELECT equipo.* FROM equipo INNER JOIN jugador ON jugador.Id_Equipo = equipo.Id_Equipo where jugador.Id_Jugador = '"+id_jugador+"'";
			

			// Objeto para realizar la conexion
			Statement st = con.createStatement();

			// Objeto que contendra los resultados de la consulta.
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				 
				Equipo equiTemporal = new Equipo();
				
				int Id_Equipo = rs.getInt("Id_Equipo");
				String NombreEquipo = rs.getString("Nombre");

				equiTemporal.setId_Equipo(Id_Equipo);
				equiTemporal.setNombre(NombreEquipo);

				equipo = equiTemporal;
				
			}

			rs.close();

		} catch (Exception e) {
			System.out.println("No se ha podido recuperar los datos.");
			System.out.println(e);
		}

		return equipo;
	}

	public static ArrayList<Jugador> traerJugadoresEquipo(int idEquipo) {

		ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();

		try {
			String sql = "SELECT * FROM jugador where Id_Equipo='" +  idEquipo + "'";

			// Objeto para realizar la conexion
			Statement st = con.createStatement();

			// Objeto que contendra los resultados de la consulta.
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				Jugador jugadorTemporal = new Jugador();

				int Id_Jugador = rs.getInt("Id_Jugador");
				String NombreJugador = rs.getString("Nombre");
				String ApellidosJugador = rs.getString("Apellidos");
				int Edad = rs.getInt("Edad");
				int Dorsal = rs.getInt("Dorsal");
				String Posicion = rs.getString("Posicion");
				int Id_Equipo = rs.getInt("Id_Equipo");

				jugadorTemporal.setId_Jugador(Id_Jugador);
				jugadorTemporal.setNombre(NombreJugador);
				jugadorTemporal.setApellidos(ApellidosJugador);
				jugadorTemporal.setEdad(Edad);
				jugadorTemporal.setDorsal(Dorsal);
				jugadorTemporal.setPosicion(Posicion);
				jugadorTemporal.setId_Equipo(Id_Equipo);



				listaJugadores.add(jugadorTemporal);
			}

			rs.close();

		} catch (Exception e) {
			System.out.println("No se ha podido recuperar los datos.");
			System.out.println(e);
		}

		return listaJugadores;
	}
}
