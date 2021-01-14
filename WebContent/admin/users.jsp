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
<link rel="stylesheet" href="../mod/style.css">
<title>XFIT - Admin</title>
</head>
<body>	
	<jsp:include page="../common/adminHeader.jsp" />
	<div class="main-panel mt-3">
      <div class="content">
          <div class="container-fluid">
              <div class="row">
                  <div class="col-md-12">
                  	<c:if test="${not empty errorMessage}">
                       <div class="alert alert-danger alert-dismissible fade show" role="alert">
						  <c:out value="${errorMessage}" />
						   <button type="button" class="close" data-dismiss="alert" aria-label="Close">
						 	   <span aria-hidden="true">&times;</span>
						   </button>
						</div>
                    </c:if>
                    <div class="d-flex">
                    	<button class="mb-2 btn btn-primary" data-toggle="modal" data-target="#create-mod">Add Mod</button>
                        <form class="mb-2 form-inline my-2 ml-auto mr-5" action="${pageContext.request.contextPath}/mod/search-category">
				        	<input class="form-control mr-sm-1 search-bar" style="width: 400px; border: 1px solid #007bff;" name="query" value="${query}" type="search" placeholder="Search">
				            <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
				        </form>
                    </div>
                      <div class="card card-plain">
                          <div class="card-header card-header-primary" style="background-color: #007bff; color: #fff">
                              <h4 class="card-title mt-0">User Management</h4>
                          </div>
                          <div class="card-body">
                              <div class="table-responsive">
                                  <table class="table table-hover">
                                      <thead>
                                          <th>
                                              ID
                                          </th>
                                          <th>
                                              Username
                                          </th>
                                          <th>
                                              Email
                                          </th>
                                          <th>
                                              Account Type
                                          </th>
                                          <th>
                                              Status
                                          </th>
                                          <th>
                                              Action
                                          </th>
                                      </thead>
                                      <tbody>
                                          <c:forEach items="${userInfoList}" var="user">
                                          	<tr>
                                              <td>
                                                  ${user.getUserID()}
                                              </td>
                                              <td>
                                                  ${user.getUsername()}
                                              </td>
                                              <td>
                                              	  ${user.getEmail() }
                                              </td>
                                              <td>
                                              	  ${user.getUser_type() }
                                              </td>
                                              <td>
                                              	  ${user.getStatus() }
                                              </td>
                                              <td>
                                              	<a type="button" data-toggle="modal" data-target="#delete-user"><i style="color: red;" class="fa fa-trash"></i></a>
                                              </td>
                                              	
                                              	<!-- Delete User Modal -->
                                              	<div class="modal fade" id="delete-user" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
												  <div class="modal-dialog" role="document">
												    <div class="modal-content">
												      <div class="modal-header">
												        <h5 class="modal-title" id="exampleModalLabel">Delete User</h5>
												        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
												          <span aria-hidden="true">&times;</span>
												        </button>
												      </div>
												      <div class="modal-body">
												        Do you want to delete?
												      </div>
												      <div class="modal-footer">
												        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
												        <form action="" method="post">
												        	<input name="userId" value="" />
												        	<button type="button" class="btn btn-danger">Delete</button>
												        </form>
												      </div>
												    </div>
												  </div>
												</div>
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
  <script>
  		w3.addClass('#user','active-nav')
  		w3.addClass('#a2','color-white')
  	</script>
	<jsp:include page="../common/footer.jsp" />
	<jsp:include page="../modals/createModModal.jsp" />
</body>
</html>