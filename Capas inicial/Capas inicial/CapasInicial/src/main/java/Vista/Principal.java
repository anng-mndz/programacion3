/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Empresa;
import Modelo.EmpresaDAO;

/**
 *
 * @author Soporte
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Empresa empresa = new Empresa("Universidad UPANA");
        System.out.println(empresa.toString());
        EmpresaDAO empresadao = new EmpresaDAO();
        //empresadao.insert(empresa);
       
       System.out.println(empresa.toString());
       empresa=empresadao.query(empresa);
       //empresa.setCodigoEmpresa(5);

      Empresa empresaEliminar = new Empresa();
      empresaEliminar.setCodigoEmpresa(2);
      //empresadao.delete(empresaEliminar);
      
      Empresa empresaActualizar = new Empresa();
      empresaActualizar.setCodigoEmpresa(3);
      empresaActualizar.setNombreEmpresa("Universidad Rafael Landivar");
      //empresadao.update(empresaActualizar);
       
    }
    
    
    
}
