package grupo7proyectofinalsc202;

import javax.swing.JOptionPane;

public class VentanaVenta {

    private Producto[] inventario;
    private String[] categorias;
    private String[] marcas;
    private Venta venta;

    public VentanaVenta() {
        venta = new Venta();
    }

    public void start() {

        boolean validarNombre = false;

        //valida que el nombre no este vacio
        while (!validarNombre) {
            String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
            validarNombre = venta.setClienteNombre(nombreCliente);
            if (!validarNombre) {
                JOptionPane.showMessageDialog(null, "ingrese un nombre no vacío");
            }
        }

        boolean repetirMenuVenta = true;
        while (repetirMenuVenta) {
            if (inventario.length == 0) {

                JOptionPane.showMessageDialog(null, "No hay productos registrados");
                repetirMenuVenta = false;

            } else {
                int opcion = 0;
                String menu = "─────── ⋆⋅⋆  ───────Menu Venta─────── ⋆⋅⋆  ───────\n\n"
                        + "Productos Disponibles:\n"
                        + "1. Escoger producto específico.\n"
                        + "2. Filtrar productos por Marca Y Categoría.\n"
                        + "3. Finalizar compra.\n"//imprimir factura
                        + "4. Regresar.\n";

                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu));

                switch (opcion) {
                    case 1:
                        String subMenuEleccionProducto = concatenarProductos(this.inventario) + "\n"
                                + (this.inventario.length + 1) + ". Regresar";//concatenación de todos los productos disponibles

                        int opcionSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(subMenuEleccionProducto));

                        if (opcionSeleccionada <= this.inventario.length && opcionSeleccionada > 0) {

                            Producto productoSeleccionado = new Producto(
                                    this.inventario[opcionSeleccionada - 1].getPrecio(),
                                    this.inventario[opcionSeleccionada - 1].getNombre(),
                                    this.inventario[opcionSeleccionada - 1].getCategoria(),
                                    this.inventario[opcionSeleccionada - 1].getMarca()
                            );

                            boolean validarCantidad = false;
                            int cantidad = 0;

                            //validar cantidad
                            while (!validarCantidad) {
                                cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del producto seleccionado a comprar"));
                                validarCantidad = productoSeleccionado.setCantidad(cantidad);
                                if (!validarCantidad) {
                                    JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida");
                                }
                            }
                            //se agrega producto a venta

                            venta.agregar(productoSeleccionado, cantidad);

                            JOptionPane.showMessageDialog(null, "Productos agregado a la venta");

                        } else if (opcionSeleccionada == this.inventario.length + 1) {
                            //no hace nada, solo regresa 
                        } else {
                            JOptionPane.showMessageDialog(null, "Opcion no es valida. Intentalo de nuevo \n\n                            ˙◠˙    \n\n");

                        }
                        break;

                    case 2:
                        //filtrar lista de productos 
                        //string del menu de categorias disponibles
                        String subMenuCategorias
                                = "─────── ⋆ ───────Categorias disponibles─────── ⋆ ───────\n"
                                + concatenarArregloString(this.categorias) + "\n"
                                + (this.categorias.length + 1) + ". Regresar"
                                + "\nSeleccione una categoría\n";

                        //selección de categoría
                        int categoriaSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(subMenuCategorias));

