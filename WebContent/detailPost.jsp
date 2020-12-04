<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="styles/detailPost.css">
    <script type="text/javascript" src="scripts/main.js"></script>
    <script src="https://kit.fontawesome.com/f93b4d7888.js" crossorigin="anonymous"></script>
    <title>DETAIL POST</title>
</head>

<body>
	<jsp:include page="/detailPost" ></jsp:include>
    <header>
        <div class="container-fluid">
            <nav class="navbar navbar-light bg-light">
                <a class="navbar-brand" href="#">
                    <img src="/docs/4.0/assets/brand/bootstrap-solid.svg" width="30" height="30"
                        class="d-inline-block align-top" alt="">
                    4XFIT
                </a>

                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">POST <span class="sr-only">(current)</span></a>
                    </li>


                </ul>
                <form class="form-inline">
                    <input class="form-control" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-primary my-2 my-sm-0" type="submit"><i
                            class="fa fa-search"></i></button>
                </form>

                <div id="group-notication">
                    <ul>
                        <li class="nav-item">
                            <button type="button" id="btnInfoWeb" style="border: none;">
                                <i class="fa fa-info"></i>
                            </button>
                            <!--THE INFO DROPDOWN BOX.-->
                            <div id="infoWeb">
                                <h3>Infomations</h3>
                                <div style="height:300px;"></div>
                                <div class="seeAll"><a href="#">See All</a></div>
                            </div>
                        </li>
                        <div id="noti_Container">
                            <li id="noti_Counter">
                        </div>
                        <button id="btnNotication" type="button" class="nav-item" style="border: none;">
                            <i class="fa fa-bell-o"></i>
                        </button>
                        <!--THE NOTIFICAIONS DROPDOWN BOX.-->
                        <div id="notifications">
                            <h3>Notifications</h3>
                            <div style="height:300px;"></div>
                            <div class="seeAll"><a href="#">See All</a></div>
                        </div>
                        </li>

                        <li class="nav-item">
                            <button type="button" style="border: none;">
                                <i class="far fa-edit"></i>
                            </button>
                        </li>
                        <li class="nav-item">
                            <button type="button" style="border: none;" id="avatar">
                                <i class="fas fa-user-astronaut"></i>
                            </button>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </header>

    <div class="banner">

    </div>

    <div class="main-content">
        <div class="container post-body position-relative">
            <div class="row">
                <div class="p-0 hidden-md-down col-lg-1">
                    <div class="post-actions d-flex flex-column align-items-center mx-auto">
                        <div class="votes post-actions__vote mb-1">
                            <button class="icon-btn vote" data-toggle="tooltip" data-placement="bottom" title="Upvote">
                                <i aria-hidden="true" style="color: rgb(100, 100, 100);" class="fa fa-caret-up"></i>
                            </button>

                            <div class="points text-muted">
                                0
                            </div>
                            <button class="icon-btn vote" data-toggle="tooltip" data-placement="bottom"
                                title="Downvote">
                                <i aria-hidden="true" style="color: rgb(100, 100, 100);" class="fa fa-caret-down"></i>
                            </button>
                        </div>

                        <div class="subscribe mb-2">
                            <button type="button " class=" button post-actions__clip el-button--default"
                                data-toggle="tooltip" data-placement="bottom" title="Clip">
                                <i class="fa fa-paperclip">

                                </i>
                            </button>
                            <div class="social-sharing mb-2">
                                <a data-toggle="tooltip" data-placement="bottom" title="Share to facebook">
                                    <i aria-hidden="true" class="fa fa-facebook"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="post-body__main col-lg-8">
                    <article class="post-content">
                        
                            <div class="mb-05">
                                <div class="d-sm-flex align-items-start mb-2">
                                    <div class="post-author mb-2 mb-sm-0">
                                        <div class="post-author__avatar">
                                            <a class="d-flex mr-05" href="#" target="_blank">
                                                <div class="d-inline-block avatar--lg">
                                                    <img src="./images/mainAboutMe.jpg" alt="avatar"
                                                        class="avatar avatar--lg img-fluid">
                                                </div>
                                            </a>
                                        </div>
                                        <div class="post-author__info overflow-hidden mr-1">
                                            <div class="d-flex">
                                                <div class="overflow-hidden flex-fix mr-05">
                                                    <a class="text-bold post-author__name" href="#">${name_author}</a>
                                                    <span class="text-muted"> @accountAuthor</span>
                                                </div>
                                                <div class="subscribe_follow">
                                                    <button type="button" class="following">
                                                        <span>Follow</span>
                                                    </button>
                                                </div>
                                            </div>
                                            <div class="stats align-items-center">
                                                <span class="stat-item text-muted" data-toggle="tooltip"
                                                    data-placement="bottom" title="Follower: 1">
                                                    <i aria-hidden="true" class="stat-item__icon fa fa-user-plus"></i>
                                                    1
                                                </span>
                                                <span class="stat-item text-muted" data-toggle="tooltip"
                                                    data-placement="bottom" title="Post: 1">
                                                    <i aria-hidden="true" class="stat-item__icon fa fa-pencil"></i>
                                                    1
                                                </span>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="post-meta d-flex flex-column flex-wrap align-items-sm-end">
                                        <div class="text-muted">
                                            Published about 4 hours ago
                                        </div>
                                        <div class="d-flex align-items-center">
                                            <div class="post-meta__item mr-1">
                                                <button type="button " class=" button " data-toggle="tooltip"
                                                    data-placement="bottom" title="Views: ${view_post}">
                                                    <i class="fa fa-eye">

                                                    </i>
                                                    <span>${view_post}</span>
                                                </button>
                                            </div>
                                            <div class="post-meta__item mr-1">
                                                <button type="button " class=" button " data-toggle="tooltip"
                                                    data-placement="bottom" title="Comment:  ${comment_post_count} ">
                                                    <i class="fa fa-comments">

                                                    </i>
                                                    <span> ${comment_post_count} </span>
                                                </button>
                                                <button type="button " class=" button " data-toggle="tooltip"
                                                    data-placement="bottom" title="Clip: ${Clip_post_count}">
                                                    <i class="fa fa-paperclip">

                                                    </i>
                                                    <span>${Clip_post_count}</span>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="post-title">
                                    <h1>${title_post} </h1>
                                </div>
                               
                        </div>
                      
                        <div class="d-md-flex align-items-top justify-content-between">
                            <div class="menu__post">
                                <div class="dropdown">
                                    <button type="button" class="dropbtn" data-toggle="tooltip"
                                        data-placement="bottom" title="Show more active">
                                        <i class="fa fa-ellipsis-h"></i>
                                    </button>
                                        <div class = "dropdown-content">
                                        <a href="#"> repost</a>
                                        <a href="#"> repost</a>
                                    </div>
                                   

                                </div>
                            </div>
                        </div>
                      
                        <div class="md-contents article-content__body my-2 flex-fill" style="height: 50px; background-color:black;">
                            
                        </div>

                    </article>




                </div>

                <div class="post-body__right px-0 hidden-md-down col-lg-3">
                    <div class="sticky-sidebar post-sidebar post-body__sidebar">
                        <div class="sticky-sidebar__inner" style="width:285px">
                            <div class="post-index hidden-sm-down">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="post-recommendations bg-light">
            <div class="container py-2">
                <div class="post-section">
                    <div class="v-ctr-section related-posts-widget pb-2">
                        <h3>Related</h3>
                        <div class="post-related__box">
                            
                           
                           <c:forEach var = "postByAuthor" items = "${listPost}" >
                              <div class="item">
                                <div class="card shadow-sm">
                                    <div class="card-body">
                                        <div class="card-body__title text-dark word-break mb-05">
                                            <a href="#"><c:out value = "${postByAuthor.p_title}"></c:out></a>
                                        </div>
                                        <div class="card-body__author">
                                            <a href="#" class="text-primary">${name_author}</a>
                                        </div>
                                        <span title="21 min read" class = "text-muted post-reading__time">
                                            21 min read
                                        </span>
                                        <div class = "d-flex">
                                            <div class = "post-stats text-muted">
                                                <span class = "stat-item mr-05" data-toggle="tooltip" data-placement="bottom" title = "Views">
                                                    <i aria-hidden = "true" class = "fa fa-eye"><c:out value = "${postByAuthor.p_views_count}"></c:out></i>
                                                </span>
                                                <span class = "stat-item mr-05" data-toggle="tooltip" data-placement="bottom" title = "Clips">
                                                    <i aria-hidden = "true" class = "fa fa-paperclip"> <c:out value = "${postByAuthor.p_clips_count}"></c:out></i>
                                                </span>
                                                <span class = "stat-item mr-05" data-toggle="tooltip" data-placement="bottom" title = "Comment">
                                                    <i aria-hidden = "true" class = "fa fa-comments">  <c:out value = "${postByAuthor.p_clips_count}"></c:out></i>
                                                </span>
                                                <div class = "points"  data-toggle="tooltip" data-placement="bottom" title = "Votes">
                                                    <div class = "carets" id = "points-carets-votes">
                                                        <i  aria-hidden = "true" class = "fa fa-caret-up text-muted"></i>
                                                        <i  aria-hidden = "true" class = "fa fa-caret-down text-muted"></i>
                                                        
                                                    </div>
                                                    <span class = "text-muted">11</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                           
                           </c:forEach>
                          
                           
                        </div>
                    </div>
                </div>
                
                   <div class="post-comments">
                    <h3>Comments</h3>
                   <div class="tab_comment">
					  <button class="tablinks" onclick="openComment(event, 'Write')" id = "btnWrite">Write</button>
					  <button class="tablinks" onclick="openComment(event, 'Preview')">Preview</button>
					 
					</div>
					
					<div id="Write" class="tabcontent">
					  <form class = "form_comment">
					   <textarea id="comment__contents" name="comment_contents"
                                        placeholder="Test comment" style="height: 120px; "> </textarea>
                        <input type="submit" id="btnPostComment" class="el-button btn btn-outline-primary" value  = "Post comment">
					  </form>
					</div>
					
					<div id="Preview" class="tabcontent">
					  <h3>Paris</h3>
					  <p>Paris is the capital of France.</p> 
					</div>
					                   
                       
                    
                </div>
                
            </div>
        </div>
    </div>
    <footer class="footer bg-dark"></footer>
    <a id="btn-top">
        <i class="fa fa-arrow-up"></i>
    </a>
    
   
</body>

</html>