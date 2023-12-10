package grupo7proyectofinalsc202;
public class Producto {
    
    private float precio;
    private String nombre;
    private String categoria;
    private String marca;
    private int cantidad;//se utiliza para manejar la cantidad de producto en venta
    
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

    public boolean setCantidad(int cantidad) {
        if(cantidad>0){
             this.cantidad = cantidad;
             return true;
        }
        else{
            return false;
        }
       
    }
    
    public void resetCantidad(int cantidad) {
             this.cantidad = cantidad;  
    }

   
          
}
