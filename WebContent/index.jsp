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
<%-- 	<jsp:include page="/home" /> --%>
	<header>
		<nav id="navbar"
			class="navbar navbar-expand-md navbar-light sticky-top">
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
					<a href="posts/create.jsp">
						<button class="btn btn-secondary mt-1" type="button">
							<i class="fas fa-edit"></i>
						</button>
					</a>
				</div>
			</div>
			<div class="img-pro"></div>
			<button type="button" class="btn dropdown-toggle"  id="dropdownMenu2"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<img class="img-profile" src="${pageContext.request.contextPath}/images/avt.png" alt="">
			</button>
			<div class="dropdown-menu dropdown-menu-right ">
				<div class="dropdown-item profile-popup">
					<img class="img-profile"
						src="${pageContext.request.contextPath}/images/avt.png" alt="">
					<div class="info-popup">
						<h5 class="name-info"><a href="${pageContext.request.contextPath}/profile">Hoang</a></h5>
						<p class="gmail-info">hoang1811@gmail.com</p>
						<button class="btn btn-primary btn-edit" type="button">Edit</button>

					</div>
				</div>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="">Profile</a> <a
					class="dropdown-item" href="#">My content</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#">Sign out</a>
			</div>
		</nav>

	</header>
	<!--  
	<div class="banner container-fluid">
		<div class="container px-0 pl-0">
			<img class="img-banner img-fluid"
				src="${pageContext.request.contextPath}/images/A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg" alt="">
		</div>
	</div>
	-->
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
							
<!-- 							<li class="feedbar-item"> -->
<!-- 								<a href="#" class="feed-link posts-trending"> -->
<!-- 									<div class="el-badge badge-has-new"> -->
<!-- 										Trending <sup -->
<!-- 											class="el-badge__content el-badge__content--undefined is-fixed" -->
<!-- 											style="display: none;"></sup> -->
<!-- 									</div> -->
<!-- 							</a></li> -->

							<li class="feedbar-item">
								<a href="/clip/posts" class="feed-link posts-clip">
									<div class="el-badge badge-has-new"> My Clips 
										<sup class="el-badge__content el-badge__content--undefined is-fixed" style="display: none;"></sup>
									</div>
							</a></li>
						</ul>
					</div>
				</div>
<!-- 				<a href="posts/create.jsp" -->
<!-- 					class="btn btn-primary float-right text-uppercase hidden-md-down mr-2" -->
<!-- 					style="font-size: 13px; font-weight: 600; font-family: sans-serif;"> -->
<!-- 					<i aria-hidden="true" class="fas fa-pencil-alt"></i> Create Post -->
<!-- 				</a> -->
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
						<div class="post-div container">
							<img class="img-pro-post float-left"
								src="${pageContext.request.contextPath}/images/${lstAuthors.get(loop.index).getAvatar() }" 
								alt="${lstAuthors.get(loop.index).getFullname() }">
							<a class="name-pro-post display-9">
								${lstAuthors.get(loop.index).getFullname() }
							</a>
							<br>
							<p class="postime">${p.getPublished_at()}</p>
							<a class="lead ml-2 title-post" 
								 href="${pageContext.request.contextPath}/post?p=${p.getURL()}">${p.getTitle() }</a>
							<div class="tag d-flex">
								<button class="btn-secondary">${p.getCategory() }</button>
	
							</div>
							<span class="viewtag t ml-20"> <i class="far fa-eye"></i><label
								class="view">${p.getViews_count() }</label>
							</span> <span class="viewtag t "> <i class="fas fa-paperclip"></i><label
								class="view">${p.getClips_count(p) }</label>
							</span> <span class="viewtag t"> <i class="far fa-comment"></i></i><label
								class="view">16</label>
							</span>
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
						<a class="d-flex img-user-div" href="#"> <img
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
						<a class="d-flex img-user-div pt-1" href="#"> <img
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
						<a class="d-flex img-user-div pt-1" href="#"> <img
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