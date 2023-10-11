package grupo7proyectofinalsc202;
import javax.swing.JOptionPane;
public class Grupo7ProyectoFinalSC202 {
    
    public static void main(String[] args) {
        // Definicion de variables.
        
        int opcion = 0;
        int opcionRegistro = 0;
        boolean repetirMenu = true;
        boolean repetirMenuRegistro = true;

        //Menu principal 
        while (repetirMenu == true) {
            String menuPrincipal = "Bienvenid@ a supermercados Los Pollitos\n\n1-Registro.\n2-Ver inventario.\n3-Registrar una venta.\n4-Salir.\n ";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal));
            switch (opcion) {
                case 1: //Menu de registro
                    while (repetirMenuRegistro) {
                        String menuRegistro = "Haz seleccionado registro\n\n1-Registrar nuevos productos.\n2-Registrar una marca.\n3-Registrar una categoria.\n4-Regresar\n";
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
                    break;

                case 2: //Ver Inventario 
                    break;

                case 3: //Registrar una venta 
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
