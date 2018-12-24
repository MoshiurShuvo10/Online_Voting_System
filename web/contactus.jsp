<%-- 
    Document   : contactus
    Created on : Oct 6, 2016, 1:23:30 PM
    Author     : Oops
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/home.css"/>
        <%@ include file="header.jsp"%>
        <title>Contact Us Page</title>
    </head>
    <body background="pic.jpg">
        <div class="contact-us" style="background-color: #3498db; padding-bottom: 100px; padding-top: 10px; margin-top: 20px;">
        <h1 style="color:  #ffffff; margin-left: 50px;">Contact US</h1>
        <form action="contact" method="get">
            <br><br>  <label style=" color: #ffffff; font-size: 20px; margin-left: 28px; ">Name: <input name="name" type="text" placeholder="enter name" style="margin-left: 167px; width: 350px;"/></label>
          <br><br>  <label style=" color: #ffffff; font-size: 20px; margin-left: 28px;">Phone number: <input name="pnumber" type="text" placeholder="enter Phone number:"style="margin-left: 96px; width: 350px;"/></label>
         <br><br>   <label style=" color: #ffffff; font-size: 20px; margin-left: 28px;">Email: <input name="email" type="text" placeholder="enter mail id"style="margin-left: 165px; width: 350px;"/></label>
         <br><br>   <label style=" color: #ffffff; font-size: 20px; margin-left: 28px;">Comments and questions:<textarea name="comment" style="width:350px; border:1px solid #999999; margin-top: 0px;margin-left: 15px; "></textarea></label>
            <br><br>
            <input type="submit" name="btn" class ="btn_contactus"/>
            
        </form>
    
    </div>
        
        <div class="contact-us-right"style="background-color: #138808;padding-bottom: 100px;">
            
            <p style="color: #ffffff;margin-top: -50px;margin-left: 22px;"><br>
                <b style="font-size: 20px;">Md. Moshiur Rahman Shuvo</b><br>
                <b style="font-size: 20px;">Facebook: <a href="https://www.facebook.com/profile.php?id=100023632572219">Moshiur Rahman</a></b> 
             <br>
            <b style="font-size: 20px;">Phone</b> 01683990207
            <br>
            <b style="font-size: 20px;">E-Mail</b> : shuvorm87@gmail.com 
            
            </p>
            
        </div> 
        <div style="margin-top: 30px;">
       
        </div>
    </body>
</html>
