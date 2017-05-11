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
			center: maison,
			
	}
	/*creation de la map*/
	map = new google.maps.Map(document.getElementById("divMap"), myOptions);
	/*connexion de la map + le panneau de l'itinéraire*/
	directionsDisplay.setMap(map);
	
	/* Affichage du trajet  */
	calcRoute(directionsService, directionsDisplay);
	/*vdocument.getElementById('mode').addEventListener('change', function() {
		calcRoute(directionsService, directionsDisplay);
      });
	
	
	ar markerDep = new google.maps.Marker({
        position: depart,
        map: map
      });
	
	var markerArr = new google.maps.Marker({
        position: arrivee,
        map: map
      });*/
	
	setMarkers(map);
	
	
	
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
	  
	  var selectedMode = "DRIVING";
	  var request = {
	      origin: start,
	      destination: end,
	      // Note that Javascript allows us to access the constant
	      // using square brackets and a string value as its
	      // "property."
	      travelMode: google.maps.DirectionsTravelMode[selectedMode]
	  };
	  directionsService.route(request, function(result, status) {
	    if (status == 'OK') {
	      directionsDisplay.setDirections(result);
	    }
	  });
	}

//Data for the markers consisting of a name, a LatLng and a zIndex for the
//order in which these markers should display on top of each other.
var Users = [
['Lolo', 43.533329, 1.23333, 1]
];



function setMarkers(map) {
    // Adds markers to the map.

    // Marker sizes are expressed as a Size of X,Y where the origin of the image
    // (0,0) is located in the top left of the image.

    // Origins, anchor positions and coordinates of the marker increase in the X
    // direction to the right and in the Y direction down.
    var image = {
      url: 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
      // This marker is 20 pixels wide by 32 pixels high.
      size: new google.maps.Size(20, 32),
      // The origin for this image is (0, 0).
      origin: new google.maps.Point(0, 0),
      // The anchor for this image is the base of the flagpole at (0, 32).
      anchor: new google.maps.Point(0, 32)
    };
    // Shapes define the clickable region of the icon. The type defines an HTML
    // <area> element 'poly' which traces out a polygon as a series of X,Y points.
    // The final coordinate closes the poly by connecting to the first coordinate.
    var shape = {
      coords: [1, 1, 1, 20, 18, 20, 18, 1],
      type: 'poly'
    };
    for (var i = 0; i < Users.length; i++) {
      var user = Users[i];
      var marker = new google.maps.Marker({
        position: {lat: user[1], lng: user[2]},
        map: map,
        icon: image,
        shape: shape,
        title: user[0],
        zIndex: user[3]
      });
    }
  }

function handleLocationError(browserHasGeolocation, infoWindow, pos) {
    infoWindow.setPosition(pos);
    infoWindow.setContent(browserHasGeolocation ?
                          'Error: The Geolocation service failed.' :
                          'Error: Your browser doesn\'t support geolocation.');
  }