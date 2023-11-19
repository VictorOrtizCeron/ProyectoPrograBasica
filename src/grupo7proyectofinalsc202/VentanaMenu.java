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
public class VentanaMenu {
    
    Producto frijol = new Producto(200, "Frijoles Ducal", "Comida enlatada", "Ducal", "5nov2024", false);
    Producto cereal = new Producto(400, "Nesquik", "Cereales", "Nestle", "5nov2024", false);
    private Producto[] inventario = {frijol,cereal};
    private String[] Categorias = {"Cereales","Comida enlatada"};
    private String[] Marcas={"Ducal","Nestle"};

    public void start() {

        int opcion = 0;

        boolean repetirMenu = true;

        //Menu principal 
        while (repetirMenu == true) {
            
            String menuPrincipal = "Bienvenid@ a supermercados Los Pollitos\n"
                    + "\n1-Registro."
                    + "\n2-Ver inventario."
                    + "\n3-Registrar una venta."
                    + "\n4-Salir.\n ";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal));
            switch (opcion) {
                case 1: //Menu de registro
                    VentanaRegistro ventanaRegistro = new VentanaRegistro();
                    ventanaRegistro.setInventario(this.inventario);
                    ventanaRegistro.setMarcas(this.Marcas);
                    ventanaRegistro.setCategorias(this.Categorias);
                    
                    ventanaRegistro.start();
                    
                    this.inventario = ventanaRegistro.getInventario();
                    this.Marcas = ventanaRegistro.getMarcas();
                    this.Categorias = ventanaRegistro.getCategorias();
                    
                    
                    System.out.println(this.inventario[2].getNombre());
                    break;

                
                case 2: //Ver Inventario 

                    VentanaInventario ventanaInventario = new VentanaInventario();
                    ventanaInventario.setMarcas(this.Marcas);
                    ventanaInventario.setCategorias(this.Categorias);
                    ventanaInventario.setInventario(this.inventario);
                    ventanaInventario.start();

                    break;

                

                case 3: //Registrar una venta 
                    VentanaVenta ventanaVenta = new VentanaVenta();
                    ventanaVenta.start();
                    break;

                case 4: //Salir del menu principal
                    repetirMenu = false;
                    JOptionPane.showMessageDialog(null, "Hasta luego, cerrando sistema.");
                    break;

                default: //Opcion invalida 
                    JOptionPane.showMessageDialog(null, "Lo siento, opcion invalida, intentalo de nuevo.");

            }
        }
    }

    public Producto getFrijol() {
        return frijol;
    }

    public void setFrijol(Producto frijol) {
        this.frijol = frijol;
    }

    public Producto getCereal() {
        return cereal;
    }

    public void setCereal(Producto cereal) {
        this.cereal = cereal;
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
