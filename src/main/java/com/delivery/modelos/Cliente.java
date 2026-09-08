package com.delivery.modelos;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private int idCliente;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;
    private List<Pedido> pedidos;

    public Cliente(int idCliente, String nombre, String telefono,
                   String correo, String direccion) {

        this.idCliente = idCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}

