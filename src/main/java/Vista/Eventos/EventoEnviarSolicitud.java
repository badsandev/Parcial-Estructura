package Vista.Eventos;

import Modelo.*;
import Vista.Areas.AreaEstudiantes;
import javax.swing.*;
import java.awt.event.*;

public class EventoEnviarSolicitud implements ActionListener {
    JTextField campoEnvia;
    JTextArea areaEstudiantes;
    RedSocial redSocial;
    Estudiante estudianteActual;
    AreaEstudiantes mostrarEstudiantes;

    public EventoEnviarSolicitud(JTextField campoEnvia, JTextArea areaEstudiantes, RedSocial redSocial, Estudiante estudianteActual, AreaEstudiantes mostrarEstudiantes) {
        this.campoEnvia = campoEnvia;
        this.areaEstudiantes = areaEstudiantes;
        this.redSocial = redSocial;
        this.estudianteActual = estudianteActual;
        this.mostrarEstudiantes = mostrarEstudiantes;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String receptor = campoEnvia.getText();
        if (!receptor.isEmpty() && !receptor.equals(estudianteActual.nombre)) {
            redSocial.enviarSolicitudAmistad(estudianteActual.nombre, receptor);
            mostrarEstudiantes.mostrarEstudiantes(areaEstudiantes);
        }
        else {
            JOptionPane.showMessageDialog(null, "No puedes enviarte una solicitud a ti mismo.");
        }
    }
}
