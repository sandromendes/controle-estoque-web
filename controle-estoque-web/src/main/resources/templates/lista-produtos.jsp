<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Controle de Estoque</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<%@ page isELIgnored="false"%>
	<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h3 class="text-center">Tela de consulta de produtos</h3>
			<hr />

			<input type="button" value="Add Produto" onclick="window.location.href='showForm'; return false;" class="btn btn-primary" /> <br /> <br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Relação dos Produtos</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>Nome</th>
							<th>Preço</th>
							<th>Categoria</th>
							<th>Fornecedor</th>
							<th>Quantidade em Estoque</th>
						</tr>

						<!-- loop over and print our customers -->
						<c:forEach var="produto" items="${listaProdutos}">
							<c:url var="alterar" value="/produto/exibirFormAlterar"> <c:param name="produtoId" value="${produto.id}" /> </c:url>
							<c:url var="remover" value="/produto/deletarProduto"> <c:param name="produtoId" value="${produto.id}" /> </c:url>

							<tr>
								<td>${produto.nome}</td>
								<td>${produto.preco}</td>
								<td>${produto.categoria.nome}</td>
								<td>${produto.fornecedor.nome}</td>
								<td>${produto.estoque.quantidade}</td>
								<td>
									<a href="${alterar}">Update</a> | <a href="${remover}" onclick="if (!(confirm('Confirma a remoção do produto?'))) return false">Remover</a>
								</td>
							</tr>

						</c:forEach>

					</table>
				</div>
			</div>
		</div>

	</div>
	<div class="footer">
		<p>Footer</p>
	</div>
</body>

</html>