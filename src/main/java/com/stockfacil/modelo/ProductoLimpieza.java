package com.stockfacil.modelo;

public class ProductoLimpieza extends Producto {
    private final String presentacion;
    public ProductoLimpieza(int id, String nombre, double precio, int stock, String presentacion) {
        super(id, nombre, precio, stock);
        if (presentacion == null || presentacion.trim().isEmpty()) throw new IllegalArgumentException("La presentación es obligatoria.");
        this.presentacion = presentacion.trim();
    }
    public String getPresentacion() { return presentacion; }
    @Override public String mostrarDetalles() { return "Presentación: " + presentacion; }
}
