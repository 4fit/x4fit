<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Tạo bài viết</title>
	<link rel="icon" type="image/png" href="images/logo.png"/>
	<link rel="Stylesheet" href="styles/style.css" type="text/css" />
	<link rel="Stylesheet" href="styles/create-post.css" type="text/css" />
	<link rel="Stylesheet" href="styles/bootstrap.min.css" type="text/css" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
	<link href="https://fonts.googleapis.com/css2?family=Bungee+Shade&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/highlight.js/latest/styles/github.min.css">
	<script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>
	<script src="https://cdn.jsdelivr.net/highlight.js/latest/highlight.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/">
			<img src="images/logo.png" width="16" class="d-inline-block align-top" alt="HOME" loading="lazy"/>
	  </a>
	  <a class="navbar-brand" href="${pageContext.request.contextPath}/about.jsp">ABOUT</a>
  </nav>
  <div class="container">
  	<h3>TẠO BÀI VIẾT</h3>
		<form action="${pageContext.request.contextPath}/CreatePost" method="post">
			<div class="form-group">
				<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text" id="basic-addon1">Tiêu đề</span>
				  </div>
				  <input type="text" class="form-control" placeholder="Tiêu đề bài viết" name="title">
				</div>
				<div>
					<div class="input-group mb-3">
					  <div class="input-group-prepend">
					    <span class="input-group-text" id="basic-addon1">Tags</span>
					  </div>
					  <input type="text" class="form-control" placeholder="Danh sách các tags" name="tags">
					</div>
					<div class="input-group mb-3">
					  <div class="input-group-prepend">
					    <span class="input-group-text" id="inputGroupFileAddon01">Ảnh thumbnail</span>
					  </div>
					  <div class="custom-file">
					    <input type="file" class="custom-file-input" name="thumbnail">
					    <label class="custom-file-label" for="thumbnail<">Choose file</label>
					  </div>
					</div>
				</div>
				<textarea name="content" id="content"></textarea>
				<input class="btn btn-primary align-middle" type="submit" value="Post">
			</div>
		</form>
	</div>
	<hr>
	<script type="text/javascript">
  const simplemde = new SimpleMDE({
		element: document.getElementById("content"),
		toolbar: ["bold", "italic", "strikethrough", "|",
							"heading-1", "heading-2", "heading-3","|",
							"unordered-list", "ordered-list", "link", "image", "table", "horizontal-rule", "|",
							"quote", "code", "|",
							"preview", "side-by-side", "fullscreen", "clean-block", "|",
							"guide",],
		spellChecker: false,
	});
  
  </script>
</body>
</html>