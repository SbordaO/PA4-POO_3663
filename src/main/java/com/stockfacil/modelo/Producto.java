package com.stockfacil.modelo;

import java.util.Objects;

public abstract class Producto implements Identificable {
    private final int id;
    private final String nombre;
    private final double precio;
    private final int stock;

    protected Producto(int id, String nombre, double precio, int stock) {
        if (id <= 0) throw new IllegalArgumentException("El ID debe ser positivo.");
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("El nombre es obligatorio.");
        if (!Double.isFinite(precio) || precio <= 0) throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        if (stock < 0) throw new IllegalArgumentException("El stock no puede ser negativo.");
        this.id = id; this.nombre = nombre.trim(); this.precio = precio; this.stock = stock;
    }
    @Override public int getId() { return id; }
    @Override public String obtenerIdentificador() { return "PROD-" + id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public double calcularValorStock() { return precio * stock; }
    public abstract String mostrarDetalles();
    @Override public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (!(objeto instanceof Producto)) return false;
        Producto otro = (Producto) objeto;
        return id == otro.id;
    }
    @Override public int hashCode() { return Objects.hash(id); }
}
