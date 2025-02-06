package Vista.Areas;

import Modelo.*;
import javax.swing.*;

public class AreaAmigos {
    Estudiante estudianteActual;

    public AreaAmigos(Estudiante estudianteActual) {
        this.estudianteActual = estudianteActual;
    }

    public void mostrarAmigos(JTextArea area) {
        if (estudianteActual != null && estudianteActual.listaAmigos != null) {
            NodoEstudiante nodoAmigo = estudianteActual.listaAmigos.primero;
            area.setText("");

            if (nodoAmigo != null) {
                area.append("Tus amigos:\n");
                while (nodoAmigo != null) {
                    if (!nodoAmigo.estudiante.nombre.equals(estudianteActual.nombre)) {
                        area.append("Amigo: " + nodoAmigo.estudiante.nombre + "\n");
                    }
                    nodoAmigo = nodoAmigo.siguiente; 
                }
            } else {
                area.append("No tienes amigos.\n");
            }
        } else {
            area.setText("No se pudo cargar la lista de amigos.\n");
        }
    }
}
