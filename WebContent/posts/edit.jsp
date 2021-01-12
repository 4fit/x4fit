<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>[Edit] ${title}</title>
	<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath}/images/logo2.png" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/post.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/post_editor.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/styles/home.css">
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
	<nav id="navbar" class="navbar navbar-expand-md navbar-light sticky-top">
		<!-- Logo -->
		<div>
			<a class="navbar-brand logo"
				href="${pageContext.request.contextPath}/">X4FIT </a>
		</div>
		
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
<!-- 				<a class="nav-item nav-link" href="#">Post</a>  -->
<!-- 				<a class="nav-item nav-link" href="#">Profile</a> -->
				<div class="input-group mb-10">
					<input type="text" class="form-control" placeholder="Search"
						aria-label="Username" aria-describedby="basic-addon1">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1"><i
							class="fas fa-search"></i></span>
					</div>
				</div>
				<button class="btn btn-primary mt-1" type="button">
					<i class="fas fa-bell"></i>
				</button>
				<a href="posts/create-post.jsp">
					<button class="btn btn-secondary mt-1" type="button">
						<i class="fas fa-edit"></i>
					</button>
				</a>
	
			</div>
		</div>
		<div class="img-pro"></div>
		<button type="button" class="btn dropdown-toggle"
			data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			<img class="img-profile"
				src="${pageContext.request.contextPath}/images/avt.png" alt="">
		</button>
		<div class="dropdown-menu dropdown-menu-right ">
			<div class="dropdown-item profile-popup">
				<img class="img-profile"
					src="${pageContext.request.contextPath}/images/avt.png" alt="">
				<div class="info-popup">
					<h5 class="name-info">Hoang</h5>
					<p class="gmail-info">hoang1811@gmail.com</p>
					<button class="btn btn-primary btn-edit" type="button">Edit</button>
	
				</div>
			</div>
			<div class="dropdown-divider"></div>
			<a class="dropdown-item" href="#">Profile</a> <a
				class="dropdown-item" href="#">My content</a>
			<div class="dropdown-divider"></div>
			<a class="dropdown-item" href="#">Sign out</a>
		</div>
	</nav>
	<div class="container">
		<h3 align="center">CHỈNH SỬA BÀI VIẾT</h3>
		<form action="${pageContext.request.contextPath}/save?p=${p}" method="post">
			<input type="hidden" name="title" value="${title}">
			<div class="form-group">
				<div class="mb-3" style="display: flex;" align="center">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Tiêu đề</span>
					</div>
					<input type="text" class="form-control" name="new_title" value="${title}">
				</div>
				<div class="mb-3" style="display: flex;">
					<div class="input-group-prepend">
						<span class="input-group-text" id="basic-addon1">Category</span>
					</div>
					<input type="text" class="form-control" name="category" value="${category}" width="100%">
					<!-- Status -->
					
					<div class="input-group-prepend">
						<span class="" id="basic-addon1">
							<span class="input-group-text custom-control custom-switch">
						  	<input type="checkbox" class="custom-control-input" 
						  		<c:if test="${is_public == true}">checked</c:if>
						  		id="is_public" name="is_public">
							  <label class="custom-control-label" for="is_public">Public</label>
							</span>
						</span>
					</div>
				</div>
				
<!-- 				<div> -->
<!-- 					<div class="input-group mb-3"> -->
<!-- 						<div class="input-group-prepend"> -->
<!-- 							<span class="input-group-text" id="inputGroupFileAddon01">Ảnh thumbnail</span> -->
<!-- 						</div> -->
<%--  						<input type="text" class="form-control" name="thumbnail_url">${thumbnail_url}  --%>
<!-- 					</div> -->
<!-- 				</div> -->
				<textarea name="content" id="content">${content}</textarea>
				<input class="btn btn-primary btn-sm btn-block" type="submit" value="LƯU">
			</div>
		</form>
	</div>
	
	<jsp:include page="../modal.jsp"></jsp:include>
	<hr>

	<script src="${pageContext.request.contextPath}/scripts/post.js"></script>
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

	</script>
</body>
</html>