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
  					<h2>Informations du compte :</h2>    
  					<dl>
  					<h4> * Utilisateur :</h4>
    				<dt>Email</dt>
    				<dd>- ${newUser.email}</dd>
    				<dt>Nom</dt>
    				<dd>- ${newUser.name}</dd>
    				
    				<h4> * Conditions de covoiturage :</h4>
    				<dt>Voiture Fumeur (oui / non)</dt>
    				<dd>- ${newUser.conditionsTrajet.fumeur}</dd>
    				<dt>Nombre passagers</dt>
    				<dd>- ${newUser.conditionsTrajet.nbCovoitureurs}</dd>
    				<dt>Qualité ('Conducteur / Passager)</dt>
    				<dd>- ${newUser.isConducteur}</dd>
    				
    				
    				<h4> * Adresse :</h4>
    				<dt>Rue</dt>
    				<dd>- ${newUser.adresseUser.voie}</dd>
    				<dt>Code postal</dt>
    				<dd>- ${newUser.adresseUser.cp}</dd>
    				<dt>Ville</dt>
    				<dd>- ${newUser.adresseUser.ville}</dd>
  					</dl>
  				</div>	    
			</div>
</body>
</html>