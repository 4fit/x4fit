<%@ page language="java" contentType="text/html; charset= UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,model.User,java.util.Date,java.text.SimpleDateFormat,java.util.ArrayList,javax.annotation.Resource,javax.sql.DataSource"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<link rel="stylesheet" href="<c:url value='styles/home.css' />">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <scr src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></scr>
    <scr src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></scr>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<style>
@charset "ISO-8859-1";


@import url('https://fonts.googleapis.com/css2?family=Nunito:wght@600&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Mukta:wght@600&family=Nunito:wght@600&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Inconsolata:wght@300;400;500;600;700;800&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Asap:wght@400;500;600;700&family=Inconsolata:wght@300;400;500;600;800;900&display=swap');
* {
    padding: 0;
    margin: 0;
}

.section-title-line>.filler-line {
    margin-left: 1em;
    flex-grow: 1;
    border-color: #d6d6d7;
}

.search-box{
margin-top: 30px;
display: inline-block;
margin-left: 40px;
}

.search-box input{
display: inline-block !important;
}



.input-group-prepend{
display: inline-block !important;
}

body {
    background-color: #fff !important;
}

.logo {
    display: block;
}

.logo-link {
    font-size: 35px;
    font-weight: 900;
    font-family: 'Asap';
}

.logo-link span {
    margin-left: 5px !important;
    font-size: 26px;
    font-weight: 600;
    font-family: 'Mukta', sans-serif;
    letter-spacing: -2px;
}

.navbar {
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    background: rgb(245, 245, 245) !important;
    position: sticky !important;
    width: 100%;
    z-index: 10000;
    top: 0;
    float: left;
}

.navbar-nav {
    display: flex;
    flex: 2;
    justify-content: space-around;
    align-items: center;
}

.navbar-nav .btn {
    height: 40px;
    width: 50px;
    margin-left: 10px;
    margin-right: 5px;
    border: none;
    float: right;
    background: rgb(56, 53, 53);
}

.input-group {
    display: flex;
    margin-left: 350px;
}

@media (max-width:1250px) {
    .input-group {
        margin-left: 300px;
        animation: far 0.6s;
    }
}

@media (max-width:1120px) {
    .input-group {
        margin-left: 100px;
        animation: near 0.6s;
    }
}

@media (min-width:1120px) {
    .input-group {
        margin-left: 200px;
        animation: nearmin 0.6s;
    }
}

@media (min-width:1250px) {
    .input-group {
        margin-left: 300px;
        animation: nearmin1 0.6s;
    }
}

@media (max-width:900px) {
    .input-group {
        margin-left: 25px;
    }
}

@media (max-width:850px) {
    .input-group {
        width: 30px;
    }
}

@keyframes nearmin1 {
    0% {
        margin-left: 200px;
    }
    50% {
        margin-left: 250px;
    }
    100% {
        margin-left: 300px;
    }
}

@keyframes nearmin {
    0% {
        margin-left: 100px;
    }
    50% {
        margin-left: 150px;
    }
    100% {	
        margin-left: 200px;
    }
}

@keyframes near {
    0% {
        margin-left: 180px;
    }
    50% {
        margin-left: 150px;
    }
    100% {
        margin-left: 100px;
    }
}

.form-control {
    width: 500px;
}

.navbar-toggler {
    width: 50px;
    padding: 4px 5px;
}

.navbar-toggler-icon {
    width: 30px;
}

.navbar-nav .nav-item {
    margin-top: 10px;
    margin-left: 15px;
    font-size: 17px;
    color: #979797;
    font-weight: 700;
    font-family: 'Mukta';
}

.dropdown-toggle .img-profile {
    width: 30px;
    height: 30px;
    border-radius: 15px;
}

.dropdown-item .img-profile {
    width: 60px;
    height: 60px;
    border-radius: 30px;
}

.info-popup {
    display: block;
    margin-left: 5px;
    font-family: 'Inconsolata';
}

.profile-popup {
    display: flex !important;
    background: rgb(184, 184, 184) !important;
}

