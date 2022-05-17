package Controller;

import java.sql.*;
import java.util.ArrayList;
import Model.*;

public class ControllerJornadas {

    public static Connection con;
    public static Statement st;
    public static ResultSet rs;

    public  ControllerJornadas() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://ligafutbol.csiagfyvzpdu.eu-west-3.rds.amazonaws.com:3306/liga_futbol","usuario1" ,"Usuario1.");

            st= con.createStatement();
            //java.sql.Statement miStatement=con.createStatement();

        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }


    public ArrayList<Calendario> getDatos(int numJornada) {
        ArrayList<Calendario> listaJornadas = new ArrayList<Calendario>();


        try {
            String query = "select e.nombre as \"EQUIPO LOCAL\",  e2.nombre as \"EQUIPO VISITANTE\", p.fecha, p.jornada from partido p \r\n"
                    + "\r\n"
                    + "inner join equipo e\r\n"
                    + "on p.Id_Equipo_local= e.Id_Equipo\r\n"
                    + "inner join equipo e2 \r\n"
                    + "on p.Id_Equipo_visitante=e2.id_equipo\r\n"
                    + "\r\n"
                    + "where e.Id_Equipo!=4 and e2.Id_Equipo!=4 and\r\n"
                    + "p.Jornada="+numJornada+"\r\n"
                    + "group by p.jornada;";

            rs = st.executeQuery(query);
            //System.out.println("CALENDARIO");
            //	System.out.println("Jornada "+ numJornada );
            while(rs.next()) {
                Calendario calendarioTemporal = new Calendario();

                String equipoLocal = rs.getString("EQUIPO LOCAL");
                String equipoVisitante = rs.getString("EQUIPO VISITANTE");
                String fecha = rs.getString("fecha");
                int jornada = rs.getInt("jornada");

                calendarioTemporal.setNumeroJornada(jornada);
                calendarioTemporal.setEquipoLocal(equipoLocal);
                calendarioTemporal.setEquipoVisitante(equipoVisitante);
                calendarioTemporal.setFecha(fecha);


                listaJornadas.add(calendarioTemporal);

                //System.out.println(equipoLocal+ " VS "+ equipoVisitante+ " fecha de juego: "+fecha+" JORNADA: "+jornada);



            }

        }catch(Exception ex) {
            ex.printStackTrace();
            //}finally {
            //	try {
            //		con.close();

            //}catch(Exception ex) {
            //		ex.printStackTrace();

            //		}
        }
        return listaJornadas;


    }
    public void setDatos(String nombre,String apellidos, int edad, String puesto) {




        try {
            String query = "insert into empleados (nombre,apellidos,edad,puesto) values ('"+nombre+"','"+apellidos+"','"+edad+"','"+puesto+"')";

            st.executeUpdate(query);


            System.out.println("Trabajador insertado con �xito");
			/*while(rs.next()) {
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				int edad = rs.getInt("edad");
				String puesto = rs.getString("puesto");
				int id = rs.getInt("id");

				System.out.println("El nombre del trabajador insertado correctamente es "+  nombre + " "+ apellidos+" , tiene "+ edad+" a�os"+ ", trabaja como "+puesto +" su ID es el n�: "+ id);
			}
			 */
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                con.close();

            }catch(Exception ex) {
                ex.printStackTrace();

            }
        }
    }

    public static ArrayList<Jornada> traerListaJornadas(int jor) {
        ArrayList<Jornada> listaJornadas = new ArrayList<Jornada>();

        try {
            String sql = "SELECT Jornada, Fecha, Hora, e1.Nombre, p.Goles_Local, p.Goles_Visitante, e2.nombre, a.nombre AS Arbitro\r\n"
                    + "FROM partido p, equipo e1, equipo e2, arbitro a\r\n"
                    + "WHERE p.Id_Equipo_Local = e1.Id_Equipo\r\n"
                    + "AND p.Id_Equipo_Visitante = e2.Id_Equipo\r\n"
                    + "AND a.Licencia = p.Licencia_Arbitro\r\n"
                    + "AND e1.Nombre != \"Descanso\" AND e2.Nombre != \"Descanso\"\r\n"
                    + "AND Jornada = "+jor+"\r\n"
                    + "ORDER BY Jornada;";

            // Objeto para realizar la conexi�n
            Statement st = con.createStatement();

            // Objeto que contendr� los resultados de la consulta.
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Jornada jornadaTemp = new Jornada();

                int numJornada = rs.getInt("Jornada");
                String fecha = rs.getString("Fecha");
                String hora = rs.getString("Hora");
                String equipoLocal = rs.getString("e1.Nombre");
                int golesLocal = rs.getInt("Goles_Local");
                int golesVisitante = rs.getInt("Goles_Visitante");
                String equipoVisitante = rs.getString("e2.Nombre");
                String arbitro = rs.getString("Arbitro");

                jornadaTemp.setNumJornada(numJornada);
                jornadaTemp.setFecha(fecha);
                jornadaTemp.setHora(hora);
                jornadaTemp.setEquipoLocal(equipoLocal);
                jornadaTemp.setGolesLocal(golesLocal);
                jornadaTemp.setGolesVisitante(golesVisitante);
                jornadaTemp.setEquipoVisitante(equipoVisitante);
                jornadaTemp.setArbitro(arbitro);

                listaJornadas.add(jornadaTemp);
            }

            rs.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return listaJornadas;
    }

    public static ArrayList<Jornada> traerListaJornadas() {
        ArrayList<Jornada> listaJornadas = new ArrayList<Jornada>();

        try {
            String sql = "SELECT Jornada, Fecha, Hora, e1.Nombre, p.Goles_Local, p.Goles_Visitante, e2.nombre, a.nombre AS Arbitro\r\n"
                    + "FROM partido p, equipo e1, equipo e2, arbitro a\r\n"
                    + "WHERE p.Id_Equipo_Local = e1.Id_Equipo\r\n"
                    + "AND p.Id_Equipo_Visitante = e2.Id_Equipo\r\n"
                    + "AND a.Licencia = p.Licencia_Arbitro\r\n"
                    + "AND e1.Nombre != \"Descanso\" AND e2.Nombre != \"Descanso\"\r\n"
                    + "ORDER BY Jornada;";

            // Objeto para realizar la conexi�n
            Statement st = con.createStatement();

            // Objeto que contendr� los resultados de la consulta.
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Jornada jornadaTemp = new Jornada();

                int numJornada = rs.getInt("Jornada");
                String fecha = rs.getString("Fecha");
                String hora = rs.getString("Hora");
                String equipoLocal = rs.getString("e1.Nombre");
                int golesLocal = rs.getInt("Goles_Local");
                int golesVisitante = rs.getInt("Goles_Visitante");
                String equipoVisitante = rs.getString("e2.Nombre");
                String arbitro = rs.getString("Arbitro");

                jornadaTemp.setNumJornada(numJornada);
                jornadaTemp.setFecha(fecha);
                jornadaTemp.setHora(hora);
                jornadaTemp.setEquipoLocal(equipoLocal);
                jornadaTemp.setGolesLocal(golesLocal);
                jornadaTemp.setGolesVisitante(golesVisitante);
                jornadaTemp.setEquipoVisitante(equipoVisitante);
                jornadaTemp.setArbitro(arbitro);

                listaJornadas.add(jornadaTemp);
            }

            rs.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return listaJornadas;
    }

}

