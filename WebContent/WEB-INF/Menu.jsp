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
<script src="js/google.js" type="text/javascript" language="javascript"></script>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>

<style>
body {
	background-color:#b3cadb;
    font: 16px 'Ubuntu', sans-serif;
	line-height:1.4;

}

.text-center {
font-size:26px;
color:#5e91b2;
opacity:0.8;
margin-bottom: 0px;
}

.nav-pills{

margin-left: 20px;
padding-right: 30px;
font-size:14px;
color: #a5abaf;
}

.nav .glyphicon-home, .nav glyphicon-globe {
margin-right: 10px;
margin-left: -10px;
color:#5e91b2;
}

.nav .glyphicon-share, .nav .glyphicon-check, 
.nav .glyphicon-edit,.nav .glyphicon-plane, .nav .glyphicon-envelope,
.nav .glyphicon-random {
margin-left : 20px;
margin-right: 10px;
color:#5e91b2;
}

p{
margin-right: 4px;
margin-left : 15px;
margin-top : 0px;
margin-bottom : 0px;
color:#5e91b2;
font-size:14px;
}

.nav .glyphicon-user,.nav  .glyphicon-road{
margin-right: 10px;
margin-left: -10px;
color:#5e91b2;
font-size:14px;
}
a{
margin-top : -5px;
margin-bottom : -5px;
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
					<c:if test="${errorConnected}">
  						<li id = "accueil"><a href="Index.jsp"><span class="glyphicon glyphicon-home"></span>Accueil</a></li>
  						<p><span class="glyphicon glyphicon-user"></span>Compte utilisateur</p>
      						<li><a href=<c:url value="/connect"/>><span class="glyphicon glyphicon-share"></span>Se connecter</a></li>
        					<li><a href=<c:url value="/register"/>><span class="glyphicon glyphicon-check"></span>Créer un compte</a></li>
        			</c:if>		
        			<c:if test="${!errorConnected}">
        			<li id = "Deconnection"><a href="Index.jsp"><span class="glyphicon glyphicon-home"></span>Deconnection</a></li>
  						<p><span class="glyphicon glyphicon-user"></span>Compte utilisateur</p>
							<li><a href=<c:url value="/modify"/>><span class="glyphicon glyphicon-edit"></span>Modifier / supprimer son compte</a></li> 
						<p><span class="glyphicon glyphicon-road"></span>Covoiturage</p>
      						<li><a href="ListCovoiturage.jsp"><span class="glyphicon glyphicon-plane"></span>Rechercher / proposer un covoiturage</a></li>
        					<li><a href="ListUser.jsp"><span class="glyphicon glyphicon-envelope"></span>Contacter un utilisateur</a></li>
        					<li><a href="Trajet.jsp"><span class="glyphicon glyphicon-random"></span>Gérer son trajet</a></li>
        			</c:if> 		                       
    		</div>	
</body>
</html>