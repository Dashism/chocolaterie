<!-- Entête commune à toutes les pages/vues JSP. -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Entête d'import de classe Java permettant d'importer la définition d'une classe pour l'utiliser dans la page. -->
<%@ page import="java.time.LocalDate"%>
<!-- Import de la librarie JSTL core -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Entête HTML 5 standard -->
<!DOCTYPE html>
<html>
<head>
<!-- Cette balise gère les méta-données de la page, 
	toute les caractéristiques propres à la page. -->
<meta charset="ISO-8859-1">
<title>Boutique</title>

<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="js/eshop.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="css/eshop.css">
</head>
<body>
	<h1>
		Hello world JSP :
		<!-- Le symbole '=' après '%' signifie : insérer le résultat de l'unique
			instruction Java dans le code HTML -->
		<%=LocalDate.now()%>
		<!-- la méthode now() donne un objet de type LocalDate, pour écrire cet objet 
			en que texte dans le HTML, toString() est appelé implicitement. -->
	</h1>
	<div>
		<!-- La syntaxe ci-dessous sert à déclarer que la suite du fichier doit 
			être interpété comme du code Java et non du code HTML. -->
		<%
			// A l'intérieur des '%' on est dans le langage Java.
			String test = "-------=========== SUPER CHAINE ===========----------";
			System.out.println(test);
		%>
		<!-- Le symbole ci-dessus correspond à déclarer la fin du bloc de code Java,
			on est de nouveau en HTML -->
	</div>

	<!-- Si l'attribut de requête 'message' est vide ou null, alors on affiche le 
		contenu de cette balise if. -->
	<c:if test="${ empty message }">
		<h2>Choisissez vos chocolats :</h2>
		<form method="post" action="">
			<div>
				<label for="name">Nom</label> <input id="name" name="name">
			</div>
			<div>
				<label for="address">Adresse</label> <input id="address"
					name="address">
			</div>
			<div>
				<label for="choco">Type de chocolats</label>
				<select id="choco" name="choco">
					<option value="">----</option>
					<c:forEach var="chocoType" items="${chocoTypes}">
						<option id="${chocoType.id}"
							value="${chocoType.value}">${chocoType.label}</option>
					</c:forEach>
				</select>
				<div id="stockinfo">
				
				</div>
			</div>
			<button>Commander</button>
		</form>
		<h3>
			<a href="index.html">Retour à l'accueil</a>
		</h3>
	</c:if>

	<c:if test="${ not empty message }">
		<div>${message}</div>
		<h3>
			<a href="index.html">Retour à l'accueil</a>
		</h3>
	</c:if>
</body>
</html>