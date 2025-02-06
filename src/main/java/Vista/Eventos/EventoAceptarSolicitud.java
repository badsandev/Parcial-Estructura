package Vista.Eventos;

import Modelo.*;
import javax.swing.*;
import java.awt.event.*;
import Vista.Areas.*;

public class EventoAceptarSolicitud implements ActionListener {
    String tipoAccion;  // Este es el parámetro adicional que falta
    JTextField campoRecibe;
    RedSocial redSocial;
    Estudiante estudianteActual;
    JTextArea areaSolicitudes;
    JTextArea areaAmigos;
    AreaSolicitudes mostrarSolicitudes;
    AreaAmigos mostrarAmigos;

    // Constructor modificado con el nuevo parámetro String
    public EventoAceptarSolicitud(String tipoAccion, JTextField campoRecibe, RedSocial redSocial, Estudiante estudianteActual, 
                                  JTextArea areaSolicitudes, JTextArea areaAmigos, AreaSolicitudes mostrarSolicitudes, AreaAmigos mostrarAmigos) {
        this.tipoAccion = tipoAccion;
        this.campoRecibe = campoRecibe;
        this.redSocial = redSocial;
        this.estudianteActual = estudianteActual;
        this.areaSolicitudes = areaSolicitudes;
        this.areaAmigos = areaAmigos;
        this.mostrarSolicitudes = mostrarSolicitudes;
        this.mostrarAmigos = mostrarAmigos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String emisor = campoRecibe.getText();
        if (!emisor.isEmpty()) {
            redSocial.aceptarSolicitud(emisor, estudianteActual.nombre);
            mostrarSolicitudes.mostrarSolicitudes(areaSolicitudes);
            mostrarAmigos.mostrarAmigos(areaAmigos);
        }        
    }
}
