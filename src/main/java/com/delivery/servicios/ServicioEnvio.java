package com.delivery.servicios;

import com.delivery.modelos.Envio;
import com.delivery.modelos.repartidor.Repartidor;

public class ServicioEnvio {

    public void asignarRepartidor(Envio envio, Repartidor repartidor) {

        if (!repartidor.isDisponible()) {
            System.out.println("El repartidor no esta disponible.");
            return;
        }

        envio.asignarRepartidor(repartidor);
    }

    public void iniciarEnvio(Envio envio) {
        envio.actualizarEstado("EN_CAMINO");
    }

    public void entregarEnvio(Envio envio) {
        envio.actualizarEstado("ENTREGADO");

        if (envio.getRepartidor() != null) {
            envio.getRepartidor().entregarPedido();
        }
    }

    public void mostrarEstado(Envio envio) {
        System.out.println("Estado del envio: " + envio.obtenerEstado());
    }
}
