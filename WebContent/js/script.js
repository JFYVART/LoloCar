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



//service GoogleMaps
var map,geocoder, marker, marker2; // La carte, le service de géocodage et les marqueurs
var ptCheck, depart, arrivee; // point de dÃ©part, arrivÃ© et de vÃ©rification

/*initialise google MAP V3*/
function initMap() {
	/*gestion des routes*/
	var directionsDisplay = new google.maps.DirectionsRenderer();
	var directionsService = new google.maps.DirectionsService();
	/*emplacement par défaut de la carte (Toulouse)*/
	var maison = new google.maps.LatLng(43.6042600, 1.4436700);
	depart = new google.maps.LatLng(43.51667, 1.2);
	arrivee = new google.maps.LatLng(43.533329, 1.53333);
	/*option par défaut de la carte*/
	var myOptions = {
			zoom:10,
			mapTypeId: google.maps.MapTypeId.ROADMAP,
			center: maison
	}
	/*creation de la map*/
	map = new google.maps.Map(document.getElementById("divMap"), myOptions);
	/*connexion de la map + le panneau de l'itinéraire*/
	directionsDisplay.setMap(map);
	
	/* Affichage du trajet  */
	calcRoute(directionsService, directionsDisplay);
	document.getElementById('mode').addEventListener('change', function() {
		calcRoute(directionsService, directionsDisplay);
      });
	
	
	/*var markerDep = new google.maps.Marker({
        position: depart,
        map: map
      });
	
	var markerArr = new google.maps.Marker({
        position: arrivee,
        map: map
      });*/
	
	
	
	
	
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

function calcRoute(directionsService, directionsDisplay) {
//	  var start = document.getElementById('start').value;
//	  var end = document.getElementById('end').value;
	var start = depart;
	var end = arrivee;  
	  
	  var selectedMode = document.getElementById('mode').value;
	  var request = {
	      origin: start,
	      destination: end,
	      // Note that Javascript allows us to access the constant
	      // using square brackets and a string value as its
	      // "property."
	      travelMode: google.maps.DirectionsTravelMode["DRIVING"]
	  };
	  directionsService.route(request, function(result, status) {
	    if (status == 'OK') {
	      directionsDisplay.setDirections(result);
	    }
	  });
	}


function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
                          'Error: The Geolocation service failed.' :
                          'Error: Your browser doesn\'t support geolocation.');
  }