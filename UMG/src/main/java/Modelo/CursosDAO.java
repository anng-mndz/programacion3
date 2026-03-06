package Modelo;

import Controlador.Cursos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursosDAO {

    private static final String SQL_SELECT =
            "SELECT cur_codigo, cur_nombre, cur_estatus FROM cursos";

    private static final String SQL_INSERT =
            "INSERT INTO cursos(cur_codigo, cur_nombre, cur_estatus) VALUES(?,?,?)";

    private static final String SQL_UPDATE =
            "UPDATE cursos SET cur_nombre=?, cur_estatus=? WHERE cur_codigo=?";

    private static final String SQL_DELETE =
            "DELETE FROM cursos WHERE cur_codigo=?";

    private static final String SQL_QUERY =
            "SELECT cur_codigo, cur_nombre, cur_estatus FROM cursos WHERE cur_codigo=?";


    // =========================
    // LISTAR TODOS LOS CURSOS
    // =========================
    public List<Cursos> select() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cursos> cursos = new ArrayList<>();

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cursos curso = new Cursos();

                curso.setCurCodigo(rs.getInt("cur_codigo"));
                curso.setCurNombre(rs.getString("cur_nombre"));
                curso.setCurEstatus(rs.getString("cur_estatus"));

                cursos.add(curso);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }

        return cursos;
    }


    // =========================
    // INSERTAR CURSO
    // =========================
    public int insert(Cursos curso) {

        Connection conn = null;
        PreparedStatement stmt = null;

        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setInt(1, curso.getCurCodigo());
            stmt.setString(2, curso.getCurNombre());
            stmt.setString(3, curso.getCurEstatus());

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
    public int update(Cursos curso) {

        Connection conn = null;
        PreparedStatement stmt = null;

        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, curso.getCurNombre());
            stmt.setString(2, curso.getCurEstatus());
            stmt.setInt(3, curso.getCurCodigo());

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
    public int delete(Cursos curso) {

        Connection conn = null;
        PreparedStatement stmt = null;

        int rows = 0;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, curso.getCurCodigo());

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
    public Cursos query(Cursos curso) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);

            stmt.setInt(1, curso.getCurCodigo());

            rs = stmt.executeQuery();

            if (rs.next()) {

                curso.setCurCodigo(rs.getInt("cur_codigo"));
                curso.setCurNombre(rs.getString("cur_nombre"));
                curso.setCurEstatus(rs.getString("cur_estatus"));

                return curso;

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