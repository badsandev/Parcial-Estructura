package Vista.Areas;

import Modelo.*;
import javax.swing.*;

public class AreaSolicitudes {
    Estudiante estudianteActual;

    public AreaSolicitudes(Estudiante estudianteActual) {
        this.estudianteActual = estudianteActual;
    }

    public void mostrarSolicitudes(JTextArea area) {
        if (estudianteActual != null && estudianteActual.listaSolicitudes != null) {
            NodoSolicitud nodoSolicitud = estudianteActual.listaSolicitudes.primera;
            area.setText("");

            if (nodoSolicitud != null) {
                area.append("Solicitudes pendientes:\n");
                while (nodoSolicitud != null) {
                    if (!nodoSolicitud.estudiante.nombre.equals(estudianteActual.nombre)) {
                        area.append("Solicitud pendiente de: " + nodoSolicitud.estudiante.nombre + "\n");
                    }
                    nodoSolicitud = nodoSolicitud.siguiente;
                }
            } else {
                area.append("No tienes solicitudes pendientes.\n");
            }
        } else {
            area.setText("No tienes solicitudes pendientes.\n");
        }
    }
}
