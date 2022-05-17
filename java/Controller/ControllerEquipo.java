package Controller;

import java.util.*;

import Model.Equipo;
import Model.Jugador;

import java.sql.*;

public class ControllerEquipo {
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

    public static ArrayList<Equipo> detalleEquipo(int idequipo) {
        ArrayList<Equipo> listaEquipo = new ArrayList<Equipo>();

        try {

            String sentenciaSql = "select * from equipo where Id_Equipo=?;";
            PreparedStatement st = con.prepareStatement(sentenciaSql);
            st.setInt(1, idequipo);


            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Equipo equipoTemporal = new Equipo();

                int Id_Equipo = rs.getInt("Id_Equipo");
                String nombre = rs.getString("nombre");
                int Licencia_Entrenador = rs.getInt("Licencia_Entrenador");

                equipoTemporal.setId_Equipo(Id_Equipo);
                equipoTemporal.setNombre(nombre);
                equipoTemporal.setLicenciaentrenador(Licencia_Entrenador);

                listaEquipo.add(equipoTemporal);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return listaEquipo;
    }

    public static ArrayList<Jugador> detalleEquipoJugadores(int idequipo) {
        ArrayList<Jugador> listaJugador = new ArrayList<Jugador>();

        try {

            String sentenciaSql = "SELECT * FROM jugador where Id_Equipo=?";
            PreparedStatement st = con.prepareStatement(sentenciaSql);
            st.setInt(1, idequipo);


            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Jugador jugadorTemporal = new Jugador();


                String nombre = rs.getString("nombre");
                String apellido = rs.getString("Apellidos");


                jugadorTemporal.setNombre(nombre);
                jugadorTemporal.setApellidos(apellido);


                listaJugador.add(jugadorTemporal);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return listaJugador;
    }

    public static ArrayList<Equipo> traerEquipos() {
        ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();
        try {

            String sentenciaSql = "select * from equipo where Nombre != 'Descanso'; ";


            PreparedStatement st = con.prepareStatement(sentenciaSql);


            ResultSet rs = st.executeQuery();


            while (rs.next()) {
                Equipo equipoTemporal = new Equipo();

                int id = rs.getInt("Id_Equipo");
                String nombre = rs.getString("Nombre");
                int licenciaEntrenador = rs.getInt("Licencia_Entrenador");

                equipoTemporal.setId_Equipo(id);
                equipoTemporal.setNombre(nombre);
                equipoTemporal.setLicenciaentrenador(licenciaEntrenador);

                listaEquipos.add(equipoTemporal);
            }

        } catch (Exception e) {

            System.out.println(e);
        }

        return listaEquipos;
    }
}
