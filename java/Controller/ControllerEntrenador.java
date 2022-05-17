package Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.*;
import Controller.*;
import java.sql.*;

public class ControllerEntrenador {
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
    
    public static ArrayList<Entrenador> traerEntrenadores(int numeroEntrenador) {
		ArrayList<Entrenador> listaEntrenadores = new ArrayList<Entrenador>();
		
		try {
			String sql = "SELECT * FROM entrenador where Licencia=' "+numeroEntrenador + "'";
			
			// Objeto para realizar la conexión
			Statement st = con.createStatement();
			
			// Objeto que contendrá los resultados de la consulta.
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Entrenador entrenadorTemporal = new Entrenador();
				
				int LicenciaEntrenador = rs.getInt("Licencia");
				String NombreEntrenador = rs.getString("Nombre");
				String ApellidosEntrenador = rs.getString("Apellidos");
				
				
				entrenadorTemporal.setNombre(NombreEntrenador);
				entrenadorTemporal.setApellidos(ApellidosEntrenador);
				entrenadorTemporal.setLicencia(LicenciaEntrenador);
				
				listaEntrenadores.add(entrenadorTemporal);
			}
			
			rs.close();
			
		} catch (Exception e) {
			System.out.println("No se ha podido recuperar los datos.");
			System.out.println(e);
		}
		
    	return listaEntrenadores;
    }
    
    
public static ArrayList<Entrenador> traerEntrenador() {
    	
        ArrayList<Entrenador> entrenadores = new ArrayList<Entrenador>();
        
        try {
            String sql = "SELECT * FROM entrenador WHERE Licencia <>0";
            // Objeto para realizar la conexi�n
            Statement st = con.createStatement();
            // Objeto que contendr� los resultados de la consulta.
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) {
                Entrenador entreTemp = new Entrenador();
                
                int licenciaEntrenador = rs.getInt("Licencia");
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");

                entreTemp.setLicencia(licenciaEntrenador);
                entreTemp.setNombre(nombre);
                entreTemp.setApellidos(apellidos);
             
                
                entrenadores.add(entreTemp);
               
               
               
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("No se ha podido recuperar los datos.");
            System.out.println(e);
        }
        return entrenadores;
    }

	public static Entrenador traerEntrenador(int licencia) {
		Entrenador entreTemp = new Entrenador();

		try {
			String sql = "SELECT * FROM entrenador where Licencia=' "+licencia + "'";
			// Objeto para realizar la conexi�n
			Statement st = con.createStatement();
			// Objeto que contendr� los resultados de la consulta.
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {

				int licenciaEntrenador = rs.getInt("Licencia");
				String nombre = rs.getString("Nombre");
				String apellidos = rs.getString("Apellidos");

				entreTemp.setLicencia(licenciaEntrenador);
				entreTemp.setNombre(nombre);
				entreTemp.setApellidos(apellidos);

			}
			rs.close();
		} catch (Exception e) {
			System.out.println("No se ha podido recuperar los datos.");
			System.out.println(e);
		}
		return entreTemp;
	}
}
   

