package com.stockfacil.servicio;

import com.stockfacil.modelo.Producto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Inventario {
    private final Set<Producto> productos = new HashSet<>();
    private int siguienteId = 1;

    public synchronized Producto agregarProducto(Producto producto) {
        if (producto == null) throw new IllegalArgumentException("El producto es obligatorio.");
        if (!productos.add(producto)) throw new IllegalArgumentException("Ya existe un producto con ese ID.");
        if (producto.getId() >= siguienteId) siguienteId = producto.getId() + 1;
        return producto;
    }
    public synchronized int generarId() { return siguienteId++; }
    public synchronized List<Producto> listarProductos() { return new ArrayList<>(productos); }
    public synchronized Producto buscarPorId(int id) {
        for (Producto producto : productos) if (producto.getId() == id) return producto;
        return null;
    }
    public synchronized List<Producto> buscarPorNombre(String nombre) {
        List<Producto> resultados = new ArrayList<>();
        if (nombre == null || nombre.trim().isEmpty()) return resultados;
        String criterio = nombre.trim().toLowerCase();
        for (Producto producto : productos) if (producto.getNombre().toLowerCase().contains(criterio)) resultados.add(producto);
        return resultados;
    }
    public synchronized boolean eliminarProducto(int id) { return productos.removeIf(p -> p.getId() == id); }
    public synchronized List<Producto> ordenarPorPrecio() {
        List<Producto> ordenados = new ArrayList<>(productos);
        Collections.sort(ordenados, Comparator.comparingDouble(Producto::getPrecio));
        return ordenados;
    }
    public synchronized int contarProductos() { return productos.size(); }
}
