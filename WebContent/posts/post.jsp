<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${title}</title>
	<link rel="icon" type="image/png" href="images/logo.png"/>
	<link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/style.css" />
	<link rel="Stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/post.css" />
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" >
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" ></script>
	<link href="https://fonts.googleapis.com/css2?family=Bungee+Shade&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
	<script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>
	<script src="https://cdn.jsdelivr.net/highlight.js/latest/highlight.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/highlight.js/latest/styles/github.min.css">
	<style type="text/css">
		.post-actions {
	    position: -webkit-sticky;
	    position: sticky;
	    top: 0;
	    padding-top: 100px;
	    padding-bottom: 100px;
	    min-width: 50px;
	    max-width: 150px;
		}
		.vote {
			display: inline-block;
			outline: none!important;
		}
		.icon-btn {
	    padding: 0px 10px 0px;
	    margin: 0px 10px 0px;
	    border: 0;
	    background: none;
	    cursor: pointer;
	    text-decoration: none;
	    text-align: center;
	    align-items: flex-start;
	    font-size: 32px;
	    color: #9b9b9b;
		}
		.points{
			font-size: .6em;
	    height: .6em;
	    line-height: .6em;
	    color: #9b9b9b;
	    font-weight: 500;
	    font-size: 32px;
	    text-align: center;
	    align-content: center;
		}
		.clip {
		  width: 40px;
	    height: 40px;
	    font-size: 18px;
	    padding: 10px;
	    margin: 10px;
	    color: #adb5bd;
	    border: 2px solid #adb5bd;
	    border-radius: 50%;
	    box-shadow: 1px 3px 6px rgba(0,0,0,.2);
	    cursor: pointer;
	    outline: none!important;
	    line-height: 1;
    }
    .share {
			width: 48px;
	    height: 48px;
	    cursor: pointer;
	    line-height: 1;
	    outline: none!important;
	    display: flex;
	    flex-direction: column;
	    align-items: center;
    }
    
    .link--muted {
    	color: #9b9b9b!important;
		}
	</style>
</head>
<body>
	<nav class="navbar navbar-light bg-light sticky-top">
		<a class="navbar-brand logo" href="${pageContext.request.contextPath}/">X4FIT
  </a>
  <a class="navbar-brand" href="${pageContext.request.contextPath}/about.jsp">ABOUT</a>
  </nav>
	<div class="container-fluid" style="margin-top:30px">
		<div class="row">
		<!-- Left -->
			<div class="col-sm-2">
				<div class="post-actions d-flex flex-column mx-auto">
					<!-- Points -->
					<div class="vote" align="center">
						<button class="icon-btn" data-original-title="Upvote">
							<i class="fa fa-caret-up"></i>
						</button>
						<div class="points">+999</div>
						<button class="icon-btn" data-original-title="Downvote">
							<i class="fa fa-caret-down"></i>
						</button>
					</div>
					<!-- Clips -->
					<div  align="center">
						<button type="button" class="clip" data-original-title="Clip this post">
							<i class="fa fa-paperclip"></i>
						</button>
					</div>
					<!-- Share -->
					<div align="center">
						<a href="https://www.facebook.com/sharer.php?u=http://x4fit.herokuapp.com/post?p=${url}" target="_blank" 
							type="button" class="share link--muted" data-original-title="Share bài viết lên Facebook">
							<img src="https://img.icons8.com/color/48/000000/facebook.png"/>
						</a>
						<a class="zalo-share-button share" data-href="" data-oaid="579745863508352884" data-layout="2" 
							data-color="white" data-customize=true>
							<img src="https://img.icons8.com/ios-filled/48/4a90e2/zalo.png"/>
						</a>
					</div>
				</div>
			</div>
			<!-- Content -->
			<div class="col-sm-8">
				<h1>${title}</h1>
				<textarea id="content" name="content">${content}</textarea>
				<br>
				<h4>Bình luận</h4>
				<form action="${pageContext.request.contextPath}/comment">
					<textarea id="cmt" name="cmt"></textarea>
					<input class="btn btn-primary" type="submit" value="Bình luận">
				</form>
				<br>
				<textarea id="comments" name="comments">${comments}</textarea>
			</div>
			<!-- Right -->
			<div class="col-sm-2">
				<div class="post-actions d-flex flex-column align-items-center mx-auto">
					<form action="${pageContext.request.contextPath}/edit?p=${url}" method="post">
						<input type="submit" value="EDIT" class="btn btn-primary">
					</form>
				</div>
			</div>
		</div>
		<hr>
  </div>
  <script type="text/javascript">
	 	const content = new SimpleMDE({
			element: document.getElementById("content"),
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
  <script src="https://sp.zalo.me/plugins/sdk.js"></script>
</body>
</html>