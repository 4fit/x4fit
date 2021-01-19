<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Navigator</title>
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
			<div class="navbar-nav" align="center">
				<div class="input-group mb-9">
					<form class="search-box" action = "${pageContext.request.contextPath}/search" method = "get" >
					  <div class="form-inline">
					     <input id = "text_search" value = "${ textSearch}"name = "textSearch" type="text" 
					     				class="form-control" style="width: 40vw;" placeholder="Search" aria-label="Search" aria-describedby="basic-addon1">
					      <div class="input-group-prepend">
					          <button name = "userCurrentAction" onclick = "highlightTextHome()" 
					          				value = "search_home" type = "submit" class = "btn btn-primary ">
					          	<i class="fas fa-search"></i>
					          </button>
					      </div>
					  </div>
					</form>			
				</div>
<!-- 				<button class="btn btn-primary mt-1" type="button"> -->
<!-- 					<i class="fas fa-bell"></i> -->
<!-- 				</button> -->
				<c:if test="${is_logged == true}">
				<a href="${pageContext.request.contextPath}/posts/create.jsp">
					<button class="btn btn-secondary mt-1" type="button">
						<i class="fas fa-edit"></i>
					</button>
				</a>
				</c:if>
	
			</div>
		</div>
		
		<c:if test="${is_logged == true}">
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
						<a href="${pageContext.request.contextPath}/profile" class="btn btn-primary btn-edit" type="button">Edit</a>
					</div>
				</div>
				<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="${pageContext.request.contextPath}/profile">Profile</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Sign out</a>
				</div>
		</c:if>
		<c:if test="${is_logged==false }">
				<div style="width: 5vw;">
					<a class="btn btn-primary" href="${pageContext.request.contextPath}/login">
					LOGIN</a>
				</div>
		</c:if>
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