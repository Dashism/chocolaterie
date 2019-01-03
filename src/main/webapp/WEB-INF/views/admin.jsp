<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<!-- Cette balise gère les méta-données de la page, 
	toute les caractéristiques propres à la page. -->
<meta charset="ISO-8859-1">
<title>Boutique</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="css/admin.css">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Administration des chocolats :</h1>
	<div class="container">
		<div class="chocoList">
			<table class="table table-stripped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Label</th>
						<th>Valeur</th>
						<th class="chocoActions">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="choco" items="${chocoTypes}">
						<tr>
							<td>${choco.id}</td>
							<td>${choco.label}</td>
							<td>${choco.value}</td>
							<td class="chocoActions">
								<a class="btn btn-danger" href="deleteChoco.html?id=${choco.id}">Supprimer</a>
								<a class="btn btn-primary" href="admin.html?id=${choco.id}">Modifier</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="chocoForm">
			<h2>${ isEdit ? "Modifier un type" : "Nouveau type" }:</h2>
			<form:form modelAttribute="chocoType" method="post">
				<c:if test="${isEdit}">
					<!-- Prise en compte de l'attribut id seulement pour la mise à jour. -->
					<form:hidden path="id" />
				</c:if>
				<div class="form-group">
					<label for="label">Libellé :</label>
					<form:input id="label" path="label" class="form-control" />
				</div>
				<div class="form-group">
					<label for="value">Valeur métier :</label>
					<form:input id="value" path="value" class="form-control" />
				</div>
				<button class="btn btn-primary">Valider</button>
				<button type="reset" class="btn btn-warning">Annuler</button>
				<a class="chocoNew btn btn-secondary" href="admin.html">Nouveau</a>
			</form:form>
		</div>
	</div>
</body>
</html>