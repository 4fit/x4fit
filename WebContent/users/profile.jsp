<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.*,model.User,java.util.Date,java.text.SimpleDateFormat,java.util.ArrayList,javax.annotation.Resource,javax.sql.DataSource"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="ProfileStyle.css" type="text/css" >
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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

body {
    background: rgb(228, 228, 228) !important;
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
    /* position: fixed !important;
    width: 100%;
    z-index: 100000; */
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
        margin-left: 20px;
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
    font-size: 20px;
    font-weight: 900;
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


/*-------------------BANNER--------------------*/

.profile-banner {
    height: 30vh;
    background: rgb(255, 255, 255);
    padding-top: 10px;
}

.container {
    max-width: 1200px!important;
    padding-top: 25px;
}

.img-profile-ban {
    width: 80px;
    height: 80px;
    margin-top: 15px;
    border-radius: 40px;
}

.info-ban {
    position: relative;
    left: 4%;
}

.name-ban {
    font-family: 'Asap', sans-serif;
    font-weight: 500;
    font-size: 25px;
}

.info-ban .btn-edit {
    width: 70px;
    height: 35px;
    border-radius: 7px;
    font-size: 16px;
    background: rgb(23, 15, 133);
    border: none;
    margin-top: 5px;
}

.gmail-ban {
    font-weight: 600;
    font-size: 16px;
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
    display: none;
    padding: 30px 30px;
    height: 100%;
}


/*------------------POST---------------------------*/

.jumbotron {
    background: transparent !important;
}

.post-div {
    margin-top: 5px;
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
    color: rgb(31, 31, 241);
    cursor: pointer;
}

.title-post {
    padding-left: 60px;
    color: black;
    font-size: 24px !important;
    font-weight: 400 !important;
    cursor: pointer;
}

.tag {
    margin-left: 10%;
    border: none;
    outline: none;
}

.tag button {
    margin-left: 10px;
    margin-bottom: 15px;
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
    margin-top: 15%;
    color: #777;
}

.divider {
    background: rgb(131, 131, 131);
    height: 0.5px;
    border: none;
}


/*-------------BOOKMARKS----------------------------*/

#Bookmarks .dropdown-menu {
    top: 0% !important;
    left: -100px !important;
    transition: all 0.6;
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

.exhibition-item.user {
    margin: 1.5rem 0;
}

.user-icon {
    margin-top: 5px;
}

.user-icon .t {
    margin-left: 15px;
}

.avatar-user {
    width: 60px;
    height: 60px;
    border-radius: 30px;
}

.img-user-div {
    margin-bottom: 18px !important;
}

.user-info {
    margin-left: 15px;
    display: block;
}

.follow .btn-follow {
    display: block;
    background-color: white;
    border: 1px solid rgb(68, 68, 231);
    color: rgb(68, 68, 231);
    font-weight: 500;
    border-radius: 8px;
}

.follow .btn-follow:hover {
    background-color: rgb(68, 68, 231);
    color: white;
}

.username {
    color: rgb(26, 26, 26);
    text-decoration: none;
    font-size: 16px;
    font-weight: 600;
    margin-left: 5px;
    font-family: 'Goldman', sans-serif;
}
</style>
<body>
<jsp:include page="/profile" ></jsp:include>
    <header>
        <nav class="navbar navbar-expand-md navbar-light sticky ">
            <div class="logo"><a class="logo-link">4<span>FIT</span></a></div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-item nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
                    <a class="nav-item nav-link" href="#">Post</a>
                    <a class="nav-item nav-link" href="#">Profile</a>
                    <div class="input-group mb-10">
                        <input type="text" class="form-control" placeholder="Search" aria-label="Username" aria-describedby="basic-addon1">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1"><i class="fas fa-search"></i></span>
                        </div>
                    </div>
                    <button class="btn btn-primary mt-1" type="button">
                        <i class="fas fa-bell"></i>
                    </button>
                    <button class="btn btn-secondary mt-1" type="button">
                        <i class="fas fa-edit"></i>
                    </button>
                </div>
            </div>
            <div class="img-pro">
            </div>
            <button type="button" id="dropdownMenu2" class="btn dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <img class="img-profile" src="images/A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg" alt="">

            </button>
            <div class="dropdown-menu dropdown dropdown-menu-right " aria-labelledby="dropdownMenu2">
                <div class="dropdown-item profile-popup">
                    <img class="img-profile" src="A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg" alt="">
                    <div class="info-popup">
                        <h5 class="name-info">Hoangf</h5>
                        <p class="gmail-info">hhoansdf</p>
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

    <!-----------------------------BANNER PROFILE----------------------------------->
    <div class="profile-banner container-fluid ">
        <div class="container  ml-2">
            <img class="img-profile-ban  float-left" src="A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg">
            <div class="info-ban">
                <h5 class="name-ban">${USER.getUsername()}</h5>
                <button class="btn-primary btn-edit">EDIT</button>
                <p class="gmail-ban">${USER.getEmail()}</p>
            </div>
        </div>
    </div>


    <!-----------------------CONTENT----------------------------->

    
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-9 content-main ">
                <button class="tablink" onclick="openPage('Post',this)"  id="defaultOpen"> Post</button>
                <button class="tablink" onclick="openPage('Bookmarks', this)">Bookmarks</button>
                <button class="tablink" onclick="openPage('Following', this)">Following</button>
                <button class="tablink" onclick="openPage('Follower',this)">Follower</button>
                <button class="tablink" onclick="openPage('Setting',this)">Setting</button>
                <!---------------------------------POSTS------------------------------->
       
         <div id="Post" class="tabcontent">
            <div class="jumbotron jumbotron-fluid" id="list-post">                      
                     <c:forEach items="${listpost}" var="post">
                    	<div class="post-div container">
                            <img class="img-pro-post float-left" src="images/A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg" alt="">
                            <a class="name-pro-post display-9"></a>
                            <p class="postime">${post.getPublished_at()}</p>
                            <p class="lead ml-2 title-post ">${post.getTitle()}</p>
                            <div class="tag d-flex">
                                <button class="btn-secondary">#CSS</button>
                                <button class="btn-secondary">#HTML</button>

                            </div>
                            <span class="viewtag t ml-20">
                                <i class="far fa-eye"></i><label class="view">${post.getViews_count()} </label>
                            </span>
                            <span class="viewtag t ">
                                <i class="fas fa-paperclip"></i><label class="view">${post.getClips_count() }</label>
                            </span>
                            <span class="viewtag t">
                                <i class="far fa-comment"></i><label class="view">16</label>
                            </span>
                        </div>
                        <div class="divider ml-5 mr-5"></div>  
                        </c:forEach>
                                      
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
				
                <!----------------------------------BOOKMARKS--------------------------------------->

                <div id="Bookmarks" class="tabcontent">
                    <div class="jumbotron jumbotron-fluid">
                        <div class="btn-group dropdown">
                            <button type="button" class="btn"> Sort by: 
                            </button>
                            <label class="sorttype"> Publish date</label>
                            <button type="button" class="btn dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              <span class="sr-only">Toggle Dropdown</span>
                            </button>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="#">Publish date</a>
                                <a class="dropdown-item" href="#">Clip date</a>
                            </div>
                        </div>
                        <div class="post-div container">
                            <img class="img-pro-post float-left" src="images/A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg" alt="">
                            <a class="name-pro-post display-9">Fluid jumbotron</a>
                            <p class="postime">kjdsnkjsnfk</p>
                            <p class="lead ml-2 title-post "></p>
                            <div class="tag d-flex">
                                <button class="btn-secondary">#CSS</button>
                                <button class="btn-secondary">#Booststrap</button>

                            </div>
                            <span class="viewtag t ml-20">
                                <i class="far fa-eye"></i><label class="view">16</label>
                            </span>
                            <span class="viewtag t ">
                                <i class="fas fa-paperclip"></i><label class="view">16</label>
                            </span>
                            <span class="viewtag t">
                                <i class="far fa-comment"></i><label class="view">16</label>
                            </span>
                        </div>
                        <div class="divider ml-5 mr-5"></div>

                        <div class="post-div container">
                            <img class="img-pro-post float-left" src="images/A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg" alt="">
                            <a class="name-pro-post display-9">Fluid jumbotron</a>
                            <p class="postime">about 4 hour ago</p>
                            <p class="lead ml-2 title-post ">This is a modified jumbotron that occupies the entire.</p>
                            <div class="tag d-flex">
                                <button class="btn-secondary">#CSS</button>
                                <button class="btn-secondary">#Booststrap</button>

                            </div>
                            <span class="viewtag t ml-20">
                                <i class="far fa-eye"></i><label class="view">16</label>
                            </span>
                            <span class="viewtag t ">
                                <i class="fas fa-paperclip"></i><label class="view">16</label>
                            </span>
                            <span class="viewtag t">
                                <i class="far fa-comment"></i><label class="view">16</label>
                            </span>
                        </div>
                        <div class="divider ml-5 mr-5"></div>                      

                    </div>
                </div>
                <!----------------------------FOLLOWING----------------------------------------->
                <div id="Following" class="tabcontent">
                    <div class="row following-row">
                        <div class="col-sm-6 col-md-4">
                            <div class="d-flex exhibition-item user mt-2">
                                <a class="d-flex img-user-div pt-1" href="#">
                                    <img class="avatar-user float-left" src="images/A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg">
                                </a>
                                <div class="user-info overflow-hidden">
                                    <a class="username">Minh Hoàng</a>
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
                        <div class="col-sm-6 col-md-4">
                            <div class="d-flex exhibition-item user mt-2">
                                <a class="d-flex img-user-div pt-1" href="#">
                                    <img class="avatar-user float-left" src="images/A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg">
                                </a>
                                <div class="user-info overflow-hidden">
                                    <a class="username">Minh Hoàng</a>
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
                        <div class="col-sm-6 col-md-4">
                            <div class="d-flex exhibition-item user mt-2">
                                <a class="d-flex img-user-div pt-1" href="#">
                                    <img class="avatar-user float-left" src="images/A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg">
                                </a>
                                <div class="user-info overflow-hidden">
                                    <a class="username">Minh Hoàng</a>
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
                    </div>

                </div>

                <!--------------------------FOLLOWER-------------------------------------->
                <div id="Follower" class="tabcontent">
                    <div class="row following-row">
                        <div class="col-sm-6 col-md-4">
                            <div class="d-flex exhibition-item user mt-2">
                                <a class="d-flex img-user-div pt-1" href="#">
                                    <img class="avatar-user float-left" src="images/A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg">
                                </a>
                                <div class="user-info overflow-hidden">
                                    <a class="username">Minh Hoàng</a>
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
                        <div class="col-sm-6 col-md-4">
                            <div class="d-flex exhibition-item user mt-2">
                                <a class="d-flex img-user-div pt-1" href="#">
                                    <img class="avatar-user float-left" src="images/A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg">
                                </a>
                                <div class="user-info overflow-hidden">
                                    <a class="username">Minh Hoàng</a>
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
                        <div class="col-sm-6 col-md-4">
                            <div class="d-flex exhibition-item user mt-2">
                                <a class="d-flex img-user-div pt-1" href="#">
                                    <img class="avatar-user float-left" src="images/A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg">
                                </a>
                                <div class="user-info overflow-hidden">
                                    <a class="username">Minh Hoàng</a>
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
                    </div>

                </div>
            </div>
            <div class="list-static col-lg-3 hidden-md-down float-right">
                <ul class="list-group ">
                    <li class="list-group-item  d-flex justify-content-between align-items-center">
                        Total post view
                        <span class="badge badge-primary badge-pill">0</span>
                    </li>
                    <li class="list-group-item d-flex w-100 justify-content-between align-items-center">
                        Following user
                        <span class="badge badge-primary badge-pill">${USER.getFollowing_count() }</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        Follower
                        <span class="badge badge-primary badge-pill">${USER.getFollower_count()}</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        Post
                        <span class="badge badge-primary badge-pill">${USER.getPostsCount() }</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        Clip
                        <span class="badge badge-primary badge-pill">${USER.getClips_count() }</span>
                    </li>
                </ul>
            </div>

        </div>
    </div>
</body>

</html>