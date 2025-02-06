package Modelo;

public class ListaAmigos {
    public NodoEstudiante primero;
    public NodoEstudiante ultimo;

    public ListaAmigos() {
        this.primero = null;
        this.ultimo = null;
    }

    public void agregarAmistad(Estudiante estudiante) {
        if (validarAmistad(estudiante.nombre)) return;

        NodoEstudiante nuevoAmigo = new NodoEstudiante(estudiante);
        if (primero == null) {
            primero = nuevoAmigo;
            ultimo = nuevoAmigo;
        } else {
            ultimo.siguiente = nuevoAmigo;
            ultimo = nuevoAmigo;
        }
    }

    public boolean validarAmistad(String nombre) {
        NodoEstudiante actual = primero;
        while (actual != null) {
            if (actual.estudiante.nombre.equals(nombre)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
}
