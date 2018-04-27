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
			<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1">
				<div class="page-header">
					<h1>Cadastro de Informações de Países</h1>
				</div>
			</div>
			<form class="form-horizontal" action="paises" method="POST">
				<input type="hidden" id="id" name="id" value="${ pais.id }" />
				<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1">
					<div class="well well-lg">
						<div class="form-group">
							<label class="control-label col-sm-2" for="nome">Nome:</label>
							<div class="col-lg-8 col-md-8 col-sm-8">
								<input type="text" class="form-control" id="nome" name="nome" value="${ pais.nome }" placeholder="Insira o nome do país" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="populacao">População:</label>
							<div class="col-lg-2 col-md-2 col-sm-2">
								<input type="number" class="form-control" id="populacao" name="populacao" value="${ pais.populacao }" placeholder="População estimada de habitantes do país">
							</div>
							<label class="control-label col-sm-2" for="area">Área:</label>
							<div class="col-lg-2 col-md-2 col-sm-2">
								<input type="number" class="form-control" id="area" name="area" value="${ pais.area }" placeholder="População estimada de habitantes do país">
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-success" name="acao" value="Gravar">Gravar País</button>
								<button type="button" class="btn btn-primary" onclick="backPage()">Voltar</button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</section>
	
	<script type="text/javascript">
		function backPage(){
			window.history.back();
		}
	</script>

	<script src="./js/jquery.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>