<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Navigator</title>
<!-- 	<link rel="icon" type="image/png" href="images/logo2.png" /> -->
<%-- 	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/style.css" /> --%>
<%-- 	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/post.css" /> --%>
<%-- 	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/home.css" /> --%>
<!-- 	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> -->
<!-- 	<link href="https://fonts.googleapis.com/css2?family=Bungee+Shade&display=swap" rel="stylesheet"> -->
<!-- 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"> -->
<!-- 	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"> -->
<!-- 	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script> -->
<!-- 	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script> -->
<!-- 	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> -->
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
				<div class="input-group mb-10">
					<form class="search-box" action = "${pageContext.request.contextPath}/search" method = "get" >
					    <div class = "d-flex">
					     <input id = "text_search" value = "${ textSearch}"name = "textSearch" type="text" 
					     				class="form-control" width="40%" placeholder="Search" aria-label="Username" aria-describedby="basic-addon1">
					      <div class="input-group-prepend">
					          <button name = "userCurrentAction" onclick = "highlightTextHome()" 
					          				value = "search_home" type = "submit" class = "btn btn-primary ">
					          	<i class="fas fa-search"></i>
					          </button>
					      </div>
					      </div>
					</form>			
				</div>
				<button class="btn btn-primary mt-1" type="button">
					<i class="fas fa-bell"></i>
				</button>
				<a href="${pageContext.request.contextPath}/posts/create.jsp">
					<button class="btn btn-secondary mt-1" type="button">
						<i class="fas fa-edit"></i>
					</button>
				</a>
	
			</div>
		</div>
		<button type="button" class="btn dropdown-toggle"
			data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			<img class="img-profile"
				src="${pageContext.request.contextPath}/images/avt.png" alt="">
		</button>
		<div class="dropdown-menu dropdown-menu-right ">
			<div class="dropdown-item profile-popup">
				<img class="img-profile"
					src="${pageContext.request.contextPath}/images/${user.getAvatar()}" alt="">
				<div class="info-popup">
					<h5 class="name-info">${user.getFullname() }</h5>
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
	 <script>
        function openPage(nampage, element) {
            var i, tabcontent, tablink;
            tabcontent = document.getElementsByClassName("tabcontent");
            for (i = 0; i < tabcontent.length; i++) {
                tabcontent[i].style.display = "none";
            }

            tablink = document.getElementsByClassName("tablink");
            for (i = 0; i < tablink.length; i++) {
                tablink[i].style.backgroundColor = "rgb(161, 161, 161)";
            }

            document.getElementById(nampage).style.display = "block";

            element.style.backgroundColor = "rgb(20, 20, 20)";
        }
       // openPage('Post',document.getElementById("defaultOpen"));     
       document.getElementById("defaultOpen").onclick();
    </script>
    
    <script>

    window.onload = function()
    {
    	highlightTextHome();
    };
     
	    function highlightTextHome() {
    		var text = document.getElementById("text_search").value;
    		
    	  var inputText = document.getElementsByClassName("title-post");
    	  for (var i = 0; i < inputText.length; i++)
    	 { 	var innerHTML = inputText[i].innerHTML;
		   	  var index = innerHTML.indexOf(text);
			  if (index >= 0) { 
			   innerHTML = innerHTML.substring(0,index) + "<span class='highlight'>" + innerHTML.substring(index,index+text.length) + "</span>" + innerHTML.substring(index + text.length);
			   inputText[i].innerHTML = innerHTML;
	  			}
    	 }
	    }
    </script>
</body>
</html>