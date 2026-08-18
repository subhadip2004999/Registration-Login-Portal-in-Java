<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align: Center;">This is Register Portal</h1>
<center>
	<form action="Register" method="Post">
		<h3>Register</h3>
		Email: <input type="text" name="email1" placeholder="Enter your email"/> <br/><br/>
		Name: <input type="text" name="name1" placeholder="Enter your name"/> <br/><br/>
		Gender: <select name="gender1">
					<option>Select Gender</option>
					<option>Male</option>
					<option>Female</option>
				</select><br/><br/>
		Mobile: <input type="text" name="mobile1" placeholder="Enter your mobile number"/> <br/><br/>
		Password: <input type="password" name="password1" placeholder="Enter a strong password"/> <br/><br/>
		City: <select name="city1">
					<option>Select City</option>
					<option>Patna</option>
					<option>Kolkata</option>
					<option>Chennai</option>
					<option>Lucknow</option>
					<option>Delhi</option>
					<option>Gauhati</option>
			  </select><br/><br/><br/><br/>
		<button type="submit">Submit</button>
	</form>
</center>
</body>
</html>