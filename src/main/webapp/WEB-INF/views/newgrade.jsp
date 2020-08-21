<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grades</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<link href="/temp.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h1>New grade</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Type</th>
					<th>Score</th>
					<th>Total</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${grades}" varStatus="loop">
					<p>
						<c:if test="${grades.last}">
           [last element]
       </c:if>
						Item ${grades}
					</p>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn link" href="/grades">Back to List</a>
	</div>
</body>
</html>