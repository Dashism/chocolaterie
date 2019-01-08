<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nos origines</title>
</head>
<body>
	<h1>Nos origines...</h1>
	<div>
		<!-- Utilisation d'une Map dans un forEach : chaque élément est un objet contenant
			la clé (key) et la valeur associée (value) -->
		<c:forEach var="mapItem" items="${typesByOrigin}">
			<div>
				<h3>${mapItem.key.text}</h3>
				<ul>
					<c:forEach var="type" items="${mapItem.value}">
						<li>${ type.label }</li>
					</c:forEach>
				</ul>
			</div>
		</c:forEach>
	</div>
	<h3>
		<a href="index.html">Retour à l'accueil</a>
	</h3>
</body>
</html>