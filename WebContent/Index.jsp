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
<!--importation de l'API google MAP Version 3-->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5Js00Q0b8fEtHzF_JN5NLBU2mH5p8v0s&callback=initMap" async defer></script>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>

<style>



.jumbotron{
margin-left: 30px;
opacity:0.8;
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
			<div class="row">
				<div class="col-md-3">
					<c:import url="/WEB-INF/Menu.jsp" />
				</div>
				<div class="col-md-9">	
					<div>
						<table>
						<tr>
							<td><b>Départ: </b></td>
							<td><input type="text" id="adrDep" value="" style="width:300px;"></td>
							<td><b>Transport: </b>
							<select id="mode">
							<option value="DRIVING">voiture</option>
							<option value="WALKING">marche</option>
							<option value="BICYCLING">vélo</option>
							</select></td>
						</tr>
						<tr>
							<td><b>Arrivée: </b></td>
							<td><input type="text" id="adrArr" value="" style="width:300px;"></td>
							<td><input type="button" value="Recherche" onclick="rechercher('adrDep','adrArr')"></td>
						</tr>
						</table>
						<div class="col-md-6" id="divMap" style="float:left;width:600px; height:350px"></div>
							<div class="col-md-6"id="divRoute" style="float:right;width:30%;height:80%"></div>
							
					</div>
					
					<br/>
					<center>
					</center>
		  		</div>	
	  		  </div>				
		</form>
	</div>
</body>
</html>