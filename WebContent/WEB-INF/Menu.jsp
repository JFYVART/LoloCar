<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Playball" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
<script src="js/script.js" type="text/javascript" language="javascript"></script>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>

<style>
body {
	background-color:#b3cadb;
    font: 16px 'Ubuntu', sans-serif;
	line-height:1.4;
	padding: 10px;
}

.text-center {
font-size:26px;
color:#5e91b2;
opacity:0.8;
margin-bottom: 0px;
}

.nav-pills{
margin-bottom: 15px;
margin-left: 15px;
padding-right: 30px;
font-size:12px;
color: #a5abaf;
}

.glyphicon-globe {
color:#5e91b2;
}


.nav-pills a:hover {
    color: #a5abaf;
    border-radius: 0px;
}

.nav-pills .active a:hover {
    color: #a5abaf;
}

.nav>li>a:hover,
.nav>li>a:focus {
	color: #a5abaf;
    background-color: #edf3f9;
}

</style>



<body>
				<div class="container-fluid bg-grey">
				<h2 class="text-center col-sm-12">
					<div class="well">
					<i class="glyphicon glyphicon-globe"></i>
					Covoiturage with LoloCar !!!
					</div>
				</h2>
				
				<ul class="nav nav-pills nav-stacked">
  					<li><a href="Index.jsp">Accueil</a></li>
  					<li><a href=<c:url value="/register"/>>Créer un compte</a></li>
  					<li><a href="#">Se connecter</a></li>
  					<li><a href="ListUser.jsp">Recherche d'un covoiturage</a></li>
				</ul>
			</div>	
</body>
</html>