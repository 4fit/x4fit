<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
                integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
                crossorigin="anonymous">
            <link rel="stylesheet"
                href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" href="./style.css">
            <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
                crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
                crossorigin="anonymous"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
                crossorigin="anonymous"></script>
            <title>Category - Mod</title>
        </head>

        <body>
            <jsp:include page="../common/modHeader.jsp" />
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
                            		<button class="mb-2 btn btn-primary" data-toggle="modal" data-target="#add-category">Add category</button>
	                                <form class="mb-2 form-inline my-2 ml-auto mr-5" action="${pageContext.request.contextPath}/mod/search-category">
					                      <input class="form-control mr-sm-1 search-bar" name="query" value="${query}" type="search" placeholder="Search">
					                      <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
					                </form>
                            	</div>
                                <div class="card card-plain">
                                    <div class="card-header card-header-primary"
                                        style="background-color: #007bff; color: #fff">
                                        <h4 class="card-title mt-0">Category Management</h4>
                                    </div>
                                    <div class="card-body">
                                        <c:choose>
                                            <c:when test="${allCategories.size() > 0}">
                                                <div class="table-responsive">
                                                    <table class="table table-hover">
                                                        <thead class="">
                                                            <th class="align-center">
                                                                ID
                                                            </th>
                                                            <th class="align-center">
                                                                Name
                                                            </th>
                                                            <th class="align-center">
                                                                Description
                                                            </th>
                                                            <th class="align-center">
                                                                Counts Post
                                                            </th>
                                                            <th class="align-center">
                                                                Action
                                                            </th>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach items="${allCategories}" var="category">
                                                                <tr>
                                                                    <td class="align-center">
                                                                        ${category.getId()}
                                                                    </td>
                                                                    <td>
                                                                        ${category.getName()}
                                                                    </td>
                                                                    <td>
                                                                        ${category.getShortDes()}
                                                                    </td>
                                                                    <td class="align-center">
                                                                        ${category.getCount_post()}
                                                                    </td>
                                                                    <td>
                                                                    	<div class="align-center">
	                                                                        <a type="button" data-toggle="modal"  data-target="#update-category${category.getId()}"><i class="fa fa-edit"></i></a>
	                                                                        <span> | </span>
	                                                                        <a type="button" data-toggle="modal"  data-target="#delete-category${category.getId()}"><i class="fa fa-trash"></i></a>
                                                                        </div>
                                                                        <!-- Update category Modal -->
																		<div class="modal fade" id="update-category${category.getId()}">
																		    <div class="modal-dialog" role="document">
																		        <div class="modal-content">
																		            <div class="modal-header">
																		                <h3 class="modal-title">Update Category</h3>
																		            </div>
																		            <div class="modal-body">
																		                <form action="${pageContext.request.contextPath}/mod/update-category" method="post">
																		                    <div class="form-group">
																		                        <label for="category-name">Category Name</label>
																		                        <input type="text" class="form-control" id="category-name" value="${category.getName()}" required
																		                            placeholder="Enter Category Name" name="category-name">
																		                    </div>
																		                    <div class="form-group">
																		                        <label for="description">Description</label>
																		                        <textarea class="form-control" id="description" rows="3" required
																		                            placeholder="Description here" name="description">${category.getDescription()}</textarea>
																		                    </div>
																		                    <input type="hidden" name="oldName" value="${category.getName()}">
																		                    <input type="hidden" name="url" value="${category.getUrl()}">
																		                    <button type="submit" class="btn btn-success">Update</button>
																		                </form>
																		            </div>
																		        </div>
																		    </div>
																		</div>
                                                                        
                                                                        <!-- Delete Category Modal -->
		                                                                <div class="modal fade" id="delete-category${category.getId()}" tabindex="-1"
		                                                                    role="dialog" aria-labelledby="exampleModalLabel"
		                                                                    aria-hidden="true">
		                                                                    <div class="modal-dialog" role="document">
		                                                                        <div class="modal-content">
		                                                                            <div class="modal-header">
		                                                                                <h5 class="modal-title"
		                                                                                    id="exampleModalLabel">Delete Category</h5>
		                                                                                <button type="button" class="close"
		                                                                                    data-dismiss="modal"
		                                                                                    aria-label="Close">
		                                                                                    <span
		                                                                                        aria-hidden="true">&times;</span>
		                                                                                </button>
		                                                                            </div>
		                                                                            <div class="modal-body">
		                                                                                Do you want to delete category <b><c:out value="${category.getName()}"></c:out></b>?
		                                                                            </div>
		                                                                            <div class="modal-footer">
		                                                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		                                                                                <form action="${pageContext.request.contextPath}/mod/delete-category" method="post">
		                                                                                	<input type="hidden" name="url" value="${category.getUrl()}" />
		                                                                                	<button type="submit" class="btn btn-danger">Delete</button>
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
                                            </c:when>
                                            <c:otherwise>
                                                <h3>No data to display!</h3>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <jsp:include page="../modals/addCategoryModal.jsp" />
            <jsp:include page="../common/footer.jsp" />
            <script>
                w3.addClass('#category', 'active-nav')
                w3.addClass('#a2', 'color-white')
            </script>
        </body>
        </html>