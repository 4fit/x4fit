<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${title}</title>
	<link rel="icon" type="image/png" href="images/logo.png" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/style.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/post.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/home.css" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<link href="https://fonts.googleapis.com/css2?family=Bungee+Shade&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/highlight.js/latest/styles/github.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>
	<script src="https://cdn.jsdelivr.net/highlight.js/latest/highlight.min.js"></script>
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
				<a class="nav-item nav-link active" href="#">Home <span
					class="sr-only">(current)</span></a> <a class="nav-item nav-link"
					href="#">Post</a> <a class="nav-item nav-link" href="#">Profile</a>
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

	<div class="container-fluid" style="margin-top: 30px">
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
					<div align="center">
						<button type="button" class="clip"
							data-original-title="Clip this post">
							<i class="fa fa-paperclip"></i>
						</button>
					</div>

					<!-- Share -->
					<div align="center">
						<a
							href="https://www.facebook.com/sharer.php?u=http://x4fit.herokuapp.com/post?p=${url}"
							target="_blank" type="button" class="share link--muted"
							data-original-title="Share bài viết lên Facebook"> <img
							src="https://img.icons8.com/color/48/000000/facebook.png" />
						</a> <a class="zalo-share-button share" data-href=""
							data-oaid="579745863508352884" data-layout="2" data-color="white"
							data-customize=true> <img
							src="https://img.icons8.com/ios-filled/48/4a90e2/zalo.png" />
						</a>
					</div>
				</div>
			</div>

			<!-- Content -->
			<div class="col-sm-8">
				<h1 align="center">
					<b>${title}</b>
				</h1>
				<textarea id="content" name="content">${content}</textarea>
				<br>
				
				<h4>Bình luận</h4>
				<form action="${pageContext.request.contextPath}/comment">
					<textarea id="cmt" name="cmt"></textarea>
					<div class="align-middle text-center">
						<input class="btn btn-primary" type="submit" value="Bình luận">
					</div>
				</form>
				<br>

				<div class="vote_comment">
					<div class="score">
						<button class="icon-btn vote" data-toggle="tooltip"
							data-placement="bottom" title="Upvote">
							<i aria-hidden="true" class="fa fa-chevron-up text-muted"></i>
						</button>

						<span class="point_vote_comment"><c:out value="${cmt.getPoints()}"></c:out></span>

						<button class="icon-btn vote" data-toggle="tooltip"
							data-placement="bottom" title="downvote">
							<i aria-hidden="true" class="fa fa-chevron-down text-muted"></i>
						</button>

					</div>

					<div class="action_with_comment d">
						<a class="reply_comment"> <span class="text-muted" id="reply">Reply</span>
						</a> <a class="share_comment"> <span class="text-muted">Share</span>
						</a>
					</div>

					<div class="more_comment">
						<div class="menu__post">
							<div class="dropdown_comment">

								<button type="button" class="dropbtn" data-toggle="tooltip"
									data-placement="bottom" title="Show more active">
									<i class="fa fa-ellipsis-h text-muted"></i>
								</button>

								<div class="dropdown-content">
									<a href="#"> repost</a>
								</div>
							</div>
						</div>
					</div>

				</div>

				<div class="list-comments">
					<%
						int i = 0;
					%>
					<c:forEach var="cmt" items="${comments}">
						<div class="user_comment_post">
							<div class="info_user_comment">

								<div class="img_user_comment_post">

									<img id="avt_comment" class="avatar--lg img-fluid"
										src="${pageContext.request.contextPath}/images/${listUserCmt.get(i).getAvatar()}"
										alt="">
								</div>

								<div class="info_username_comment">
									<a href="${listUserCmt.get(i).getUrl()}"><c:out
											value="${listUserCmt.get(i).getFullname()}"></c:out></a> <br /> <span
										class="text-muted">@author</span>
								</div>

								<div class="time_comment">
									<a>Created at:</a> <br /> <span class="text-muted"><c:out
											value="${cmt.getCreated_at()}"></c:out></span>
								</div>
							</div>

							<div class="content_comment" >
								<textarea id="comment" name="comment" rows="5">${cmt.getContent()}</textarea>
							</div>

						</div>
						<%
							i += 1;
						%>
					</c:forEach>
				</div>

			</div>
			<!-- Right -->
			<div class="col-sm-2">
				<div
					class="post-actions d-flex flex-column align-items-center mx-auto">
					<form action="${pageContext.request.contextPath}/edit?p=${url}"
						method="post">
						<input type="submit" value="EDIT" class="btn btn-primary">
					</form>
				</div>
			</div>
		</div>
		<hr>
	</div>

	<script src="${pageContext.request.contextPath}/scripts/post.js"></script>
	<script type="text/javascript">
		content = ViewContent(); 
		content.togglePreview();
		var listComments = ViewComments();
		listComments.forEach((comment) => comment.togglePreview());
		
		cmt = Comment("cmt");
  </script>
	<script src="https://sp.zalo.me/plugins/sdk.js"></script>
</body>
</html>