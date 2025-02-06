package Modelo;

public class Estudiante {
    public String nombre;
    public String clave;
    public Estudiante sig;
    public ListaSolicitudes listaSolicitudes;
    public ListaAmigos listaAmigos;

    public Estudiante(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
        this.listaSolicitudes = new ListaSolicitudes();
        this.listaAmigos = new ListaAmigos();
    }
}
