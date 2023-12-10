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
public class Venta {

    private String clienteNombre;
    private Producto[] productosDeCompra;
    private String factura;

    public Venta() {
        this.clienteNombre = "";
        this.productosDeCompra = new Producto[0];
        this.factura = "";
    }

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

    public Producto[] getProductosDeCompra() {
        return productosDeCompra;
    }

    public void setProductosDeCompra(Producto[] productosDeCompra) {
        this.productosDeCompra = productosDeCompra;
    }

    public String getFactura() {
        
        String factura = "Nombre de cliente: " + this.clienteNombre + "\n";

        float total = 0;

        for (int i = 0; i < productosDeCompra.length; i++) {
            factura
                    += "\nNombre del producto: " + productosDeCompra[i].getNombre()
                    + "\n cantidad: " + productosDeCompra[i].getCantidad()
                    + "\n precio: " + productosDeCompra[i].getPrecio()
                    + "\n subtotal: " + (productosDeCompra[i].getPrecio() * productosDeCompra[i].getCantidad());

            total += productosDeCompra[i].getPrecio() * productosDeCompra[i].getCantidad();

        }
        factura += "\nTOTAL DE VENTA: " + total;

        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }
    public boolean agregar(Producto productoAgregado,int cantidad){
        
        
        for(int i = 0 ; i<productosDeCompra.length; i++){
            
            
            //agregación de más cantidad del mismo producto sin redundancias
            if(productoAgregado.getNombre().equals(productosDeCompra[i].getNombre())){
                
               
                
               
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

}
