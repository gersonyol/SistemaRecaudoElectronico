/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;

//Comentario de prueba -- Profe

/**
 *
 * @author Chezter
 */
public class ControladorAdministrador implements ActionListener, WindowListener, MouseListener {
    
        FrmAdministrador fa = new FrmAdministrador();
        UsuarioVO gvo = new UsuarioVO();
        UsuarioDAO gdao = new UsuarioDAO();
        
              
        
 public ControladorAdministrador(FrmAdministrador fa, UsuarioVO gvo, UsuarioDAO gdao) {
            
        this.fa = fa;
        this.gvo = gvo;
        this.gdao = gdao;
        
        fa.btnIngresar.addActionListener(this);
        fa.btnBorrar.addActionListener(this);
        fa.btnModificar.addActionListener(this);
        fa.addWindowListener(this);
        fa.addMouseListener(this);
        fa.tblAdministrador.addMouseListener(this);
        fa.setLocationRelativeTo(null);
      
    }     
 
 private void insertarUsuario(){
        gvo.setNombre_empleado(fa.txtNombreUsuario.getText());
        gvo.setApellido_empleado(fa.txtApellidoUsuario.getText());
        gvo.setEdad_empleado(Integer.parseInt(fa.txtEdadUsuario.getText()));
        gvo.setUser_empleado(fa.txtUser.getText());
        gvo.setPassword_empleado(fa.txtPassword.getText());
        gvo.setId_tipo_empleado(fa.cmbTipoUsuario.getSelectedIndex());
        gvo.setId_estado(fa.cmbEstadoUsuario.getSelectedIndex());
       
        gdao.insertar(gvo);
        fa.optMensajeIngresar.showMessageDialog(null, " ¡Registro insertado correctamente! ");
    }
 
 private void mostrarDatos(){
        
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("Id");
        m.addColumn("Nombre");
        m.addColumn("Apellido");
        m.addColumn("Edad");
        m.addColumn("User");
        m.addColumn("Password");
        m.addColumn("Id_Tipo_Empleado");
        m.addColumn("Id_Estado");
        
        for (UsuarioVO v : this.gdao.consultarTabla()) {
            m.addRow(new Object[]{v.getId_empleado(), v.getNombre_empleado(),
            v.getApellido_empleado(), v.getEdad_empleado(), v.getUser_empleado(),
            v.getPassword_empleado(), v.getId_tipo_empleado(), v.getId_estado()});
        }
        
        fa.tblAdministrador.setModel(m);
    }
 
 private void eliminarDatos(){
        this.gvo.getId_empleado();
        this.gdao.eliminar(gvo);
        fa.optMensajeBorrar.showMessageDialog(null, "¡Registro eliminado correctamente!");
    }
 
 private void agregarDatosTxt(){
        int seleccion;
        seleccion = fa.tblAdministrador.getSelectedRow();
        gvo.setId_empleado((int)fa.tblAdministrador.getValueAt(seleccion, 0));
        fa.txtNombreUsuario.setText(String.valueOf(fa.tblAdministrador.getValueAt(seleccion, 1)));
        fa.txtApellidoUsuario.setText(String.valueOf(fa.tblAdministrador.getValueAt(seleccion, 2)));
        fa.txtEdadUsuario.setText(String.valueOf(fa.tblAdministrador.getValueAt(seleccion, 3)));
        fa.txtUser.setText(String.valueOf(fa.tblAdministrador.getValueAt(seleccion, 4)));
        fa.txtPassword.setText(String.valueOf(fa.tblAdministrador.getValueAt(seleccion, 5)));
        fa.cmbTipoUsuario.setSelectedIndex((int)fa.tblAdministrador.getValueAt(seleccion, 6));
        fa.cmbEstadoUsuario.setSelectedIndex((int)fa.tblAdministrador.getValueAt(seleccion, 7));
    }
 
 private void modificarDatos(){
        
        gvo.getId_empleado();
        gvo.setNombre_empleado(fa.txtNombreUsuario.getText());
        gvo.setApellido_empleado(fa.txtApellidoUsuario.getText());
        gvo.setEdad_empleado(Integer.parseInt(fa.txtEdadUsuario.getText()));
        gvo.setUser_empleado(fa.txtUser.getText());
        gvo.setPassword_empleado(fa.txtPassword.getText());
        gvo.setId_tipo_empleado(fa.cmbTipoUsuario.getSelectedIndex());
        gvo.setId_estado(fa.cmbEstadoUsuario.getSelectedIndex());
        
        gdao.modificar(gvo);
        fa.optMensajeModificar.showMessageDialog(null, "¡Registro modificado correctamente!");
    }
 
 public void limpiarTxt(){
        fa.txtNombreUsuario.setText("");
        fa.txtApellidoUsuario.setText("");
        fa.txtEdadUsuario.setText("");
        fa.txtUser.setText("");
        fa.txtPassword.setText("");
        fa.cmbTipoUsuario.setSelectedIndex(0);
        fa.cmbEstadoUsuario.setSelectedIndex(0);
        
    }
 
 
    @Override
    public void actionPerformed(ActionEvent ae) {
        if ((ae.getSource() == fa.btnIngresar)){                
            
            this.insertarUsuario();
            this.mostrarDatos();
            this.limpiarTxt();
        
        }if (ae.getSource() == fa.btnBorrar) {
            
            this.eliminarDatos();
            this.mostrarDatos();
            this.limpiarTxt();
        }
        
        if (ae.getSource() == fa.btnModificar) {
            
            this.modificarDatos();
            this.mostrarDatos();
            this.limpiarTxt();
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
        this.mostrarDatos();
    }

    @Override
    public void windowClosing(WindowEvent we) {
        
    }

    @Override
    public void windowClosed(WindowEvent we) {
        
    }

    @Override
    public void windowIconified(WindowEvent we) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
       
    }

    @Override
    public void windowActivated(WindowEvent we) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        this.agregarDatosTxt();
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
    

   
    

