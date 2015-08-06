<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"
	prefix="logic"%>
<html>
<head>
<style type="text/css">
body {
	font-family: 'Verdana';
	font-size: 9pt;
	padding: 40px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Pessoa</title>
</head>
<body>
	<h3>Cadastro de Pessoa</h3>
	<a href="index.jsp">Voltar</a>
	<hr/>
	
	<html:form action="ControllerPessoa.do?cmd=cadastrar">
	
	Informe o nome: <html:text property="pessoa.nome"/><br/><br/>
	Informe o email: <html:text property="pessoa.email"/><br/><br/>
	Informe o cpf: <html:text property="pessoa.cpf"/><br/><br/>
	Informações Complementares: <br/>
	<html:textarea property="pessoa.infosComp"/><br/><br/>
	<html:submit value="Cadastrar!" />
	
	<p style="color: green;">
		<b><bean:write name="msg" ignore="true" /></b>
	</p>
	
	<p style="color: red;">
		<b><bean:write name="erro" ignore="true" /></b>
	</p>
	
	</html:form>
	
	<br/>
	<h3>Relação de Pessoas Cadastradas</h3>
	<hr/>
	
	<table border="1" style="width: 80%; font-size: 9pt;">
		<thead>
			<tr>
				<th>Código</th>
				<th>Nome da Pessoa</th>
				<th>Endereço de Email</th>
				<th>CPF</th>
				<th>Infos Comp</th>
				<th>Data Entrada</th>
				<th>Excluir</th>
				<th>Editar</th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate name="PessoaBean" property="listaPessoas" id="p">
				<tr>
					<td align="center"><bean:write name="p" property="idPessoa" /></td>
					<td align="center"><bean:write name="p" property="nome" /></td>
					<td align="center"><bean:write name="p" property="email" /></td>
					<td align="center"><bean:write name="p" property="cpf" /></td>
					<td align="center"><bean:write name="p" property="infosComp" /></td>
					<td align="center"><bean:write name="p" property="dataEntrada" format="dd/MM/yyyy" /></td>
					<td align="center"><a href='ControllerPessoa.do?cmd=excluir&id=<bean:write name="p" property="idPessoa"/>'>Excluir</a></td>
					<td align="center"><a href='ControllerPessoa.do?cmd=editar&id=<bean:write name="p" property="idPessoa"/>'>Editar</a></td>
				</tr>
			</logic:iterate>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5" align="center"><b>Quantidade de registro(s): <bean:size
						name="PessoaBean" property="listaPessoas" id="qtd" />
					<bean:write name="qtd" /></b></td>
				<td colspan="3" align="center"><a href=""> Gerar Relatório</a></td>
			</tr>
		</tfoot>
	</table>
	
	<p style="color: green;">
		<b><bean:write name="sucesso" ignore="true" /></b>
	</p>
	
	<p style="color: red;">
		<b><bean:write name="erro1" ignore="true" /></b>
	</p>
	
</body>
</html>