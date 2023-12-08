package grupo7proyectofinalsc202;
import javax.swing.JOptionPane;
public class VentanaRegistro {

    //ATRIBUTOS
    private Producto[] Inventario = new Producto[0];
    private String[] Categorias = new String[0];
    private String[] Marcas = new String[0];
    private boolean existente = true;

    //MENU DE LA OPCION REGISTRO.
    public void start() {
        int opcionRegistro;
        int opcionRegistrarProductos;
        int opcionRegistrarMarca;
        int opcionRegistrarCategoria;
        boolean repetirMenuRegistro = true;
        while (repetirMenuRegistro) {
            String menuRegistro = "─────── ⋆⋅⋆  ───────Menu registro─────── ⋆⋅⋆  ───────\n\n"
                    + "1-Registrar nuevos productos.\n"
                    + "2-Registrar una marca.\n"
                    + "3-Registrar una categoria.\n"
                    + "4-Regresar\n";
            opcionRegistro = Integer.parseInt(JOptionPane.showInputDialog(menuRegistro));
            switch (opcionRegistro) { //Sub menu de registro

                case 1: // REGISTRAR NUEVOS PRODUCTOS
                    
                    boolean repetirMenuRegistroProductos = true;
                    while (repetirMenuRegistroProductos) { //Ciclo para confirmar si quiere registrar o no el producto. 
                        //Validar existencia de productos o marcas.
                        if (Categorias.length == 0 || Marcas.length == 0) { //Si no existen
                            JOptionPane.showMessageDialog(null, "No hay categorias o marcas registradas\n\n                            ˙◠˙    \n\n    Debes registrar ambas primero.");
                            repetirMenuRegistroProductos = false;

                        } else { //Si si existen entonces se procede con el registro del producto. 
                            String entradaNombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del producto.\n");
                            //Elegir la marca
                            String entradaMarca = "";
                            String mensajeMarcas
                                    = "─────── ⋆ ─────── Marcas disponibles ─────── ⋆ ───────\n"
                                    + concatenarArregloString(this.Marcas)
                                    + "\nSeleccione la marca del producto\n";
                            int seleccionMarca = Integer.parseInt(JOptionPane.showInputDialog(null, mensajeMarcas));
                            //Recorrer el arreglo para almacenar la marca seleccion en el registro del nuevo producto
                            if (seleccionMarca <= this.Marcas.length + 1 && seleccionMarca > 0) {
                                String marcaSeleccionada = this.Marcas[seleccionMarca - 1];
                                
                                //Escoger categoria
                                boolean validarCategoria = false;
                                String entradaCategoria = "";
                                String mensajeCategoria
                                        = "─────── ⋆ ─────── Categorias disponibles ─────── ⋆ ───────\n"
                                        + concatenarArregloString(this.Categorias)
                                        + "\nSeleccione la categoria del producto\n";
                                int seleccionCategoria = Integer.parseInt(JOptionPane.showInputDialog(null, mensajeCategoria));
                                //Recorrer el arreglo para almacenar la categoria seleccion en el registro del nuevo producto.
                                if (seleccionCategoria <= this.Categorias.length + 1 && seleccionCategoria > 0) {
                                    String categoriaSeleccionada = this.Categorias[seleccionCategoria - 1];

                                    
                                    
                                    //Digitar el precio
                                    float entradaPrecio = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el precio del producto.\n"));
                                    
                                    
                                    
                                    //SE CREA EL OBJETO PRODUCTO
                                    Producto nuevoProducto = new Producto(
                                            entradaPrecio,
                                            entradaNombre,
                                            categoriaSeleccionada,
                                            marcaSeleccionada);

                                    //CONFIRMACION DE CREACION
                                    String confirmarCreacionProducto = "¿Esta seguro de que desea registrar este producto?\n1- Si.\n2-No.\n\n";
                                    opcionRegistrarProductos = Integer.parseInt(JOptionPane.showInputDialog(null, confirmarCreacionProducto));
                                    switch (opcionRegistrarProductos) {
                                        case 1:
                                            JOptionPane.showMessageDialog(null, "¡Se ha registrado el producto con exito!");
                                            AgregarProducto(nuevoProducto);
                                            repetirMenuRegistroProductos = false;
                                            break; // break del case 1
                                        case 2:
                                            repetirMenuRegistroProductos = false;
                                            JOptionPane.showMessageDialog(null, "No se ha registrado el producto. Volviendo al menu principal...");
                                            break;// break del case 2

                                        default://Opcion invalida 
                                            JOptionPane.showMessageDialog(null, "¡Ups! opcion invalida, intentalo de nuevo.\n\n                            ˙◠˙    \n\n");
                                            break; // break del default
                                            
                                    } // llave del cierre del switch de confirmacion
                                } // esta es la llave de  if (seleccionMarca <=Categorias.length +1 && seleccionMarca > 0){
                            } // esta es la llave de  ifif (seleccionCategoria < this.Categorias.length +1 &&seleccionCategoria >0 ){
                        } //llave del else 
                    } //llave del while
                    
                    break; // break del case 1

                case 2: // REGISTRAR UNA MARCA
                    String nombreMarca = JOptionPane.showInputDialog(null, "Ingrese una nueva marca.\n");
                    String confirmarCreacionMarca = "Esta seguro de que desea registrar esta marca?\n1- Si.\n2-No.\n\n";
                    opcionRegistrarMarca = Integer.parseInt(JOptionPane.showInputDialog(null, confirmarCreacionMarca));
                    switch (opcionRegistrarMarca) {
                        case 1:
                            boolean resultadoMarcaAgregar = RegistrarMarca(nombreMarca);
                            if (resultadoMarcaAgregar) {
                                JOptionPane.showMessageDialog(null, "Se ha registrado la marca con exito.");

                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "No se logró registrar la marca, verifique que los datos sean válidos.");
                                break;
                            }

                        case 2:
                            JOptionPane.showMessageDialog(null, "No se ha registrado la marca. Volviendo al menu principal...");
                            break; // break del case 2

                        default://Opcion invalida 
                            JOptionPane.showMessageDialog(null, "Opcion no es valida. Intentalo de nuevo \n\n                            ˙◠˙    \n\n");
                            break; // break del default
                    }
                    break; // break del case 2

                case 3: // REGISTRAR UNA CATEGORIA
                    String nombreCategoria = JOptionPane.showInputDialog(null, "Ingrese la categoria del producto.\n");
                    String confirmarCreacionCategoria = "Esta seguro de que desea registrar esta categoria?\n1- Si.\n2-No.\n\n";
                    opcionRegistrarCategoria = Integer.parseInt(JOptionPane.showInputDialog(null, confirmarCreacionCategoria));
                    switch (opcionRegistrarCategoria) {
                        case 1:
                            boolean resultadoCategoriaAgregar = RegistrarCategoria(nombreCategoria);

                            if (resultadoCategoriaAgregar) {

                                JOptionPane.showMessageDialog(null, "Se ha registrado la categoría con exito.");
                            } else {
                                JOptionPane.showMessageDialog(null, "No se logró registrar la categoría, verifique que los datos sean válidos.");
                            }
                            break;// break del case 1

                        case 2:
                            JOptionPane.showMessageDialog(null, "No se ha registrado la categoria. Volviendo al menu principal...");
                            break;// break del case 2

                        default://Opcion invalida 
                            JOptionPane.showMessageDialog(null, "Opcion no es valida. Intentalo de nuevo \n\n                            ˙◠˙    \n\n");
                            break;// break del default
                    }
                    break; // break del case 3

                case 4: //REGRESAR AL MENU PRINCIPAL
                    repetirMenuRegistro = false;
                    JOptionPane.showMessageDialog(null, "Volviendo al menu principal...");
                    break; // break del case 4

                default: //Opcion invalida 
                    JOptionPane.showMessageDialog(null, "Opcion no es valida. Intentalo de nuevo \n\n                            ˙◠˙    \n\n");
                    break; // break del default

            }
        }
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

