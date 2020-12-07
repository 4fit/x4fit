<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Admin Dashboard</title>
<style>
.avata {
    height: 35px;
    width: 35px;
    border-radius: 50%;
}

.form-control {
    width: 500px !important;
}

.col-sm-0, .col-md-2, .col-md-10, .col-sm-12 {
    margin: 0;
    padding: 0;
}


.logo {
    border-right: none;
    margin-left: 10px;
}

.logo a {
    font-size: 20px;
    font-weight: 500;
    text-decoration: none;
}

.logo a:hover {
    cursor: pointer;
}

.nav-left {
    padding-top: 15px;
    margin-top: none;
}

.nav-left ul {
    list-style-type: none;
}

.nav-left ul li {
    margin-top: 20px;
    font-size: 18px;
}

.nav-left ul li a {
    text-decoration: none;
}

.nav-left ul li a span {
    margin: 0;
    padding: 0;
    text-align: left;
}

.nav-left ul li a i {
    width: 15px;
    margin-right: 10px;
}

.nav-left ul li:hover {
    cursor: pointer;
    color: grey;
}
</style>
</head>
<body>	
	<jsp:include page="../common/header.jsp" />
	<div class="main-panel mt-3">
      <div class="content">
          <div class="container-fluid">
              <div class="row">
                  <div class="col-md-12">
                      <div class="card card-plain">
                          <div class="card-header card-header-primary" style="background-color: #007bff; color: #fff">
                              <h4 class="card-title mt-0"> Quản lí người dùng</h4>
                          </div>
                          <div class="card-body">
                              <div class="table-responsive">
                                  <table class="table table-hover">
                                      <thead class="">
                                          <th>
                                              ID
                                          </th>
                                          <th>
                                              Tên người dùng
                                          </th>
                                          <th>
                                              Avata
                                          </th>
                                          <th>
                                              Total Posts
                                          </th>
                                          <th>
                                              Action
                                          </th>
                                      </thead>
                                      <tbody>
                                          <c:forEach items="${allUsers}" var="user">
                                          	<tr>
                                              <td>
                                                  ${user.getUserId()}
                                              </td>
                                              <td>
                                                  ${user.getName()}
                                              </td>
                                              <td>
                                                 <a> ${user.getAvata()} </a>
                                              </td>
                                              <td>
                                                  ${user.getPostsCount() }
                                              </td>
                                              <td class="text-primary">
                                                  Xem chi tiết
                                              </td>
                                          	</tr>
                                          </c:forEach>
                                      </tbody>
                                  </table>
                              </div>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>