                        if (categoriaSeleccionada < categorias.length + 1 && categoriaSeleccionada > 0) {

                            //arreglo de productos filtrados por categoria
                            Producto[] filtradoCategoria = filtradoCategoria(this.categorias[categoriaSeleccionada - 1], this.inventario);

                            //lista de productos filtrados desplegada
                            String menuFiltradoPorCategoria = "─────── ⋆ ─────── Resultados de filtrado por Categoría ─────── ⋆ ───────\n\n"
                                    + concatenarInventario(filtradoCategoria) + "\n"
                                    + "1. Filtrar por marca.\n"
                                    + "2. Regresar.\n";

                            int opcionSubMenuMarcas = Integer.parseInt(JOptionPane.showInputDialog(menuFiltradoPorCategoria));

                            switch (opcionSubMenuMarcas) {

                                case 1:

                                    String marcasConcatenacion = "─────── ⋆ ─────── Marcas registradas ─────── ⋆ ───────: \n"
                                            + concatenarArregloString(this.marcas) + "\n"
                                            + (this.marcas.length + 1) + ". Regresar\n"
                                            + "Seleccione una de las marcas disponibles\n";

                                    int marcaSeleccionada = Integer.parseInt(JOptionPane.showInputDialog(marcasConcatenacion));

                                    if (marcaSeleccionada < marcas.length + 1 && marcaSeleccionada > 0) {
                                        Producto[] filtradoMarca = filtradoMarca(this.marcas[marcaSeleccionada - 1], filtradoCategoria);

                                        String menuFiltradoFinal = "─────── ⋆ ─────── Resultados de filtrado por categoría y marca ─────── ⋆ ───────\n\n"
                                                + concatenarProductos(filtradoMarca) + "\n";

                                        int indiceProducto = Integer.parseInt(JOptionPane.showInputDialog(null, menuFiltradoFinal));
                                        if (indiceProducto <= filtradoMarca.length && indiceProducto > 0) {

                                            Producto productoSeleccionado = new Producto(
                                                    filtradoMarca[indiceProducto - 1].getPrecio(),
                                                    filtradoMarca[indiceProducto - 1].getNombre(),
                                                    filtradoMarca[indiceProducto - 1].getCategoria(),
                                                    filtradoMarca[indiceProducto - 1].getMarca()
                                            );

                                            boolean validarCantidad = false;
                                            int cantidad = 0;

                                            //valida cantidad
                                            while (!validarCantidad) {
                                                cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del producto seleccionado a comprar"));
                                                validarCantidad = productoSeleccionado.setCantidad(cantidad);
                                                if (!validarCantidad) {
                                                    JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida");
                                                }
                                            }
                                            //se agrega producto a venta
                                            venta.agregar(productoSeleccionado, cantidad);

                                            JOptionPane.showMessageDialog(null, "Productos agregado a la venta");

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Opcion no es valida. Intentalo de nuevo \n\n");
                                        }

                                    } else if (marcaSeleccionada == marcas.length + 1) {
                                        repetirMenuVenta = false;

                                    } else {
                                        JOptionPane.showMessageDialog(null, "Opcion no es valida. Intentalo de nuevo \n\n                            ˙◠˙    \n\n");
                                    }
                                    break;

                                case 2:
                                    JOptionPane.showMessageDialog(null, "Regresando...");
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opcion no es valida. Intentalo de nuevo \n\n                            ˙◠˙    \n\n");
                                    break;
                            }

                        } else if (categoriaSeleccionada == categorias.length + 1) {

                        } else {
                            JOptionPane.showMessageDialog(null, "Opcion no es valida. Intentalo de nuevo \n\n                            ˙◠˙    \n\n");
                        }
                        break;
                    case 3:
                        //finalizar venta
                        String factura = venta.getFactura() + "\n\n Escoja lo que desee hacer"
                                + "\n1. Confirmar y realizar venta"//se devuelven a menu principal
                                + "\n2. Cancelar venta"//se devuelven a menu principal
                                + "\n3. Agregar más productos";//se devuelve a submenu de registro de ventas

                        int opcionFactura = Integer.parseInt(JOptionPane.showInputDialog(factura));

                        switch (opcionFactura) {
                            case 1:
                                //opcion para finalizar venta

                                String subMenuConfirmacion = venta.getFactura() + "\n ¿Confirma la realización de la venta?"
                                        + "\n1. Si"
                                        + "\n2. No";

                                int confirmacion = Integer.parseInt(JOptionPane.showInputDialog(subMenuConfirmacion));

                                switch (confirmacion) {

                                    case 1:
                                        JOptionPane.showMessageDialog(null, "Venta registrada, volviendo a menú principal");
                                        repetirMenuVenta = false;
                                        break;
                                    case 2:
                                        JOptionPane.showMessageDialog(null, "Venta no registrada");
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Ingrese una opción válida");
                                        break;

                                }
                                break;
                            case 2:
                                //si no existe , se agrega
                                JOptionPane.showMessageDialog(null, "venta cancelada, regresando al menú principal");
                                repetirMenuVenta = false;

                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Regresando a sub menu de registro de ventas");

                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Ingrese una opción válida");
                                break;

                        }

                        break;
                    case 4:
                        repetirMenuVenta = false;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no es valida. Intentalo de nuevo \n\n                            ˙◠˙    \n\n");
                        break;
                }

            }

        }
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

    public Producto[] getInventario() {
        return inventario;
    }

    public void setInventario(Producto[] inventario) {
        this.inventario = inventario;
    }

    public String[] getCategorias() {
        return categorias;
    }

    public void setCategorias(String[] categorias) {
        this.categorias = categorias;
    }

    public String[] getMarcas() {
        return marcas;
    }

    public void setMarcas(String[] marcas) {
        this.marcas = marcas;
    }

    public String concatenarProductos(Producto[] productos) {
        String inventarioString = "";

        if (productos.length != 0) {
            for (int i = 0; i < productos.length; i++) {

                inventarioString = inventarioString
                        + "\n" + (i + 1) + ".Nombre:   "
                        + productos[i].getNombre()
                        + "\n   Categoría: "
                        + productos[i].getCategoria()
                        + "\n   Marca:     "
                        + productos[i].getMarca() + "\n";
            }
        } else {
            inventarioString = "vacío";
        }
        return inventarioString;
    }

}
