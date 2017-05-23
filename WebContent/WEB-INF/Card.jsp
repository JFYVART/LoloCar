<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

dt{
margin-left: 10px;
}

dd{
margin-left: 20px;
}

h4{
margin-left: -10px;
}

</style>

<body>
	<div class="container bg-grey">
				<div class="well col-sm-6">
  					<h2>Informations du compte :</h2>    
  					<dl>
  					<h4> * Utilisateur :</h4>
    				<dt>Email</dt>
    				<dd>- ${newUser.email}</dd>
    				<dt>Nom</dt>
    				<dd>- ${newUser.name}</dd>
    				
    				<h4> * Conditions de covoiturage :</h4>
    				<dt>Voiture Fumeur (oui / non)</dt>
    				<dd>
    					<c:choose>
    						<c:when test="${newUser.conditionsTrajet.fumeur}">
    							- Fumeur
  							</c:when>
  							<c:otherwise>
    							- Non fumeur
  							</c:otherwise>
  						</c:choose>	
    				</dd>
    				<dt>Nombre passagers</dt>
    				<dd>- ${newUser.conditionsTrajet.nbCovoitureurs}</dd>
    				<dt>Qualité ('Conducteur / Passager)</dt> 
    				<dd>
    					<c:choose>
    						<c:when test="${newUser.isConducteur}">
    							- Conducteur
  							</c:when>
  							<c:otherwise>
    							- Passager
  							</c:otherwise>
  						</c:choose>	
					</dd>
    				<h4> * Adresse :</h4>
    				<dt>Rue</dt>
    				<dd>- ${newUser.adresseUser.voie}</dd>
    				<dt>Code postal</dt>
    				<dd>- ${newUser.adresseUser.cp}</dd>
    				<dt>Ville</dt>
    				<dd>- ${newUser.adresseUser.ville}</dd> 
  					</dl>
  				</div>
  				<div class="${msgHide}" style="margin-left: 30px">${msgUtilisateur}</div>	    
			</div>
</body>
</html>