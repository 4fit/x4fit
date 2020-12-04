<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="styles/ProfileStyle.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


</head>

<body>
<jsp:include page="/profile.jsp"/>

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
            <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <img class="img-profile" src="images/A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg" alt="">

            </button>
            <div class="dropdown-menu dropdown-menu-right ">
                <div class="dropdown-item profile-popup">
                    <img class="img-profile" src="images/A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg" alt="">
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

    <!-----------------------------BANNER PROFILE----------------------------------->
    <div class="profile-banner container-fluid ">
        <div class="container  ml-2">
            <img class="img-profile-ban  float-left" src="images/A-Field-of-Eternal-Blue-Bluebonnet-Texas.jpg">
            <div class="info-ban">
                <h5 class="name-ban">Hoàng</h5>
                <button class="btn-primary btn-edit">EDIT</button>
                <p class="gmail-ban">nguyenhoang1111@gmail.com</p>
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
                            <p class="postime">${post.getP_published_at()}</p>
                            <p class="lead ml-2 title-post ">${post.getP_title()}</p>
                            <div class="tag d-flex">
                                <button class="btn-secondary">#CSS</button>
                                <button class="btn-secondary">#HTML</button>

                            </div>
                            <span class="viewtag t ml-20">
                                <i class="far fa-eye"></i><label class="view">${post.getP_views_count()} </label>
                            </span>
                            <span class="viewtag t ">
                                <i class="fas fa-paperclip"></i><label class="view">${post.getP_clips_count() }</label>
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
                            <p class="postime">${listpost[0].getP_title()}"</p>
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
                        <span class="badge badge-primary badge-pill">14</span>
                    </li>
                    <li class="list-group-item d-flex w-100 justify-content-between align-items-center">
                        Following user
                        <span class="badge badge-primary badge-pill">2</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        Follower
                        <span class="badge badge-primary badge-pill">1</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        Post
                        <span class="badge badge-primary badge-pill">1</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        Clip
                        <span class="badge badge-primary badge-pill">1</span>
                    </li>
                </ul>
            </div>

        </div>
    </div>
   <!--   <script src="scripts/ProfilePage.js" type="text/javascript"></script>-->
</body>

</html>