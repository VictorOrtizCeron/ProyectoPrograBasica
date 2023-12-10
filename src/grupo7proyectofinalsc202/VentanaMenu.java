package grupo7proyectofinalsc202;
import javax.swing.JOptionPane;
public class VentanaMenu {
    Producto frijol = new Producto(200, "Frijoles Ducal", "Comida enlatada", "Ducal");
    Producto cereal = new Producto(400, "Nesquik", "Cereales", "Nestle");
    Producto cereal2 = new Producto(500, "Zucaritas", "Cereales", "Kellogs");
    private Producto[] inventario = {frijol, cereal, cereal2}; //frijol, cereal, cereal2
    private String[] Categorias = {"Cereales", "Comida enlatada"}; //"Cereales", "Comida enlatada"
    private String[] Marcas = {"Ducal","Nestle","Kellogs"}; //"Ducal","Nestle","Kellogs"


    public void start() {

        int opcion = 0;
        boolean repetirMenu = true;

        //Menu principal 
        while (repetirMenu == true) {

            String menuPrincipal = "─────── ⋆⋅⋆  ────────Bienvenid@ a supermercados Los Pollitos ─────── ⋆⋅⋆  ────────\n"
                    + "\n1-Registro."
                    + "\n2-Ver inventario."
                    + "\n3-Registrar una venta."
                    + "\n4-Salir.\n ";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal));
            switch (opcion) {
                case 1: //VER MENU REGISTRO
                    VentanaRegistro ventanaRegistro = new VentanaRegistro();
                    ventanaRegistro.setInventario(this.inventario);
                    ventanaRegistro.setMarcas(this.Marcas);
                    ventanaRegistro.setCategorias(this.Categorias);

                    ventanaRegistro.start();

                    this.inventario = ventanaRegistro.getInventario();
                    this.Marcas = ventanaRegistro.getMarcas();
                    this.Categorias = ventanaRegistro.getCategorias();

                    break; // break del case 1

                case 2: //VER INVENTARIO

                    VentanaInventario ventanaInventario = new VentanaInventario();
                    ventanaInventario.setMarcas(this.Marcas);
                    ventanaInventario.setCategorias(this.Categorias);
                    ventanaInventario.setInventario(this.inventario);
                    ventanaInventario.start();

                    break; // break del case 2

                case 3: //REGISTRAR UNA VENTA
                    VentanaVenta ventanaVenta = new VentanaVenta();
                    ventanaVenta.setMarcas(this.Marcas);
                    ventanaVenta.setCategorias(this.Categorias);
                    ventanaVenta.setInventario(this.inventario);
                    ventanaVenta.start();
                    
                    
                    break; // break del case 3

                case 4: //SALIR AL MENU PRICIPAL
                    repetirMenu = false;
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema (_ _ ) . . z Z");
                    break; // break del case 4

                default: //Opcion invalida 
                    JOptionPane.showMessageDialog(null, "Opcion no es valida. Intentalo de nuevo \n\n                            ˙◠˙    \n\n");

            }
        }
    }

//    public Producto getFrijol() {
//        return frijol;
//    }
//
//    public void setFrijol(Producto frijol) {
//        this.frijol = frijol;
//    }
//
//    public Producto getCereal() {
//        return cereal;
//    }
//
//    public void setCereal(Producto cereal) {
//        this.cereal = cereal;
//    }

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
