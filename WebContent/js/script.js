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
	
	var latLng = new google.maps.LatLng(43.6044600, 1.4439700);
	var marker = new google.maps.Marker({
        position: latLng,
        map: map
      });
	
	/*connexion de la map + le panneau de l'itinéraire*/
	directionsDisplay.setMap(map);
	directionsDisplay.setPanel(document.getElementById("divRoute"));
	/*intialise le geocoder pour localiser les adresses */
	geocoder = new google.maps.Geocoder();
	
	
	// Géolocalisation
	var infoWindow = new google.maps.InfoWindow({map: map});

    // Try HTML5 geolocation.
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(function(position) {
        var pos = {
          lat: position.coords.latitude,
          lng: position.coords.longitude
        };

        infoWindow.setPosition(pos);
        infoWindow.setContent('Location found.');
        map.setCenter(pos);
      }, function() {
        handleLocationError(true, infoWindow, map.getCenter());
      });
    } else {
      // Browser doesn't support Geolocation
      handleLocationError(false, infoWindow, map.getCenter());
    }
  }

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
                          'Error: The Geolocation service failed.' :
                          'Error: Your browser doesn\'t support geolocation.');
  }