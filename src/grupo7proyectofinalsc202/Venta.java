package grupo7proyectofinalsc202;
import javax.swing.JOptionPane;
public class Venta {

    //atributos
    private String clienteNombre;
    private Producto[] productosDeCompra;
    private String factura;

    //constructor de la venta
    public Venta() {
        this.clienteNombre = "";
        this.productosDeCompra = new Producto[0];
        this.factura = "";
    }

    //metodos
    public String getClienteNombre() {
        return clienteNombre;
    }

    public boolean setClienteNombre(String clienteNombre) {

        if (clienteNombre.equals("")) {
            return false;
        } else {
            this.clienteNombre = clienteNombre;
            return true;
        }

    }

    public String getFactura() {

        String factura = "─────── ⋆ ───────Factura─────── ⋆ ───────\nNombre de cliente: " + this.clienteNombre;

        float total = 0;

        for (int i = 0; i < productosDeCompra.length; i++) {
            factura
                    += "\nNombre del producto: " + productosDeCompra[i].getNombre()
                    + "\nCantidad: " + productosDeCompra[i].getCantidad()
                    + "\nPrecio: " + productosDeCompra[i].getPrecio()
                    + "\nSubtotal: " + (productosDeCompra[i].getPrecio() * productosDeCompra[i].getCantidad());

            total += productosDeCompra[i].getPrecio() * productosDeCompra[i].getCantidad();

        }
        factura += "\nTOTAL DE VENTA: " + total+"\n─────── ⋆ ───────────────────── ⋆ ───────";

        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public boolean agregar(Producto productoAgregado, int cantidad) {

        for (int i = 0; i < productosDeCompra.length; i++) {

            //agregación de más cantidad del mismo producto sin redundancias
            if (productoAgregado.getNombre().equals(productosDeCompra[i].getNombre())) {
                productosDeCompra[i].agregarCantidad(cantidad);
                return true;
            }

        }
        //agregación de nuevo producto
        int limite = productosDeCompra.length; //Indice +1
        Producto[] productosNuevo = new Producto[limite + 1];
        for (int i = 0; i < limite; i++) {
            productosNuevo[i] = productosDeCompra[i];
        }
        productosNuevo[limite] = productoAgregado;
        this.productosDeCompra = productosNuevo;

        return true;

    }

    public Producto[] getProductosDeCompra() {
        return productosDeCompra;
    }

    public void setProductosDeCompra(Producto[] productosDeCompra) {
        this.productosDeCompra = productosDeCompra;
    }

} //llave de la clase
