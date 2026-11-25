package com.stockfacil.modelo;

public class ProductoElectronico extends Producto {
    private final int mesesGarantia;
    public ProductoElectronico(int id, String nombre, double precio, int stock, int mesesGarantia) {
        super(id, nombre, precio, stock);
        if (mesesGarantia < 0) throw new IllegalArgumentException("La garantía no puede ser negativa.");
        this.mesesGarantia = mesesGarantia;
    }
    public int getMesesGarantia() { return mesesGarantia; }
    @Override public String mostrarDetalles() { return "Garantía: " + mesesGarantia + " meses"; }
}
