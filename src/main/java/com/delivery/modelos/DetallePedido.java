package com.delivery.modelos;

public class DetallePedido {

    private int cantidad;
    private double precioUnitario;
    private double subtotal;
    private Plato plato;

    public DetallePedido(Plato plato, int cantidad) {
        this.plato = plato;
        this.cantidad = cantidad;
        this.precioUnitario = plato.getPrecio();
        this.subtotal = calcularSubtotal();
    }

    public double calcularSubtotal() {
        subtotal = cantidad * precioUnitario;
        return subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public Plato getPlato() {
        return plato;
    }
}

