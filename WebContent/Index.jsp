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
<!--importation de l'API google MAP Version 3-->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5Js00Q0b8fEtHzF_JN5NLBU2mH5p8v0s&callback=initMap" async defer></script>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>

<style>



.well{
font-size:26px;
color:#5e91b2;
opacity:0.8;
}
.glyphicon-transfer {
color:#5e91b2;
}
p{
margin-left: 30px;
color:#5e91b2;
font-size: 8px;
}


</style>


<body onload="initMap();">
	<div class="container">
		<form name="myForm">
		<input id="idUserConnected" name="idUserConnected" type="hidden"></input>
			<div class="row">
				<div class="col-md-3">
					<c:set var = "errorConnected" scope = "session" value = "${true}"/>
					<c:import url="/WEB-INF/Menu.jsp" />
				</div>
				<div class="col-md-9">
					<div class="well">
					
					<h3><i class="glyphicon glyphicon-transfer"></i> Carte des covoiturages en cours</h3>
					</div>	
					<div class="col-md-6" id="divMap" style="float:left;width:845px; height:600px"></div>	
	  		  </div>				
		</form>
	</div>
</body>
</html>