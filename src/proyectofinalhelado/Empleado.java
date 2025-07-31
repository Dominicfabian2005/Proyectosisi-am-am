/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalhelado;

/**
 *
 * @author domif
 */

    public class Empleado extends Persona {
    private int idEmpleado;
    private String turno;

    public Empleado(int idEmpleado, String nombre, String turno) {
        super(nombre);
        this.idEmpleado = idEmpleado;
        this.turno = turno;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getTurno() {
        return turno;
    }

    public void verPedido(Pedido pedido) {
        // lógica para mostrar pedido
    }

    public void cambiarEstadoPedido(Pedido pedido, String nuevoEstado) {
        pedido.setEstado(nuevoEstado);
    }
}
