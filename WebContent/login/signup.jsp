<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="../styles/signup.css">
	<link
		href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap"
		rel="stylesheet">
	<link href="styles/signup.css" rel="stylesheet">
	<script src="https://kit.fontawesome.com/f93b4d7888.js"></script>
	<title>Sign Up</title>
</head>

<body>
<<<<<<< HEAD
    
    <div class="login">
        <!-- <img class="wave" src="#"> -->
        <div class="container">
            <div class="img">
                <img src="../images/createAccount.jpg" >
            </div>
            <div class="login-content">
                <form action="${pageContext.request.contextPath}/signUp" method = "post">
                    <img src="#">
                    <h2 class="title"> Account</h2>
                    <div class="input-div one">
                        <div class="i">
                            <i class="fas fa-envelope-open-text"></i>
                        </div>
                        <div class="div">
                            
                            <input type="text" class="form-control" placeholder = "email" name = "email" value = "${email}">
                            
                        </div>
                        
                    </div>
                    <lable class = "error_signup"> <c:out value = "${errEmail}"></c:out></lable>
                    <div class="input-div pass">
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div class="div">
                            
                            <input type="text" class="form-control" placeholder = "username " name = "username" value = "${username}">
                            
                        </div>
                       
                    </div>
                     <lable class = "error_signup"> <c:out value = "${errUsername}"></c:out></lable>
                    <div class="input-div pass">
                        <div class="i">
                            <i class="fas fa-lock"></i>
                        </div>
                        <div class="div">
                            
                            <input type="password" class="form-control" placeholder = "password" name = "password" value = "${password}">
                           
                        </div>
                        
                    </div>
                     <lable class = "error_signup"> <c:out value = "${errPass}"></c:out></lable>
                    <a href="login.jsp"> Are you have account ?</a>
                    <input type="submit" class="btn" value="sign up" >
                   
                </form>
                
            </div>
            
        </div>
        
=======

	<div class="login">
		<!-- <img class="wave" src="#"> -->
		<div class="container">
			<div class="img">
				<img src="../images/createAccount.jpg">
			</div>
			<div class="login-content">
				<form action="signUp" method="post">
					<img src="#">
					<h2 class="title">Account</h2>
					<div class="input-div one">
						<div class="i">
							<i class="fas fa-envelope-open-text"></i>
						</div>
						<div class="div">
							<input type="text" class="form-control" placeholder="email"
								name="email" value="${email}">
						</div>
					</div>
					<lable class="error_signup"> <c:out value="${errEmail}"></c:out></lable>
					<div class="input-div pass">
						<div class="i">
							<i class="fas fa-user"></i>
						</div>
						<div class="div">
							<input type="text" class="form-control" placeholder="username "
								name="username" value="${username}">
						</div>
					</div>
					<lable class="error_signup"> <c:out value="${errUsername}"></c:out></lable>
					<div class="input-div pass">
						<div class="i">
							<i class="fas fa-lock"></i>
						</div>
						<div class="div">
							<input type="password" class="form-control"
								placeholder="password" name="password" value="${password}">
						</div>
					</div>
					<lable class="error_signup"> <c:out value="${errPass}"></c:out></lable>
					<a href="login.jsp"> Are you have account ?</a> 
					<input
						type="submit" class="btn" value="sign up">
				</form>
			</div>
		</div>
	</div>
>>>>>>> 438ee2cfd44d58da6171b07e3bd2f5f5e594ac6e
</body>

</html>