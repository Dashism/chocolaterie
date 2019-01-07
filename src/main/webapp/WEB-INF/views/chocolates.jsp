<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nos chocolats</title>
<link rel="stylesheet" href="css/chocolates.css">
</head>
<body>
	<h1>Nos chocolats !.</h1>
	<div class="chocoParent">
		<c:forEach var="type" items="${chocoTypes}">
			<div class="choco" style="background-image: url('${type.url}')">
				<h2>${type.label}</h2>
			</div>
		</c:forEach>
	</div>
	<h3>
		<a href="index.html">Retour à l'accueil</a>
	</h3>
</body>
</html>