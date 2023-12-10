/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7proyectofinalsc202;

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

    public void agregarProducto(Producto productoAgregado) {

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
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }
    public boolean agregar(Producto productoAgregado){
        for(int i = 0 ; i<productosDeCompra.length; i++){
            //agregación de más cantidad del mismo producto sin redundancias
            if(productoAgregado.getNombre().equals(productosDeCompra[i].getNombre())){
            
                int totalCantidad = productoAgregado.getCantidad()+ productosDeCompra[i].getCantidad();
                productosDeCompra[i].resetCantidad(totalCantidad);
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
