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
					<h1>Cadastro de Quadro de Medalhas</h1>
				</div>
			</div>
			<form class="form-horizontal" action="quadro_medalhas" method="POST">
				<input type="hidden" id="id" name="id" value="${ quadro.id }" />
				<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1">
					<div class="well well-lg">
						<div class="form-group">
							<label class="control-label col-sm-1" for="pais">País:</label>
							<div class="col-lg-2 col-md-2 col-sm-2">
								<select name="pais" id="pais" class="form-control" required="required">
									<option value="" selected disabled>Selecione</option>
									<c:forEach var="pais" items="${ paises }">
			                    		<option value="${ pais.id }">${ pais.nome }</option>
									</c:forEach>
								</select>
							</div>
							
							<label class="control-label col-sm-2" for="modalidade">Modalidade:</label>
							<div class="col-lg-2 col-md-2 col-sm-2">
								<select name="modalidade" id="modalidade" class="form-control" required="required">
									<option value="" selected disabled>Selecione</option>
									<c:forEach var="modalidade" items="${ modalidades }">
			                    		<option value="${ modalidade.id }">${ modalidade.nome }</option>
									</c:forEach>
								</select>
							</div>
							<label class="control-label col-sm-2" for="ano">Ano:</label>
							<div class="col-lg-2 col-md-2 col-sm-2">
								<select name="ano" id="ano" class="form-control" required="required">
									<option value="" selected disabled>Selecione</option>
									<c:forEach var="ano" items="${ anos }">
			                    		<option value="${ ano.ano }">${ ano.ano }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-1" for="nome">Ouro:</label>
							<div class="col-lg-2 col-md-2 col-sm-2">
								<input type="text" class="form-control" id="ouro" name="ouro" value="${ quadro.ouro }" placeholder="Ouros" required="required"/>
							</div>
							
							<label class="control-label col-sm-2" for="nome">Prata:</label>
							<div class="col-lg-2 col-md-2 col-sm-2">
								<input type="text" class="form-control" id="prata" name="prata" value="${ quadro.prata }" placeholder="Pratas" required="required"/>
							</div>
							
							<label class="control-label col-sm-2" for="nome">Bronze:</label>
							<div class="col-lg-2 col-md-2 col-sm-2">
								<input type="text" class="form-control" id="bronze" name="bronze" value="${ quadro.bronze }" placeholder="Bronzes" required="required"/>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-lg-10 col-lg-offset-1 col-md-10 col-lg-offset-1 col-sm-10 col-sm-offset-1">
								<button type="submit" class="btn btn-success" name="acao" value="Gravar">Gravar Quadro</button>
								<button type="button" class="btn btn-primary" onclick="backPage()">Voltar</button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</section>
	
	<script type="text/javascript">
		
		document.getElementById('pais').value = ${ quadro.pais.id };
		document.getElementById('modalidade').value = ${ quadro.modalidade.id };
		document.getElementById('ano').value = ${ quadro.ano.ano };
		
		function backPage(){
			window.history.back();
		}
	</script>

	<script src="./js/jquery.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>