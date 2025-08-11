/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalhelado;

/**
 *
 * @author 20242260
 */


public class HeladoCajita extends Producto {
    private String tamanio; // Atributo específico

    public HeladoCajita(int id, String nombre, double precio, int proveedor, String tamanio) {
        super(id, nombre, precio, proveedor);
        this.tamanio = tamanio;
    }

   
    public double calcularPrecioFinal() {
        double precioAdicional = 0.0;
        if (this.tamanio.equals("Grande")) {
            precioAdicional = 1.25;
        }
        return getPrecio() + precioAdicional;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }
}
