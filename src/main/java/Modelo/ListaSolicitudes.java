package Modelo;

public class ListaSolicitudes {
    public NodoSolicitud primera;
    public NodoSolicitud ultima;

    public ListaSolicitudes() {
        this.primera = null;
        this.ultima = null;
    }

    public void agregarSolicitud(Estudiante solicitud) {
        if (validarSolicitud(solicitud.nombre)) {
            return;
        }
        NodoSolicitud nuevaSolicitud = new NodoSolicitud(solicitud);
        if (primera == null) {
            primera = nuevaSolicitud;
            ultima = nuevaSolicitud;
        } else {
            ultima.siguiente = nuevaSolicitud;
            ultima = nuevaSolicitud;
        }
    }

    public boolean validarSolicitud(String nombre) {
        NodoSolicitud actual = primera;
        while (actual != null) {
            if (actual.estudiante.nombre.equals(nombre)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public void eliminarSolicitudAceptada(String nombreEmisor) {
        NodoSolicitud actual = primera;
        NodoSolicitud anterior = null;

        while (actual != null) {
            if (actual.estudiante.nombre.equals(nombreEmisor)) {
                if (anterior == null) {
                    primera = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                if (actual == ultima) {
                    ultima = anterior;
                }
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
    }
}
