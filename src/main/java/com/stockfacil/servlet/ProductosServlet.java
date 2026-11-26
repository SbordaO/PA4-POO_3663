package com.stockfacil.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/productos")
public class ProductosServlet extends BaseServlet {
    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orden = request.getParameter("orden");
        request.setAttribute("productos", "precio".equals(orden) ? obtenerInventario().ordenarPorPrecio() : obtenerInventario().listarProductos());
        request.setAttribute("total", obtenerInventario().contarProductos());
        request.getRequestDispatcher("/WEB-INF/vistas/inventario.jsp").forward(request, response);
    }
}
