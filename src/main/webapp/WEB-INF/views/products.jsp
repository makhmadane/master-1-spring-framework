<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Liste des produits</title>
</head>
<body>
<h1>Liste des produits</h1>

<a href="${pageContext.request.contextPath}/products/new">Ajouter un produit</a>

<table border="1" cellpadding="5" cellspacing="0">
    <thead>
    <tr>
        <th>ID</th>
        <th>Libellé</th>
        <th>Prix</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.libelle}</td>
            <td>${product.prix}</td>
            <td>
                <a href="${pageContext.request.contextPath}/products/edit/${product.id}">Modifier</a>
                |
                <a href="${pageContext.request.contextPath}/products/delete/${product.id}"
                   onclick="return confirm('Supprimer ce produit ?');">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
