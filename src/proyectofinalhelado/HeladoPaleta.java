/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalhelado;

/**
 *
 * @author 20242260
 */

public class HeladoPaleta extends Producto {
    private String tipoBase; // Atributo específico

    public HeladoPaleta(int id, String nombre, double precio, int proveedor, String tipoBase) {
        super(id, nombre, precio, proveedor);
        this.tipoBase = tipoBase;
    }

    @Override
    public double calcularPrecioFinal() {
        double precioFinal = getPrecio();
        if (this.tipoBase.equals("Crema")) {
            precioFinal += 0.75;
        }
        return precioFinal;
    }

    public String getTipoBase() {
        return tipoBase;
    }

    public void setTipoBase(String tipoBase) {
        this.tipoBase = tipoBase;
    }
}

