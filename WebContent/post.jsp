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
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
					integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" 
					crossorigin="anonymous">
	</script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" 
					integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" 
					crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
				integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
				crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" 
					integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" 
					crossorigin="anonymous">
	</script>
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
	<div class="container-fluid" style="margin-top:30px">
		<div class="row">
			<div class="col-sm-2">
				<h3>Left</h3>
				<!-- <%= request.getParameter("id")%> -->
			</div>
			<div class="col-sm-8">
				<textarea id="contents" name="contents">${contents}</textarea>
				<br>
				<h4>Bình luận</h4>
				<form action="${pageContext.request.contextPath}/comment">
					<textarea id="cmt" name="cmt"></textarea>
					<input class="btn btn-primary" type="submit" value="Bình luận">
				</form>
				<br>
				<textarea id="comments" name="comments">${comments}</textarea>
			</div>
			<div class="col-sm-2">
				<h3>Right</h3>
			</div>
		</div>
		<hr>
  </div>
  <script type="text/javascript">
	 	const content = new SimpleMDE({
			element: document.getElementById("contents"),
			toolbar: ["bold", "italic", "strikethrough", "|",
								"heading-1", "heading-2", "heading-3","|",
								"unordered-list", "ordered-list", "link", "image", "table", "horizontal-rule", "|",
								"quote", "code", "|",
								"preview", "side-by-side", "fullscreen", "clean-block", "|",
								"guide",],
			status: false,
			toolbar: false,
			spellChecker: false,
			renderingConfig: {
		        codeSyntaxHighlighting: true,
		  },
		});
	 	content.togglePreview();
		
		const comments = new SimpleMDE({
			element: document.getElementById("comments"),
			toolbar: ["bold", "italic", "strikethrough", "|",
								"heading-1", "heading-2", "heading-3","|",
								"unordered-list", "ordered-list", "link", "image", "table", "horizontal-rule", "|",
								"quote", "code", "|",
								"preview", "side-by-side", "fullscreen", "clean-block", "|",
								"guide",],
			status: false,
			toolbar: false,
			spellChecker: false,
			renderingConfig: {
		        codeSyntaxHighlighting: true,
		  },
		});
		comments.togglePreview();
		
		const cmt = new SimpleMDE({
			element: document.getElementById("cmt"),
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
								},],
			spellChecker: false,
			promptURLs: true,
			placeholder: "Bình luận có thể hiển thị với định dạng Markdown.",
			renderingConfig: {
		        codeSyntaxHighlighting: true,
		  },
		});
		
  </script>
</body>
</html>