    public void AgregarProducto(Producto nuevoProducto) {
        int limite = Inventario.length; //Indice +1
        Producto[] inventarioNuevo = new Producto[limite + 1];
        for (int i = 0; i < limite; i++) {
            inventarioNuevo[i] = Inventario[i];
        }
        inventarioNuevo[limite] = nuevoProducto;
        this.Inventario = inventarioNuevo;
    }

    public boolean RegistrarCategoria(String nombreCategoria) {

        for (int i = 0; i < Categorias.length; i++) {
            if (nombreCategoria.equals(this.Categorias[i])) {
                return false;
            }
        }
        int limite = Categorias.length;
        String[] nuevasCategorias = new String[limite + 1];
        for (int i = 0; i < Categorias.length; i++) {
            nuevasCategorias[i] = this.Categorias[i];
        }
        nuevasCategorias[limite] = nombreCategoria;
        this.Categorias = nuevasCategorias;
        return true;
    }

    public boolean RegistrarMarca(String nombreMarca) {

        for (int i = 0; i < Marcas.length; i++) {
            if (nombreMarca.equals(this.Marcas[i])) {
                return false;
            }
        }
        int limite = Marcas.length;
        String[] nuevasMarcas = new String[limite + 1];
        for (int i = 0; i < Marcas.length; i++) {
            nuevasMarcas[i] = this.Marcas[i];
        }
        nuevasMarcas[limite] = nombreMarca;
        this.Marcas = nuevasMarcas;
        return true;
    }

    public boolean ProductoExistente() {
        boolean existe = false;
        if (!this.existente) {
            existe = true;
        } else {
            this.existente = false;
        }
        return existe;
    }

    public Producto[] getInventario() {
        return Inventario;
    }

    public void setInventario(Producto[] Inventario) {
        this.Inventario = Inventario;
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
