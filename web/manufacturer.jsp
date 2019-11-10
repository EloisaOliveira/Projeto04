<%-- 
    Document   : manufacturer
    Created on : 04/11/2019, 17:01:13
    Author     : elois
--%>

<%@page import="br.com.fatecpg.db.Manufacturer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fabricantes - JavaDB Sample</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/navbar.jspf"%>
        <h1>Fabricantes</h1>
        <table border='1'>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Cidade</th>
                <th>Estado</th>
            </tr>
            <%try{%>
                <%for(Manufacturer m: Manufacturer.getList()){%>
                <tr>
                    <%int id = m.getId();%>
                    <td><a href="produtos.jsp?id=<%=id%>"> <%= m.getId()%></a></td>
                    <td><%= m.getName() %></td>
                    <td><%= m.getEmail() %></td>
                    <td><%= m.getCidade() %></td>
                    <td><%= m.getEstado() %></td>
                </tr>
                <%}%>
            <%}catch(Exception e){%>
                <tr><td colspan="3">Erro: <%= e.getMessage()%></td></tr>
            <%}%>
        </table>
    </body>
</html>
