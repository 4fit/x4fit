<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
			<title>Posts - Mod</title>
		</head>

		<body>
			<jsp:include page="../common/modHeader.jsp" />
			<div class="main-panel mt-3">
				<div class="content">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								<div class="card card-plain">
									<div class="card-header card-header-primary"
										style="background-color: #007bff; color: #fff">
										<h4 class="card-title mt-0">Posts Management</h4>
									</div>
									<div class="card-body">
										<c:choose>
											<c:when test="${allPosts.size() > 0}">
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
																	<td>
																		<a type="button" data-toggle="modal"
																			data-target="#allow-post${post.getID()}"><i
																				class="fa fa-check-circle"></i></a>

																		<!-- Allow post Modal -->
																		<div class="modal fade"
																			id="allow-post${post.getID()}" tabindex="-1"
																			role="dialog"
																			aria-labelledby="exampleModalLabel"
																			aria-hidden="true">
																			<div class="modal-dialog" role="document">
																				<div class="modal-content">
																					<div class="modal-header">
																						<h5 class="modal-title"
																							id="exampleModalLabel">Allow
																							Post</h5>
																						<button type="button"
																							class="close"
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
																						<form
																							action="${pageContext.request.contextPath}/mod/accept-posts"
																							method="get">
																							<input type="hidden"
																								name="postId"
																								value="${post.getID()}" />
																							<button type="submit"
																								class="btn btn-success">Allow</button>
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
												<h1>No data to display!</h1>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<script>
				w3.addClass('#post', 'active-nav')
				w3.addClass('#a3', 'color-white')
			</script>
			<jsp:include page="../common/footer.jsp" />
		</body>

		</html>