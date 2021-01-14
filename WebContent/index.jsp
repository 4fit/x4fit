<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Trang chủ</title>
	<link rel="icon" type="image/png" href="images/logo2.png" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<link href="https://fonts.googleapis.com/css2?family=Bungee+Shade&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/home.css" />
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<!------------------------------THANH BAR------------------------------>
	<div class="bg-dark py-md-1 py-05">
		<div class="container">
			<div class="row d-flex align-items-center justify-content-between">
				<div class="feed-bar">
					<div class="feedbar-wrapper">
						<ul class="feed-links">
							<li class="feedbar-item">
							</li>
							
							<li class="feedbar-item nuxt-link-exact-active active">
								<a href="#" class="feed-link posts-newest">
									<div class="el-badge badge-has-new"> Newest 
									<sup
											class="el-badge__content el-badge__content--undefined is-fixed"
											style="display: none;"></sup>
									</div>
							</a></li>

							<li class="feedbar-item">
								<a href="/followings" class="feed-link posts-subscriptions" aria-current="page">
									<div class="el-badge badge-has-new"> Followings 
										<sup class="el-badge__content el-badge__content--undefined is-fixed" style="display: none;">
										</sup>
									</div>
							</a>
							</li>
							<li class="feedbar-item">
								<a href="/clip/posts" class="feed-link posts-clip">
									<div class="el-badge badge-has-new"> My Clips 
										<sup class="el-badge__content el-badge__content--undefined is-fixed" style="display: none;"></sup>
									</div>
							</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-9 content-main ">

			<!----------------------------------BOOKMARKS--------------------------------------->

			<div id="Bookmarks" class="tabcontent">
				<div class="jumbotron jumbotron-fluid">
<!-- 					<div class="btn-group dropdown"> -->
<!-- 						<button type="button" class="btn">Sort by:</button> -->
<!-- 						<label class="sorttype"> Publish date</label> -->
<!-- 						<button type="button" class="btn dropdown-toggle dropdown-toggle-split" -->
<!-- 							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> -->
<!-- 							<span class="sr-only">Toggle Dropdown</span> -->
<!-- 						</button> -->
<!-- 						<div class="dropdown-menu"> -->
<!-- 							<a class="dropdown-item" href="#">Publish date</a> <a -->
<!-- 								class="dropdown-item" href="#">Clip date</a> -->
<!-- 						</div> -->
<!-- 					</div> -->
					
					<c:forEach var="p" items="${topPosts}" begin="0" end="${topPosts.size()}" varStatus="loop">
						<div class="card bg-light" style="margin-top: 1.5em; margin-bottom: 1.5em; ">
						  <h6 class="card-header" style="padding: 0.5rem 1.25rem;">
						  	<img class="img-pro-post float-left"
									src="${pageContext.request.contextPath}/images/${lstAuthors.get(loop.index).getAvatar() }" 
									alt="${lstAuthors.get(loop.index).getFullname() }">
								<a style="margin: 10px;" href="#">
									${lstAuthors.get(loop.index).getFullname() }
								</a>
								<br>
								<small><span style="margin: 10px;">${p.getPublished_at()}</span></small>
							</h6>
						  <div class="card-body">
						    <h3 class="card-title">
						    	<a href="${pageContext.request.contextPath}/post?p=${p.getURL()}">
								 			${p.getTitle() }
									</a>
									<br>
									<h6>
									<span class="viewtag t ml-20"> 
										<i class="far fa-eye"></i>
										<label class="view"> ${p.getViews_count()}</label>
									</span> 
									<span class="viewtag t "> 
										<i class="fas fa-paperclip"></i>
										<label class="view"> ${p.getClips_count()}</label>
									</span> 
									<span class="viewtag t"> 
										<i class="far fa-comment"></i>
										<label class="view"> ${p.getCommentsCount()}</label>
									</span>
									<a class="badge badge-info" style="margin-left: 20px;" href="#">${p.getCategory() }</a>
									</h6>
						    </h3>
						    <p class="card-text">${p.getShortContent()}...</p>
						    <a href="${pageContext.request.contextPath}/post?p=${p.getURL()}" 
						    		class="btn btn-primary">Đọc tiếp...</a>
						  </div>
						</div>
						
					</c:forEach>
				</div>
			</div>
		</div>

		<!------------------------------Top AUTHORT---------------------------->
		<div class="list-static col-lg-3 hidden-md-down float-right">
			<ul class="list-group ">
				<li class="label">
					<h3>TOP AUTHORS</h3>
				</li>
				<li
					class="list-group-item  d-flex justify-content-between align-items-center">
					<div class="d-flex exhibition-item user ">
						<a class="d-flex img-user-div" href="#"> 
						<img alt="" 
							class="avatar-user float-left"
							src="${pageContext.request.contextPath}/images/avt.png">
						</a>
						<div class="user-info overflow-hidden">
							<a class="username">Minh Hoàng</a>
							<div class="user-icon">
								<span class="viewtag t "> <i class="fas fa-user-plus"></i><label
									class="view">16</label>
								</span> <span class="viewtag t"> <i class="far fa-edit"></i><label
									class="view">16</label>
								</span>
							</div>
							<div class="follow">
								<button class="btn btn-follow" type="button">Follow</button>
							</div>
						</div>

					</div>
				</li>
				<li
					class="list-group-item d-flex w-100 justify-content-between align-items-center">

					<div class="d-flex exhibition-item user mt-2">
						<a class="d-flex img-user-div pt-1" href="#"> 
						<img alt="" 
							class="avatar-user float-left"
							src="${pageContext.request.contextPath}/images/avt.png">
						</a>
						<div class="user-info overflow-hidden">
							<a class="username">Minh Hoàng</a>
							<div class="user-icon">
								<span class="viewtag t "> <i class="fas fa-user-plus"></i><label
									class="view">16</label>
								</span> <span class="viewtag t"> <i class="far fa-edit"></i><label
									class="view">16</label>
								</span>
							</div>
							<div class="follow">
								<button class="btn btn-follow" type="button">Follow</button>
							</div>
						</div>

					</div>
				</li>
				<li
					class="list-group-item d-flex justify-content-between align-items-center">
					<div class="d-flex exhibition-item user mt-2">
						<a class="d-flex img-user-div pt-1" href="#"> 
						<img alt=""
							class="avatar-user float-left"
							src="${pageContext.request.contextPath}/images/avt.png">
						</a>
						<div class="user-info overflow-hidden">
							<a class="username">Minh Hoàng</a>
							<div class="user-icon">
								<span class="viewtag t "> <i class="fas fa-user-plus"></i><label
									class="view">16</label>
								</span> <span class="viewtag t"> <i class="far fa-edit"></i><label
									class="view">16</label>
								</span>
							</div>
							<div class="follow">
								<button class="btn btn-follow" type="button">Follow</button>
							</div>
						</div>

					</div>
				</li>

			</ul>
		</div>

	</div>
	<script>
    document.getElementById("dropdownMenu2").onclick=function(){
    	if(document.getElementsByClassName("dropdown-menu")[0].style.display=="block")
    	{
    		document.getElementsByClassName("dropdown-menu")[0].style.display="none";
    		document.getElementsByClassName("dropdown-menu")[0].style.top=	"60%";
    	}
    	else
    	{
    		document.getElementsByClassName("dropdown-menu")[0].style.display="block";
    		document.getElementsByClassName("dropdown-menu")[0].style.transition="top 1s"
    	      document.getElementsByClassName("dropdown-menu")[0].style.top=	"95%";
    	}
    
    }
    
    </script>
</body>
</html>