.gmail-info {
    font-size: 16px;
    margin-top: -5px;
    font-weight: 500;
}

.name-info {
    font-size: 17px;
    margin-top: -5px;
}

.btn-edit {
    height: 32px;
    width: 65px;
    margin-top: -10px;
    font-size: 14px;
    font-weight: 600;
    font-family: 'Mukta';
    border-radius: 5px;
}

.dropdown-item {
    padding-left: 20px !important;
    padding-right: 10px !important;
    font-size: 16px;
    font-weight: 500;
    font-family: 'Mukta';
    margin-top: 0px !important;
}

.dropdown-menu {
    top: 95% !important;
    margin-right: 10px !important;
    margin-top: 0px !important;
}


/*--------------------CONTENT----------------------------*/

.tablink {
    background: rgb(161, 161, 161);
    color: white;
    float: left;
    border: none;
    outline: none !important;
    cursor: pointer;
    padding: 14px 16px;
    font-size: 17px;
    width: 20%;
    font-family: 'Asap';
}

@media (max-width: 600px) {
    .tablink {
        font-size: 14px;
        animation: smalla 0.5;
    }
}

@media (max-width: 490px) {
    .tablink {
        font-size: 12px;
        padding-left: 0px;
        padding-right: 0px;
    }
}

@keyframes smalla {
    0% {
        font-size: 16px;
    }
    50% {
        font-size: 15px;
    }
    100% {
        font-size: 14px;
    }
}

.list-static {
    margin-top: 50px;
}

@media (max-width: 991.98px) {
    .hidden-md-down {
        display: none!important;
    }
}

.tablink:hover {
    background-color: #777;
}


/* Style the tab content (and add height:100% for full page content) */

.tabcontent {
    color: white;
    padding: 30px 30px;
    height: 100%;
    margin-top: 50px;
}


/*------------------POST---------------------------*/

.jumbotron {
    background: transparent !important;
}

.post-div {
    margin-top: 15px;
    margin-left: 15px;
    margin-bottom: 15px;
}

.img-pro-post {
    width: 50px;
    height: 50px;
    border-radius: 25px;
}

.name-pro-post {
    margin-left: 13px;
    text-decoration: none;
    color: rgb(71, 71, 150);
    cursor: pointer;
    font-size: 13px;
}

.title-post {
    padding-left: 60px;
    color: black;
    font-size: 20px !important;
    font-weight: 400 !important;
    cursor: pointer;
}

.tag {
    margin-left: 10%;
    border: none;
    font-size: 12px;
    outline: none;
}

.tag button {
    margin-left: 5px;
    margin-bottom: 5px;
    outline: none !important;
    border: none;
}

.postime {
    font-size: 14px;
    padding-left: 70px;
    float: right;
    margin-right: 10px;
    color: rgb(88, 88, 88);
}

.t {
    margin-left: 2%;
    margin-top: 5%;
    color: #777;
}

.divider {
    background: rgb(131, 131, 131);
    height: 0.5px;
    border: none;
    margin-top: -15px;
    ;
}


/*-------------BOOKMARKS----------------------------*/

#Bookmarks .dropdown-menu {
    top: 0% !important;
    left: -100px !important;
    transition: all 0.6;
}

.jumbotron {
    padding-top: 10px !important;
    margin-left: 15px;
}

.jumbotron .btn {
    font-weight: 500;
}

.jumbotron .btn-group {
    margin-bottom: 20px;
    margin-bottom: 10px;
}

.sorttype {
    margin-top: 8px;
    color: rgb(78, 78, 78);
}


/*-----------------------following------------------------*/

.label {
    list-style: none;
}

.label h3 {
    background-color: #242564;
    color: white;
    font-size: 18px;
    font-weight: 600;
    height: 30px;
    font-family: monospace;
    padding: 5px 10px;
    width: auto;
}

.exhibition-item.user {
    margin: 0rem 0;
}

.user-icon {
    margin-top: 0px;
}

.user-icon .t {
    margin-left: 15px;
}

