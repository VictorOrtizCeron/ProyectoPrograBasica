/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7proyectofinalsc202;

import javax.swing.JOptionPane;

/**
 *
 * @author victo
 */
public class VentanaMenu {

    public void start() {

        int opcion = 0;

        boolean repetirMenu = true;

        //Menu principal 
        while (repetirMenu == true) {
            String menuPrincipal = "Bienvenid@ a supermercados Los Pollitos\n"
                    + "\n1-Registro."
                    + "\n2-Ver inventario."
                    + "\n3-Registrar una venta."
                    + "\n4-Salir.\n ";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal));
            switch (opcion) {
                case 1: //Menu de registro
                    VentanaRegistro ventanaRegistro = new VentanaRegistro();
                    ventanaRegistro.start();
                    break;

                
                case 2: //Ver Inventario 

                    VentanaInventario ventanaInventario = new VentanaInventario();
                    ventanaInventario.start();

                    break;

                

                case 3: //Registrar una venta 
                    VentanaVenta ventanaVenta = new VentanaVenta();
                    ventanaVenta.start();
                    break;

                case 4: //Salir del menu principal
                    repetirMenu = false;
                    JOptionPane.showMessageDialog(null, "Hasta luego, cerrando sistema.");
                    break;

                default: //Opcion invalida 
                    JOptionPane.showMessageDialog(null, "Lo siento, opcion invalida, intentalo de nuevo.");

            }
        }
    }
}
