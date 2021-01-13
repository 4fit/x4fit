<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://www.w3schools.com/lib/w3.js"></script>
<div class="row">
  <div class="col-sm-0 col-md-2" style="border-right: 1px solid #ccc;">
      <div class="logo" style="border-bottom: 1px solid #ccc">
          <a href="${pageContext.request.contextPath}/mod/all-categories">
              <img src="https://colorlib.com/polygon/adminator/assets/static/images/logo.png">
              <span>X4FIT</span>
          </a>
      </div>
      
      <div class="nav-left">
          <ul>
<<<<<<< HEAD:WebContent/common/modHeader.jsp
              <div class="dropdown-divider"></div>
              <li id="user">
                  <a id="a2" href="#">
                      <i class="fa fa-user" aria-hidden="true"></i>
                      <span>CATEGORY</span> 
                  </a>
              </li>
              <div class="dropdown-divider"></div>
=======
              <li id="category">
                  <a id="a2" href="${pageContext.request.contextPath}/mod/all-categories">
                      <i class="fa fa-list-alt" aria-hidden="true"></i>
                      <span>CATEGORY</span> 
                  </a>
              </li>
>>>>>>> 13300e8195c3126b81d14cb1d01eb1fc902b81e6:WebContent/common/header.jsp
              <li id="post">
                  <a id="a3" href="${pageContext.request.contextPath}/mod/all-posts">
                      <i class="fa fa-book" aria-hidden="true"></i>
                      <span>POSTS</span> 
                  </a>
              </li>
          </ul>
      </div>

  </div>
  <div class="col-md-10 col-sm-12">
      <div class="navbar-top" style="border-bottom: 1px solid #ccc;">
          <nav class="navbar navbar-expand-lg navbar-light">
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse">
                  <ul class="navbar-nav ml-auto mt-2 mt-lg-0 mr-5">
                      <li class="nav-item dropdown">
                          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span><img class="avata" src=""></span>
                            Văn Cụi
                          </a>
                          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Setting</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Logout</a>
                          </div>
                        </li>
                  </ul>
              </div>
          </nav>
      </div>