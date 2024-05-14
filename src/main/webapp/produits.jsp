<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <%@ include file="header.jsp"  %>
    <title>Produits</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap-5.3.3-dist/css/bootstrap.min.css">
</head>
<body>
<p></p>
<div class="container col-md-10 col-md-offset-1">
<div class="card border-3">
    <div class="card-header text-white bg-primary">Recherche des produits</div>
    <div class="card-body">
        <form method="get" action="chercher.do">
            <label><b> Mot clé : </b></label>
            <input type="text" name="motCle" value="${model.motCle}">
            <button class="btn btn-primary" type="submit">Chercher</button>
        </form>
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Designation</th>
                <th>Prix</th>
                <th>Quantite</th>
                <th >Supprimer</th>
                <th >Edit</th>
            </tr>
            <c:forEach items="${model.produits}"  var="p" >
                <tr>
                    <td>${p.id}</td>
                    <td>${p.designation}</td>
                    <td>${p.prix}</td>
                    <td>${p.quantite}</td>
                    <td><a onclick="return confirm('Etes vous sure?')" class="btn btn-danger" href="supprimer.do?id=${p.id}">Supprimer</a></td>
                    <td><a class="btn btn-warning" href="edit.do?id=${p.id}">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</div>
</body>
</html>