.avatar-user {
    width: 50px;
    height: 50px;
    border-radius: 25px;
}

.img-user-div {
    margin-bottom: 5px !important;
}

.user-info {
    margin-left: 10px;
    display: block;
}

.follow .btn-follow {
    display: block;
    background-color: white;
    border: 1px solid rgb(68, 68, 231);
    color: rgb(68, 68, 231);
    font-weight: 400;
    font-size: 14px;
    height: 30px;
    margin-left: 30px;
    border-radius: 8px;
    padding-bottom: 0px;
}

.user-icon i {
    font-size: 12px;
}

.user-icon label {
    font-size: 13px;
}

.follow .btn-follow:hover {
    background-color: rgb(68, 68, 231);
    color: white;
}

.username {
    color: rgb(56, 56, 56);
    text-decoration: none;
    font-size: 14px;
    font-weight: 600;
    margin-left: 5px;
    font-family: 'Goldman', sans-serif;
}


/*---------------------Bannner-------------------*/

.banner .container {
    padding-left: 0 !important;
    padding-top: 0 !important;
    background-color: royalblue;
}

.banner img {
    width: 100%;
    padding: 0;
    height: 20vh;
}


/*--------------Bar--------*/

@media (min-width: 768px) {
    .pb-md-1,
    .py-md-1 {
        padding-bottom: 1.5rem!important;
    }
}

.container {
    width: 100%;
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
    padding-top: 10px;
    padding-bottom: 10px;
}

.justify-content-between {
    justify-content: space-between!important;
}

.feed-bar {
    height: 1.6em;
    overflow-y: hidden;
}

@media (min-width: 768px) {
    .feed-bar {
        min-height: 35px;
    }
}

@media (max-width: 767.98px) {
    .feed-bar {
        height: 1.9rem;
    }
}

@media (max-width: 767.98px) {
    .feed-bar {
        padding-left: 1rem;
        padding-right: 1.5rem;
    }
}

.feed-bar .feed-links {
    display: flex;
    flex-wrap: nowrap;
    align-items: center;
    justify-content: flex-start;
    height: 100%;
    overflow-x: auto;
    min-height: calc(1.6rem + 11px);
    padding-bottom: 0;
    margin-bottom: 0;
    overflow-y: hidden;
    margin-top: 0!important;
    max-height: 40px;
}

.feed-bar ul.feed-links {
    list-style: none;
    padding-left: 0;
}

.feed-bar .feed-links .feedbar-item {
    padding: 0;
    position: relative;
    margin-right: 1.5rem;
    flex-shrink: 0;
    top: -5px;
}

li {
    display: list-item;
    text-align: -webkit-match-parent;
}

.feed-bar .feed-links .feedbar-item+.feedbar-item {
    margin-left: 1rem;
}

.feed-bar .feed-links .feedbar-item .feed-link {
    color: rgb(255, 255, 255);
    font-size: 1em;
    font-weight: 700;
    text-transform: uppercase;
    text-decoration: none;
}

.el-badge {
    position: relative;
    vertical-align: middle;
    display: inline-block;
}

.feed-bar .feedbar-item.active>.feed-link::after {
    width: 100%;
    height: 2px;
    content: "";
    display: block;
    margin-top: 5px;
    background-color: rgb(255, 255, 255);
}

.feed-bar .feedbar-item .feed-link::after {
    left: 0px;
    width: 0px;
    height: 2px;
    content: "";
    bottom: -5px;
    display: block;
    position: absolute;
    background-color: rgb(255, 255, 255);
    transition: width 0.3s ease 0s;
}

.el-badge__content.is-fixed {
    position: absolute;
    top: 0px;
    right: 10px;
    transform: translateY(-50%) translateX(100%);
}

.el-badge__content {
    background-color: rgb(245, 108, 108);
    color: rgb(255, 255, 255);
    display: inline-block;
    font-size: 12px;
    height: 18px;
    line-height: 18px;
    text-align: center;
    white-space: nowrap;
    border-radius: 10px;
    padding: 0px 6px;
    border-width: 1px;
    border-style: solid;
    border-color: rgb(255, 255, 255);
    border-image: initial;
}

