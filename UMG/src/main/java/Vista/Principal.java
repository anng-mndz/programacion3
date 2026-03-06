package Vista;

import Controlador.CursosControlador;
import Controlador.Cursos;
import Modelo.CursosDAO;

public class Principal {

    public static void main(String[] args) {

        // ===============================
        // INSERTAR CURSO
        // ===============================

        Cursos curso = new Cursos();
        curso.setCurCodigo(1);
        curso.setCurNombre("Programacion I");
        curso.setCurEstatus("Activo");

        //CursosDAO cursosDAO = new CursosDAO();

        //cursosDAO.insert(curso);

        System.out.println("Curso insertado:");
        System.out.println(curso);


        // ===============================
        // CONSULTAR CURSO
        // ===============================

        Cursos cursoBuscar = new Cursos();
        cursoBuscar.setCurCodigo(1);

        //cursoBuscar = cursosDAO.query(cursoBuscar);

        System.out.println("Curso encontrado:");
        System.out.println(cursoBuscar);


        // ===============================
        // ACTUALIZAR CURSO
        // ===============================

        Cursos cursoActualizar = new Cursos();
        cursoActualizar.setCurCodigo(1);
        cursoActualizar.setCurNombre("Programacion I Actualizada");
        cursoActualizar.setCurEstatus("Activo");

        //cursosDAO.update(cursoActualizar);

        System.out.println("Curso actualizado:");
        System.out.println(cursoActualizar);


        // ===============================
        // ELIMINAR CURSO
        // ===============================

        Cursos cursoEliminar = new Cursos();
        cursoEliminar.setCurCodigo(1);

        //cursosDAO.delete(cursoEliminar);

        System.out.println("Curso eliminado con codigo: " + cursoEliminar.getCurCodigo());

    }
}