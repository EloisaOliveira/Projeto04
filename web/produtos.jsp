<%-- 
    Document   : produtos
    Created on : 10/11/2019, 21:13:59
    Author     : elois
--%>
<%@page import="br.com.fatecpg.db.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navbar.jspf"%>
        <h2><a href="manufacturer.jsp">Fabricas</a></h2>
        <h1>Fabricante</h1>
        <table border ="1">
            <tr>    
                <th>ID Fabrica</th>
                <th>ID Produto</th>
                <th>Codigo do Produto</th>
                <th>Preco</th>
                <th>Disponivel</th1>
                <th>Descricao</th1>
            </tr>
            <% try{ %>
            <%int id = Integer.parseInt(request.getParameter("id"));%>
            <%for (Product p: Product.getList(id)) { %>
                <tr>
                    <td><%= p.getIdFabricante()%></td>
                    <td><%= p.getId()%></td>
                    <td><%= p.getCodigo() %></td>
                    <td><%= p.getPreco() %></td>
                    <td><%= p.getDisponibilidade() %></td>
                    <td><%= p.getDescricao() %></td>
                </tr>
                <% } %>
                <%} catch(Exception e) {%>
                <tr><td colspan="3"> Erro: <%= e.getMessage() %> </td></tr>
                <% } %>
        </table>
    </body>
</html>
