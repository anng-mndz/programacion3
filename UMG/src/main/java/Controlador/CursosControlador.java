package Controlador;

import Modelo.CursosDAO;
import java.util.List;

public class CursosControlador {

    CursosDAO dao = new CursosDAO();

    // INSERTAR
    public void agregarCurso(int codigo, String nombre, String estatus) {

        Cursos curso = new Cursos(codigo, nombre, estatus);
        dao.insert(curso);

    }

    // LISTAR (DEVUELVE LISTA PARA LA TABLA)
    public List<Cursos> listarCursos() {

        return dao.select();

    }

    // BUSCAR
    public Cursos buscarCurso(int codigo) {

        Cursos curso = new Cursos();
        curso.setCurCodigo(codigo);

        return dao.query(curso);

    }

    // ACTUALIZAR
    public void actualizarCurso(int codigo, String nombre, String estatus) {

        Cursos curso = new Cursos(codigo, nombre, estatus);
        dao.update(curso);

    }

    // ELIMINAR
    public void eliminarCurso(int codigo) {

        Cursos curso = new Cursos();
        curso.setCurCodigo(codigo);

        dao.delete(curso);

    }

}