<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="./css/bootstrap.min.css" />

<title>Olimpiadas</title>
</head>
<body>
	<!-- Import do Menu. -->
	<c:import url="Menu.jsp" />

	<section class="secao-feedback-gravacao">
		<div class="container">
			<div class="jumbotron">
				<h2>Operação com sucesso!</h2>
				<p>
					<div class="alert alert-success" role="alert">
						<strong>Sucesso!</strong> A operação realizada obteve êxito!	
					</div>
				</p>
				<p>
					<a class="btn btn-success btn-lg" href="inicio" role="button">Voltar</a>
				</p>
			</div>
		</div>
	</section>

	<script src="./js/jquery.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>