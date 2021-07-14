<?php
	/* $_COOKIE */
	if(!isset($_cookie['lang']) || empty($_cookie['lang']))
		setcookie('lang', 'en', time() + 3600 * 24 * 365, null, null, false, false);
?>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title><?= $title ?></title>
</head>
<body>
	<h1>Les cookies en PHP</h1>
	
	<p>Langue de l'utilisateur : <?= htmlspecialchars($_COOKIE['lang']) ?></p>
</body>
</html>