<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Tạo bài viết</title>
	<link rel="icon" type="image/png" href="images/logo.png"/>
	<link rel="stylesheet" href="styles/style.css" type="text/css" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Bungee+Shade&display=swap">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/highlight.js/latest/styles/github.min.css">
	<script src="https://cdn.jsdelivr.net/highlight.js/latest/highlight.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>
	<script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand logo" href="${pageContext.request.contextPath}/">X4FIT</a>
	  <a class="navbar-brand" href="${pageContext.request.contextPath}/about.jsp">ABOUT</a>
  </nav>
  <div class="container">
  	<h3 align="center">TẠO BÀI VIẾT</h3>
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
					  <input type="text" class="form-control" placeholder="Tối đa 5 tags" name="tags">
					</div>
					<div class="input-group mb-3">
					  <div class="input-group-prepend">
					    <span class="input-group-text" id="inputGroupFileAddon01">Ảnh thumbnail</span>
					  </div>
					  <input type="text" class="form-control" placeholder="Nhập đường link đến ảnh thumbnail" name="thumbnail_url">
					  <!-- 
					  <div class="custom-file">
					    <input type="file" class="custom-file-input" name="image" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
					    <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
					  </div>
					  -->
					</div>
				</div>
				<textarea name="content" id="content"></textarea>
				<input class="btn btn-primary btn-sm btn-block" type="submit" value="Post">
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
							{
								name: "guide",
								action: (editor) => {
									var win = window.open("https://www.markdownguide.org/cheat-sheet/", '_blank');
									win.focus();
								},
								className: "fa fa-question-circle",
								title: "Markdown Guide",
							},
							],
		spellChecker: false,
		promptURLs: true,
		placeholder: "Bài viết có thể hiển thị với định dạng Markdown.",
		renderingConfig: {
	        codeSyntaxHighlighting: true,
	  },
	});
  
  </script>
</body>
</html>