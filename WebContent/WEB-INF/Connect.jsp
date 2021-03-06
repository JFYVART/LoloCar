<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
</head>

<style>
.input-group {
	
}

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
	<div class="container bg-grey">
		<div class="row">
			<div class="col-sm-6">
				<div class="row">
					<h3>- Compte</h3>
					<div class="col-sm-12 input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-envelope"></i></span> <input
							class="form-control" id=emailUtilisateur type="email"
							name="emailUtilisateur" value="${form['emailUtilisateur']}"
							placeholder="Adresse email" required="required">
					</div>
					<br>
					<div class="col-sm-12 input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-lock"></i></span> <input class="form-control"
							id="pwd1Utilisateur" name="pwd1Utilisateur"
							placeholder="Mot de passe" type="password" pattern=".{5,10}"
							required title="5 caractères minimum, 10 caractères maximum."
							required>
					</div>
					<br>
					<div class="${msgHide}" style="margin-left: 30px">${msgUtilisateur}</div>
					<br>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="row">
					<div class="${errorEmailHide}" style="margin-left: 60px">${errors['emailUtilisateur']}</div>
					<br> <br>
					<div class="${errorPwdHide}" style="margin-left: 60px">${errors['pwd1Utilisateur']}</div>
					<br>
				</div>
			</div>
		</div>
	</div>
	<div class="container bg-grey">
		<div class="row">
			<p></p>
			<div class="col-sm-12">
				<div class="row" id="btnGrp">
					<div class="col-sm-6 form-group">
						<button class="btn btn-default btn-md col-sm-8" type="submit">
							<a style="vertical-align: middle"><span
								class="glyphicon glyphicon-log-in"></span></a>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>