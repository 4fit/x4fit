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
            <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
            <title>Category - Mod</title>
        </head>

        <body>
            <jsp:include page="../common/modHeader.jsp" />
            <div class="main-panel mt-3">
                <div class="content">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                <button class="mb-2 btn btn-primary" data-toggle="modal" data-target="#add-category">Add
                                    category</button>
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
                                                                    <td class="align-center">
                                                                        ${category.getShortDes()}
                                                                    </td>
                                                                    <td class="align-center">
                                                                        ${category.getCount_post()}
                                                                    </td>
                                                                    <td class="align-center">
                                                                        <a type="button" data-toggle="modal"
                                                                            data-target="#allow-post"><i
                                                                                class="fa fa-check-circle"></i></a>
                                                                    </td>
                                                                </tr>
                                                                <!-- Allow post Modal -->
                                                                <form
                                                                    action="${pageContext.request.contextPath}/AcceptPostController}"
                                                                    method="get">
                                                                    <div class="modal fade" id="allow-post"
                                                                        tabindex="-1" role="dialog"
                                                                        aria-labelledby="exampleModalLabel"
                                                                        aria-hidden="true">
                                                                        <div class="modal-dialog" role="document">
                                                                            <div class="modal-content">
                                                                                <div class="modal-header">
                                                                                    <h5 class="modal-title"
                                                                                        id="exampleModalLabel">Allow
                                                                                        Post</h5>
                                                                                    <button type="button" class="close"
                                                                                        data-dismiss="modal"
                                                                                        aria-label="Close">
                                                                                        <span
                                                                                            aria-hidden="true">&times;</span>
                                                                                    </button>
                                                                                </div>
                                                                                <div class="modal-body">
                                                                                    Allow this post public on web?
                                                                                </div>
                                                                                <div class="modal-footer">
                                                                                    <button type="button"
                                                                                        class="btn btn-secondary"
                                                                                        data-dismiss="modal">Close</button>
                                                                                    <input type="hidden" name="postId"
                                                                                        value="${post.getID()}" />
                                                                                    <button type="submit"
                                                                                        class="btn btn-success">Allow</button>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </form>
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
            <!-- Add category Modal -->
            <div class="modal fade" id="add-category">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h3 class="modal-title">Add Category</h3>
                        </div>
                        <div class="modal-body">
                            <form action="${pageContext.request.contextPath}/mod/add-category" method="post">
                                <div class="form-group">
                                    <label for="category-name">Category Name</label>
                                    <input type="text" class="form-control" id="category-name" required
                                        placeholder="Enter Category Name" name="category-name"> 
                                </div>
                                <div class="form-group">
                                    <label for="description">Description</label>
                                    <textarea class="form-control" id="description" rows="3" required
                                        placeholder="Description here" name="description"></textarea>
                                </div>
                                <button type="submit" class="btn btn-success text-xs-center">Add</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <script>
                w3.addClass('#category', 'active-nav')
                w3.addClass('#a2', 'color-white')
            </script>
            <jsp:include page="../common/footer.jsp" />
        </body>

        </html>