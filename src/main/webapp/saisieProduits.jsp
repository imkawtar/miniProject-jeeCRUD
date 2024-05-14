<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <%@ include file="header.jsp"  %>
    <title>Siaisr produits</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap-5.3.3-dist/css/bootstrap.min.css">
</head>
<body>
<p></p>
<div class="container col-md-8 col-md-offset-2">
    <div class="card border-3">
        <div class="card-header text-white bg-primary fw-bold">Saisir d'un produit</div>
        <div class="card-body">
            <form method="post" action="saveProduit.do">
                <div class="form-group">
                    <label class="form-label fw-bold"> Designation</label>
                    <input class="form-control" type="text" value="${produit.designation}" name="designation" required>
                    <span></span>
                </div>
                <div class="form-group">
                    <label class="form-label fw-bold"> Prix</label>
                    <input class="form-control" value="${produit.prix}" type="text" name="prix">
                    <span></span>
                </div>
                <div class="form-group">
                    <label class="form-label fw-bold"> Quantite</label>
                    <input class="form-control" value="${produit.quantite}" type="text" name="quantite">
                    <span></span>
                </div>
                <div>
                    <button class="btn btn-primary mt-4 fw-bold" type="submit">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
