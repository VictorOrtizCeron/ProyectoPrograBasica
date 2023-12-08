package grupo7proyectofinalsc202;
public class Producto {
    
    private float precio;
    private String nombre;
    private String categoria;
    private String marca;
    private int cantidad;
    
    public boolean estaCaducado(){
          return false;
    }

    public Producto(float precio, String nombre, String categoria, String marca) {
        this.precio = precio;
        this.nombre = nombre;
        this.categoria = categoria;
        this.marca = marca;
        
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

   
          
}
