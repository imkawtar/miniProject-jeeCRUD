<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <%@ include file="header.jsp"  %>
    <title>Confirmation</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap-5.3.3-dist/css/bootstrap.min.css">
</head>
<body>
<p></p>
<div class="container col-md-8 col-md-offset-2">
    <div class="card border-3">
        <div class="card-header text-white bg-primary fw-bold">Confimation</div>
        <div class="card-body">
            <div class="form-group">
                <label>ID:</label>
                <label> ${produit.id}</label>
            </div>
            <div class="form-group">
                <label>Designation:</label>
                <label> ${produit.designation}</label>
            </div>
            <div class="form-group">
                <label>Prix:</label>
                <label> ${produit.prix}</label>
            </div>
            <div class="form-group">
                <label>Quantite:</label>
                <label> ${produit.quantite}</label>
            </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
