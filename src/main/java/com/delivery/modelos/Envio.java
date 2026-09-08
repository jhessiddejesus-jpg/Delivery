package com.delivery.modelos;

import com.delivery.interfaz.Rastreable;
import com.delivery.modelos.repartidor.Repartidor;

import java.util.Date;

public class Envio implements Rastreable {

    private int idEnvio;
    private String direccionEntrega;
    private String estado;
    private double distancia;
    private Date fechaEntrega;
    private Repartidor repartidor;

    public Envio(int idEnvio, String direccionEntrega, double distancia) {
        this.idEnvio = idEnvio;
        this.direccionEntrega = direccionEntrega;
        this.distancia = distancia;
        this.estado = "PENDIENTE";
    }

    public double calcularCosto() {
        return distancia * 2000;
    }

    public void asignarRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
        repartidor.aceptarPedido();
        actualizarEstado("ASIGNADO");
    }

    @Override
    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;

        if (nuevoEstado.equals("ENTREGADO")) {
            fechaEntrega = new Date();
        }
    }

    @Override
    public String obtenerEstado() {
        return estado;
    }

    public int getIdEnvio() {
        return idEnvio;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public double getDistancia() {
        return distancia;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public Repartidor getRepartidor() {
        return repartidor;
    }
}

