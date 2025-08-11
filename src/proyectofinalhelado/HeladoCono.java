/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalhelado;

public class HeladoCono extends Producto {
    private String tipoCono; // Atributo específico
    private String sabor;    // Atributo específico

    public HeladoCono(int id, String nombre, double precio, int proveedor, String tipoCono, String sabor) {
        super(id, nombre, precio, proveedor);
        this.tipoCono = tipoCono;
        this.sabor = sabor;
    }

    @Override
    public double calcularPrecioFinal() {
        double precioAdicional = 0.0;
        if (this.tipoCono.equals("Waffle")) {
            precioAdicional = 0.50;
        }
        return getPrecio() + precioAdicional;
    }

    public String getTipoCono() {
        return tipoCono;
    }

    public void setTipoCono(String tipoCono) {
        this.tipoCono = tipoCono;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
}