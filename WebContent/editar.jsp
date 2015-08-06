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
<title>Edição de Pessoa</title>
</head>
<body>
	<h3>Editar Pessoa</h3>
	<a href="cadastro.jsp">Voltar</a> para página de cadastro.
	<hr/>
	
	<html:form method="post" action="ControllerPessoa.do?cmd=atualizar">
	
	Código: <html:text property="pessoa.idPessoa" readonly="true"/><br/><br/>
	Informe o nome: <html:text property="pessoa.nome"/><br/><br/>
	Informe o email: <html:text property="pessoa.email"/><br/><br/>
	Informe o cpf: <html:text property="pessoa.cpf"/><br/><br/>
	Informações Complementares: <br/>
	<html:textarea property="pessoa.infosComp"/><br/><br/>
	<html:submit value="Atualizar!" />
	
	<p style="color: green;">
		<b><bean:write name="msg" ignore="true" /></b>
	</p>
	
	<p style="color: red;">
		<b><bean:write name="erro" ignore="true" /></b>
	</p>
	
	</html:form>
	
</body>
</html>