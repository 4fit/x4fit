<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[Edit] ${title}</title>
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/images/logo.png" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/style.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/post.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Bungee+Shade&display=swap">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/highlight.js/latest/styles/github.min.css">
<script
	src="https://cdn.jsdelivr.net/highlight.js/latest/highlight.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand logo"
			href="${pageContext.request.contextPath}/">X4FIT</a> <a
			class="navbar-brand"
			href="${pageContext.request.contextPath}/about.jsp">ABOUT</a>
	</nav>
	<div class="container">
		<h3 align="center">CHỈNH SỬA BÀI VIẾT</h3>
		<form action="${pageContext.request.contextPath}/save?p=${p}"
			method="post">
			<input type="hidden" name="title" value="${title}">
			<div class="form-group">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Tiêu đề</span>
					</div>
					<input type="text" class="form-control" name="new_title" value="${title}">
				</div>
				<div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon1">Tags</span>
						</div>
						<input type="text" class="form-control" name="tags" value="${category}">
					</div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroupFileAddon01">Ảnh thumbnail</span>
						</div>
<%-- 						<input type="text" class="form-control" name="thumbnail_url">${thumbnail_url} --%>
					</div>
				</div>
				<textarea name="content" id="content">${content}</textarea>
				<input class="btn btn-primary btn-sm btn-block" type="submit"
					value="LƯU">
			</div>
		</form>
	</div>
	<hr>

	<script src="${pageContext.request.contextPath}/scripts/post.js"></script>
	<script type="text/javascript">
		content = Editor();
	</script>
</body>
</html>