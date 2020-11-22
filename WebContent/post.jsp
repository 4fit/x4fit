<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${title}</title>
	<link rel="icon" type="image/png" href="images/logo.png"/>
	<link rel="Stylesheet" href="styles/style.css" type="text/css" />
	<link rel="Stylesheet" href="styles/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
	<link href="https://fonts.googleapis.com/css2?family=Bungee+Shade&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
	<script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>
	<script src="https://cdn.jsdelivr.net/highlight.js/latest/highlight.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/highlight.js/latest/styles/github.min.css">
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand logo" href="${pageContext.request.contextPath}/">X4FIT
  </a>
  <a class="navbar-brand" href="${pageContext.request.contextPath}/about.jsp">ABOUT</a>
  </nav>
	<div class="container">
		<form action="${pageContext.request.contextPath}/Post">	
			<textarea id="content" >${content}</textarea>
		</form>
  </div>
  <script type="text/javascript">
	 	const simplemde = new SimpleMDE({
			element: document.getElementById("content"),
			status: false,
			toolbar: false,
			spellChecker: false,
		});
		simplemde.togglePreview();
  </script>
</body>
</html>