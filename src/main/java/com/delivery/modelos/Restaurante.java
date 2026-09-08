package com.delivery.modelos;

public class Restaurante {

    private int idRestaurante;
    private String nombre;
    private String direccion;
    private String telefono;
    private Menu menu;

    public Restaurante(int idRestaurante, String nombre, String direccion, String telefono) {
        this.idRestaurante = idRestaurante;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.menu = new Menu(idRestaurante);
    }

    public void agregarPlato(Plato plato) {
        menu.agregarPlato(plato);
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public Menu getMenu() {
        return menu;
    }

    @Override
    public String toString() {
        return nombre + " - " + direccion;
    }
}



