package com.stockfacil.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/buscar")
public class BusquedaServlet extends BaseServlet {
    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String criterio = request.getParameter("criterio");
        request.setAttribute("productos", obtenerInventario().buscarPorNombre(criterio));
        request.setAttribute("total", obtenerInventario().buscarPorNombre(criterio).size());
        request.setAttribute("busqueda", criterio);
        request.getRequestDispatcher("/WEB-INF/vistas/inventario.jsp").forward(request, response);
    }
}
