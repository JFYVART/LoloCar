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

glyphicon glyphicon-plus{
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
 
#Titre{
	color:#5e91b2;
}

</style>


<body>
	<div class="container">
		<form id="form" name="myListUser" method="post" action="addUsersTrajet">
		<input id="emailUserToAdd" name="emailUserToAdd" type="hidden"></input>	
		<input id="emailUserToDel" name="emailUserToDel" type="hidden"></input>		
				<div class="row">
				   
					<div class="col-md-3">
							<c:set var = "errorConnected" scope = "session" value = "${false}"/>
							<c:import url="/WEB-INF/Menu.jsp" />
					</div>
					<br>
					
					<div class="col-md-9">
					<h3 id = "Titre">Gestion du trajet</h3>
						<table class="table table-hover">
						    <thead>
						      <tr>
						      <th>Nom</th>
						      <th>Email</th>
						      <th>Ajouter un utilisateur</th>
						      </tr>
						    </thead>
						    <tbody>
						      <c:forEach var="userItem" items="${usershaut}">
     								<tr>
          								<td><c:out value="${userItem.name}"/></td>
          								<td><c:out value="${userItem.email}" /></td>
          								<td onclick="add('${userItem.email}')"><c:out value='${user.email}'/><span class=" glyphicon glyphicon-plus"></span></td>
          							</tr>	
     							</c:forEach>
						    </tbody>
					  	</table>
					  </div>	
					  
					  <div class="col-md-9">
						<table class="table table-hover">
						    <thead>
						      <tr>
						      <th>Nom</th>
						      <th>Email</th>
						      <th>Supprimer un utilisateur</th>
						      </tr>
						    </thead>
						    <tbody>
						      <c:forEach var="userItem" items="${usersbas}">
     								<tr>
          								<td><c:out value="${userItem.name}"/></td>
          								<td><c:out value="${userItem.email}" /></td>
          								<td onclick="del('${userItem.email}')"><c:out value='${user.email}'/><span class=" glyphicon glyphicon-remove"></span></td>
          							</tr>	
     							</c:forEach>
						    </tbody>
					  	</table>
					  </div>	
					  
				 </div> 
			</div>
		</form>				 
	</div>
	<script type="text/javascript">
	function add(email){
	    document.getElementById("emailUserToAdd").value=email;
	    document.getElementById("form").submit();
	}
	function del(email){
		document.getElementById("emailUserToDel").value=email;
	    document.getElementById("form").submit();
	}
	</script>
</body>
</html>