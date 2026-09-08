package com.delivery.modelos;
import java.util.ArrayList;
import java.util.List;


public class Menu {

    private int idMenu;
    private String estado;
    private List<Plato> platos;

    public Menu(int idMenu) {
        this.idMenu = idMenu;
        this.estado = "ACTIVO";
        this.platos = new ArrayList<>();
    }

    public void agregarPlato(Plato plato) {
        platos.add(plato);
    }

    public void eliminarPlato(Plato plato) {
        platos.remove(plato);
    }

    public List<Plato> obtenerPlatos() {
        return platos;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}



