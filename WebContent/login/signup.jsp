<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/signup.css">
    <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">

    <script src="https://kit.fontawesome.com/f93b4d7888.js" crossorigin="anonymous"></script>
    <title>SIGN UP</title>
</head>

<body>
    <div class="login">
        <!-- <img class="wave" src="#"> -->
        <div class="container">
            <div class="img">
                <img src="./images/createAccount.jpg" >
            </div>
            <div class="login-content">
                <form action="signUp" method = "post">
                    <img src="#">
                    <h2 class="title"> Account</h2>
                    <div class="input-div one">
                        <div class="i">
                            <i class="fas fa-envelope-open-text"></i>
                        </div>
                        <div class="div">
                            
                            <input type="text" class="form-control" placeholder = "email" name = "email">
                        </div>
                    </div>
                    <div class="input-div pass">
                        <div class="i">
                            <i class="fas fa-user"></i>
                        </div>
                        <div class="div">
                            
                            <input type="text" class="form-control" placeholder = "username" name = "username">
                        </div>
                    </div>
                    <div class="input-div pass">
                        <div class="i">
                            <i class="fas fa-lock"></i>
                        </div>
                        <div class="div">
                            
                            <input type="password" class="form-control" placeholder = "password" name = "password">
                        </div>
                    </div>
                    <a href="login.jsp"> Are you have account ?</a>
                    <input type="submit" class="btn" value="sign up">
                   
                </form>
                
            </div>
            
        </div>
        <script type="text/javascript" src="js/main.js"></script>
</body>

</html>