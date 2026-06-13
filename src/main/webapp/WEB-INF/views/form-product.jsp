<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${product.id != null ? 'Modifier le produit' : 'Ajouter un produit'}</title>
</head>
<body>
<h1>${product.id != null ? 'Modifier le produit' : 'Ajouter un produit'}</h1>

<form action="${pageContext.request.contextPath}/products" method="post">
    <input type="hidden" name="id" value="${product.id}"/>
    <div>
        <label for="libelle">Libellé :</label>
        <input type="text" id="libelle" name="libelle" value="${product.libelle}" required="required"/>
    </div>
    <div>
        <label for="prix">Prix :</label>
        <input type="number" id="prix" name="prix" value="${product.prix}" step="0.01" required="required"/>
    </div>
    <div>
        <button type="submit">Enregistrer</button>
        <a href="${pageContext.request.contextPath}/products">Annuler</a>
    </div>
</form>
</body>
</html>