.highlight{
 font-weight: bold;
 color: #5488c7;
}
</style>
<body>
 <header>
        <nav id="navbar" class="navbar navbar-expand-md navbar-light sticky-top">
            <div class="logo"><a class="logo-link">4<span>FIT</span></a></div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-item nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
                    <a class="nav-item nav-link" href="#">Post</a>
                    <a class="nav-item nav-link" href="#">Profile</a>
                   <form class="input-group mb-10" action = "${pageContext.request.contextPath}/home" method = "get">
                        <input value = "${ textSearch}"name = "textSearch" type="text" class="form-control" placeholder="Search" aria-label="Username" aria-describedby="basic-addon1">
                        <div class="input-group-prepend">
                            <button type = "hidden" value = "search_home" name = "userCurrentAction" style = "border: none; height: 100%; width: 100%;"><span class="input-group-text" id="basic-addon1"><i class="fas fa-search"></i></span></button>
                        </div>
                    </form>
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
            <div class="img-pro">
            </div>
            <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <img class="img-profile" src="A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg" alt="">

            </button>
            <div class="dropdown-menu dropdown-menu-right ">
                <div class="dropdown-item profile-popup">
                    <img class="img-profile" src="./images/A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg" alt="">
                    <div class="info-popup">
                        <h5 class="name-info"> Hoang</h5>
                        <p class="gmail-info">hoang1811@gmail.com</p>
                        <button class="btn btn-primary btn-edit" type="button">Edit</button>

                    </div>
                </div>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Profile</a>
                <a class="dropdown-item" href="#">My content</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Sign out</a>
            </div>
        </nav>

    </header>
    <div class="row">
    <div class = "col-md-9">
    <form class="search-box" action = "${pageContext.request.contextPath}/home" method = "get" >
    <div class = "d-flex">
     <input id = "text_search" value = "${ textSearch}"name = "textSearch" type="text" class="form-control" placeholder="Search" aria-label="Username" aria-describedby="basic-addon1">
      <div class="input-group-prepend">
          <button name = "userCurrentAction" onclick = "highlightTextHome()" value = "search_home" type = "submit" class = "btn btn-primary "><i class="btn btn-primary fas fa-search"></i></button>
      </div>
      </div>
