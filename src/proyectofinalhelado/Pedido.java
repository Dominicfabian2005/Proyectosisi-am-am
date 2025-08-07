/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalhelado;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private int id;
    private String nombreCliente;
    private Date fecha;
    private String estado;
    private double total;
    private List<DetallePedido> detalles;

    // Constructor con parámetros
    public Pedido(int id, Date fecha, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.detalles = new ArrayList<>();
        this.total = 0;
        this.nombreCliente = "";
    }

    // Constructor vacío que inicializa la lista y otros atributos
    public Pedido() {
        this.id = 0;
        this.fecha = new Date();
        this.estado = "";
        this.detalles = new ArrayList<>();
        this.total = 0;
        this.nombreCliente = "";
    }

    public void agregarDetalle(DetallePedido detalle) {
        detalles.add(detalle);
    }

    public double calcularTotal() {
        double total;
        total = 0;
        for (DetallePedido detalle : detalles) {
            total += detalle.calcularSubtotal();
        }
        this.total = total;
        return total;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }

    void setNombre(String nombreCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}