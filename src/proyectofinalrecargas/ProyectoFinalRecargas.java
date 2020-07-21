/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinalrecargas;

import controlador.ControladorAdministrador;
import controlador.ControladorLogin;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAdministrador;
import vista.FrmGeneral;
import vista.FrmLogin;

/**
 *
 * @author Chezter
 */
public class ProyectoFinalRecargas {

    public static void main(String[] args) {
        // TODO code application logic here
        FrmLogin fl = new FrmLogin();
        FrmAdministrador fad = new FrmAdministrador();
        FrmGeneral fgen = new FrmGeneral();

        UsuarioVO uvo = new UsuarioVO();
        UsuarioDAO udao = new UsuarioDAO();

        ControladorLogin cl = new ControladorLogin(fl, fad, uvo, udao);
        ControladorAdministrador ca = new ControladorAdministrador(fad, uvo, udao);

        fl.setVisible(true);
        fl.setLocationRelativeTo(null);

    }

}
