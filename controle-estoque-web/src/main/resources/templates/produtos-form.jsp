<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Controle de Estoque</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h3 class="text-center">Formulário de cadastro de produtos</h3>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Add Produto</div>
				</div>
				<div class="panel-body">
					<form:form action="salvarProduto" cssClass="form-horizontal" method="post" modelAttribute="produto">

						<!-- need to associate this data with produto id -->
						<form:hidden path="id" />

						<div class="form-group">
							<label for="nome" class="col-md-3 control-label">Nome</label>
							<div class="col-md-9">
								<form:input path="nome" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="preco" class="col-md-3 control-label">Preço</label>
							<div class="col-md-9">
								<form:input path="preco" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="categoria" class="col-md-3 control-label">Categoria</label>
							<div class="col-md-9">
								<form:input path="categoria" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="fornecedor" class="col-md3 control-label">Fornecedor</label>
							<div class="col-md-9">
								<form:input path="fornecedor" cssClass="form-control"/>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-3 col-md-9">
								<form:button cssClass="btn btn-primary">Submit</form:button>
							</div>
						</div>

					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>