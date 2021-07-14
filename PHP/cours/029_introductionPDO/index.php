<?php

require 'db-config.php';

try
{
	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS);
	
	echo 'Connexion &eacute;tablie !';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}