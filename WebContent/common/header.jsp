<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://www.w3schools.com/lib/w3.js"></script>
<div class="row">
  <div class="col-sm-0 col-md-2" style="border-right: 1px solid #ccc;">
      <div class="logo" style="border-bottom: 1px solid #ccc">
          <a href="#">
              <img src="https://colorlib.com/polygon/adminator/assets/static/images/logo.png">
              <span>X4FIT</span>
          </a>
      </div>
      
      <div class="nav-left">
          <ul>
              <li id="dashboard">
                  <a id="a1" href="#">
                      <i class="fa fa-home" aria-hidden="true"></i>
                      <span>Dashboard</span> 
                  </a>
              </li>
              <div class="dropdown-divider"></div>
              <li id="user">
                  <a id="a2" href="${pageContext.request.contextPath}/all-users">
                      <i class="fa fa-user" aria-hidden="true"></i>
                      <span>Users</span> 
                  </a>
              </li>
              <div class="dropdown-divider"></div>
              <li id="post">
                  <a id="a3" href="#">
                      <i class="fa fa-book" aria-hidden="true"></i>
                      <span>Posts</span> 
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
                  <form class="form-inline my-2 my-lg-0 mr-auto">
                      <input class="form-control mr-sm-2 search-bar" type="search" placeholder="Search" aria-label="Search">
                      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                  </form>
                  <ul class="navbar-nav ml-auto mt-2 mt-lg-0 mr-5">
                      <li class="nav-item dropdown">
                          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span><img class="avata" src="https://scontent.fsgn9-1.fna.fbcdn.net/v/t1.0-9/80286599_2478335852420325_5248975640924782592_o.jpg?_nc_cat=101&ccb=2&_nc_sid=174925&_nc_ohc=TiGT5d0AuGEAX82VXQ9&_nc_ht=scontent.fsgn9-1.fna&oh=8a9647f7d7670b314a0bf3dbea4b3306&oe=5FE3B135"></span>
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