function checkPwd(){
	var mdp1 = document.getElementById("pwd1Utilisateur").value;
	var mdp2 = document.getElementById("pwd2Utilisateur").value;
    
	var longueur1 = mdp1.lenght; 
    
    if(longueur1 < 8 || longueur1 > 255) {
        document.getElementById("passwordStrength").innerHTML = "Attention le mot de passe n'est pas assez long, il doit faire 8 caractères minimum.";
        } else if(!mdp1.equals(mdp2)) {
        document.getElementById("passwordStrength").innerHTML = "Erreur : Le mot de passe et sa confirmation sont différent.";
        } else {
        	document.getElementById("passwordStrength").innerHTML = "OK";
        }
}




/*initialise google MAP V3*/
function init() {
//	var directionsService = new google.maps.DirectionsService(); 
	// service GoogleMaps
	var map,geocoder, marker, marker2; // La carte, le service de géocodage et les marqueurs
	var depart,arrivee,ptCheck; // point de départ, arrivé et de vérification
	/*gestion des routes*/
	directionsDisplay = new google.maps.DirectionsRenderer();
	/*emplacement par défaut de la carte (Toulouse)*/
	var maison = new google.maps.LatLng(43.6042600, 1.4436700);
	/*option par défaut de la carte*/
	var myOptions = {
			zoom:8,
			mapTypeId: google.maps.MapTypeId.ROADMAP,
			center: maison
	}
	/*creation de la map*/
	map = new google.maps.Map(document.getElementById("divMap"), myOptions);
	/*connexion de la map + le panneau de l'itinéraire*/
	directionsDisplay.setMap(map);
	directionsDisplay.setPanel(document.getElementById("divRoute"));
	/*intialise le geocoder pour localiser les adresses */
	geocoder = new google.maps.Geocoder();
}