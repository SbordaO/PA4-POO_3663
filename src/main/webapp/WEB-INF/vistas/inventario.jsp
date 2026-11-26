
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>StockFácil 2.0</title>

    <link rel="stylesheet"
            href="${pageContext.request.contextPath}/css/estilos.css">
</head>

<body>

<main class="contenedor">

    <header>
        <div>
            <span class="marca">STOCKFÁCIL 2.0</span>
            <h1>Gestión de inventario</h1>
            <p>Administrá productos electrónicos, alimenticios y de limpieza.</p>
        </div>

        <div class="contador">
            <strong>${total}</strong>
            <span>productos</span>
        </div>
    </header>

    <c:if test="${not empty sessionScope.mensaje}">
        <div class="alerta ok">
            <c:out value="${sessionScope.mensaje}"/>
        </div>
        <c:remove var="mensaje" scope="session"/>
    </c:if>

    <c:if test="${not empty sessionScope.error}">
        <div class="alerta error">
            <c:out value="${sessionScope.error}"/>
        </div>
        <c:remove var="error" scope="session"/>
    </c:if>

    <section class="panel">

        <h2>Registrar producto</h2>

        <form action="${pageContext.request.contextPath}/registrar"
              method="post"
              class="formulario">

            <label>
                Categoría
                <select name="tipo" id="tipo"
                        onchange="mostrarCampos()" required>
                    <option value="electronico">Electrónico</option>
                    <option value="alimenticio">Alimenticio</option>
                    <option value="limpieza">Limpieza</option>
                </select>
            </label>

            <label>
                Nombre
                <input name="nombre" maxlength="100" required>
            </label>

            <label>
                Precio (S/)
                <input type="number" name="precio"
                       min="0.01" step="0.01" required>
            </label>

            <label>
                Stock
                <input type="number" name="stock"
                       min="0" step="1" required>
            </label>

            <label class="extra" id="campo-garantia">
                Garantía (meses)
                <input type="number" name="garantia"
                       min="0" value="12">
            </label>

            <label class="extra oculto" id="campo-vencimiento">
                Fecha de vencimiento
                <input type="date" name="vencimiento">
            </label>

            <label class="extra oculto" id="campo-presentacion">
                Presentación
                <input name="presentacion"
                       placeholder="Ej. botella 1 L">
            </label>

            <button type="submit">Registrar producto</button>

        </form>

    </section>

    <section class="panel">

        <div class="barra">
            <h2>Inventario</h2>

            <a class="boton-secundario"
               href="${pageContext.request.contextPath}/productos?orden=precio">
                Ordenar por precio
            </a>
        </div>

        <form action="${pageContext.request.contextPath}/buscar"
              method="get"
              class="buscador">

            <input name="criterio"
                   value="<c:out value='${busqueda}'/>"
                   placeholder="Buscar por nombre">

            <button>Buscar</button>

            <a href="${pageContext.request.contextPath}/productos">
                Ver todos
            </a>

        </form>

        <div class="tabla-wrap">

            <table>

                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Producto</th>
                        <th>Categoría y detalles</th>
                        <th>Precio</th>
                        <th>Stock</th>
                        <th>Valor stock</th>
                        <th>Acción</th>
                    </tr>
                </thead>

                <tbody>

                    <c:forEach var="p" items="${productos}">

                        <tr>

                            <td>
                                <c:out value="${p.id}"/>
                            </td>

                            <td>
                                <strong>
                                    <c:out value="${p.nombre}"/>
                                </strong>

                                <small>
                                    <c:out value="${p.obtenerIdentificador()}"/>
                                </small>
                            </td>

                            <td>
                                <c:out value="${p['class'].simpleName}"/>

                                <small>
                                    <c:out value="${p.mostrarDetalles()}"/>
                                </small>
                            </td>

                            <td>
                                S/ <c:out value="${p.precio}"/>
                            </td>

                            <td>
                                <c:out value="${p.stock}"/>
                            </td>

                            <td>
                                S/ <c:out value="${p.calcularValorStock()}"/>
                            </td>

                            <td>
                                <form action="${pageContext.request.contextPath}/eliminar"
                                      method="post">

                                    <input type="hidden"
                                           name="id"
                                           value="${p.id}">

                                    <button class="peligro"
                                            onclick="return confirm('¿Eliminar este producto?')">
                                        Eliminar
                                    </button>

                                </form>
                            </td>

                        </tr>

                    </c:forEach>

                    <c:if test="${empty productos}">
                        <tr>
                            <td colspan="7" class="vacio">
                                No hay productos para mostrar.
                            </td>
                        </tr>
                    </c:if>

                </tbody>

            </table>

        </div>

    </section>

    <footer>
        StockFácil 2.0 · PA4 Programación Orientada a Objetos
    </footer>

</main>

<script>

    function mostrarCampos() {

        const tipo = document.getElementById('tipo').value;

        document.querySelectorAll('.extra').forEach(e => {
            e.classList.add('oculto');
        });

        const campo = document.getElementById(
            'campo-' +
            (tipo === 'electronico'
                ? 'garantia'
                : tipo === 'alimenticio'
                    ? 'vencimiento'
                    : 'presentacion')
        );

        campo.classList.remove('oculto');
        campo.querySelector('input').required = true;

        document.querySelectorAll('.extra').forEach(e => {
            if (e !== campo) {
                e.querySelector('input').required = false;
            }
        });

    }

    mostrarCampos();

</script>

</body>
</html>
