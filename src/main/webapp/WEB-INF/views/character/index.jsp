<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Spring-Data MVC Project</title>
	</head>
	<body>
		<c:if test="${not empty characters}">
		<table>
			<thead>
				<tr>
					<td>Name</td>
					<td>Class</td>
					<td>Level</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${characters}" var="item">
					<tr>
						<td>${item.name}</td>
						<td>${item.characterClass}</td>
						<td>${item.level}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		<c:if test="${empty characters}">
		<br /><span>Nothing to display.</span>
		</c:if>
	</body>
</html>