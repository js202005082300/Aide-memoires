<?php
/*
	session_status()	-> 0 (PHP_SESSION_DISABLED)
						-> 1 (PHP_SESSION_NONE)
						-> 2 (PHP_SESSION_ACTIVE)
						
	session_id()
	session_name()
	session_start()
	session_regenerate_id(true)
	session_unset()
	session_destroy()
	session_write_close()
*/	
	session_start();
	session_regenerate_id(true);
	
	echo session_status();

?>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<title>Cours PHP</title>
</head>
<body>
	<h1>Sessions en PHP</h1>
	
	<p>Bonjour <?= htmlspecialchars($_SESSION['username']) ?></p>
</body>
</html>