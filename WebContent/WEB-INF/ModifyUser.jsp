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
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>

<style>

body {
	background-color: #b3cadb;
	font: 16px 'Ubuntu', sans-serif;;
	line-height: 1.4;
	padding: 10px;
}

.text-center, h3 {
	font-size: 26px;
	color: #5e91b2;
	opacity: 0.8;
}

.input-group {
	border-radius: 0;
	margin-left: 30px;
	text-transform: uppercase;
	padding-left: 70px;
}

#btnGrp {
	margin-top: 10px;
	margin-left: 0px;
}

.glyphicon {
	color: #d1625c;
}

.glyphicon-user, .glyphicon-log-in, .glyphicon-erase,
.glyphicon-education {
	color: #5e91b2;
}

#nbCov {
   font-size: 15px;
   font-style: initial;
   color: #5e91b2;
   opacity: 0.8;
}

h4 {
   font-size: 15px;
   color: #5e91b2;
   opacity: 0.8;
   margin-left: 20px;
}

#fumeurUtilisateur, #isConducteurUtilisateur {
   font-size: 15px;
   color: #5e91b2;
   opacity: 0.8;
   margin-left: 35px;
}

.btn-default {
	box-shadow: 1px 1px 1px #92a7b7;
	background-color: #e6ecf2;
	opacity: 0.8;
}

.bg-success {
	margin-left: 15px;
}


</style>


<body>
	<div class="container">
		<form name="myForm" method="post" action="modify">
		<input id="emailUserToDel" name="emailUserToDel" type="hidden"></input>	
			<div class="row">
				<div class="col-md-3">
					<c:set var = "errorConnected" scope = "session" value = "${false}"/>
					<c:import url="/WEB-INF/Menu.jsp" />
				</div>
				<div class="col-md-9">
					<br>	
					<c:import url="/WEB-INF/Card.jsp" />
					
					<div class="container bg-grey">
						<div class="row">
							<p></p>
							<div class="col-sm-12">
								<div class="row" id="btnGrp">
									<div class="col-sm-6 form-group">
										<button class="btn btn-default btn-md col-sm-8" type="submit">
											<a style="vertical-align: middle"><span
												class="glyphicon glyphicon-remove"></span></a>
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
			</div>	
		</form>
	</div>
</body>
</html>