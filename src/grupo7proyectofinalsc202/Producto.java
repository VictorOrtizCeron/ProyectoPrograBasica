/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7proyectofinalsc202;

/**
 *
 * @author victo
 */
public class Producto {
    
    private float precio;
    private String nombre;
    private String categoria;
    private String marca;
    private String fechaExp;//opcional
    private boolean estadoVenta;//opcional
    
    public boolean estaCaducado(){
          return false;
    }

    public Producto(float precio, String nombre, String categoria, String marca, String fechaExp, boolean estadoVenta) {
        this.precio = precio;
        this.nombre = nombre;
        this.categoria = categoria;
        this.marca = marca;
        this.fechaExp = fechaExp;
        this.estadoVenta = estadoVenta;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(String fechaExp) {
        this.fechaExp = fechaExp;
    }

    public boolean getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(boolean estadoVenta) {
        this.estadoVenta = estadoVenta;
    }
          
}
