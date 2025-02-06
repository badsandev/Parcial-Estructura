package Modelo;

public class ListaEstudiantes {
    public NodoEstudiante primero = null;
    public NodoEstudiante ultimo = null;

    public void agregarEstudiante(Estudiante nuevo) {
        if (nuevo != null) {
            if (validarEstudiante(nuevo.nombre)) {
                return;
            }
            NodoEstudiante nuevoNodo = new NodoEstudiante(nuevo);
            if (primero == null) {
                primero = nuevoNodo;
                ultimo = nuevoNodo;
            } else {
                ultimo.siguiente = nuevoNodo;
                ultimo = nuevoNodo;
            }
        }
    }

    public boolean validarEstudiante(String nombre) {
        NodoEstudiante actual = primero;
        while (actual != null) {
            if (actual.estudiante.nombre.equals(nombre)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public Estudiante obtenerEstudiante(String nombre) {
        NodoEstudiante actual = primero;
        while (actual != null) {
            if (actual.estudiante.nombre.equals(nombre)) {
                return actual.estudiante;
            }
            actual = actual.siguiente;
        }
        return null;
    }
}
