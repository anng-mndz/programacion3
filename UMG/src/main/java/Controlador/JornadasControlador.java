package Controlador;

import Modelo.JornadasDao;
import java.util.List;

public class JornadasControlador {

    JornadasDao dao = new JornadasDao();

    // INSERTAR
    public void agregarJornada(int codigo, String nombre) {

        Jornadas jornada = new Jornadas(codigo, nombre);
        dao.insert(jornada);

    }

    // LISTAR (DEVUELVE LISTA PARA LA TABLA)
    public List<Jornadas> listarJornadas() {

        return dao.select();

    }

    // BUSCAR
    public Jornadas buscarJornada(int codigo) {

        Jornadas jornada = new Jornadas();
        jornada.setJor_codigo(codigo);

        return dao.query(jornada);

    }

    // ACTUALIZAR
    public void actualizarJornada(int codigo, String nombre) {

        Jornadas jornada = new Jornadas(codigo, nombre);
        dao.update(jornada);

    }

    // ELIMINAR
    public void eliminarJornada(int codigo) {

        Jornadas jornada = new Jornadas();
        jornada.setJor_codigo(codigo);

        dao.delete(jornada);

    }

}