package com.stockfacil.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/eliminar")
public class EliminarServlet extends BaseServlet {
    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean eliminado = obtenerInventario().eliminarProducto(id);
            request.getSession().setAttribute(eliminado ? "mensaje" : "error", eliminado ? "Producto eliminado." : "No se encontró el producto.");
        } catch (NumberFormatException ex) {
            request.getSession().setAttribute("error", "ID inválido.");
        }
        response.sendRedirect(request.getContextPath() + "/productos");
    }
}
