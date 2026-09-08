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

        // ______________________________
        // CREAMOS RESTAURANTE
        // ______________________________
        Restaurante restaurante = new Restaurante(
                1,
                "Sabor Colombiano",
                "Carrera 5 # 10-20",
                "3001234567"
        );

        // _______________________________
        // CREAMOS PLATOS

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

        //________________________________
        // SERVICIO RESTAURANTE
        //________________________________

        ServicioRestaurante servicioRestaurante =
                new ServicioRestaurante();

        servicioRestaurante.agregarPlato(
                restaurante,
                hamburguesa
        );

        servicioRestaurante.agregarPlato(
                restaurante,
                pizza
        );

        servicioRestaurante.mostrarMenu(restaurante);

        // ________________________________
        // CREAR CLIENTE
        //________________________________

        Cliente cliente = new Cliente(
                1,
                "Jhessid",
                "3101234567",
                "jhessid@gmail.com",
                "Calle 10 # 5-20"
        );

        // _______________________________
        // CREAR PEDIDO
        // _______________________________

        Pedido pedido = new Pedido(
                1,
                cliente,
                restaurante
        );

        // _______________________________
        // SERVICIO PEDIDO
        // _______________________________

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

        // ________________________________
        // CREAR ENVIO
        // ________________________________

        Envio envio = new Envio(
                1,
                cliente.getDireccion(),
                5
        );

        pedido.crearEnvio(envio);

        // ________________________________
        // CREAR REPARTIDOR
        // ________________________________

        Repartidor repartidor =
                new RepartidorMoto(
                        1,
                        "Carlos",
                        "3209876543",
                        40
                );

        // ________________________________
        // SERVICIO DE ENVIO
        // ________________________________

        ServicioEnvio servicioEnvio =
                new ServicioEnvio();

        // Asignar repartidor
        servicioEnvio.asignarRepartidor(
                envio,
                repartidor
        );

        // ________________________________
        // CONFIRMAR PEDIDO
        // ________________________________

        servicioPedido.confirmarPedido(pedido);

        // ________________________________
        // MOSTRAR INFORMACION DEL PEDIDO
        // ________________________________

        System.out.println();
        System.out.println("      PEDIDO      ");

        System.out.println(
                "Cliente: " + cliente.getNombre()
        );

        System.out.println(
                "Subtotal: $" + pedido.getSubtotal()
        );

        System.out.println(
                "Costo envio: $" + pedido.getCostoEnvio()
        );

        System.out.println(
                "Total: $" + pedido.getTotal()
        );

        System.out.println(
                "Estado pedido: " + pedido.getEstado()
        );

        // ________________________________
        // INICIAR ENVIO
        // ________________________________

        servicioEnvio.iniciarEnvio(envio);

        servicioEnvio.mostrarEstado(envio);

        // ________________________________
        // ESPERAR ENTREGA
        // ________________________________

        servicioEnvio.esperarEntrega(envio);

        // ________________________________
        // MOSTRAR ESTADO FINAL
        // ________________________________

        servicioEnvio.mostrarEstado(envio);

        System.out.println();
        System.out.println("      FIN DEL PEDIDO      ");
    }
}
