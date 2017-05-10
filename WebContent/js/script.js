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