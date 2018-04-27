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
					<h1>Cadastro de Informações de Modalidades</h1>
				</div>
			</div>
			<form class="form-horizontal" action="modalidades" method="POST">
				<input type="hidden" id="id" name="id" value="${ modalidade.id }" />
				<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1">
					<div class="well well-lg">
						<div class="form-group">
							<label class="control-label col-sm-2" for="nome">Nome:</label>
							<div class="col-lg-8 col-md-8 col-sm-8">
								<input type="text" class="form-control" id="nome" name="nome" value="${ modalidade.nome }" placeholder="Insira o nome da modalidade" required="required"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2" for="populacao">Tipo:</label>
							<div class="col-lg-2 col-md-2 col-sm-2">
								<select name="tipo" id="tipo" class="form-control" required="required">
									<c:if test="${ empty modalidade.tipo }">
										<option value="" selected disabled>Selecione</option>
			                    		<option value="I">Inverno</option>
			                    		<option value="V">Verão</option>
									</c:if>
									<c:if test="${ not empty modalidade.tipo }">
			                    		<option value="I" ${ modalidade.tipo == modalidade.inverno ? 'selected' : '' }>Inverno</option>
			                    		<option value="V" ${ modalidade.tipo == modalidade.verao ? 'selected' : '' }>Verão</option>
									</c:if>
									
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-success" name="acao" value="Gravar">Gravar Modalidade</button>
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