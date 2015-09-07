<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Please enter your height and weight. so we can comupute your BMI</title>
</head>
<body>
	<form method="post" action="/demystify-JavaEE/bmi">
		Height in Inches:  <input type="text" name="height"/><br/>
		Weight in Pounds:  <input type="text" name="weight"/><br/>
		<input type="submit" value="Calculate your BMI"/>
	
	</form>
</body>
</html>