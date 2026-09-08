package com.delivery.modelos.repartidor;

public abstract class Repartidor {

    private int idRepartidor;
    private String nombre;
    private String telefono;
    private boolean disponible;
    
    public Repartidor(int idRepartidor, String nombre, String telefono) {
        this.idRepartidor = idRepartidor;
        this.nombre = nombre;
        this.telefono = telefono;
        this.disponible = true;
    }

    public void aceptarPedido() {
        disponible = false;
    }

    public void entregarPedido() {
        disponible = true;
    }

    public abstract double calcularTiempoEntrega(double distancia);

    public int getIdRepartidor() {
        return idRepartidor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean isDisponible() {
        return disponible;
    }
}

