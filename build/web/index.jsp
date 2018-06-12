<%-- 
    Document   : index
    Created on : Jun 7, 2018, 3:49:08 PM
    Author     : User name
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>index</title>
    </head>
    <body>
        <h1>CD list</h1>
        
        <table>
            <tr>
                <th>Description</th>
                <th class="right">Price</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td><c:out value='${product.description}'/></td>
                    <td class="right">${product.priceCurrencyFormat}</td>
                    <td>
                        <form action="cart" method="post">
                            <input type="hidden" name="productCode" value="<c:out value='${product.code}'/>">
                            <input type="submit" value="Add To Cart">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
