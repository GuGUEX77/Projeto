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

	<section class="tabela-paises">
		<div class="container">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>
						<span class="glyphicon glyphicon-globe"></span> Países
					</h3>
				</div>
				<div class="panel-body">
					<div class="col-lg-6 col-md-6 col-sm-6">
						<p>
							<div class="alert alert-info" role="alert">
								<span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
								Lista de países cadastrados no sistema
							</div>
						</p>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-6">
						<br />
						<div>
							<a href="paises?acao=Novo" type="button" class="btn btn-success" >Cadastrar Novo País</a>
						</div>
					</div>
				</div>
	
				<!-- Table -->
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>Nome</th>
							<th>População</th>
							<th>Área</th>
							<th>Funções</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="pais" items="${ paises }">
							<tr>
								<td>${ pais.id }</td>
								<td>${ pais.nome }</td>
								<td>${ pais.populacao }</td>
								<td>${ pais.area }</td>
								<td>
									<button type="button" class="btn btn-primary">Medalhas</button>
									<a href="paises?acao=Editar&id=${ pais.id }" type="button" class="btn btn-warning" >Consultar</a>
									<a href="paises?acao=Excluir&id=${ pais.id }" type="button" class="btn btn-danger">Excluir</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>

	<script src="./js/jquery.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>