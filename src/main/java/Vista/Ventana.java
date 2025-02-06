package Vista;

import javax.swing.*;
import java.awt.event.*;
import Modelo.*;
import Vista.Eventos.*;
import Vista.Areas.*;
import java.awt.*;

public class Ventana {

    JButton botonIngresar, botonRegistrar, botonEnviar, botonRecibir, volverARegistrar;
    public JTextField campoNombre, campoEnvia, campoRecibe;
    public JPasswordField campoClave;
    public JTextArea areaEstudiantes, areaSolicitudes, areaAmigos, areaMensaje;
    public JFrame frame1, frame2;
    public RedSocial redSocial = new RedSocial();
    public Estudiante estudianteActual;
    

    public void iniciarVentana() {
        frame1 = new JFrame("Red Social");
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(250, 235, 215)); 
        frame1.setSize(430, 430);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1.add(new JLabel("Nombre"));
        campoNombre = new JTextField(10);
        panel1.add(campoNombre);
        panel1.add(new JLabel("Clave: "));
        campoClave = new JPasswordField(10);
        panel1.add(campoClave);

        botonIngresar = new JButton("Ingresar");
        botonRegistrar = new JButton("Registrar estudiante");
        panel1.add(botonIngresar);
        panel1.add(botonRegistrar);

        areaMensaje = new JTextArea(20, 30);
        areaMensaje.setEditable(false);
        panel1.add(areaMensaje);

        frame1.add(panel1);
        frame1.setVisible(true);

        botonRegistrar.addActionListener(new EventoRegistrar(campoNombre, campoClave, redSocial, areaMensaje));

        botonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = campoNombre.getText();
                String clave = campoClave.getText();
                boolean estado = redSocial.iniciarSesion(nombreUsuario, clave);

                if (estado) {
                    estudianteActual = redSocial.listaEstudiantes.obtenerEstudiante(nombreUsuario);
                    frame1.setVisible(false);
                    campoClave.setText("");
                    campoNombre.setText("");
                    mostrarPanelCuenta();
                }
            }
        });
    }

    public void mostrarPanelCuenta() {
        frame2 = new JFrame("Estudiante " + estudianteActual.nombre);
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(250, 235, 215));
        frame2.setLocation(520, 150);

        panel2.add(new JLabel("Lista de amigos"));  
        areaAmigos = new JTextArea(5, 20);
        areaAmigos.setEditable(false);
        AreaAmigos mostrarAmigos = new AreaAmigos(estudianteActual);
        mostrarAmigos.mostrarAmigos(areaAmigos);
        panel2.add(new JScrollPane(areaAmigos));

        panel2.add(new JLabel("Enviar solicitud a: "));
        campoEnvia = new JTextField(10);
        panel2.add(campoEnvia);
        botonEnviar = new JButton("Enviar solicitud");
        panel2.add(botonEnviar);

        AreaEstudiantes mostrarEstudiantes = new AreaEstudiantes(redSocial, estudianteActual);
        areaEstudiantes = new JTextArea(5, 20);
        areaEstudiantes.setEditable(false);
        mostrarEstudiantes.mostrarEstudiantes(areaEstudiantes);
        panel2.add(new JScrollPane(areaEstudiantes));

        panel2.add(new JLabel("Aceptar solicitud de: "));
        campoRecibe = new JTextField(10);
        panel2.add(campoRecibe);
        botonRecibir = new JButton("Aceptar solicitud");
        panel2.add(botonRecibir);

        AreaSolicitudes mostrarSolicitudes = new AreaSolicitudes(estudianteActual);
        areaSolicitudes = new JTextArea(5, 20);
        areaSolicitudes.setEditable(false);
        mostrarSolicitudes.mostrarSolicitudes(areaSolicitudes);
        panel2.add(new JLabel("Solicitudes: "));
        panel2.add(new JScrollPane(areaSolicitudes));

        volverARegistrar = new JButton("Salir");
        panel2.add(volverARegistrar);

        botonEnviar.addActionListener(new EventoEnviarSolicitud(campoEnvia, areaEstudiantes, redSocial, estudianteActual, mostrarEstudiantes));
        
        botonRecibir.addActionListener(new EventoAceptarSolicitud("Aceptar solicitud", campoRecibe, redSocial, estudianteActual, areaSolicitudes, areaAmigos, mostrarSolicitudes, mostrarAmigos));

        volverARegistrar.addActionListener(new EventoVolverRegistrar(frame2, frame1));

        frame2.add(panel2);
        frame2.setSize(310, 545);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
    }

    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.iniciarVentana();
    }
}