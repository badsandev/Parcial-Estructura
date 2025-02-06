package Vista.Areas;

import Modelo.*;
import javax.swing.*;

public class AreaEstudiantes {
    RedSocial redSocial;
    Estudiante estudianteActual;

    public AreaEstudiantes(RedSocial redSocial, Estudiante estudianteActual) {
        this.redSocial = redSocial;
        this.estudianteActual = estudianteActual;
    }

    public void mostrarEstudiantes(JTextArea area) {
        NodoEstudiante nodoEstudiante = redSocial.listaEstudiantes.primero;
        area.setText("");
        area.append("Estudiantes activos:\n");
        while (nodoEstudiante != null) {
            if (!nodoEstudiante.estudiante.nombre.equals(estudianteActual.nombre)) {
                area.append(nodoEstudiante.estudiante.nombre + "\n");
            }
            nodoEstudiante = nodoEstudiante.siguiente;
        }
    }
}
