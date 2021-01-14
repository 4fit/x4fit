<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <!DOCTYPE html>

        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Profile</title>
            <link rel="stylesheet" href="ProfileStyle.css" type="text/css">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
            <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        </head>
        <style>
            @charset "UTF-8";
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
                top: 60%;
                margin-right: 10px !important;
                margin-top: 0px !important;
                transition: top 1s;
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
            
            .content-main {
                padding: 0 !important;
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
                color: black;
                padding-left: 60px;
                font-size: 21px;
                cursor: pointer;
            }
            
            .title-post a {
                text-decoration: none;
                color: black;
                font-weight: 500;
                width: 100%;
            }
            
            .title-post a:hover {
                color: navy;
                font-weight: 600;
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
            
            @import url(https://fonts.googleapis.com/css?family=Droid+Serif);
            .setting-row .container {
                position: absolute;
                left: 0;
                height: 100%;
                transition: transform 0.4s ease;
                transform: translateX(-130%);
                width: 100%;
            }
            
            .setting-row div:nth-of-type(1) {
                background-color: #ffffff;
            }
            
            .setting-row div:nth-of-type(2) {
                background-color: #ffffff;
            }
            
            .setting-row div:nth-of-type(3) {
                background-color: #ffffff;
            }
            
            .setting-row div:nth-of-type(4) {
                background-color: #ffffff;
            }
            
            input[type=radio] {
                position: absolute;
                width: 10px;
                height: 25%;
                outline: 5px solid;
                outline-offset: -5px;
                margin: 0;
                z-index: 1;
                cursor: pointer;
            }
            
            input[type=radio]:nth-of-type(1) {
                outline-color: #686868;
                top: 0%;
            }
            
            input[type=radio]:nth-of-type(2) {
                outline-color: #686868;
                top: 25%;
            }
            
            input[type=radio]:nth-of-type(3) {
                outline-color: #686868;
                top: 50%;
            }
            
            input[type=radio]:nth-of-type(4) {
                outline-color: #686868;
                top: 75%;
            }
            
            input[type=radio]:checked+div {
                transform: translateX(0%);
                color: rgb(14, 14, 14);
                transition: transform 0.3s ease 0.3s;
            }
            
            input[type=radio]:checked {
                outline-color: #ffffff;
                transition: 0.8s ease;
            }
            
            .setting-btn {
                z-index: 100000;
            }
            
            .setting-btn button {
                width: 143%;
                margin-left: -30px;
                height: 25%;
                border: none;
                outline: none;
                background-color: #05198b;
                color: white;
                border-top: 1px solid white;
                font-size: 20px;
                font-weight: 600;
                border-radius: 0;
                letter-spacing: 1px;
            }
            
            .setting-btn button:hover {
                letter-spacing: 2px;
                transition: 0.5s ease;
                background-color: rgb(37, 66, 119);
                color: white;
            }
            
            .content {
                height: 70vh;
            }
            
            .setting-row .container {
                margin-left: 15px;
            }
            
            .container .form-group {
                margin-left: 20px;
            }
            
            .container .advance {
                color: blue;
                text-decoration: underline;
                font-size: 15px;
                font-family: sans-serif;
                cursor: pointer;
            }
            
            .form-group label{
            	font-size: 14px;
            	font-style: italic;
            	color: red;
            }
            
            .form-control {
                width: 100% !important;
            }
            
            .avatar img {
                height: 100px;
                width: auto;
            }
            
            .avatar button {
                width: 100px;
                background-color: cornflowerblue;
                color: white;
                font-size: 17px;
                height: 40px;
                border: none;
                font-weight: 600;
                border-radius: 20px;
                outline: none;
                font-family: sans-serif;
            }
            
            .btnsave {
                font-size: 15px;
                font-weight: 600;
                background-color: rgb(0, 0, 172);
                color: #ffffff;
                letter-spacing: 1px;
                font-family: sans-serif;
                border-radius: 20px;
                height: 40px;
                outline: none;
                border: none;
                padding: 5px;
                width: 130px;
                margin: 10px 160px;
            }
            
            .btnsave:hover {
                background-color: #4c71eb;
                color: black;
                letter-spacing: 2px;
                transition: 0.5s ease-in-out;
            }
            
            #advance {
                display: none;
            }
            
            #changepass {
                display: none;
            }
            
            .changepass,
            .forgotpass {
                color: blue;
                text-decoration: underline;
                font-size: 15px;
                font-family: sans-serif;
                cursor: pointer;
            }
        </style>

        <body>
            <header>
                <nav class="navbar navbar-expand-md navbar-light sticky ">
                    <div class="logo"><a class="logo-link">4<span>FIT</span></a></div>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div class="navbar-nav">
                            <a class="nav-item nav-link active" href="../index.jsp">Home <span class="sr-only">(current)</span></a>

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
                            <img class="img-profile" src="${pageContext.request.contextPath}/images/${usermain.getAvatar() }" alt="">
                            <div class="info-popup">
                                <h5 class="name-info">${usermain.getFullname()}</h5>
                                <p class="gmail-info">${usermain.getEmail(usermain.getUserID())}</p>
                                <form action="/profile" method="get">
                                    <button class="btn btn-primary btn-edit" type="submit">Edit</button>

                                </form>

                            </div>
                        </div>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/profile">Profile</a>
                        <a class="dropdown-item" href="#">My content</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Sign out</a>
                    </div>
                </nav>
            </header>

            <!-----------------------------BANNER PROFILE----------------------------------->
            <div class="profile-banner container-fluid ">
                <div class="container  ml-2">
                    <img class="img-profile-ban  float-left" src="${pageContext.request.contextPath}/images/${usermain.getAvatar() }">
                    <div class="info-ban">
                        <h5 class="name-ban">${usermain.getFullname()}</h5>
                        <button class="btn-primary btn-edit">EDIT</button>
                        <p class="gmail-ban">${usermain.getEmail(usermain.getUserID())}</p>
                    </div>
                </div>
            </div>


            <!-----------------------CONTENT----------------------------->


            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-9 content-main ">
                        <button class="tablink" onclick="openPage('Post',this)" id="defaultOpen"> Post</button>
                        <button class="tablink" onclick="openPage('Bookmarks', this)">Bookmarks</button>
                        <button class="tablink" onclick="openPage('Following', this)">Following</button>
                        <button class="tablink" onclick="openPage('Follower',this)">Follower</button>
                        <button class="tablink" onclick="openPage('Setting',this)">Setting</button>
                        <!---------------------------------POSTS------------------------------->

                        <div id="Post" class="tabcontent">
                            <div class="jumbotron jumbotron-fluid" id="list-post">
                                <c:forEach items="${listpost}" var="post">
                                    <div class="post-div container">
                                        <img class="img-pro-post float-left" src="${pageContext.request.contextPath}/images/${usermain.getAvatar() }" alt="${usermain.getFullname() }">
                                        <a class="name-pro-post display-9">${usermain.getFullname()}</a>
                                        <p class="postime">${post.getPublished_at()}</p>
                                        <p class="lead ml-2 title-post"><a href="${pageContext.request.contextPath}/post?p=${post.getURL()}">${post.getTitle() }</a>
                                        </p>
                                        <div class="tag d-flex">
                                            <button class="btn-secondary">${post.getCategory() }</button>

                                        </div>
                                        <span class="viewtag t ml-20">
                                <i class="far fa-eye"></i><label class="view">${post.getViews_count()} </label>
                            </span>
                                        <span class="viewtag t ">
                                <i class="fas fa-paperclip"></i><label class="view">${post.getClips_count(post) }</label>
                            </span>
                                        <span class="viewtag t">
                                <i class="far fa-comment"></i><label class="view">${post.countComment(post.getID())}</label>
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
                                <c:forEach items="${clipspost}" var="post">
                                    <div class="post-div container">
                                        <img class="img-pro-post float-left" src="${pageContext.request.contextPath}/images/${usermain.getAvatar() }" alt="${usermain.getFullname() }">
                                        <a class="name-pro-post display-9">${post.getAuthor(post.getUser_id())}</a>
                                        <p class="postime">${post.getPublished_at()}</p>
                                        <p class="lead ml-2 title-post"><a href="${pageContext.request.contextPath}/post?p=${post.getURL()}">${post.getTitle() }</a>
                                        </p>
                                        <div class="tag d-flex">
                                            <button class="btn-secondary">${post.getCategory() }</button>

                                        </div>
                                        <span class="viewtag t ml-20">
                                <i class="far fa-eye"></i><label class="view">${post.getViews_count()} </label>
                            </span>
                                        <span class="viewtag t ">
                                <i class="fas fa-paperclip"></i><label class="view">${post.getClips_count(post) }</label>
                            </span>
                                        <span class="viewtag t">
                                <i class="far fa-comment"></i><label class="view">${post.countComment(post.getID())}</label>
                            </span>
                                    </div>
                                    <div class="divider ml-5 mr-5"></div>
                                </c:forEach>

                            </div>
                        </div>
                        <!----------------------------FOLLOWING----------------------------------------->
                        <div id="Following" class="tabcontent">
                            <div class="row following-row">
                                <c:forEach items="${following}" var="user">
                                    <div class="col-sm-6 col-md-4">
                                        <div class="d-flex exhibition-item user mt-2">
                                            <a class="d-flex img-user-div pt-1" href="#">
                                                <img class="avatar-user float-left" src="${pageContext.request.contextPath}/images/${user.getAvatar() }">
                                            </a>
                                            <div class="user-info overflow-hidden">
                                                <a class="username">${user.getFullname()}</a>
                                                <div class="user-icon">
                                                    <span class="viewtag t ">
                                            <i class="fas fa-user-plus"></i><label class="view">${user.countFollowing(user)}</label>
                                        </span>
                                                    <span class="viewtag t">
                                            <i class="far fa-edit"></i><label class="view">${user.countPost(user.getUserID())}</label>
                                        </span>
                                                </div>
                                                <div class="follow">
                                                    <button class="btn btn-follow" type="button">
                                            Following
                                        </button>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <!--------------------------FOLLOWER-------------------------------------->
                        <div id="Follower" class="tabcontent">
                            <div class="row following-row">
                                <c:forEach items="${follower}" var="user">
                                    <div class="col-sm-6 col-md-4">
                                        <div class="d-flex exhibition-item user mt-2">
                                            <a class="d-flex img-user-div pt-1" href="#">
                                                <img class="avatar-user float-left" src="${pageContext.request.contextPath}/images/${user.getAvatar() }">
                                            </a>
                                            <div class="user-info overflow-hidden">
                                                <a class="username">${user.getFullname()}</a>
                                                <div class="user-icon">
                                                    <span class="viewtag t ">
                                            <i class="fas fa-user-plus"></i><label class="view">${user.countFollowing(user)}</label>
                                        </span>
                                                    <span class="viewtag t">
                                            <i class="far fa-edit"></i><label class="view">${user.countPost(user.getUserID())}</label>
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

                            </div>
                        </div>
                        <div id="Setting" class="tabcontent">
                            <div class="row content">
                                <div class="col-md-2 setting-btn">
                                    <button type="button" class="btn">PROFILE </button>
                                    <button type="button" class="btn">ACCOUNT </button>
                                    <button type="button" class="btn">GALLERY </button>
                                    <button type="button" class="btn">CONTACT </button>
                                </div>
                                <div class="col-md-10 setting-row">
                                    <input type="radio" name="name" checked="checked" />
                                    <div class="container">

                                        <div class="row">
                                            <div class="col-md-3 avatar">
                                                <img src="${pageContext.request.contextPath}/images/${usermain.getAvatar() }">
                                                <button class="btn-light"> Upload</button>
                                            </div>
                                            <div class="col-md-9">
                                                <h4 style="margin-bottom: 10px;">Your information</h4>
                                                <form action="${pageContext.request.contextPath}/profile?action=edit" method="GET">
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Full name</label>
                                                        <input type="text" class="form-control" name="fullname" placeholder="Enter fullname" value="${usermain.getFullname()}">
                                                        <label>${nameError}</label>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="exampleInputEmail1">Email address</label>
                                                        <input type="email" class="form-control" name="email" aria-describedby="emailHelp" placeholder="Enter email" value="${usermain.getEmail(usermain.getUserID()) }">
                                                    	<label>${emailError}</label>
                                                    </div>
                                                    <label class="advance">Change login information</label>
                                                    <div id="advance">
                                                        <div class="form-group">
                                                            <label for="exampleInputEmail1">Username</label>
                                                            <input type="text" class="form-control" name="username" placeholder="username" value="${usermain.getUsername(usermain.getUserID()) }">
                                                        	<label>${usernameError}</label>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="exampleInputEmail1">Current password</label>
                                                            <input type="password" class="form-control" name="currentpass" placeholder="current password" value="${acc.getPassword() }">
                                                       		
                                                        </div>

                                                        <span> <label class="changepass">Change your password</label> or  <label class="forgotpass">Forgot your password ?</label></span>
                                                        <div id="changepass">
                                                            <div class="form-group">
                                                                <label for="exampleInputEmail1">Old password</label>
                                                                <input type="password" class="form-control" name="oldpass" placeholder="type your old password">
                                                            	<label>${oldpassError}</label>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="exampleInputEmail1">New password</label>
                                                                <input type="password" class="form-control" name="newpass" placeholder="type new password">
                                                            	<label>${newpassError}</label>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="exampleInputEmail1">Confirm new password</label>
                                                                <input type="password" class="form-control" name="confirmnewpass" placeholder="confirm new password">
                                                           		<label>${confirmError}</label>
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <button class="btnsave" type="submit">Save change</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <input type="radio" name="name" />
                                    <div class="container">hELLLO</div>
                                    <input type="radio" name="name" />
                                    <div class="container">Hi</div>
                                    <input type="radio" name="name" />
                                    <div class="container"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="list-static col-lg-3 hidden-md-down float-right">
                        <ul class="list-group ">
                            <li class="list-group-item  d-flex justify-content-between align-items-center">
                                Total post view
                                <span class="badge badge-primary badge-pill">${usermain.coutTotalPostView(usermain.getUserID())}</span>
                            </li>
                            <li class="list-group-item d-flex w-100 justify-content-between align-items-center">
                                Following user
                                <span class="badge badge-primary badge-pill">${usermain.countFollowing(usermain)}</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Follower
                                <span class="badge badge-primary badge-pill">${usermain.countFollower(usermain)}</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Post
                                <span class="badge badge-primary badge-pill">${usermain.countPost(usermain.getUserID())}</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                Clip
                                <span class="badge badge-primary badge-pill">${usermain.countClips(usermain) }</span>
                            </li>
                        </ul>
                    </div>


                </div>
            </div>
            <script>
                document.getElementById("dropdownMenu2").onclick = function() {
                    if (document.getElementsByClassName("dropdown-menu")[0].style.display == "block") {
                        document.getElementsByClassName("dropdown-menu")[0].style.display = "none";
                        document.getElementsByClassName("dropdown-menu")[0].style.top = "60%";
                    } else {
                        document.getElementsByClassName("dropdown-menu")[0].style.display = "block";
                        document.getElementsByClassName("dropdown-menu")[0].style.transition = "2s ease"
                        document.getElementsByClassName("dropdown-menu")[0].style.top = "95%";
                    }
                    s

                }

                document.getElementsByClassName("advance")[0].onclick = function() {
                    if (document.getElementById("advance").style.display == "none")
                        document.getElementById("advance").style.display = "block";
                    else
                        document.getElementById("advance").style.display = "none";
                }

                document.getElementsByClassName("changepass")[0].onclick = function() {
                    if (document.getElementById("changepass").style.display == "none")
                        document.getElementById("changepass").style.display = "block";
                    else
                        document.getElementById("changepass").style.display = "none";
                }
            </script>
        </body>

        </html>