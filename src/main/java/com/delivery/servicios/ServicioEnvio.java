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

        System.out.println();
        System.out.println("El pedido esta en camino...");
    }

    public void esperarEntrega(Envio envio) {

        Repartidor repartidor = envio.getRepartidor();

        double tiempoMinutos = repartidor.calcularTiempoEntrega(
                envio.getDistancia()
        );

        int segundos = (int) (tiempoMinutos * 2);

        try {

            System.out.println();
            System.out.println(
                    "Tiempo estimado de entrega: "
                    + tiempoMinutos
                    + " minutos"
            );

            System.out.println();

            for (int i = segundos; i > 0; i--) {

                System.out.println(
                        "Tiempo restante: "
                        + i
                        + " segundos"
                );

                Thread.sleep(1000);
            }

            entregarEnvio(envio);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println(
                    "La espera fue interrumpida."
            );
        }
    }

    public void entregarEnvio(Envio envio) {

        envio.actualizarEstado("ENTREGADO");

        if (envio.getRepartidor() != null) {
            envio.getRepartidor().entregarPedido();
        }

        System.out.println();
        System.out.println("¡Pedido entregado!");
    }

    public void mostrarEstado(Envio envio) {

        System.out.println(
                "Estado del envio: "
                + envio.obtenerEstado()
        );
    }
}
