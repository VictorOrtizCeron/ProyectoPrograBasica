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
public class VentanaRegistro {
    
    public void start(){
        int opcionRegistro = 0;
        boolean repetirMenuRegistro = true;
        while (repetirMenuRegistro) {
                        String menuRegistro = "Haz seleccionado registro\n\n"
                                + "1-Registrar nuevos productos.\n"
                                + "2-Registrar una marca.\n"
                                + "3-Registrar una categoria.\n"
                                + "4-Regresar\n";
                        opcionRegistro = Integer.parseInt(JOptionPane.showInputDialog(menuRegistro));
                        switch (opcionRegistro) { //Sub menu de registro
                            case 1: // Registrar nuevos productos.

                                break;

                            case 2: // Registrar una marca.

                                break;

                            case 3: //• Registrar una categoría.

                                break;

                            case 4: //Regresar
                                repetirMenuRegistro = false;
                                JOptionPane.showMessageDialog(null, "Volviendo al menu principal...");
                                break;

                            default: //Opcion invalida 
                                JOptionPane.showMessageDialog(null, "Ups! opcion invalida, intentalo de nuevo.");

                        }
                    }
    }
}
