package com.stockfacil.modelo;

import java.time.LocalDate;

public class ProductoAlimenticio extends Producto {
    private final LocalDate fechaVencimiento;
    public ProductoAlimenticio(int id, String nombre, double precio, int stock, LocalDate fechaVencimiento) {
        super(id, nombre, precio, stock);
        if (fechaVencimiento == null) throw new IllegalArgumentException("La fecha de vencimiento es obligatoria.");
        this.fechaVencimiento = fechaVencimiento;
    }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    @Override public String mostrarDetalles() { return "Vencimiento: " + fechaVencimiento; }
}
