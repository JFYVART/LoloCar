<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
</head>

<style>
.well{
	background-color:#b3cadb;
	margin-left:20px;
}

h2{
	color:#c17974;
}

dl{
	color:#7a7b91;
}

</style>

<body>
	<div class="container bg-grey">
				<div class="well col-sm-6">
  					<h2>Informations de l'utilisateur :</h2>    
  					<dl>
    				<dt>Email</dt>
    				<dd>- ${newUser.email}</dd>
    				<dt>nom</dt>
    				<dd>- ${newUser.name}</dd>
  					</dl>
  				</div>	    
			</div>
</body>
</html>