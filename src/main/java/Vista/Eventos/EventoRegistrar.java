package Vista.Eventos;

import java.awt.event.*;
import javax.swing.*;
import Modelo.*;

public class EventoRegistrar implements ActionListener {
    private JTextField campoNombre, campoClave;
    private RedSocial redSocial;
    private JTextArea areaMensaje;

    // Constructor para inicializar los campos de la clase
    public EventoRegistrar(JTextField campoNombre, JTextField campoClave, RedSocial redSocial, JTextArea areaMensaje) {
        this.campoNombre = campoNombre;
        this.campoClave = campoClave;
        this.redSocial = redSocial;
        this.areaMensaje = areaMensaje;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = campoNombre.getText();
        String clave = campoClave.getText();
        
        if (!nombre.isEmpty() && !clave.isEmpty()) {
            Estudiante nuevoEstudiante = new Estudiante(nombre, clave);
            boolean registrado = redSocial.registrarEstudiante(nuevoEstudiante);
            
            if (registrado) {
                areaMensaje.setText("Estudiante "+nuevoEstudiante.nombre+" registrado exitosamente");
            } else {
                areaMensaje.setText("El estudiante ya está registrado");
            }
        } else {
            areaMensaje.setText("Por favor, complete todos los campos");
        }
    }
}
