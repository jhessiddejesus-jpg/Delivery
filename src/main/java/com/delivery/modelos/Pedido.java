package main.java.com.delivery.modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private int idPedido;
    private Date fecha;
    private String estado;
    private double subtotal;
    private double costoEnvio;
    private double total;

    private Cliente cliente;
    private Restaurante restaurante;
    private List<DetallePedido> detalles;
    private Envio envio;

    public Pedido(int idPedido, Cliente cliente, Restaurante restaurante) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.fecha = new Date();
        this.estado = "PENDIENTE";
        this.detalles = new ArrayList<>();
    }

    public void agregarDetalle(DetallePedido detalle) {
        detalles.add(detalle);
        calcularSubtotal();
        calcularTotal();
    }

    public double calcularSubtotal() {
        subtotal = 0;

        for (DetallePedido detalle : detalles) {
            subtotal += detalle.getSubtotal();
        }

        return subtotal;
    }

    public double calcularCostoEnvio() {
        if (envio != null) {
            costoEnvio = envio.calcularCosto();
        }

        return costoEnvio;
    }

    public double calcularTotal() {
        total = subtotal + costoEnvio;
        return total;
    }

    public void crearEnvio(Envio envio) {
        this.envio = envio;
        calcularCostoEnvio();
        calcularTotal();
    }

    public int getIdPedido() {
        return idPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public double getTotal() {
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}