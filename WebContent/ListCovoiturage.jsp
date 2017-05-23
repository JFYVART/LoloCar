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
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5Js00Q0b8fEtHzF_JN5NLBU2mH5p8v0s&callback=initVisuMap" async defer></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>

<style>



.jumbotron{
margin-left: 30px;
opacity:0.8;
}

.glyphicon-flag , .glyphicon-search {
color:#5e91b2;
}

 .btn-default {
      box-shadow: 1px 1px 1px #92a7b7;
      background-color: #e6ecf2; 
      opacity:0.8;
      margin-left: -15px; 
  }
  
 

</style>


<body >
	<div class="container" onLoad = "initVisuMap">
		<form name="myForm">
			<div class="row">
				<div class="col-md-3">
				<c:set var = "errorConnected" scope = "session" value = "${false}"/>
					<c:import url="/WEB-INF/Menu.jsp" />
				</div>
				<div class="col-md-9">	
					<div class="col-md-9">
						
							<div class="col-sm-8 input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-flag"></i></span> <input 
									class="form-control" id=adrDep type="text"
									name="adrDep" value="${form['adrDepUtilisateur']}" placeholder="Départ"
									required="required">
							</div>
							<br>
							<div class="col-sm-8 input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-flag"></i></span> <input 
									class="form-control" id=adrArr type="text"
									name="adrArr" value="${form['adrArrUtilisateur']}" placeholder="Arrivée"
									required="required">
							</div>
							<br>
								<div class="col-sm-6 form-group">
								<button class="btn btn-default btn-md col-sm-8" value="Recherche" onclick="AddRow()">
									<a style="vertical-align: middle"><span class="glyphicon glyphicon-search"></span></a>
								</button>
							</div>
						<div id="divMap" style="float:left;width:600px; height:350px"></div>
						<br>
							<div class="col-md-9">
						<table class="table table-hover" id="myTable">
						    <thead>
						      <tr>
						      <th>Nom</th>
						      <th>Email</th>
						      <th>Contacter la personne</th>
						      </tr>
						    </thead> 
						    <tbody>
						    </tbody>
					  	</table>
					  </div>
					</div>
					
					<br/>
					<center>
					</center>
		  		</div>	
	  		  </div>				
		</form>
	</div>
	<script type="text/javascript">
	var Covoitures = [
		["Laurent Palmier", 43.533329, 1.23333, 0, 0,"Laurent.Palmier@Magnus.fr"],
		["Sybille Cazaux", 43.6042600, 1.4436700, 1, 0, "Sybille.Cazaux@Magnus.fr"]
		];
	

    }
	
	</script>
</body>
</html>