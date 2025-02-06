package Modelo;

import javax.swing.*;

public class RedSocial {
    public ListaEstudiantes listaEstudiantes = new ListaEstudiantes();

    public boolean registrarEstudiante(Estudiante nuevo) {
        if (listaEstudiantes.validarEstudiante(nuevo.nombre)) {
            JOptionPane.showMessageDialog(null, "El estudiante ya está registrado.");
            return false;
        } else {
            nuevo.listaSolicitudes = new ListaSolicitudes();
            nuevo.listaAmigos = new ListaAmigos();
            listaEstudiantes.agregarEstudiante(nuevo);
            return true;
        }
    }
    
    public boolean iniciarSesion(String nombre, String contraseña) {
        if (nombre.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return false;
        }

        Estudiante encontrado = listaEstudiantes.obtenerEstudiante(nombre);
        if (encontrado == null) {
            JOptionPane.showMessageDialog(null, "El estudiante no está registrado.");
            return false;
        }
        if (encontrado.clave.equals(contraseña)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Contraseña incorrecta.");
            return false;
        }
    }

    public void enviarSolicitudAmistad(String nombreEmisor, String nombreReceptor) {
        if (nombreEmisor.isEmpty() || nombreReceptor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return;
        }

        Estudiante emisor = listaEstudiantes.obtenerEstudiante(nombreEmisor);
        Estudiante receptor = listaEstudiantes.obtenerEstudiante(nombreReceptor);

        if (emisor == null || receptor == null) {
            JOptionPane.showMessageDialog(null, "El estudiante no está registrado.");
            return;
        }

        if (emisor.nombre.equals(receptor.nombre)) {
            JOptionPane.showMessageDialog(null, "No puedes enviarte una solicitud a ti mismo.");
            return;
        }

        if (emisor.listaAmigos.validarAmistad(nombreReceptor)) {
            JOptionPane.showMessageDialog(null, "Ya son amigos.");
            return;
        }

        if (receptor.listaSolicitudes.validarSolicitud(nombreEmisor)) {
            JOptionPane.showMessageDialog(null, "Ya existe una solicitud pendiente de este estudiante.");
            return;
        }

        if (emisor.listaSolicitudes.validarSolicitud(nombreReceptor)) {
            JOptionPane.showMessageDialog(null, "No puedes enviar una solicitud porque ya tienes una solicitud pendiente de este estudiante.");
            return;
        }

        receptor.listaSolicitudes.agregarSolicitud(emisor);
        JOptionPane.showMessageDialog(null, "Solicitud enviada exitosamente.");
    }

    
    public void aceptarSolicitud(String nombreEmisor, String nombreReceptor) {
        if (nombreEmisor.isEmpty() || nombreReceptor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return;
        }

        Estudiante emisor = listaEstudiantes.obtenerEstudiante(nombreEmisor);
        Estudiante receptor = listaEstudiantes.obtenerEstudiante(nombreReceptor);

        if (emisor == null || receptor == null) {
            JOptionPane.showMessageDialog(null, "El estudiante no está registrado.");
            return;
        }

        if (!receptor.listaSolicitudes.validarSolicitud(nombreEmisor)) {
            JOptionPane.showMessageDialog(null, "No tienes una solicitud de este estudiante.");
            return;
        }

        if (receptor.listaAmigos.validarAmistad(nombreEmisor)) {
            JOptionPane.showMessageDialog(null, "Ya son amigos.");
            return;
        }

        receptor.listaAmigos.agregarAmistad(emisor);
        emisor.listaAmigos.agregarAmistad(receptor);

        receptor.listaSolicitudes.eliminarSolicitudAceptada(nombreEmisor);

        JOptionPane.showMessageDialog(null, "Solicitud aceptada.");
    }
}
