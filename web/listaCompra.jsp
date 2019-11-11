<%-- 
    Document   : listaCompra
    Created on : 11/11/2019, 03:17:14
    Author     : Cliente
--%>

<%@page import="br.com.fatecpg.db.Compras"%>
<%@page import="br.com.fatecpg.db.Customers"%>
<%@page import="br.com.fatecpg.db.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compras Usuario</title>
    </head>
   <body>
        <%@include file="WEB-INF/jspf/navbar.jspf"%>
        <h2><a href="customers.jsp">Clientes</a></h2>
        <h1>Produto</h1>
        <table border ="1">
            <tr>    
                <th>ID do Cliente</th>
          
                <th>Id do Produto</th>
          
                <th>Quantidade do Produto</th>
                
                <th>Preço</th>
                
                <th>Empresa</th>
                
            </tr>
            <% try{ %>
            <%int id = Integer.parseInt(request.getParameter("id"));%>
            <%for (Compras c: Compras.getList(id)) { %>
                <tr>
                 
                    
                    <td><%= c.getIdCliente()%></td>
                    <td><%= c.getIdProduto()%></td>
                    <td><%= c.getQuantidade()%></td>
                    <td><%= c.getPreco()%></td>
                    <td><%= c.getFrete()%></td>
                </tr>
                <% } %>
                <%} catch(Exception e) {%>
                <tr><td colspan="3"> Erro: <%= e.getMessage() %> </td></tr>
                <% } %>
        </table>
    </body>
</html>
