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
                    + concatenarInventario(this.inventario) + "\n"
                    + "1.Filtrar por categoría.\n"
                    + "2.Filtrar por marca.\n"
                    + "3.Regresar.\n";

            opcionInventario = Integer.parseInt(JOptionPane.showInputDialog(menuInventario));
            switch (opcionInventario) {
                case 1: // Filtrar por categoría.
                    String listaCategorias = "";

                    for (int i = 0; i < this.Categorias.length; i++) {
                        listaCategorias += (i + 1) + ". " + Categorias[i] + "\n";
                    }
                    listaCategorias += (Categorias.length + 1) + ". Regresar";
                    int categoriaSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(null, "Categorías disponibles:\n" + listaCategorias + "\n" + "Seleccione una categoría"));

                    if (categoriaSeleccionada == Categorias.length + 1) {
                        //no hace nada
                    } else {
                        String nombreCategoriaSeleccionada = this.Categorias[categoriaSeleccionada - 1];

                        String inventarioFiltradoCategoria = "";

                        for (int i = 0; i < inventario.length; i++) {
                            int j = 1;
                            if (nombreCategoriaSeleccionada.equals(inventario[i].getCategoria())) {
                                inventarioFiltradoCategoria += +j + ". " + inventario[i].getNombre() + "\n";
                                j++;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Productos filtrados por categoría: "
                                + nombreCategoriaSeleccionada + "\n"
                                + inventarioFiltradoCategoria
                        );

                    }
                    break;

                case 2: // Filtrar por marca.
                    String listaMarcas = "";

                    for (int i = 0; i < this.Marcas.length; i++) {
                        listaMarcas += (i + 1) + ". " + Marcas[i] + "\n";
                    }
                    listaMarcas += (Marcas.length + 1) + ". Regresar";
                    int marcaSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(null, "Marcas disponibles:\n" + listaMarcas + "\n" + "Seleccione una marca"));

                    if (marcaSeleccionada == Marcas.length + 1) {
                        //no hace nada
                    } else {
                        String nombreMarcaSeleccionada = this.Marcas[marcaSeleccionada - 1];

                        String inventarioFiltradoMarca = "";

                        for (int i = 0; i < inventario.length; i++) {
                            int j = 1;
                            if (nombreMarcaSeleccionada.equals(inventario[i].getMarca())) {
                                inventarioFiltradoMarca += +j + ". " + inventario[i].getNombre() + "\n";
                                j++;
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Productos filtrados por marca: "
                                + nombreMarcaSeleccionada + "\n"
                                + inventarioFiltradoMarca
                        );
                        repetirMenuInventario = false;

                    }

                    break;

                case 3: // Regresar.
                    repetirMenuInventario = false;
                    JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                    break;

                default: // Opcion invalida.
                    JOptionPane.showMessageDialog(null, " Opción inválida, inténtalo de nuevo.");
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
