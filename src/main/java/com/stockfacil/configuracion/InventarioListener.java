package com.stockfacil.configuracion;

import com.stockfacil.servicio.Inventario;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class InventarioListener implements ServletContextListener {
    public static final String INVENTARIO = "inventario";
    @Override public void contextInitialized(ServletContextEvent evento) {
        evento.getServletContext().setAttribute(INVENTARIO, new Inventario());
    }
}