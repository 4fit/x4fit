<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tạo bài viết</title>
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/images/logo2.png" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/post.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/post_editor.css">
<script src="${pageContext.request.contextPath}/scripts/post.js"></script>
<!-- GetBootstrap -->
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

<!-- MD Bootstrap CDN -->
<!-- Bootstrap core CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Material Design Bootstrap -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css"
	rel="stylesheet">
<!-- JQuery -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand logo"
			href="${pageContext.request.contextPath}/">X4FIT</a> <a
			class="navbar-brand"
			href="${pageContext.request.contextPath}/about.jsp">ABOUT</a>
	</nav>
	<div class="container">
		<h3 align="center">TẠO BÀI VIẾT</h3>
		<form action="${pageContext.request.contextPath}/create" method="post">
			<div class="form-group">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Tiêu đề</span>
					</div>
					<input type="text" class="form-control"
						placeholder="Tiêu đề bài viết" name="title">
				</div>
				<div>
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text" id="basic-addon1">Category</span>
						</div>
						<input type="text" class="form-control"
							placeholder="Chủ đề bài viết" name="category">
					</div>
<!-- 					<div class="input-group mb-3"> -->
<!-- 						<div class="input-group-prepend"> -->
<!-- 							<span class="input-group-text" id="basic-addon1">Thumbnail</span> -->
<!-- 						</div> -->
<!-- 						<div class="custom-file"> -->
<!-- 							<label class="custom-file-label" for="customFileLang"></label>  -->
<!-- 							<input type="file" class="custom-file-input" id="customFileLang" lang="vi"> -->
<!-- 						</div> -->
<!-- 					</div> -->
				</div>
				<textarea name="content" id="content"></textarea>
				<input class="btn btn-primary btn-sm btn-block" type="submit"
					value="Post">
			</div>
		</form>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">Images</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<jsp:include page="../upload.jsp" /> 
				</div>
				<hr>
				<div align="center">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<hr>

	<script type="text/javascript">
		content = Editor();

		$('.image-upload-wrap').bind('dragover', function() {
			$('.image-upload-wrap').addClass('image-dropping');
		});
		$('.image-upload-wrap').bind('dragleave', function() {
			$('.image-upload-wrap').removeClass('image-dropping');
		});

		$('.upload-btn').hide();
		$('.remove-btn').hide();

		function insertImage(simplemde, url)
		{
			var pos = simplemde.codemirror.getCursor();
			simplemde.codemirror.setSelection(pos, pos);
			simplemde.codemirror.replaceSelection("![Figure](" + url + ")");
			
		}
	</script>
</body>
</html>