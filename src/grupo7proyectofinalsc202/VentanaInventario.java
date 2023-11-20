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
                    + "1.Filtrar .\n"
                    + "2.Regresar.\n";

            opcionInventario = Integer.parseInt(JOptionPane.showInputDialog(menuInventario));
            switch (opcionInventario) {
                case 1:
                    //Primero filtra por categoría
                    String subMenuCategorias
                            = "Categorias disponibles\n"
                            + concatenarArregloString(this.Categorias) + "\n"
                            + (this.Categorias.length + 1) + ". Regresar"
                            + "\nSeleccione una categoría\n";

                    int categoriaSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(subMenuCategorias));

                    if (categoriaSeleccionada < Categorias.length+1 && categoriaSeleccionada > 0) {

                        Producto[] filtradoCategoria = filtradoCategoria(this.Categorias[categoriaSeleccionada - 1], this.inventario);

                        String menuFiltradoPorCategoria = "Resultados de filtrado por Categoría\n\n"
                                + concatenarInventario(filtradoCategoria) + "\n"
                                + "1. Filtrar por marca.\n"
                                + "2. Regresar.\n";

                        int opcionSubMenu = Integer.parseInt(JOptionPane.showInputDialog(menuFiltradoPorCategoria));

                        switch (opcionSubMenu) {

                            case 1:
                                
                                String marcasConcatenacion = "Marcas registradas: \n"+
                                        concatenarArregloString(this.Marcas)+
                                        "\nSeleccione una de las marcas disponibles";
                                
                                
                                int marcaSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(marcasConcatenacion));
                                
                                if (marcaSeleccionada < Marcas.length+1 && marcaSeleccionada > 0) {
                                    Producto[] filtradoMarca = filtradoMarca(this.Marcas[marcaSeleccionada - 1], filtradoCategoria);

                                    String menuFiltradoFinal = "Resultados de filtrado por categoría y marca\n\n"
                                            + concatenarInventario(filtradoMarca) + "\n";
                                    
                                    JOptionPane.showMessageDialog(null,menuFiltradoFinal);
                                   
                                    
                                } else if (marcaSeleccionada == Marcas.length+1) {
                                     repetirMenuInventario = false;
                                    
                                } else {
                                    JOptionPane.showMessageDialog(null, "Ingrese una opción válida");
                                }
                                break;
                            
                            case 2:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null,"Opción inválida");
                                break;
                        }
                       
                    } else if (categoriaSeleccionada == Categorias.length + 1) {

                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese una opción válida");
                    }

                    break;

                case 2: // Regresar.
                    repetirMenuInventario = false;
                    JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                    break;

                default: // Opcion invalida.
                    JOptionPane.showMessageDialog(null, " Opción inválida, inténtalo de nuevo.");
                    break;
            }
        }
    }

    public Producto[] filtradoCategoria(String filtro, Producto[] listaProductos) {
        Producto[] inventarioFiltrado = new Producto[0];

        for (int i = 0; i < listaProductos.length; i++) {
            if (listaProductos[i].getCategoria().equals(filtro)) {
                inventarioFiltrado = agregarElemento(listaProductos[i], inventarioFiltrado);
            }
        }
        return inventarioFiltrado;
    }

    public Producto[] filtradoMarca(String filtro, Producto[] listaProductos) {
        Producto[] inventarioFiltrado = new Producto[0];

        for (int i = 0; i < listaProductos.length; i++) {
            if (listaProductos[i].getMarca().equals(filtro)) {
                inventarioFiltrado = agregarElemento(listaProductos[i], inventarioFiltrado);
            }
        }
        return inventarioFiltrado;
    }

    public Producto[] agregarElemento(Producto productoAgregar, Producto[] productosOriginal) {

        int limite = productosOriginal.length;
        Producto[] productosNuevo = new Producto[limite + 1];

        for (int i = 0; i < limite; i++) {
            productosNuevo[i] = productosOriginal[i];

        }

        productosNuevo[limite] = productoAgregar;
        return productosNuevo;
    }

    public String concatenarInventario(Producto[] productos) {
        String inventarioString = "";

        if (productos.length != 0) {
            for (int i = 0; i < productos.length; i++) {

                inventarioString = inventarioString
                        + "\n Nombre:   "
                        + productos[i].getNombre()
                        + "\nCategoría: "
                        + productos[i].getCategoria()
                        + "\nMarca:     "
                        + productos[i].getMarca() + "\n";
            }
        } else {
            inventarioString = "vacío";
        }
        return inventarioString;
    }

    public String concatenarArregloString(String[] arreglo) {
        String arregloString = "";

        if (arreglo.length != 0) {
            for (int i = 0; i < arreglo.length; i++) {

                arregloString = arregloString + "\n " + (i + 1) + ". " + arreglo[i];
            }
        } else {
            arregloString = "vacío";
        }
        return arregloString;
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
