package com.stockfacil.servlet;

import com.stockfacil.modelo.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/registrar")
public class RegistroServlet extends BaseServlet {
    @Override protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            String tipo = request.getParameter("tipo");
            String nombre = request.getParameter("nombre");
            double precio = Double.parseDouble(request.getParameter("precio"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            int id = obtenerInventario().generarId();
            Producto producto;
            switch (tipo == null ? "" : tipo) {
                case "electronico" -> producto = new ProductoElectronico(id, nombre, precio, stock, Integer.parseInt(request.getParameter("garantia")));
                case "alimenticio" -> producto = new ProductoAlimenticio(id, nombre, precio, stock, LocalDate.parse(request.getParameter("vencimiento")));
                case "limpieza" -> producto = new ProductoLimpieza(id, nombre, precio, stock, request.getParameter("presentacion"));
                default -> throw new IllegalArgumentException("Seleccioná una categoría válida.");
            }
            obtenerInventario().agregarProducto(producto);
            request.getSession().setAttribute("mensaje", "Producto registrado correctamente.");
        } catch (NumberFormatException ex) {
            request.getSession().setAttribute("error", "Revisá los valores numéricos y la fecha ingresada.");
        } catch (Exception ex) {
            request.getSession().setAttribute("error", ex.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/productos");
    }
}
