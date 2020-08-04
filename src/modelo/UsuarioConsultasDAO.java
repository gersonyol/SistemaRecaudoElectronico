/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Chezter
 */
public interface UsuarioConsultasDAO {
    
    public void insertar(UsuarioVO g);
    public void eliminar(UsuarioVO g);
    public void modificar(UsuarioVO g);
    public ArrayList<UsuarioVO> consultarTabla();
    public ArrayList<UsuarioVO> consultarEmpleadoPass(UsuarioVO gvo);
    public ArrayList<UsuarioVO> consultarTipoEstado(UsuarioVO gvo);
}
 