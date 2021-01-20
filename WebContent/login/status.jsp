<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
     <link rel="stylesheet" href="../styles/status.css">
</head>

<body style="background-color: #6FC9E7; margin: 0 !important; padding: 0 !important;">
    <!-- HIDDEN PREHEADER TEXT -->
    <div style="display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: 'Lato', Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;"> We're thrilled to have you here! Get ready to dive into your new account. </div>
    <form  action = "${pageContext.request.contextPath}/signUp" method = "post">
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
        <!-- LOGO -->
        <tr>
            <td bgcolor="#6FC9E7" align="center">
                <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;">
                    <tr>
                        <td align="center" valign="top" style="padding: 40px 10px 40px 10px;"> </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td bgcolor="#6FC9E7" align="center" style="padding: 0px 10px 0px 10px;">
                <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;">
                    <tr>
                        <td bgcolor="#ffffff" align="center" valign="top" style="padding: 40px 20px 20px 20px; border-radius: 4px 4px 0px 0px; color: #111111; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 48px; font-weight: 400; letter-spacing: 4px; line-height: 48px;">
                            <h1 style="font-size: 48px; font-weight: 400; margin: 2;">Welcome <b>X4FIT </b>!</h1> <img src=" https://img.icons8.com/clouds/100/000000/handshake.png" width="125" height="120" style="display: block; border: 0px;" />
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td bgcolor="#f4f4f4" align="center" style="padding: 0px 10px 0px 10px;">
                <table border="0" cellpadding="0" cellspacing="0" width="100%" style="max-width: 600px;">
                    <tr>
                        <td bgcolor="#ffffff" align="left" style="padding: 20px 30px 40px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;">
                            <p style="margin: 0;">We're excited to have you get started. First, you need to confirm your account, we send for you <b>CODE</b>  to your email. Just press the button below.</p>
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="#ffffff" align="left">
                            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td bgcolor="#ffffff" align="center" style="padding: 20px 30px 60px 30px;">
                                        <form action = "#" mothod = "">
                                        <table border="0" cellspacing="0" cellpadding="0">
                                            <tr>
                                            <td style="padding: 0px 0px 0px 0px;">
                                            <input type = "text" name = "code" value = "${code}" placeholder = "CODE" style = "width: 250px; height: 55px; text-align:center;"></td>
                                                <td align="center" style="border-radius: 3px;" bgcolor="#6FC9E7">
                                             
                                                 <button id ="btn"  type = "submit" name = "userCurrentAction" value = "btn"style="font-size: 20px; font-family: Helvetica, Arial, sans-serif; color: #ffffff;  color: #ffffff;  padding: 15px 25px; border-radius: 2px; border: 1px solid #6FC9E7; display: inline-block;background-color:#6FC9E7; line: none;">Confirm Account</button></td>
                                            </tr>
                                            <span id = "message"></span>
                                        </table>
                                        </form>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr> <!-- COPY -->
                    
                    <tr>
                        <td bgcolor="#ffffff" align="left" style="padding: 0px 30px 20px 30px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;">
                            <p style="margin: 0;">If you have any questions, just reply to this <b> ngocyen174308@gmail.com </b> we're always happy to help out.</p>
                        </td>
                    </tr>
                    <tr>
                        <td bgcolor="#ffffff" align="left" style="padding: 0px 30px 40px 30px; border-radius: 0px 0px 4px 4px; color: #666666; font-family: 'Lato', Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400; line-height: 25px;">
                            <p style="margin: 0;">Yen,<br>4XFIT Team</p>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td bgcolor="#f4f4f4" align="center" style="padding: 30px 10px 0px 10px;">
                
            </td>
        </tr>
       
    </table>
    </form>
    
    <script>
   document.getElementById('code').onkeyup=function(){
      
	   
       var code = document.getElementById("code").value;  
       //check empty code field  
       if(pw == "") {  
          document.getElementById("message").innerHTML = "**Fill the code please!";  
          document.getElementById("btn").disabled = true;
          
       } 
       
       else
           
       { 
    	   document.getElementById("message").innerHTML = "";  
	       document.getElementById("btn").disabled = false;
       }
  
   }
   
   </script>
</body>

</html>