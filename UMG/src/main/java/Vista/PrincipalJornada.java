package Vista;

import Controlador.Jornadas;
import Modelo.JornadasDao;

public class PrincipalJornada {

public static void main(String[] args) {

    // ===============================
    // INSERTAR JORNADA
    // ===============================

    Jornadas jornada = new Jornadas();
    jornada.setJor_codigo(1);
    jornada.setJor_nombre("Matutina");

    JornadasDao jornadasDao = new JornadasDao();

    jornadasDao.insert(jornada);

    System.out.println("Jornada insertada:");
    System.out.println(jornada);


    // ===============================
    // CONSULTAR JORNADA
    // ===============================

    Jornadas jornadaBuscar = new Jornadas();
    jornadaBuscar.setJor_codigo(1);

    jornadaBuscar = jornadasDao.query(jornadaBuscar);

    System.out.println("Jornada encontrada:");
    System.out.println(jornadaBuscar);


    // ===============================
    // ACTUALIZAR JORNADA
    // ===============================

    Jornadas jornadaActualizar = new Jornadas();
    jornadaActualizar.setJor_codigo(1);
    jornadaActualizar.setJor_nombre("Matutina Actualizada");

    jornadasDao.update(jornadaActualizar);

    System.out.println("Jornada actualizada:");
    System.out.println(jornadaActualizar);


    // ===============================
    // ELIMINAR JORNADA
    // ===============================

    Jornadas jornadaEliminar = new Jornadas();
    jornadaEliminar.setJor_codigo(1);

    //jornadasDao.delete(jornadaEliminar);

    System.out.println("Jornada eliminada con codigo: " + jornadaEliminar.getJor_codigo());

}
}
