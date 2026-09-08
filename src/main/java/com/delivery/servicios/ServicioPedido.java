package com.delivery.servicios;

import com.delivery.modelos.DetallePedido;
import com.delivery.modelos.Pedido;
import com.delivery.modelos.Plato;

public class ServicioPedido {

    public void agregarPlato(Pedido pedido, Plato plato, int cantidad) {

        if (!plato.isDisponible()) {
            System.out.println("El plato no esta disponible");
            return;
        }

        DetallePedido detalle = new DetallePedido(plato, cantidad);

        pedido.agregarDetalle(detalle);
    }

    public void confirmarPedido(Pedido pedido) {

        pedido.calcularSubtotal();
        pedido.calcularCostoEnvio();
        pedido.calcularTotal();

        pedido.setEstado("CONFIRMADO");
    }
}


