package com.delivery;

import com.delivery.modelos.Cliente;
import com.delivery.modelos.Envio;
import com.delivery.modelos.Pedido;
import com.delivery.modelos.Plato;
import com.delivery.modelos.Restaurante;
import com.delivery.modelos.repartidor.Repartidor;
import com.delivery.modelos.repartidor.RepartidorMoto;
import com.delivery.servicios.ServicioEnvio;
import com.delivery.servicios.ServicioPedido;
import com.delivery.servicios.ServicioRestaurante;

public class Main {

    public static void main(String[] args) {

        // Crear restaurante
        Restaurante restaurante = new Restaurante(
                1,
                "Sabor Colombiano",
                "Carrera 5 # 10-20",
                "3001234567"
        );

        // Crear platos
        Plato hamburguesa = new Plato(
                1,
                "Hamburguesa",
                "Hamburguesa con queso",
                18000
        );

        Plato pizza = new Plato(
                2,
                "Pizza",
                "Pizza de pollo",
                25000
        );

        // Servicio restaurante
        ServicioRestaurante servicioRestaurante =
                new ServicioRestaurante();

        servicioRestaurante.agregarPlato(restaurante, hamburguesa);
        servicioRestaurante.agregarPlato(restaurante, pizza);

        servicioRestaurante.mostrarMenu(restaurante);

        // Crear cliente
        Cliente cliente = new Cliente(
                1,
                "Jhessid",
                "3101234567",
                "jhessid@gmail.com",
                "Calle 10 # 5-20"
        );

        // Crear pedido
        Pedido pedido = new Pedido(
                1,
                cliente,
                restaurante
        );

        // Servicio pedido
        ServicioPedido servicioPedido =
                new ServicioPedido();

        servicioPedido.agregarPlato(
                pedido,
                hamburguesa,
                2
        );

        servicioPedido.agregarPlato(
                pedido,
                pizza,
                1
        );

        // Crear envio
        Envio envio = new Envio(
                1,
                cliente.getDireccion(),
                5
        );

        pedido.crearEnvio(envio);

        // Crear repartidor
        Repartidor repartidor =
                new RepartidorMoto(
                        1,
                        "Carlos",
                        "3209876543",
                        40
                );

        // Servicio de envio
        ServicioEnvio servicioEnvio =
                new ServicioEnvio();

        servicioEnvio.asignarRepartidor(
                envio,
                repartidor
        );

        servicioEnvio.iniciarEnvio(envio);

        // Confirmar pedido
        servicioPedido.confirmarPedido(pedido);

        // Mostrar informacion
        System.out.println();
        System.out.println("PEDIDO ");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Subtotal: $" + pedido.getSubtotal());
        System.out.println("Costo envío: $" + pedido.getCostoEnvio());
        System.out.println("Total: $" + pedido.getTotal());
        System.out.println("Estado pedido: " + pedido.getEstado());

        servicioEnvio.mostrarEstado(envio);

        // Entregar
        servicioEnvio.entregarEnvio(envio);

        servicioEnvio.mostrarEstado(envio);
    }
}
