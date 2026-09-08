package com.delivery.servicios;
import com.delivery.modelos.Plato;
import com.delivery.modelos.Restaurante;


public class ServicioRestaurante {

    public void agregarPlato(Restaurante restaurante, Plato plato) {
        restaurante.agregarPlato(plato);
    }

    public void mostrarMenu(Restaurante restaurante) {

        System.out.println("menu");
        System.out.println(restaurante.getNombre());

        for (Plato plato : restaurante.getMenu().obtenerPlatos()) {
            if (plato.isDisponible()) {
                System.out.println(
                    plato.getNombre() + " - $" + plato.getPrecio()
                );
            }
        }
    }
}


