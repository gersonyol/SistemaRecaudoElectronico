/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;
import vista.FrmGeneral;
import vista.FrmLogin;

/**
 *
 * @author Chezter
 */
public class ControladorLogin implements ActionListener, WindowListener {

    FrmLogin flog = new FrmLogin();
    FrmAdministrador fadmin = new FrmAdministrador();
    FrmGeneral fgene = new FrmGeneral();
    UsuarioVO gvo = new UsuarioVO();
    UsuarioDAO gdao = new UsuarioDAO();

    public ControladorLogin(FrmLogin flog, FrmAdministrador fadmin, UsuarioVO gvo, UsuarioDAO gdao) {
        this.flog = flog;
        this.fadmin = fadmin;
        this.fgene = fgene;

        this.flog.btnAceptar.addActionListener(this);
        this.flog.btnCancelar.addActionListener(this);
    }

    public void Login() {

        this.gvo.setLoginEmpleado(flog.txtUser.getText());
        this.gvo.setLoginPassword(String.valueOf(flog.txtPassword.getPassword()));
        gdao.consultarEmpleadoPass(gvo);
        gdao.consultarTipoEstado(gvo);

        if ((this.flog.txtUser.getText().isEmpty())
                || (String.valueOf(this.flog.txtPassword.getPassword()).isEmpty())) {

            flog.optErrorLogin.showMessageDialog(null, "¡Ingrese usuario y password!");

        } else if (gvo.getLoginEmpleado().equals(gvo.getUser_empleado())
                && gvo.getLoginPassword().equals(gvo.getPassword_empleado())) {

            if (gvo.getId_estado() == 1) {
                switch (gvo.getId_tipo_empleado()) {
                    case 1:
                        flog.dispose();
                        fadmin.setVisible(true);
                        fadmin.setLocationRelativeTo(null);
                        break;
                    case 2:
                        flog.dispose();
                        fgene.setVisible(true);
                        fgene.setLocationRelativeTo(null);
                        break;
                }
                flog.optIngresoLogin.showMessageDialog(null, "Bienvenido");
            } else {
                flog.optUsuarioInactivo.showMessageDialog(null, "Usuario Inactivo, comuniquese con el administrador");
            }
        } else {
            flog.optErrorLogin.showMessageDialog(null, "Datos Incorrectos");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == flog.btnAceptar) {
            this.Login();
        }

        if (ae.getSource() == flog.btnCancelar) {
            this.flog.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent we) {

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

}
