package com.delivery.modelos.repartidor;

public class RepartidorBicicleta extends Repartidor {

    private double velocidadPromedio;

    public RepartidorBicicleta(int idRepartidor, String nombre,
                               String telefono, double velocidadPromedio) {

        super(idRepartidor, nombre, telefono);
        this.velocidadPromedio = velocidadPromedio;
    }

    @Override
    public double calcularTiempoEntrega(double distancia) {
        return (distancia / velocidadPromedio) * 60;
    }

    public double getVelocidadPromedio() {
        return velocidadPromedio;
    }
}

