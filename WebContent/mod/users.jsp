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
</style>
</head>
<body>	
	<div class="main-panel mt-3">
      <div class="content">
          <div class="container-fluid">
          	<a href="#" class="btn btn-success mb-1">New User</a>
              <div class="row">
                  <div class="col-md-12">
                      <div class="card card-plain">
                          <div class="card-header card-header-primary" style="background-color: #007bff; color: #fff">
                              <h4 class="card-title mt-0">User Management</h4>
                          </div>
                          <div class="card-body">
                              <div class="table-responsive">
                                  <table class="table table-hover">
                                      <thead class="">
                                          <th>
                                              ID
                                          </th>
                                          <th>
                                              Name
                                          </th>
                                          <th>
                                              Total Posts
                                          </th>
                                          <th>
                                              Avata
                                          </th>
                                          <th>
                                              Action
                                          </th>
                                          <th>
                                              Delete
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
                                              	  ${user.getPostsCount() }
                                              </td>
                                              <td>
											      <img class="user-avata" src="${user.getAvata()}" onerror="this.src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAASwAAACoCAMAAABt9SM9AAAAZlBMVEXHzuH////Ey97///3z9vjGzeH//v/BzN7d5OvCyd3///zFzuDS2ebDyt/R1+j9///t8PTl6PDY3+jN0uTV2ubM0+G/y9vi5vHr7/S+yOLX3ez39frk6u/T2uT1+frd4Ozr7vfHyuKXQLlCAAAFC0lEQVR4nO2d7XaiMBBAySQBYwgBgdJVC/b9X3LR1t1u19pMtILO3NP+7UnvmUyGfCYJwzAMwzAMwzAMwzAMwzAMw+CBqRswV1gMwzAMwzAMwzAMwzAMwzCTAtpBBgCOZyvPo7Uxtm1Wq6osK822vsTB01OdV6pPxR6pgGWdRGvQRVeqVHop3lwtHMv6Hz1mp1HUwZA44hs2dQKt8+dULP96OrD9NXW7ZgcYKKpUnGDrpm7b3NCwVl6ckiX7YerGzQqAbNjIE6LeUYWZuomzwZpijKqvZaVL34G1UzdzFmSw/ZzT/++Lm5oz15is3Esv05OZ/QNe+sGRjy2A4RtPf9iSr0xddyZZ/dsTfZmQji0wVWhc7elJ75XKBvldtvpAKlViyerSuccE1n76gezMlk7UEicrFSVVWbDAqdrjF1TrrQ2yF+6RLUlbeoVXNfJMsSMCqMAK61/SeuqWTwAkcbLEQk/d9Amo41zJiqAsKKJcsSyW9Q3RsrYEh8NoWT3BqRrII2VRXJ5mWQhYFgKWhYBlIWBZCDKWFU7WsKxgsoh5UpbFsr6HZSFgWQhYFgKWhYBlIWBZCFgWAtexrFD0r7gFaYqyslLGLRuKpcpzYrYiV1j3ssZfYothNtbVAWLbJc3mAlee2K6jMWfFy1KGVmRlZbwrSU7Wc7ysZUlNFmoD/KfI2tFylWSRJelBVketdGjjZYlm6tbfmItk5cQiC4yPrh08tfNOYCrk6Yq/lMRq0iTR8f1w/Tp1429OdKUlLT1Zsfvg/ZpYej8ARcTRHSEWJC8Q0S3iYOYRmdbEyvd3oj6mFbG5rCNRSxYUd8Hv0fnJy2fOs6KY3keg9mhZ5Kr3I5D06OKB7hlpg69LF0C0GyawQkaW9ETHwhGbpAJXmO7I3uswhla3xKX4YuoWT8iY4lGuNqSvhQLMZnjpiX7qvKMx1xz5BbElsM+A2Ya6WpZPVMuGdyCD0NjyfO1fArkMKh+8n7qlMwCawMq0n7qlM8AMLCuY4PGQZY3D4S7MFees8ftQq8DIUpSr9zesC10RY1mJhcB5B6lol+97rGVZwWShex5Y1hhZoTcWkJcFkJmXYFnOkf6QhnZbhq7wSKmqmrAt9G6HkvBMafDszBHfkg0tgNDi/YgcyE5pYZcrRiqWFc6W7AM8Bn/PkW+pFlsOm7L2N7rSlAWwRrsSIp262dOAHwsPdCRDK2ujdnZvHLlnNLVxq6hT0n65tZTWpSEDne+iT+4I0XetMTTe/wVTdxsR+ujVKaSUm1Xy8J1Rg7FNee4tw2B82dgHnrKx2kLbKeRevzOorgb7mI+taaebUl4jqP6wlOWgHy+8rDV11cfe1fMl4x/0VeGyh4ouA+voW42+8yW8WoN5lPAah60OPb2AsJWOP7sXeIQnbl9dW6U/FFUfUWt719u+tc0gWUV9AeJJRf9c3HHtBdAu8KdzLmCsvZK7nB2E7LXdXa2kCkQePoXuLrzAtM+3VnXQJdOqvquxETJT3ChVnUTl93N2TJtc3WD8O4NUL3exDARg6gtuXbsaajX/SlWb26f1k0ihXvS8bYEdZqHqjTKZcZ1qoYh8OvSH6Nv5ll1PTcQdID+KL2ZadVnXePzdAz+KTOd6OiorZtUF3/FzTPLWFfEX0/0kc9wAp/VNv5kRNPPriG6YWspX9K+zy/F2yo/B8wzXHxHhMuJ2LtwEZdxF/9r1ZeXzlZXWr1eS9RtcCEZfy+xR1AAAAABJRU5ErkJggg=='" alt="${user.getName()}">
                                              </td>
                                              <td class="text-primary">
                                                 <a href="#">Details</a> 
                                              <td>
                                              	<a type="button" data-toggle="modal" data-target="#delete-user"><i style="color: red;" class="fa fa-trash"></i></a>
                                              	
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
												        Do you want to delete <b><c:out value="${user.getName()}" /></b>?
												      </div>
												      <div class="modal-footer">
												        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
												        <form action="" method="post">
												        	<input name="userId" value="${user.getUserId()}" />
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
</body>
</html>