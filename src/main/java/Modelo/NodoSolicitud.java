package Modelo;

public class NodoSolicitud {
    public Estudiante estudiante;
    public NodoSolicitud siguiente;

    public NodoSolicitud(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.siguiente = null;
    }
}
