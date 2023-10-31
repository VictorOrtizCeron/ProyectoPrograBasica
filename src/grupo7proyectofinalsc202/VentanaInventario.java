/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7proyectofinalsc202;

import javax.swing.JOptionPane;

public class VentanaInventario {

    private String inventario;
    private String Categorias;
    private String Marcas;

    public void start() {
        int opcionInventario = 0;
        boolean repetirMenuInventario = true;
        while (repetirMenuInventario) {
            String menuInventario = "Haz seleccionado Ver inventario\n\n"
                    + "1.filtrar por categoria.\n"
                    + "2.Mostrar inventario.\n"
                    + "3.Regresar.\n";

            opcionInventario = Integer.parseInt(JOptionPane.showInputDialog(menuInventario));
            switch (opcionInventario) { //Sub menu de registro
                case 1: // FiltrarPorCartegoria.

                    break;

                case 2: // MostrarInventario.

                    break;

                case 3: //• Regresar.

                    repetirMenuInventario = false;
                    JOptionPane.showMessageDialog(null, "Volviendo al menu principal...");
                    break;

                default: //Opcion invalida 
                    JOptionPane.showMessageDialog(null, "Ups! opcion invalida, intentalo de nuevo.");
                    break;

            }
        }
    }

    public String getInventario() {
        return inventario;
    }

    public void setInventario(String inventario) {
        this.inventario = inventario;
    }

    public String getCategorias() {
        return Categorias;
    }

    public void setCategorias(String Categorias) {
        this.Categorias = Categorias;
    }

    public String getMarcas() {
        return Marcas;
    }

    public void setMarcas(String Marcas) {
        this.Marcas = Marcas;
    }
    

}
