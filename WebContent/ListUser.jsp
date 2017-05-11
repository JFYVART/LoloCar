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
	color:#5e91b2;
}



.input-group {
      border-radius: 0;
      margin-left: 15px;
      text-transform: uppercase;
      padding-left: 5px;
  }
  
  .btn-default {
      border-radius: 0;
      margin-left: 0px;
  }

.glyphicon{
color:#5e91b2;
}

td{
margin-left: 30px;
color:#5e91b2;
font-size: 10px;
background-color:#f4f5f7;
}

glyphicon-remove-sign{
cursor:pointer;
}

table{
margin-left: -15px;
}
 thead{
 border-radius: 5px;
 background-color:#dce2f2;
 color:#5e91b2;
 font-size: 12px;
 }

</style>


<body>
	<div class="container">
		<form name="myListUser" method="post" action="listeUsers">	
				<div class="row">
					<div class="col-md-3">
							<c:import url="/WEB-INF/Menu.jsp" />
					</div>
					<div class="col-md-9">
						<div class="row">
							<div class="col-sm-6 input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-screenshot"></i></span><input 
									class="form-control" id=emailUtilisateur type="text"
									name="emailUtilisateur" value="${emailUtilisateur}" placeholder="Utilisateur recherché">
							</div>
						<br>			
						<div class="col-sm-6">
								<button class="btn btn-default btn-md col-sm-6" type="submit">
									<a style="vertical-align: middle"><span class="glyphicon glyphicon-search"></span></a>
								</button>
						</div>
					</div>
					<br>
					<div class="col-md-9">
						<table class="table table-hover">
						    <thead>
						      <tr>
						      <th>Nom</th>
						      <th>Email</th>
						      <th>Contacter l'utilisateur)</th>
						      </tr>
						    </thead>
						    <tbody>
						      <c:forEach var="userItem" items="${users}">
     								<tr>
          								<td><c:out value="${userItem.value.name}"/></td>
          								<td><c:out value="${userItem.value.email}" /></td>
          								<td onclick="location.href='delUser?emailUserToDel='"><c:out value='${user.email}'/><span class="glyphicon glyphicon-envelope"></span></td>
          							</tr>	
     							</c:forEach>
						    </tbody>
					  	</table>
					  </div>	
				 </div> 
			</div>
		</form>				 
	</div>
</body>
</html>