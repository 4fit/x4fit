<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${title}</title>
	<link rel="icon" type="image/png" href="images/logo2.png" />
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
	<jsp:include page="../navbar.jsp"></jsp:include>

	<div class="container-fluid" style="margin-top: 30px">
		<div class="row">

			<!-- Left -->
			<div class="col-sm-2">
				<div class="post-actions d-flex flex-column mx-auto">

					<!-- Points -->
					<div class="vote" align="center">
						<button class="icon-btn" data-original-title="Upvote" 
										onclick="Vote(${postID}, 'POST', 1, '${pageContext.request.contextPath}/vote');
														 incrementValue('${postID}');">
							<i class="fa fa-caret-up"></i>
						</button>
						<br>
						<input	style="font-weight: bolder; height: 1em; background-color: transparent; border: none;" 
									disabled size="1" class="points" id="${postID}" value="${points}">
						<br>
						<button class="icon-btn" data-original-title="Downvote"
										onclick="Vote(${postID}, 'POST', 1, '${pageContext.request.contextPath}/vote');
														 decrementValue('${postID}');">
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

					<div align="center">
						<!-- Share -->
						<a
							href="https://www.facebook.com/sharer.php?u=http://x4fit.herokuapp.com/post?p=${url}"
							target="_blank" type="button" class="share link--muted" data-original-title="Share bài viết lên Facebook"> 
							<img src="https://img.icons8.com/color/48/000000/facebook.png" />
						</a> 
						<a class="zalo-share-button share" data-href="" data-oaid="579745863508352884" data-layout="2" data-color="white" data-customize=true> 
							<img src="https://img.icons8.com/ios-filled/48/4a90e2/zalo.png" />
						</a>
						
						<br>
						
						<c:if test="${is_author}">
							<!-- Edit -->
							<form action="${pageContext.request.contextPath}/edit?p=${url}" method="post">
								<button type="submit" value="EDIT" class="btn btn-primary">
									<i class="fa fa-edit"></i>
								</button>
							</form>
							<br>
						</c:if>
						
						<!-- Báo cáo -->
						<form action="${pageContext.request.contextPath}/report?p=${url}" method="post">
							<button type="submit" value="REPORT" class="btn btn-danger">
								<i class="fa fa-flag"></i>
							</button>
						</form>
					</div>
				</div>
			</div>

			<!-- Content -->
			<div class="col-sm-8">
				<h1 align="center" style="margin: 20px;">
					<b>${title}</b>
				</h1>
				<textarea id="content" name="content">${content}</textarea>
				<br>
				
				<h4>Bình luận</h4>
				<form action="${pageContext.request.contextPath}/comment" method="post">
					<textarea id="comment" name="comment"></textarea>
					<br>
					<div class="align-middle text-center">
						<input type="hidden" value="${postID}" name="postID">
						<input type="hidden" value="${url}" name="url">
						<input class="btn btn-primary" type="submit" value="Bình luận">
					</div>
				</form>
				<br>
				<%
					int i = 0;
				%>
				<c:forEach var="cmt" items="${comments}">
					<div class="list-comments">
						<div class="user_comment_post">
							<div class="info_user_comment">

								<div class="img_user_comment_post">

									<img id="avt_comment" class="avatar--lg img-fluid"
										src="${pageContext.request.contextPath}/images/${listUserCmt.get(i).getAvatar()}"
										alt="">
								</div>

								<div class="info_username_comment">
									<a href="${listUserCmt.get(i).getUrl()}">
										<c:out value="${listUserCmt.get(i).getFullname()}"></c:out>
									</a> 
									<br /> 
									<c:if test="${is_author}">
										<span class="badge badge-info">@author</span>
									</c:if>
									<div class="time_comment">
										<span class="text-muted">${cmt.getCreated_at()}</span>
									</div>
								</div>
								
							</div>

							<div class="content_comment" >
								<textarea id="comment" name="comment" rows="5">${cmt.getContent()}</textarea>
							</div>

							<div class="vote_comment">
								<div class="action_with_comment">
									<span class="btn btn-danger btn-sm font-weight-bold">
										<input style="cursor: none; background-color:transparent; color:white; font-weight:bolder; border:none; text-align: right;" 
														disabled size="1" id="cmt${cmt.getID()}" value="${cmt.getPoints()}"/> 
										<i class="fa fa-heart" aria-hidden="true"></i>
									</span>
									<button type="submit" value="Upvote" class="btn btn-warning btn-sm font-weight-bold"
													onclick="Vote(${cmt.getID()}, 'COMMENT', 1, '${pageContext.request.contextPath}/vote');
																	 incrementValue('cmt${cmt.getID()}');">
										<i class="fas fa-thumbs-up"></i>&nbsp;Upvote
									</button>
									<button type="submit" value="Downvote" class="btn btn-dark btn-sm font-weight-bold"
													onclick="Vote(${cmt.getID()}, 'COMMENT', -1, '${pageContext.request.contextPath}/vote');
																	 decrementValue('cmt${cmt.getID()}');">
										<i class="fas fa-thumbs-down"></i>&nbsp;Downvote
									</button>
									
									<!-- More -->
									<div class="btn-group dropright">
									  <button type="button" class="btn btn-secondary btn-sm dropdown-toggle font-weight-bold" 
									  				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									    More
									  </button>
									  <div class="dropdown-menu">
									    <a class="dropdown-item" href="#">Action</a>
									    <a class="dropdown-item" href="#">Another action</a>
									    <a class="dropdown-item" href="#">Something else here</a>
									  </div>
									</div>
								
								</div>
								
							</div>
						</div>
						<%
							i += 1;
						%>
						</div>
				</c:forEach>
				
			</div>
			<!-- Right -->
			<div class="col-sm-2">
				
			</div>
		</div>
		<hr>
	</div>
	
	<jsp:include page="../modals/modalUpload.jsp"></jsp:include>
	<jsp:include page="../modals/modalReport.jsp"></jsp:include>

	<script src="${pageContext.request.contextPath}/scripts/post.js"></script>
	<script type="text/javascript">
		detailPost = ViewContent(); 
		detailPost.togglePreview();
		var listComments = ViewComments();
		listComments.forEach((comment) => comment.togglePreview());
		
		content = Comment();
		$('.image-upload-wrap').bind('dragover', function() {
			$('.image-upload-wrap').addClass('image-dropping');
		});
		$('.image-upload-wrap').bind('dragleave', function() {
			$('.image-upload-wrap').removeClass('image-dropping');
		});

		$('.upload-btn').hide();
		$('.remove-btn').hide();
  </script>
	<script src="https://sp.zalo.me/plugins/sdk.js"></script>
</body>
</html>