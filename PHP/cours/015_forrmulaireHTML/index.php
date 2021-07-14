?> <!-- POST -->
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Formulaire HTML</title>
</head>
<body>
	<h1>Saisie d'informations</h1>

	<form method="post" action="result.php">
		<p><label for="iduser">Utilisateur :</label> <input type="text" id="iduser" name="user"></p>
		<p><label for="idchoice">Choix : </label> <input type="radio" name="choice" id="idchoice" value="oui">Oui 
		<input type="radio" name="choice" id="idchoice" value="non">Non</p>
		<p><input type="submit" name="valid_form" value="valider"></p>
	</form>
</body>
</html>
<?php