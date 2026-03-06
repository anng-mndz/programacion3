package Modelo;

import Controlador.Jornadas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JornadasDao {

    private static final String SQL_SELECT =
            "SELECT Jor_codigo, Jor_nombre, FROM jornadas";

    private static final String SQL_INSERT =
            "INSERT INTO jornadas(Jor_codigo, Jor_nombre) VALUES(?,?)";

    private static final String SQL_UPDATE =
            "UPDATE jornadas SET Jor_nombre=?, WHERE Jor_codigo=?";

    private static final String SQL_DELETE =
            "DELETE FROM jornadas WHERE Jor_codigo=?";

    private static final String SQL_QUERY =
            "SELECT Jor_codigo, Jor_nombre FROM jornadas WHERE Jor_codigo=?";


    // =========================
    // LISTAR TODOS LOS CURSOS
    // =========================
    public List<Jornadas> select() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Jornadas> jornadas = new ArrayList<>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Jornadas jornada = new Jornadas ();

                jornada.setJor_codigo(rs.getInt("Jor_codigo"));
                jornada.setJor_nombre(rs.getString("Jor_nombre"));

                jornadas.add(jornada);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return jornadas;
    }


    // =========================
    // INSERTAR CURSO
    // =========================
    public int insert(Jornadas jornadas) {

        Connection conn = null;
        PreparedStatement stmt = null;

        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setInt(1, jornadas.getJor_codigo());
            stmt.setString(2, jornadas.getJor_nombre());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return rows;
    }


    // =========================
    // ACTUALIZAR CURSO
    // =========================
    public int update(Jornadas jornadas) {

        Connection conn = null;
        PreparedStatement stmt = null;

        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, jornadas.getJor_nombre());
            stmt.setInt(2, jornadas.getJor_codigo());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return rows;
    }


    // =========================
    // ELIMINAR CURSO
    // =========================
    public int delete(Jornadas jornadas) {

        Connection conn = null;
        PreparedStatement stmt = null;

        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, jornadas.getJor_codigo());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return rows;
    }


    // =========================
    // BUSCAR CURSO
    // =========================
    public Jornadas query(Jornadas jornadas) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);

            stmt.setInt(1, jornadas.getJor_codigo());

            rs = stmt.executeQuery();

            if (rs.next()) {

                jornadas.setJor_codigo(rs.getInt("Jor_codigo"));
                jornadas.setJor_nombre(rs.getString("Jor_nombre"));

                return jornadas;

            } else {

                return null;

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return null;
    }

}