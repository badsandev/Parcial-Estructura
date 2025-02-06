package Modelo;

public class NodoEstudiante {
    public Estudiante estudiante;
    public NodoEstudiante siguiente;

    public NodoEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.siguiente = null;
    }
}
