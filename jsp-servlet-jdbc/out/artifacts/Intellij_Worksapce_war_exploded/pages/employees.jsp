<%@page import="com.mnr.pojo.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border ="1" width="500" align="center">
<tr bgcolor="00FF7F">
<th>Id</th>
<th>Pr�nom</th>
<th>Nom</th>
<th>D�partement</th>
</tr>
<jsp:useBean id="employees" beanName="employee" scope="request" 
             type="java.util.List<com.mnr.pojo.Employee>"/>
<%
for(Employee employee : employees){%>
	<tr>	
		<td><%=employee.getId() %></td>
		<td><%=employee.getFirstName() %></td>
		<td><%=employee.getLastName() %></td>
		<td><%=employee.getDepartement() %></td>
	</tr>
<%
}
%>
</table>
<br/><br/>
<a href="index.jsp">Acceuil</a>
</body>
</html>