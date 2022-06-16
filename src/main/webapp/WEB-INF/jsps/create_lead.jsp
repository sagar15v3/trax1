<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lead  |  Create</title>
</head>
<body>
	<h1>Lead | Create</h1>
	<div>
		${emailerror}
	</div>
	
	<form action="saveLead" method="post">
	<pre>
	FirstName   <input type="text" name="firstName"/>
	LastName    <input type="text" name="lastName"/>
	LeadSource: <select name="leadSource" >
				  <option value="radio">Radio Channel</option>
				  <option value="newspaper">News Paper</option>
				  <option value="tv">TV</option>
				  <option value="online">Online</option>
				</select>
	Email       <input type="email" name="email"/>
	Mobile      <input type="text" name="mobile"/>
	    <input type="submit" value="save"/>
	
	</pre>
	
	
	</form>

</body>
</html>