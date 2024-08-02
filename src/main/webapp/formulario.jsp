<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- IMPORTAR ETIQUETAS STRUTS Y JAVA SCRIPT -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<s:head/>
<sx:head/>
<body>
	<sx:tabbedpanel id="formUsercap">
		<sx:div label="FORMULARIO CRUD USERCAP">
			<s:form action="alta.action" method="post">
				<s:push value="usercap">
					<s:hidden key="id"></s:hidden>
					<s:textfield key="nombre" label="NOMBRE"></s:textfield>
					<s:radio name="genero" label="GENERO" list="#{'MASCULINO':'M', 'FEMENINO':'F'}"></s:radio>
					<s:select name="ciudad" label="CIUDAD" list="#{'Pue':'Puebla','Mor':'MORELOS','Tlax':'TLAXCALA','Ver':'Veracruz'}"></s:select>
					<s:textarea key="descripcion" label="DESCRIPCION"></s:textarea>
					<s:textarea key="desarrollador" label="TIENE EXPERIENCIA EN DESARROLLO WEB?"></s:textarea>
					<s:submit value="Aceptar"></s:submit>
					<s:reset value="Limpiar"></s:reset>
				</s:push>
			</s:form>
		</sx:div>
	</sx:tabbedpanel>
	
	<table>
		<tr>
			<td>ID</td>
			<td>NOMBRE</td>
			<td>GENERO</td>
			<td>CIUDAD</td>
			<td>DESCRIPCION</td>
			<td>DESARROLLADOR</td>
			<td>ACCIONES</td>
		</tr>
		<s:iterator value="listaUsercaps">
			<tr>
				<td><s:property value="id"/></td>
				<td><s:property value="nombre"/></td>
				<td><s:property value="genero"/></td>
				<td><s:property value="ciudad"/></td>
				<td><s:property value="descripcion"/></td>
				<td><s:property value="desarrollador"/></td>
				<td>
					<s:url id="editURL" action="editar">
						<s:param name="id" value="%{id}"></s:param>					
					</s:url>
					<s:a href="%{editURL}">Editar</s:a>
				</td>
				<td>
					<s:url id="deleteURL" action="baja">
						<s:param name="id" value="%{id}"></s:param>					
					</s:url>
					<s:a href="%{deleteURL}">Eliminar</s:a>
				</td>			
			</tr>
		</s:iterator>
	
	</table>

</body>
</html>