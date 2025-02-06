package Vista.Eventos;

import javax.swing.*;
import java.awt.event.*;

public class EventoVolverRegistrar implements ActionListener {
    JFrame frameCuenta, frameLogin;

    public EventoVolverRegistrar(JFrame frameCuenta, JFrame frameLogin) {
        this.frameCuenta = frameCuenta;
        this.frameLogin = frameLogin;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frameCuenta.setVisible(false);
        frameLogin.setVisible(true); 
    }
}