</form>
    <!------------------------------THANH BAR------------------------------>
    
    
        <div class="content-main ">
		<div style = "display: block">
			
		 <button class="tablink" onclick="openPage('Bookmarks',this)"  id="defaultOpen"> Post</button>
                <button class="tablink" onclick="openPage('searchAuthor', this)">Author</button>
		</div>
            <!----------------------------------BOOKMARKS--------------------------------------->

            <div id="Bookmarks" class="tabcontent">
                <div class="jumbotron jumbotron-fluid">
                <c:choose>
                <c:when test =" ${lenListpost == 0}">
                <span style = "color: #d9d9d9;"> Không tìm thấy bài viết !</span>
                 </c:when> 
                 </c:choose>
                <c:forEach var = "post" items = "${listPost}" >
                <!-- block bài viết -->
                
                    <div class="post-div container">
                        <img class="img-pro-post float-left" src="A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg" alt="">
                        <a class="name-pro-post display-9">@${post.getUsername()}</a>
                        
                         <span class="name-pro-post display-9">${post.getNameUser()}</span>
                        <p class="postime">${post.published_at}</p>
                        <p id = "textTitle" class="lead ml-2 title-post ">${post.title}</p>
                        <p class = "text-muted" id = "">${post.getShortContent()}</p>
                        <div class="tag d-flex">
                            
                            <button class="btn-secondary">${post.category}</button>

                        </div>
                        <span class="viewtag t ml-20">
                            <i class="far fa-eye"></i><label class="view">${post.views_count}</label>
                        </span>
                        <span class="viewtag t ">
                            <i class="fas fa-paperclip"></i><label class="view">${post.getClips_count()}</label>
                        </span>
                        <span class="viewtag t">
                            <i class="far fa-comment"></i></i><label class="view">${post.getCommentCount()}</label>
                        </span>
                    </div>
                    <div class="divider ml-5 mr-5"></div>

                 <!-- end block -->
                  </c:forEach>
                
                </div>
            </div>
        	<div id = "searchAuthor" class="tabcontent">
        	<div class="row following-row " style = "margin-top: 50px;">
        	
        	
        	
        		<!-- block author  -->
        		<c:choose>
        	 <c:when test ="${lenListauthor == 0}" >
                <span> Không tìm thấy tác giả !</span>
                 </c:when> 
                 </c:choose>
        	<c:forEach var = "user" items = "${listAuthor}" >
                        <div class="col-sm-6 col-md-4">
                            <div class="d-flex exhibition-item user mt-2">
                                <a class="d-flex img-user-div pt-1" href="#">
                                    <img class="avatar-user float-left" src="images/A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg">
                                </a>
                                <div class="user-info overflow-hidden">
                                    <a class="username">${ user.getUsername()}</a>
                                    <div class="user-icon">
                                        <span class="viewtag t ">
                                            <i class="fas fa-user-plus"></i><label class="view">16</label>
                                        </span>
                                        <span class="viewtag t">
                                            <i class="far fa-edit"></i><label class="view">16</label>
                                        </span>
                                    </div>
                                    <div class="follow">
                                        <button class="btn btn-follow" type="button">
                                            Follow
                                        </button>
                                    </div>
                                </div>

                            </div>
                        </div>
                        
                 </c:forEach>       
           <!-- end block -->
        	
                        </div>
        	</div>
        </div>
		</div>
		
		 <!------------------------------Top SYCHTACH---------------------------->
        
		<div class = "col-md-3">
       
	        <div class="section-title-line mb-1">
	        <h4 class="text-uppercase text-muted" style = "margin-top: 30px">
	            Search syntax
	        </h4><hr class="filler-line"></div>
	        
	        <div class = "main-search-syntax">
		        <div>
		        <a class = "btn btn-secondary" data-v-1ebc36b8="" href="${pageContext.request.contextPath}/home?textSearch=title:Overfitting&userCurrentAction=search_home" class="el-tag tag active el-tag--info el-tag--default">
	                title:Overfitting </a> 
	            <p class="text-muted">
	                Containing "Overfitting" in title </p>
	            </div>
		        
			        <div>
			        <a class = "btn btn-secondary" data-v-1ebc36b8="" href="${pageContext.request.contextPath}/home?textSearch=tag:new&userCurrentAction=search_home" class="el-tag tag active el-tag--info el-tag--default">
	                tag:new </a> 
	            <p class="text-muted">Tagged with "new"</p>
	            </div>
           
           
           		<div><a class = "btn btn-secondary" data-v-1ebc36b8="" href="${pageContext.request.contextPath}/home?textSearch=NOT:xuân&userCurrentAction=search_home" class="el-tag tag active el-tag--info el-tag--default">
                NOT:xuân
            </a> <p class="text-muted">
                Must not contain "xuân"
            </p></div>
            
            
            <div><a class = "btn btn-secondary" data-v-1ebc36b8="" href="${pageContext.request.contextPath}/home?textSearch=user:Tien&userCurrentAction=search_home" class="el-tag tag active el-tag--info el-tag--default">
                user:Tien
            </a> <p class="text-muted">
                Created by user "Tien"
            </p></div>
            
            
		        </div>
		        
		        
        
		</div>
    </div>
    
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
    		
    	  var inputText = document.getElementById("textTitle");
    	  var innerHTML = inputText.innerHTML;
    	  var index = innerHTML.indexOf(text);
    	  if (index >= 0) { 
    	   innerHTML = innerHTML.substring(0,index) + "<span class='highlight'>" + innerHTML.substring(index,index+text.length) + "</span>" + innerHTML.substring(index + text.length);
    	   inputText.innerHTML = innerHTML;
    	  }
    	}
    </script>
</body>
</html>