package com.stockfacil.servlet;

import com.stockfacil.configuracion.InventarioListener;
import com.stockfacil.servicio.Inventario;
import jakarta.servlet.http.HttpServlet;

public abstract class BaseServlet extends HttpServlet {
    protected Inventario obtenerInventario() {
        return (Inventario) getServletContext().getAttribute(InventarioListener.INVENTARIO);
    }
}
