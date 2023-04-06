<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Design by foolishdeveloper.com -->
    <title>Đăng nhập</title>
 
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
    
       <link href='<c:url value="/resources/css/style-login.css" />' rel="stylesheet" type ="text/css"> 
       <style>
  .bg-img { background-image: url('<c:url value="/resources/images/panda.png" />'); }
    .bg-img2 { background-image: url('<c:url value="/resources/images/tiger.png" />'); }
</style>
</head>
<body>/
    <div class="background">
        <div class="shape"></div>
        <div class="shape"></div>
    </div>
    <div class="bg-img">
    <div class="bg-img2">
    </div>
    <form:form action = "login" method = "post" modelAttribute="account" onsubmit = "return(validate());">
        <!-- <h3>Đăng nhập</h3> -->
		<span id="error" style="color: #eb1c26; margin-top: 10px;">${error }</span>
		
        <label for="username">Tên tài khoản</label>
        <form:input path="username" type="text" placeholder="Tên tài khoản" id="username" name = "username" />
		<span id="username-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Trường này không được để trống.</span>
        <label for="password">Mật khẩu</label>
        <form:input path="password" type="password" placeholder="Mật khẩu" id="password" name = "password" />
        <span id="password-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Trường này không được để trống.</span>
        
        <button type = "submit">Đăng nhập</button>
        <div class="checkbox-wrapper-54">
		  <label class="switch">
    		<input type="checkbox" id = "remember" name = "remember">
    		<span class="slider"></span>
  		 </label>
		</div>

		<br>
		<p style="margin: 10px;">&emsp;&emsp;&emsp;&ensp;Tự động đăng nhập</p>
        <br>	
		<br>
   		<p>
   		 Chưa có tài khoản?
    		<a href="register">
        		Tạo tài khoản
    		</a>
    			
		</p>
        <!-- <div class="social">
          <div class="go"><i class="fab fa-google"></i>  Google</div>
          <div class="fb"><i class="fab fa-facebook"></i>  Facebook</div>
        </div> -->
    </form:form>
    </div>
    <script>
    	function validate() {
    		let check = true;
    		if( document.getElementById("username").value == "" ) {
	            document.getElementById("username-invalid").style.display = "block";
	            check = false;
	         } else {
		        document.getElementById("username-invalid").style.display = "none";
	         }
			
			if( document.getElementById("password").value == "" ) {
				console.log("password");
	            document.getElementById("password-invalid").style.display = "block";
	            check = false;
	         } else {
	        	 document.getElementById("password-invalid").style.display = "none";
	         }
			
			return check;
    	}
    </script>
</body>
</html>