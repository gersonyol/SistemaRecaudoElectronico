/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Chezter
 */
public class UsuarioDAO implements UsuarioConsultasDAO {

    @Override
    public void insertar(UsuarioVO g) {
        Conector c = new Conector();
        
        try {
            c.conectar();
            c.consultaMultiple("INSERT INTO tbl_empleado (nombre_empleado, "
                    + "apellido_empleado, edad_empleado, user_empleado, "
                    + "password_empleado, id_tipo_empleado, id_estado) VALUES ( '"+g.getNombre_empleado()
                    +"', '"+g.getApellido_empleado()+"', "+g.getEdad_empleado()
                    +" ,'"+g.getUser_empleado()+"','"+g.getPassword_empleado()
                    +" ', "+g.getId_tipo_empleado()+" , "+g.getId_estado()+" ); "  );
                              
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        c.desconectar();
    }

    @Override
    public void eliminar(UsuarioVO g) {
        Conector c = new Conector();
        
        try {
            c.conectar();
            c.consultaMultiple(" DELETE FROM tbl_empleado WHERE id_empleado = "+g.getId_empleado()+";");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        c.desconectar();
    }

    @Override
    public void modificar(UsuarioVO g) {
        Conector c = new Conector();
        
        try {
            c.conectar();
            c.consultaMultiple("UPDATE tbl_empleado SET nombre_empleado = '"+g.getNombre_empleado()
                    +"', apellido_empleado = ' "+g.getApellido_empleado()+" ', edad_empleado = "+g.getEdad_empleado()
                    +" , user_empleado = ' "+g.getUser_empleado()+" ', password_empleado = '"+g.getPassword_empleado()
                    +" ', id_tipo_empleado = "+g.getId_tipo_empleado()+" , id_estado = "+g.getId_estado()
                    + " WHERE id_empleado = "+g.getId_empleado());
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<UsuarioVO> consultarTabla() {
        Conector c = new Conector();
        ArrayList<UsuarioVO> info = new ArrayList();
        
        try {
            c.conectar();
            ResultSet rs = c.consultaObtener("SELECT * FROM tbl_empleado;");
            while(rs.next()){
                UsuarioVO gvo = new UsuarioVO();
                gvo.setId_empleado(rs.getInt(1));
                gvo.setNombre_empleado(rs.getString(2));
                gvo.setApellido_empleado(rs.getString(3));
                gvo.setEdad_empleado(rs.getInt(4));
                gvo.setUser_empleado(rs.getString(5));
                gvo.setPassword_empleado(rs.getString(6));
                gvo.setId_tipo_empleado(rs.getInt(7));
                gvo.setId_estado(rs.getInt(8));
                info.add(gvo);
         
            }          
            
        } catch (Exception e) {
        }
        return info;
    }

    @Override
    public ArrayList<UsuarioVO> consultarEmpleadoPass(UsuarioVO gvo) {
        Conector c = new Conector();
        ArrayList<UsuarioVO> info = new ArrayList<>();
        
        try {
            c.conectar();
            ResultSet rs = c.consultaObtener("SELECT user_empleado, password_empleado FROM tbl_empleado WHERE user_empleado = '"+gvo.getLoginEmpleado()+"';");
            while(rs.next()){
                
                gvo.setUser_empleado(rs.getString(1));
                gvo.setPassword_empleado(rs.getString(2));
                
                info.add(gvo);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return info;
    }

    @Override
    public ArrayList<UsuarioVO> consultarTipoEstado(UsuarioVO gvo) {
        Conector c = new Conector();
       ArrayList<UsuarioVO> info = new ArrayList<>();
       
        try {
            c.conectar();
            ResultSet rs = c.consultaObtener("SELECT id_tipo_empleado, id_estado FROM tbl_empleado WHERE user_empleado = '"+gvo.getLoginEmpleado()+"';");
            while(rs.next()){
                
                gvo.setId_tipo_empleado(rs.getInt(1));
                gvo.setId_estado(rs.getInt(2));
                
                info.add(gvo);
            }
                 
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return info;
    }

    
}
