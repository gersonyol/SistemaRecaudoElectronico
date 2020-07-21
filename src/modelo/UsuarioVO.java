/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Chezter
 */
public class UsuarioVO {

    private int id_empleado;
    private String nombre_empleado;
    private String apellido_empleado;
    private int edad_empleado;
    private String user_empleado;
    private String password_empleado;
    private int id_tipo_empleado;
    private int id_estado;
    private String loginEmpleado;
    private String loginPassword;

    public String getLoginEmpleado() {
        return loginEmpleado;
    }

    public void setLoginEmpleado(String loginEmpleado) {
        this.loginEmpleado = loginEmpleado;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellido_empleado() {
        return apellido_empleado;
    }

    public void setApellido_empleado(String apellido_empleado) {
        this.apellido_empleado = apellido_empleado;
    }

    public int getEdad_empleado() {
        return edad_empleado;
    }

    public void setEdad_empleado(int edad_empleado) {
        this.edad_empleado = edad_empleado;
    }

    public String getUser_empleado() {
        return user_empleado;
    }

    public void setUser_empleado(String user_empleado) {
        this.user_empleado = user_empleado;
    }

    public String getPassword_empleado() {
        return password_empleado;
    }

    public void setPassword_empleado(String password_empleado) {
        this.password_empleado = password_empleado;
    }

    public int getId_tipo_empleado() {
        return id_tipo_empleado;
    }

    public void setId_tipo_empleado(int id_tipo_empleado) {
        this.id_tipo_empleado = id_tipo_empleado;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

}
