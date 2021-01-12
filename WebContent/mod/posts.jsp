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
<title>Posts - Mod</title>
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

.user-avata {
    height: 50px;
    width: 50px;
    border-radius: 50%;
}

.active-nav {
    background-color: #007bff;
    border-radius: 5px;
}

.color-white {
    color: white;
}

.align-center {
	text-align: center;
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
                              <h4 class="card-title mt-0">Posts Management</h4>
                          </div>
                          <div class="card-body">
                              <div class="table-responsive">
                                  <table class="table table-hover">
                                      <thead class="">
                                          <th class="align-center">
                                              Post ID
                                          </th>
                                          <th class="align-center">
                                              Title
                                          </th>
                                          <th class="align-center">
                                              Category
                                          </th>
                                          <th class="align-center">
                                              View Counts
                                          </th>
                                          <th class="align-center">
                                              Points
                                          </th>
                                          <th class="align-center">
                                              Is Public
                                          </th>
                                          <th class="align-center">
                                          	Status
                                          </th>
                                          <th class="align-center">
                                          	Action
                                          </th>
                                      </thead>
                                      <tbody>
                                          <c:forEach items="${allPosts}" var="post">
                                          	<tr>
                                              <td class="align-center">
                                                  ${post.getID()}
                                              </td>
                                              <td>
                                                  ${post.getTitle()}
                                              </td>
                                              <td class="align-center">
                                                  ${post.getCategory()}
                                              </td>
                                              <td class="align-center">
                                              	  ${post.getViews_count()}
                                              </td>
                                              <td class="align-center">
                                              	${post.getPoints()}
                                              </td>
                                              <td class="align-center">
											      ${post.getIs_public() }
                                              </td>
                                              <td class="align-center">
                                              	  ${post.getStatus() }
                                              </td>
                                              <td class="align-center">
                                              	<a type="button" data-toggle="modal" data-target="#allow-post"><i class="fa fa-check-circle"></i></a>
                                              </td>
                                          	</tr>
                                          	<!-- Allow post Modal -->
                                          	<form action="${pageContext.request.contextPath}/AcceptPostController}" method="get">
		                                    <div class="modal fade" id="allow-post" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
											  <div class="modal-dialog" role="document">
											    <div class="modal-content">
											      <div class="modal-header">
											        <h5 class="modal-title" id="exampleModalLabel">Allow Post</h5>
											        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
											          <span aria-hidden="true">&times;</span>
											        </button>
											      </div>
											      <div class="modal-body">
											        Allow this post public on web?
											      </div>
											      <div class="modal-footer">
											        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
											        <input type="hidden" name="postId" value="${post.getID()}" />
											        <button type="submit" class="btn btn-success">Allow</button>
											      </div>
											    </div>
											  </div>
											</div>
											</form>
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
  	<script>
  		w3.addClass('#post','active-nav')
  		w3.addClass('#a3','color-white')
  	</script>
	<jsp:include page="../common/footer.jsp" />
</body>
</html>