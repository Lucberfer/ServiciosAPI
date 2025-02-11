/*
package org.example;


import org.apache.commons.net.telnet.TelnetClient;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TelnetClientExample {
    private static final String HOST = "192.168.56.1";  // Dirección IP del servidor Telnet
    private static final int PORT = 23;                 // Puerto Telnet (23 por defecto)
    private static final String USER = "usuario";       // Usuario de Telnet
    private static final String PASSWORD = "contraseña"; // Contraseña de Telnet

    public static void main(String[] args) {
        TelnetClient telnet = new TelnetClient();

        try {
            System.out.println("Conectando a " + HOST + ":" + PORT + "...");
            telnet.connect(HOST, PORT);

            InputStream in = telnet.getInputStream();
            OutputStream out = telnet.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            Scanner reader = new Scanner(in);

            // Autenticación (ajustar según el sistema Telnet)
            if (reader.hasNextLine()) {
                String response = reader.nextLine();
                System.out.println("Servidor: " + response);
                if (response.toLowerCase().contains("login:")) {
                    writer.println(USER);
                }
            }

            if (reader.hasNextLine()) {
                String response = reader.nextLine();
                System.out.println("Servidor: " + response);
                if (response.toLowerCase().contains("password:")) {
                    writer.println(PASSWORD);
                }
            }

            // Esperar el prompt del sistema
            Thread.sleep(1000);
            while (reader.hasNextLine()) {
                String response = reader.nextLine();
                System.out.println(response);
                if (response.contains(">") || response.contains("#") || response.contains("$")) {
                    break;  // Prompt detectado
                }
            }

            System.out.println(" Conexión Telnet exitosa");

            // Enviar un comando y leer la respuesta
            writer.println("ls");
            TimeUnit.SECONDS.sleep(1);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }

            // Cerrar sesión
            writer.println("exit");
            telnet.disconnect();
            System.out.println("Conexión Telnet cerrada.");

        } catch (Exception e) {
            System.err.println("Error en la conexión Telnet: " + e.getMessage());
        }
    }
}
*/