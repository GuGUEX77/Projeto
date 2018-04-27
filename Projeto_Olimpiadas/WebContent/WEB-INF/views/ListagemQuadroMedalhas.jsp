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

	<section class="tabela-modalidades">
		<div class="container">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>
						<span class="glyphicon glyphicon-star"></span> Quadro de Medalhas
					</h3>
				</div>
				<div class="panel-body">
					<div class="col-lg-6 col-md-6 col-sm-6">
						<p>
							<div class="alert alert-info" role="alert">
								<span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
								Quadro de Medalhas de Países cadastrados.
							</div>
						</p>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-6">
						<br />
						<div>
							<a href="quadro_medalhas?acao=Novo" type="button" class="btn btn-success" >Cadastrar Quadro</a>
						</div>
					</div>
				</div>
	
				<!-- Table -->
				<table class="table">
					<thead>
						<tr>
							<th>País</th>
							<th>Ano</th>
							<th>Tipo</th>
							<th>Ouro</th>
							<th>Prata</th>
							<th>Bronze</th>
							<th>Total</th>
							<th>Funções</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="quadro" items="${ quadros }">
							<tr>
								<td>${ quadro.pais.nome }</td>
								<td>${ quadro.ano.ano }</td>
								<c:if test="${quadro.tipo == quadro.ano.inverno}">
									<td>Inverno</td>
								</c:if>
								<c:if test="${quadro.tipo == quadro.ano.verao}">
									<td>Verão</td>
								</c:if>
								<td>${ quadro.ouro }</td>
								<td>${ quadro.prata }</td>
								<td>${ quadro.bronze }</td>
								<td>${ quadro.ouro + quadro.prata + quadro.bronze }</td>
								<td>
									<a href="quadro_medalhas?acao=Editar&pais=${ quadro.pais.id }&ano=${ quadro.ano.ano }&modalidade=${ quadro.modalidade.id }" type="button" class="btn btn-warning">Consultar</a>
									<a href="quadro_medalhas?acao=Excluir&pais=${ quadro.pais.id }&ano=${ quadro.ano.ano }&modalidade=${ quadro.modalidade.id }" type="button" class="btn btn-danger">Excluir</a>
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