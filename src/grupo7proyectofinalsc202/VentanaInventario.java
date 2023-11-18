/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7proyectofinalsc202;
 
import javax.swing.JOptionPane;

public class VentanaInventario {
    

    private Producto[] inventario;//Van a ser arreglos
    private String[] Categorias;
    private String[] Marcas;

    public void start() {
        int opcionInventario = 0;

       
        
        
        boolean repetirMenuInventario = true;
        while (repetirMenuInventario) {
            String menuInventario = "Haz seleccionado Ver inventario\n\n"
                    + concatenarInventario(this.inventario)+"\n"
                    + "1.Filtrar por categoría.\n"
                    + "2.Regresar.\n";

            opcionInventario = Integer.parseInt(JOptionPane.showInputDialog(menuInventario));
            switch (opcionInventario) { //Sub menu de registro
                case 1: // Filtrar.

                    String input = JOptionPane.showInputDialog(null, "Escoja una marca");
                    break;

                case 2: //• Regresar.

                    repetirMenuInventario = false;
                    JOptionPane.showMessageDialog(null, "Volviendo al menu principal...");
                    break;

                default: //Opcion invalida 
                    JOptionPane.showMessageDialog(null, "Ups! opcion invalida, intentalo de nuevo.");
                    break;

            }
        }
    }

    public String concatenarInventario(Producto[] inventario) {
        String inventarioString = "";

        if (inventario.length != 0) {
            for (int i = 0; i < inventario.length; i++) {

                inventarioString = inventarioString + "\n " + inventario[i].getNombre();
            }
        } else {
            inventarioString = "Inventario vacío";
        }
        return inventarioString;
    }

    public Producto[] getInventario() {
        return inventario;
    }

    public void setInventario(Producto[] inventario) {
        this.inventario = inventario;
    }

    public String[] getCategorias() {
        return Categorias;
    }

    public void setCategorias(String[] Categorias) {
        this.Categorias = Categorias;
    }

    public String[] getMarcas() {
        return Marcas;
    }

    public void setMarcas(String[] Marcas) {
        this.Marcas = Marcas;
    }

}
