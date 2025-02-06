package Vista.Eventos;


import Modelo.*;

import Vista.Ventana;
import javax.swing.*;
import java.awt.event.*;

public class EventoIngresar implements ActionListener {
    String nombreUsuario;
    JTextField campoNombre, campoClave;
    RedSocial redSocial;
    Estudiante estudianteActual;
    JFrame frame1;
    Ventana ventana; 

    public EventoIngresar(String nombreUsuario, JTextField campoNombre, JTextField campoClave, RedSocial redSocial,
                          Estudiante estudianteActual, JFrame frame1, Ventana ventana) {
        this.nombreUsuario = nombreUsuario;
        this.campoNombre = campoNombre;
        this.campoClave = campoClave;
        this.redSocial = redSocial;
        this.estudianteActual = estudianteActual;
        this.frame1 = frame1;
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombreUsuario = campoNombre.getText();
        String clave = campoClave.getText();
        boolean estado = redSocial.iniciarSesion(nombreUsuario, clave);

        if (estado) {
            estudianteActual = redSocial.listaEstudiantes.obtenerEstudiante(nombreUsuario);
            frame1.setVisible(false);
            ventana.mostrarPanelCuenta();
        }
    }
}