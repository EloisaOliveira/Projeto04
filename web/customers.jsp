<%-- 
    Document   : customers
    Created on : 04/11/2019, 15:58:32
    Author     : elois
--%>

<%@page import="br.com.fatecpg.db.Customers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes - JavaDB Sample</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navbar.jspf"%>
        <h1>Clientes</h1>
        <table border='1'>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>E-mail</th>
            </tr>
            <%try{%>
                <%for(Customers c: Customers.getList()){%>
                <tr>
                    <td><%= c.getId() %></td>
                    <td><%= c.getName() %></td>
                    <td><%= c.getEmail() %></td>
                </tr>
                <%}%>
            <%}catch(Exception e){%>
                <tr><td colspan="3">Erro: <%= e.getMessage()%></td></tr>
            <%}%>
        </table>
    </body>
</html>
