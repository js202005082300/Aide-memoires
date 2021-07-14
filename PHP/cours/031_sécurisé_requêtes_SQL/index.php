<?php

require 'db-config.php';

try
{
	$options =
	[
		PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
		PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
		PDO::ATTR_EMULATE_PREPARES => false
	];

	$PDO = new PDO($DB_DSN, $DB_USER, $DB_PASS, $options);
		
	$request = $PDO->prepare('SELECT * FROM fv_clients WHERE client_firstname = :name');
	
	$request->bindValue(':name', "Tic");
	$request->execute();
	
	echo '<pre>';
	print_r($request->fetch(PDO::FETCH_ASSOC));
	echo '</pre>';
}
catch(PDOException $pe)
{
	echo 'ERREUR : '.$pe->getMessage();
}

?>